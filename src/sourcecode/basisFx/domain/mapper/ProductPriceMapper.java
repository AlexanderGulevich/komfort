//package basisFx.domain.mapper;
//
//import basisFx.dataSource.DataMapper;
//import basisFx.dataSource.Db;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.domaine.Price;
//import javafx.collections.ObservableList;
//
//import java.sql.*;
//
//public class ProductPriceMapper extends DataMapper {
//    private static ProductPriceMapper ourInstance = new ProductPriceMapper();
//
//    public static ProductPriceMapper getInstance() {
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
//    public void getDomainList(ObservableList list) {
//
//    }
//
//    @Override
//    public void getDomainListForObserverTables(ObservableList list, DomainObject selectedDomainObject)   {
//        try {
//            int selectedDomainObjectID=selectedDomainObject.getId();
//
//            String expression="SELECT * FROM " +" ProductPriceStore "+" where productId= " +selectedDomainObjectID+" ORDER BY startDate desc";
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
//                pojo.setProductId(rs.getInt("productId"));
//                pojo.setPrice( Double.toString(rs.getDouble("price")));
//                pojo.setStartingDate(rs.getDate("startDate").toLocalDate());
//
//               setStoredId(id);
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
//    public void updateDomainObject(DomainObject d)   {
//        try {
//            if(isReadyToTransaction(d)) {
//                System.out.println("Price.updateDomainObject".toUpperCase());
//
//                Price domainObject= (Price) d;
//
//                String expression = "UPDATE "+    " ProductPriceStore"+ " SET  " +
//                        " price = ?," +
//                        " startDate = ?," +
//                        " productId = ? " +
//                        " where id =?";
//
//
//                boolean check = checkUniquenessDateById(
//                        "ProductPriceStore",
//                        "startDate",
//                        domainObject.getStartingDate(),
//                        "productId",
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
//    public void deleteDomainObject(DomainObject d)   {
//        super.delete(d," ProductPriceStore ");
//    }
//
//    @Override
//    public void insertDomainObject(DomainObject d)   {
//        try {
//            Price domainObject=(Price) d;
//
//            if(isReadyToTransaction(d)) {
//
//                    String expression = "INSERT INTO " + " ProductPriceStore "
//                            + "("
//                            + " price ,  "
//                            + " startDate,  "
//                            + " productId        "
//                            + ") VALUES(?,?,?)";
//
//
//                boolean check = checkUniquenessDateById(
//                        "ProductPriceStore",
//                        "startDate",
//                        domainObject.getStartingDate(),
//                        "productId",
//                        getObservableDomaineId()
//                );
//
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
