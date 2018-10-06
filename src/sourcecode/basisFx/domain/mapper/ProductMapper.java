//package basisFx.domain.mapper;
//
//import basisFx.domain.domaine.ActiveRecord;
//import basisFx.dataSource.Db;
//import basisFx.appCore.domainScetch.BoolComboBox;
//import basisFx.appCore.domainScetch.DomainObject;
//import basisFx.domain.domaine.Product;
//import javafx.collections.ObservableList;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class ProductMapper extends ActiveRecord{
//
//    private static ProductMapper ourInstance = new ProductMapper();
//
//    public static ProductMapper getInstance() {
//        return ourInstance;
//    }
//
//
//    @Override
//    public boolean isReadyToTransaction(DomainObject d) {
//        Product product= (Product) d;
//        if (
//                product.getName() != null &&
//                product.getSleeve() != null
//                ) {
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public void getAll(ObservableList list)   {
//
//        try {
//            String expression="SELECT * FROM " +"Product"+" ORDER BY ID";
//
//            Statement stmt  = Db.getConnection().createStatement();
//
//            ResultSet rs    = stmt.executeQuery(expression);
//
//            while (rs.next()) {
//
//                Product pojo=new Product();
//
//                int id =rs.getInt("id");
//                pojo.setId(id);
//
//                pojo.setName(rs.getString("name"));
//                pojo.setSleeve(new BoolComboBox(rs.getBoolean("sleeve") )  );
//
//                setStoredId(id);
//
//                list.add(pojo);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
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
//            if(isReadyToTransaction(d)) {
//
//                Product product= (Product) d;
//                String expression = "UPDATE "+    "Product"+ " SET  " +
//                        " name = ?," +
//                        " sleeve = ? " +
//                        " WHERE id= ?" ;
//
//                PreparedStatement pstmt = null;
//
//                    pstmt = Db.getConnection().prepareStatement(expression);
//                    pstmt.setName(1, product.getName());
//                    pstmt.setBoolean(2, product.getSleeve().getBoolean());
//                    pstmt.setInt(3, product.getId());
//                    pstmt.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(DomainObject d)   {
//        super.deleteForBoundTables(d,"Product","ProductPriceStore");
//    }
//
//    @Override
//    public void insert(DomainObject d)   {
//
//        try {
//            Product product= (Product) d;
//
//            if(isReadyToTransaction(d)) {
//
//                    String expression = "INSERT INTO " + "Product "
//                            + "("
//                            + " name ,  "
//                            + " sleeve "
//                            + ") VALUES(?,?)";
//
//                    PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
//                    pstmt.setName(1, product.getName());
//                    pstmt.setBoolean(2, product.getSleeve().getBoolean());
//
//
//
//                    pstmt.executeUpdate();
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//}
