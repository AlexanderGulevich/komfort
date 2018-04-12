package basisFx.appCore.domainScetch;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.domainModel.mapper.EquipmentDataMapper;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by AlexanderGulevich on 17.03.2018.
 *
 * @autor AlexanderGulevich
 */
public class NamedDataMapper extends DataMapper {
    private StringValueDomainObject domainObject;

    @Override
    public void getAllDomainObjectList(ObservableList list) {

    }

    @Override
    public void getAllDomainObjectList(ObservableList list, DomainObject selectedDomainObject) {

    }

    @Override
    public void updateDomainObject(DomainObject d) {
        try {
            domainObject=(StringValueDomainObject) d;

            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!NamedDataMapper.updateDomainObject+ d.getTableName()==="+ d.getTableName());

            String expression = "UPDATE "+ d.getTableName()+
                    " SET  name = ? WHERE id= ?";


            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);

            pstmt.setString(1, domainObject.getStringValue());
            pstmt.setInt(2, domainObject.getId());



            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void insertDomainObject(DomainObject d) {

        domainObject=(StringValueDomainObject) d;

        try {
            String expression= "INSERT INTO "+ d.getTableName()
                    + "(name) VALUES(?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setString(1, domainObject.getStringValue());

            pstmt.executeUpdate();


        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}



