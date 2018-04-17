package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Employer;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeesManagerMapper extends DataMapper{
    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        return false;
    }

    @Override
    public void getAllDomainObjectList(ObservableList list) {

        try {

            String expression="SELECT * FROM " +"Employer"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {


                Employer pojo=new Employer();
                pojo.setId(rs.getInt("id"));
                pojo.setStringValue(rs.getString("name"));
                pojo.setIsFired(rs.getBoolean("isFired"));


                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void getAllDomainObjectList(ObservableList list, DomainObject selectedDomainObject) {

    }

    @Override
    public void updateDomainObject(DomainObject d) {

    }

    @Override
    public void insertDomainObject(DomainObject d) {

    }
}
