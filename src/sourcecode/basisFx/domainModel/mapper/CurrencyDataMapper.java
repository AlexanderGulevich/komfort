package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.domainModel.pojo.Currency;
import basisFx.domainModel.pojo.DomainObject;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by AlexanderGulevich on 11.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class CurrencyDataMapper extends DataMapper{

    private Currency domainObject;

    private static CurrencyDataMapper ourInstance = new CurrencyDataMapper();

    public static CurrencyDataMapper getInstance() {
        return ourInstance;
    }

    private CurrencyDataMapper() {
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

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);



            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateDomainObject(DomainObject d) {
        try {
            domainObject=(Currency) d;

            String expression = "UPDATE "+ d.getTableName()+
                    " SET  name = ? WHERE id= ?";


            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);

            pstmt.setString(1, domainObject.getName());
            pstmt.setInt(2, domainObject.getId());



            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insertDomainObject(DomainObject d) {

        domainObject=(Currency) d;

        try {
            String expression= "INSERT INTO "+ d.getTableName()
                    + "(name) VALUES(?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setString(2, domainObject.getName());

            pstmt.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
