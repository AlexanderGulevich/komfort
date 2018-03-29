package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.NamedDataMapper;
import basisFx.appCore.domainScetch.NamedDomainObject;
import basisFx.domainModel.pojo.Currency;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by AlexanderGulevich on 24.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class CurrencyDataMapper extends NamedDataMapper {


    private static CurrencyDataMapper ourInstance = new CurrencyDataMapper();

    public static CurrencyDataMapper getInstance() {
        return ourInstance;
    }


    @Override
    public void getAllDomainObjectList(ObservableList list, String tableName) {
        try {

            String expression="SELECT * FROM " +tableName+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                Currency pojo=new Currency();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));
                pojo.setTableName(tableName);

                unitOfWork.getStoredPojoesId().add(rs.getInt("id"));


                list.add(pojo);



            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}