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

    private static Map<Integer,NamedDomainObject> namedDomainObjectMap=new HashMap<>();

    private static NamedDataMapper ourInstance = new NamedDataMapper();

    public static NamedDataMapper getInstance() {
        return ourInstance;
    }

    private NamedDataMapper() {
    }

    @Override
    public void getAllDomainObjectList(ObservableList list, String tableName) {
        try {

            String expression="SELECT * FROM " +tableName+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                NamedDomainObject pojo=new NamedDomainObject();
                pojo.setId(rs.getInt("id"));
                pojo.setName(rs.getString("name"));

                //вставляю id в список хранимых в бд
                namedDomainObjectMap.put(rs.getInt("id"),pojo);

                list.add(pojo);



            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDataMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void updateDomainObject(DomainObject d) {
        try {
            domainObject=(NamedDomainObject) d;

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



