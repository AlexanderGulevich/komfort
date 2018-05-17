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
        private static PacketSizeMapper ourInstance = new PacketSizeMapper();

        public static PacketSizeMapper getInstance() {
            return ourInstance;
        }


        @Override
        public boolean isReadyToTransaction(DomainObject d) {
            PacketSize packetSize = (PacketSize) d;
            if (
                    packetSize.getSize()!=null

                    ) {

                return true;
            }

            return false;
        }

        @Override
        public void getDomainList(ObservableList list)   {

                String expression="SELECT * FROM " +"PacketSize"+" ORDER BY ID";

            try {
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
                    PacketSize pojo = (PacketSize) d;
                    String expression = "UPDATE " + "PacketSize" + " SET  " +
                            " size = ?" +
                            " where id=? ";

                    PreparedStatement pstmt = null;

                        pstmt = Db.getConnection().prepareStatement(expression);

                        pstmt.setInt(2, pojo.getId());
                        pstmt.setString(1, pojo.getSize());

                        pstmt.executeUpdate();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    @Override
    public void deleteDomainObject(DomainObject d)   {
        super.delete(d,"PacketSize");
    }

    @Override
        public void insertDomainObject(DomainObject d)   {

                PacketSize pojo= (PacketSize) d;

        try {
            String expression= "INSERT INTO "+ "PacketSize "
                    + "(size "
                    + ") VALUES(?)";

            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
            pstmt.setString(1, pojo.getSize());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
