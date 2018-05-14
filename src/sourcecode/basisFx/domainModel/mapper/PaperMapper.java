package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Counterparty;
import basisFx.domainModel.domaine.Packet;
import basisFx.domainModel.domaine.PacketSize;
import basisFx.domainModel.domaine.Paper;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaperMapper  extends DataMapper {

    private static PaperMapper ourInstance = new PaperMapper();

    public static PaperMapper getInstance() {
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
    public void getDomainList(ObservableList list) {
        try {

            String expression="SELECT * FROM " +"Paper"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                int counterpartyId=rs.getInt("counterpartyId");
                Counterparty counterparty = (Counterparty) dataMapperFabric.counterpartyDataMapper().toHashMapByCommonRawId().get(counterpartyId);

                Paper pojo=new Paper();
                pojo.setId(rs.getInt("id"));
                pojo.setCounterparty(new ComboBoxValue(counterparty.getName()));

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);



            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {

    }

    @Override
    public void updateDomainObject(DomainObject d) {

        if (isReadyToTransaction(d)) {
            Paper pojo = (Paper) d;
            String expression = "UPDATE " + "Paper" + " SET  " +
                    " counterpartyId = ?" +
                    " where id=? ";

            PreparedStatement pstmt = null;
            try {
                pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setInt(2, pojo.getId());
                pstmt.setInt(1, pojo.getCounterparty().getId());

                pstmt.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void insertDomainObject(DomainObject d) {
        Paper pojo= (Paper) d;
        try {
            String expression= "INSERT INTO "+ "Paper "
                    + "(counterpartyId  "
                    + ") VALUES(?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setInt(1, pojo.getCounterparty().getId());


            pstmt.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
