package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.SingleStringValueDataMapper;
import basisFx.domainModel.domaine.Country;
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
public class CountryDataMapper extends SingleStringValueDataMapper {

    private static CountryDataMapper ourInstance = new CountryDataMapper();

    public static CountryDataMapper getInstance() {
        return ourInstance;
    }



    @Override
    public void getAllDomainObjectList(ObservableList list) {
        try {

            String expression="SELECT * FROM " +"Country"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                Country pojo=new Country();
                pojo.setId(rs.getInt("id"));
                pojo.setStringValue(rs.getString("name"));
//                domaine.setTableName(tableName);


                unitOfWork.getStoredPojoesId().add(rs.getInt("id"));


                list.add(pojo);



            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
