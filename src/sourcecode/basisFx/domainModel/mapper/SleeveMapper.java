package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Counterparty;
import basisFx.domainModel.domaine.Packet;
import basisFx.domainModel.domaine.Paper;
import basisFx.domainModel.domaine.Sleeve;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SleeveMapper  extends DataMapper {

    private static SleeveMapper ourInstance = new SleeveMapper();

    public static SleeveMapper getInstance() {
        return ourInstance;
    }



    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Paper pojo = (Paper) d;
        if (
                pojo.getCounterparty()!=null &&
                        pojo.getCounterparty()!=null
                ) {
            return true;
        }
        return false;
    }

    @Override
    public void getDomainList(ObservableList list)   {

            String expression="SELECT * FROM " +"Sleeve"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                int counterpartyId=rs.getInt("counterpartyId");
                Counterparty counterparty = (Counterparty) dataMapperFabric.counterpartyDataMapper().toHashMapByCommonRawId().get(counterpartyId);

                Sleeve pojo=new Sleeve();
                pojo.setId(rs.getInt("id"));
                pojo.setCounterparty(new ComboBoxValue(counterparty.getName()));

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);



            }
    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {

    }

    @Override
    public void updateDomainObject(DomainObject d)   {

        if (isReadyToTransaction(d)) {
            Sleeve pojo = (Sleeve) d;
            String expression = "UPDATE " + "Sleeve" + " SET  " +
                    " counterpartyId = ?" +
                    " where id=? ";

            PreparedStatement pstmt = null;

                pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setInt(2, pojo.getId());
                pstmt.setInt(1, pojo.getCounterparty().getId());

                pstmt.executeUpdate();
        }
    }

    @Override
    public void deleteDomainObject(DomainObject d)   {
        super.deleteForBoundTables(d,"Sleeve","SleevePriceStore ");
    }

    @Override
    public void insertDomainObject(DomainObject d)   {
        Sleeve pojo= (Sleeve) d;

            String expression= "INSERT INTO "+ "Sleeve "
                    + "(counterpartyId  "
                    + ") VALUES(?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setInt(1, pojo.getCounterparty().getId());

            pstmt.executeUpdate();

    }
}
