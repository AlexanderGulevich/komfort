//package basisFx.domain.mapper;
//
//import basisFx.domain.ActiveRecord;
//import basisFx.dataSource.Db;
//import basisFx.appCore.domainScetch.ComboBoxValue;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.domaine.Counterparty;
//import basisFx.domain.domaine.Label;
//import javafx.collections.ObservableList;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.HashMap;
//
//public class LabelMapper  extends ActiveRecord {
//
//    private static LabelMapper ourInstance = new LabelMapper();
//
//    public static LabelMapper getInstance() {
//        return ourInstance;
//    }
//
//
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        Label pojo = (Label) d;
//        if (
//                pojo.getCounterparty()!=null &&
//                        pojo.getName()!=null
//                ) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void getAll(ObservableList list)   {
//
//            String expression="SELECT * FROM " +"Label"+" ORDER BY ID";
//
//        try {
//            Statement stmt  = Db.getConnection().createStatement();
//
//            ResultSet rs    = stmt.executeQuery(expression);
//
//            HashMap<Integer, ComboBoxValue> hm =dataMapperFabric.counterpartyMapper().toComboBoxValHashMap(domainObject -> ((Counterparty) domainObject).getName());
//
//            while (rs.next()) {
//
//                int counterpartyId=rs.getInt("counterpartyId");
//
//
//                Label pojo=new Label();
//
//                int id=rs.getInt("id");
//                pojo.setId(id);
//
//                pojo.setCounterparty(hm.get(counterpartyId));
//                pojo.setName(rs.getString("name"));
//
//                setStoredId(id);
//
//                list.add(pojo);
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void getDomainListForAccessoryTable(ObservableList list, DomainObject selectedDomainObject) {
//
//    }
//
//    @Override
//    public void update(DomainObject d)   {
//
//        try {
//            if (isReadyToTransaction(d)) {
//                Label pojo = (Label) d;
//                String expression = "UPDATE " + "Label" + " SET  " +
//                        " name = ?" +
//                        " counterpartyId = ?" +
//                        " where id=? ";
//
//                PreparedStatement pstmt = null;
//
//                    pstmt = Db.getConnection().prepareStatement(expression);
//
//                    pstmt.setInt(3, pojo.getId());
//                    pstmt.setName(1, pojo.getName());
//                    pstmt.setInt(2, pojo.getCounterparty().getId());
//
//                    pstmt.executeUpdate();
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(DomainObject d)   {
//        super.deleteForBoundTables(d,"Label","LabelPriceStore");
//    }
//
//    @Override
//    public void insert(DomainObject d)   {
//        Label pojo= (Label) d;
//
//            String expression= "INSERT INTO "+ "Label "
//                    + "(" +
//                    "name, " +
//                    "counterpartyId " +
//                     ") " +
//                    "VALUES(?,?)";
//
//        try {
//            PreparedStatement pstmt =  Db.getConnection().prepareStatement(expression);
//            pstmt.setName(1, pojo.getName());
//            pstmt.setInt(2, pojo.getCounterparty().getId());
//
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
