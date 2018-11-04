package basisFx.domain;

import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

import java.time.LocalDate;

public class Employer extends ActiveRecord {

    private SimpleObjectProperty<String> name =new SimpleObjectProperty<>(this, "name", null);
    private SimpleObjectProperty<LocalDate> startingRateDate =new SimpleObjectProperty<>(this, "startingRateDate", null);
    private SimpleObjectProperty<Boolean> isFired =new SimpleObjectProperty<>(this, "isFired", false);
    private SimpleObjectProperty<RatePerHourTamplate> rate =new SimpleObjectProperty<>(this, "rate", null);

    public Employer() {
        super("Employer");
    }

    @Override
    public ObservableList<ActiveRecord> getAll() {
        try {
//            String expression="SELECT * FROM " +"Employer " +
//                    "where isFired = false " +
//                    " "+" ORDER BY ID";
//
//            Statement stmt  = Db.getConnection().createStatement();
//
//            ResultSet rs    = stmt.executeQuery(expression);
//
//
//            while (rs.next()) {
//
//                Employer pojo=new Employer();
//
//                int id=rs.getInt("id");
//
//                int externalId=rs.getInt("PRODUCTID");
//
//                pojo.setId(id);
//
//                pojo.setName(rs.getString("name"));
//
//                pojo.setIsFired(rs.getBoolean("isFired"));
////                dataMapperFabric.employeesRateMapper().t;
////                pojo.setRate();
////                EmployeesRatePerHour rate=getNewest(rs.getInt("id"));
////
////                if (rate != null) {
////
////                    pojo.setStartingRateDate(rate.getStartingDate());
////
////                    pojo.setRate(rate);
////                }
//
//                setStoredId(id);
//
//                list.add(pojo);
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public void update() {
            Employer employer= (Employer) d;
//            String expression = "UPDATE "+    "Employer"+ " SET  " +
//                    " name = ?," +
//                    " isFired = ?" +
//                    " WHERE id= ?" ;
//
//            try {
//                PreparedStatement pstmt = null;
//
//                pstmt = Db.getConnection().prepareStatement(expression);
//                pstmt.setName(1, employer.getName());
//                pstmt.setBoolean(2, employer.getIsFired());
//                pstmt.setInt(3, employer.getId());
//                pstmt.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
    }

    @Override
    public ActiveRecord find(int id) {
        return null;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public void insert() {
            Employer domainObject=(Employer) d;
//
//        if(isReadyToTransaction(d)) {
//
//                String expression = "INSERT INTO " + "Employer "
//                        + "("
//                        + " name ,  "
//                        + " isFired "
//                        + ") VALUES(?,?)";
//
//            try {
//                PreparedStatement pstmt = Db.getConnection().prepareStatement(expression);
//                pstmt.setName(1, domainObject.getName());
//                pstmt.setBoolean(2, domainObject.getIsFired());
//
//                pstmt.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//
//
//        }
    }

    @Override
    public ObservableList<ActiveRecord> findAllByOuterId(int id) {
        return null;
    }
}
