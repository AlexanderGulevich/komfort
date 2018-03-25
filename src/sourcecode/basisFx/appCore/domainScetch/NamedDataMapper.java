package basisFx.appCore.domainScetch;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.domainModel.mapper.EquipmentDataMapper;
import basisFx.domainModel.pojo.Country;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by AlexanderGulevich on 17.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class NamedDataMapper extends DataMapper {
    private NamedDomainObject domainObject;

    @Override
    public void getAllDomainObjectList(ObservableList list, String tableName) {

    }

    @Override
    public void updateDomainObject(DomainObject d) {
        try {
            domainObject=(NamedDomainObject) d;

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!NamedDataMapper.updateDomainObject+ d.getTableName()==="+ d.getTableName());

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

        domainObject=(NamedDomainObject) d;

        try {
            String expression= "INSERT INTO "+ d.getTableName()
                    + "(name) VALUES(?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setString(1, domainObject.getName());

            pstmt.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}



