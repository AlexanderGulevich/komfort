package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.PacketSize;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacketSizeMapper extends DataMapper {
        private static RatePerHourTemplatesDataMapper ourInstance = new RatePerHourTemplatesDataMapper();

        public static RatePerHourTemplatesDataMapper getInstance() {
            return ourInstance;
        }


        @Override
        public boolean isReadyToTransaction(DomainObject d) {
            PacketSize ratePerHour = (PacketSize) d;
            if (

                    ratePerHour.getSize()!=null

                    ) {

                return true;
            }

            return false;
        }

        @Override
        public void getAllDomainObjectList(ObservableList list) {
            try {

                String expression="SELECT * FROM " +"PacketSize"+" ORDER BY ID";

                Statement stmt  = Db.getConnection().createStatement();

                ResultSet rs    = stmt.executeQuery(expression);


                while (rs.next()) {

                    PacketSize pojo=new PacketSize();
                    pojo.setId(rs.getInt("id"));
                    pojo.setSize(rs.getString("size"));

                    //вставляю id в список хранимых в бд
                    this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                    list.add(pojo);



                }

            } catch (SQLException ex) {
                Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        @Override
        public void getAllDomainObjectList(ObservableList list, DomainObject selectedDomainObject) {

        }

        @Override
        public void updateDomainObject(DomainObject d) {

            if (isReadyToTransaction(d)) {
                PacketSize pojo = (PacketSize) d;
                String expression = "UPDATE " + "PacketSize" + " SET  " +
                        " id = ?," +
                        " size = ?";

                PreparedStatement pstmt = null;
                try {
                    pstmt = Db.getConnection().prepareStatement(expression);

                    pstmt.setInt(1, pojo.getId());
                    pstmt.setString(2, pojo.getSize());

                    pstmt.executeUpdate();

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        }

        @Override
        public void insertDomainObject(DomainObject d) {
            PacketSize pojo= (PacketSize) d;
            try {
                String expression= "INSERT INTO "+ "PacketSize "
                        + "(size "
                        + ") VALUES(?)";

                PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
                pstmt.setString(1, pojo.getSize());


                pstmt.executeUpdate();


            } catch (SQLException ex) {
                Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
}
