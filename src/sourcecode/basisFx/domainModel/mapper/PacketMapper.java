package basisFx.domainModel.mapper;

import basisFx.appCore.dataSource.DataMapper;
import basisFx.appCore.dataSource.Db;
import basisFx.appCore.domainScetch.ComboBoxValue;
import basisFx.appCore.domainScetch.DomainObject;
import basisFx.domainModel.domaine.Counterparty;
import basisFx.domainModel.domaine.Packet;
import basisFx.domainModel.domaine.PacketSize;
import javafx.collections.ObservableList;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacketMapper  extends DataMapper {

    private static PacketMapper ourInstance = new PacketMapper();

    public static PacketMapper getInstance() {
        return ourInstance;
    }



    @Override
    public boolean isReadyToTransaction(DomainObject d) {
        Packet pojo = (Packet) d;
        if (
                pojo.getSize()!=null &&
                pojo.getCounterparty()!=null
                ) {
            return true;
        }
        return false;
    }

    @Override
    public void getDomainList(ObservableList list) {
        try {

            String expression="SELECT * FROM " +"Packet"+" ORDER BY ID";

            Statement stmt  = Db.getConnection().createStatement();

            ResultSet rs    = stmt.executeQuery(expression);


            while (rs.next()) {

                int packetSizeId=rs.getInt("packetSizeId");
                int counterpartyId=rs.getInt("counterpartyId");
                PacketSize packetSize = (PacketSize) dataMapperFabric.packetSizeMapper().toHashMapByCommonRawId().get(packetSizeId);
                Counterparty counterparty = (Counterparty) dataMapperFabric.counterpartyDataMapper().toHashMapByCommonRawId().get(counterpartyId);

                Packet pojo=new Packet();
                pojo.setId(rs.getInt("id"));
                pojo.setSize(new ComboBoxValue(packetSize.getSize()));
                pojo.setCounterparty(new ComboBoxValue(counterparty.getName()));

                //вставляю id в список хранимых в бд
                this.unitOfWork.getStoredPojoesId().add(rs.getInt("id"));

                list.add(pojo);



            }

        } catch (SQLException ex) {
            Logger.getLogger(EquipmentDM.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject) {

    }

    @Override
    public void updateDomainObject(DomainObject d) {

        if (isReadyToTransaction(d)) {
            Packet pojo = (Packet) d;
            String expression = "UPDATE " + "Packet" + " SET  " +
                    " packetSizeId = ?" +
                    " counterpartyId = ?" +
                    " where id=? ";

            PreparedStatement pstmt = null;
            try {
                pstmt = Db.getConnection().prepareStatement(expression);

                pstmt.setInt(3, pojo.getId());
                pstmt.setInt(1, pojo.getSize().getId());
                pstmt.setInt(2, pojo.getCounterparty().getId());

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
