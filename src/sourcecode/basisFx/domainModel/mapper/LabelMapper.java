package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Counterparty;
import basisFx.domainModel.domaine.Label;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LabelMapper  extends DataMapper {

    private static LabelMapper ourInstance = new LabelMapper();

    public static LabelMapper getInstance() {
        return ourInstance;
    }


    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Label pojo = (Label) d;
        if (
                pojo.getCounterparty()!=null &&
                        pojo.getName()!=null
                ) {
            return true;
        }
        return false;
    }

    @Override
    public void getDomainList(ObservableList list) throws SQLException {

            String expression="SELECT * FROM " +"Label"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            HashMap<Integer, ComboBoxValue> comboBoxValue_hm =
                    dataMapperFabric.counterpartyDataMapper()
                    .toComboBoxValHashMap(domainObject -> ((Counterparty) domainObject).getName());

            while (rs.next()) {

                int counterpartyId=rs.getInt("counterpartyId");


                Label pojo=new Label();
                pojo.setId(rs.getInt("id"));
                pojo.setCounterparty(comboBoxValue_hm.get(counterpartyId));
                pojo.setName(rs.getString("name"));

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);

            }

    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {

    }

    @Override
    public void updateDomainObject(DomainObject d) throws SQLException {

        if (isReadyToTransaction(d)) {
            Label pojo = (Label) d;
            String expression = "UPDATE " + "Label" + " SET  " +
                    " name = ?" +
                    " counterpartyId = ?" +
                    " where id=? ";

            PreparedStatement pstmt = null;

                pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setInt(3, pojo.getId());
                pstmt.setString(1, pojo.getName());
                pstmt.setInt(2, pojo.getCounterparty().getId());

                pstmt.executeUpdate();

        }
    }

    @Override
    public void deleteDomainObject(DomainObject d) throws SQLException {
        super.deleteForBoundTables(d,"Label","LabelPriceStore");
    }

    @Override
    public void insertDomainObject(DomainObject d) throws SQLException {
        Label pojo= (Label) d;

            String expression= "INSERT INTO "+ "Label "
                    + "(" +
                    "name, " +
                    "counterpartyId " +
                     ") " +
                    "VALUES(?,?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setString(1, pojo.getName());
            pstmt.setInt(2, pojo.getCounterparty().getId());

            pstmt.executeUpdate();
    }
}
