//package basisFx.domain.mapper;
//
//import basisFx.domain.domaine.ActiveRecord;
//import basisFx.dataSource.Db;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.domaine.Price;
//import javafx.collections.ObservableList;
//
//import java.sql.*;
//
//public class SleevePriceMapper extends ActiveRecord {
//
//
//    private static SleevePriceMapper ourInstance = new SleevePriceMapper();
//
//    public static SleevePriceMapper getInstance() {
//        return ourInstance;
//    }
//
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        Price price = (Price) d;
//
//        if (
//                price.getPrice()!= null
//                        && price.getStartingDate() !=null
//
//                ) {
//
//            return true;
//        }
//
//        return false;
//
//    }
//
//
//    @Override
//    public void getAll(ObservableList list) {
//
//    }
//
//    @Override
//    public void getDomainListForAccessoryTable(ObservableList list, DomainObject selectedDomainObject)   {
//        try {
//            int selectedDomainObjectId=selectedDomainObject.getId();
//
//            String expression="SELECT * FROM " +"SleevePriceStore "+" where sleeveId= " +selectedDomainObjectId+" ORDER BY startDate desc";
//
//            Statement stmt  = Db.getConnection().createStatement();
//
//            ResultSet rs    = stmt.executeQuery(expression);
//
//            while (rs.next()) {
//
//                Price pojo=new Price();
//
//                int id=rs.getInt("id");
//                pojo.setId(id);
//
//
//                pojo.setProductId(rs.getInt("sleeveId"));
//                pojo.setPrice( Double.toString(rs.getDouble("price")));
//                pojo.setStartingDate(rs.getDate("startDate").toLocalDate());
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
//
//    }
//
//    @Override
//    public void update(DomainObject d)   {
//        try {
//            if(isReadyToTransaction(d)) {
//
//
//                Price domainObject= (Price) d;
//
//                String expression = "UPDATE "+    "SleevePriceStore"+ " SET  " +
//                        " price = ?," +
//                        " startDate = ?," +
//                        " sleeveId = ? " +
//                        " where id =?";
//
//
//                boolean check = checkUniquenessDateById(
//                        "SleevePriceStore",
//                        "startDate",
//                        domainObject.getStartingDate(),
//                        "sleeveId",
//                        getObservableDomaineId()
//                );
//
//                if (!check) {
//                    PreparedStatement pstmt = null;
//
//                    pstmt = Db.getConnection().prepareStatement(expression);
//
//                    pstmt.setDouble(1, Double.valueOf(domainObject.getPrice()));
//                    pstmt.setDate(2, Date.valueOf(domainObject.getStartingDate()));
//                    pstmt.setInt(3, domainObject.getProductId());
//                    pstmt.setInt(4, domainObject.getId());
//                    pstmt.executeUpdate();
//                }
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(DomainObject d)   {
//        super.delete(d,"SleevePriceStore");
//    }
//
//    @Override
//    public void insert(DomainObject d)   {
//        Price domainObject=(Price) d;
//
//        try {
//            if(isReadyToTransaction(d)) {
//
//
//                    String expression = "INSERT INTO " + "SleevePriceStore "
//                            + "("
//                            + " price ,  "
//                            + " startDate,  "
//                            + " sleeveId        "
//                            + ") VALUES(?,?,?)";
//
//
//                boolean check = checkUniquenessDateById(
//                        "SleevePriceStore",
//                        "startDate",
//                        domainObject.getStartingDate(),
//                        "sleeveId",
//                        getObservableDomaineId()
//                );
//
//                if (!check) {
//                    PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
//
//                    pstmt.setDouble(1, Double.valueOf(domainObject.getPrice()));
//                    pstmt.setDate(2, Date.valueOf(domainObject.getStartingDate()));
//                    pstmt.setInt(3, getObservableDomaineId());
//
//                    pstmt.executeUpdate();
//                }
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//
//}
