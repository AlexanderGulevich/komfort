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
    public void getDomainList(ObservableList list)   {

            String expression="SELECT * FROM " +"Label"+" ORDER BY ID";

        try {
            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);

            HashMap<Integer, ComboBoxValue> hm =dataMapperFabric.counterpartyMapper().toComboBoxValHashMap(domainObject -> ((Counterparty) domainObject).getName());

            while (rs.next()) {

                int counterpartyId=rs.getInt("counterpartyId");


                Label pojo=new Label();
                pojo.setId(rs.getInt("id"));
                pojo.setCounterparty(hm.get(counterpartyId));
                pojo.setName(rs.getString("name"));

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {

    }

    @Override
    public void updateDomainObject(DomainObject d)   {

        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDomainObject(DomainObject d)   {
        super.deleteForBoundTables(d,"Label","LabelPriceStore");
    }

    @Override
    public void insertDomainObject(DomainObject d)   {
        Label pojo= (Label) d;

            String expression= "INSERT INTO "+ "Label "
                    + "(" +
                    "name, " +
                    "counterpartyId " +
                     ") " +
                    "VALUES(?,?)";

        try {
            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setString(1, pojo.getName());
            pstmt.setInt(2, pojo.getCounterparty().getId());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
