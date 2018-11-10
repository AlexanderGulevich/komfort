//package basisFx.domain.mapper;
//
//import basisFx.domain.ActiveRecord;
//import basisFx.dataSource.Db;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.ProductPrice;
//import javafx.collections.ObservableList;
//
//import java.sql.*;
//
//public class PaperPriceMapper extends ActiveRecord {
//
//
//    private static PaperPriceMapper ourInstance = new PaperPriceMapper();
//
//    public static PaperPriceMapper getInstance() {
//        return ourInstance;
//    }
//
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        ProductPrice price = (ProductPrice) d;
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
//
//        try {
//            int selectedDomainObjectId=selectedDomainObject.getId();
//
//            String expression="SELECT * FROM " +"PaperPriceStore "+" where paperId= " +selectedDomainObjectId+" ORDER BY startDate desc";
//
//            Statement stmt  = Db.getConnection().createStatement();
//
//            ResultSet rs    = stmt.executeQuery(expression);
//
//            while (rs.next()) {
//
//                ProductPrice pojo=new ProductPrice();
//
//                int id=rs.getInt("id");
//                pojo.setId(id);
//
//
//                pojo.setProductId(rs.getInt("paperId"));
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
//    }
//
//    @Override
//    public void update(DomainObject d)   {
//
//        if(isReadyToTransaction(d)) {
//
//            ProductPrice domainObject= (ProductPrice) d;
//
//            String expression = "UPDATE "+    "PaperPriceStore"+ " SET  " +
//                    " price = ?," +
//                    " startDate = ?," +
//                    " paperId = ? " +
//                    " where id =?";
//
//            PreparedStatement pstmt = null;
//
//
//            boolean check = checkUniquenessDateById(
//                    "PaperPriceStore",
//                    "startDate",
//                    domainObject.getStartingDate(),
//                    "paperId",
//                    getObservableDomaineId()
//            );
//
//            if (!check) {
//                try {
//                    pstmt = Db.getConnection().prepareStatement(expression);
//
//                    pstmt.setDouble(1, Double.valueOf(domainObject.getPrice()));
//                    pstmt.setDate(2, Date.valueOf(domainObject.getStartingDate()));
//                    pstmt.setInt(3, domainObject.getProductId());
//                    pstmt.setInt(4, domainObject.getId());
//                    pstmt.executeUpdate();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        }
//    }
//
//    @Override
//    public void delete(DomainObject d)   {
//        super.delete(d, "PaperPriceStore");
//    }
//
//    @Override
//    public void insert(DomainObject d)   {
//        ProductPrice domainObject=(ProductPrice) d;
//
//        try {
//            if(isReadyToTransaction(d)) {
//
//                    String expression = "INSERT INTO " + "PaperPriceStore "
//                            + "("
//                            + " price ,  "
//                            + " startDate,  "
//                            + " paperId        "
//                            + ") VALUES(?,?,?)";
//
//                boolean check = checkUniquenessDateById(
//                        "PaperPriceStore",
//                        "startDate",
//                        domainObject.getStartingDate(),
//                        "paperId",
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
