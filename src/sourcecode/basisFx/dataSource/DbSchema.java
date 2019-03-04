package basisFx.dataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DbSchema {

    public DbSchema() {

        String equipment = "CREATE TABLE IF NOT EXISTS Equipment ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,  "
                + "	name VARCHAR(40)"
                + ")";
        String counterparty= "CREATE TABLE IF NOT EXISTS Counterparty ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,  "
                + "	name VARCHAR(40),  "
                + " currencyId INTEGER,  "
                + " FOREIGN KEY (currencyId) REFERENCES Currency(id) "
                + ")";
        String currency= "CREATE TABLE IF NOT EXISTS Currency( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	name VARCHAR(40)"
                + ")";
        String employer= "CREATE TABLE IF NOT EXISTS Employer( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " isFired Boolean,   "
                + "	name VARCHAR(40) "
                + ")";
        String ratePerHourHistory= "CREATE TABLE IF NOT EXISTS EMPLOYEESRATEPERHOUR ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " employerId INTEGER,   "
                + " rate DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (employerId) REFERENCES Employer(id) on delete cascade , "
                + " UNIQUE  (employerId, startDate)"
                + ")";
        String timeRecordingForEmployers= "CREATE TABLE IF NOT EXISTS TimeRecordingForEmployers ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " employerId INTEGER,   "
                + " date Date,   "
                + " hours DOUBLE,  "
                + " FOREIGN KEY (employerId) REFERENCES Employer(id) on delete cascade , "
                + " UNIQUE  (employerId, date)"
                + ")";
        String exchangeRates= "CREATE TABLE IF NOT EXISTS ExchangeRates ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " currencyId INTEGER,   "
                + " rate DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (currencyId) REFERENCES Currency(id)  on delete cascade , "
                + " UNIQUE  (currencyId, startDate)"
                + ")";
        String product= "CREATE TABLE IF NOT EXISTS Product( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	name VARCHAR(40), "
                + "	havingSleeve Boolean "
                + ")";
        String productPriceStore= "CREATE TABLE IF NOT EXISTS ProductPrice ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " productId INTEGER,   "
                + " price DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (productId) REFERENCES Product(id)  on delete cascade , "
                + " UNIQUE  (productId, startDate)"
                + ")";
        String packetSize = "CREATE TABLE IF NOT EXISTS PacketSize( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	size VARCHAR(40) "
                + ")";
        String packet = "CREATE TABLE IF NOT EXISTS Packet( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	packetSizeId INTEGER, "
                + "	counterpartyId INTEGER, "
                + " FOREIGN KEY (packetSizeId) REFERENCES PacketSize(id), "
                + " FOREIGN KEY (counterpartyId) REFERENCES Counterparty(id) "
                + ")";
        String packetPriceStore= "CREATE TABLE IF NOT EXISTS PacketPrice ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " packetId INTEGER,   "
                + " price DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (packetId) REFERENCES Packet(id)  on delete cascade , "
                + " UNIQUE  (packetId, startDate)"
                + ")";
        String packetProductAccordance= "CREATE TABLE IF NOT EXISTS PacketProductAccordance ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " packetSizeId INTEGER,   "
                + " productId INTEGER,   "
                + " number INTEGER,   "
                + " FOREIGN KEY (productId) REFERENCES Product(id), "
                + " FOREIGN KEY (packetSizeId) REFERENCES PacketSize(id) "
                + ")";
        String label = "CREATE TABLE IF NOT EXISTS Label( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	name VARCHAR(40), "
                + "	counterpartyId INTEGER, "
                + " FOREIGN KEY (counterpartyId) REFERENCES Counterparty(id) "
                + ")";
        String labelPriceStore= "CREATE TABLE IF NOT EXISTS LabelPrice ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " labelId INTEGER,   "
                + " price DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (labelId) REFERENCES Label(id)  on delete cascade , "
                + " UNIQUE  (labelId, startDate)"
                + ")";
        String sleeve= "CREATE TABLE IF NOT EXISTS Sleeve ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	counterpartyId INTEGER, "
                + " FOREIGN KEY (counterpartyId) REFERENCES Counterparty(id) "
                + ")";
        String sleevePrice= "CREATE TABLE IF NOT EXISTS SleevePrice ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " sleeveId INTEGER,   "
                + " price DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (sleeveId) REFERENCES Sleeve(id)  on delete cascade, "
                + " UNIQUE  (sleeveId, startDate)"
                + ")";
        String paper= "CREATE TABLE IF NOT EXISTS Paper ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	counterpartyId INTEGER, "
                + " FOREIGN KEY (counterpartyId) REFERENCES Counterparty(id) "
                + ")";
        String paperPriceStore= "CREATE TABLE IF NOT EXISTS PaperPrice ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " paperId INTEGER,   "
                + " price DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (paperId) REFERENCES Paper(id)  on delete cascade , "
                + " UNIQUE  (paperId, startDate)"
                + ")";

        String jumboAccounting= "CREATE TABLE IF NOT EXISTS JumboAccounting ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " overallWeight Double,   "
                + " CounterpartyId INTEGER,   "
                + " date Date,  "
                + " FOREIGN KEY (CounterpartyId) REFERENCES Counterparty(id)  on delete cascade "
                + ")";
        String Jumbo= "CREATE TABLE IF NOT EXISTS Jumbo ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " width INTEGER,   "
                + " numberOfProduct INTEGER    "
                + ")";
        String viewFired= "Create  view Fired  as " +
                " SELECT  * from  employer  where employer.ISFIRED=true ORDER BY  employer.ID " ;

        String viewActualRate= "Create  view ActualEmployersRate  as " +
                " SELECT  r.employerId as id,r.employerId as employerId , r.rate, r.startDate, e.name, e.isFired"+
                " from  employer as e,"+
                " (select * from EMPLOYEESRATEPERHOUR where (employerId, startDate)"+
                " in (select employerId, max(startDate) from  EMPLOYEESRATEPERHOUR group by employerId)) as r"+

                " where r.employerId=e.id and e.isFired = false"+
//                " where r.employerId=e.id  "+
                " ORDER BY r.employerId";
        String viewTimeRecordingAndSalary= "Create  view TimeRecordingAndSalary  as " +
                "SELECT EMPLOYERID, DATE, HOURS , rate, rate*HOURS AS salary, e.ISFIRED,e.NAME FROM(\n" +
                "SELECT t.EMPLOYERID, t.DATE,t.HOURS,\n" +
                "(select RATE from EMPLOYEESRATEPERHOUR where (employerId, startdate)\n" +
                "in (\n" +
                "SELECT employerId, startdate FROM (\n" +
                "select employerId,max(startdate) AS startdate\n" +
                "from ( SELECT * from EMPLOYEESRATEPERHOUR WHERE startdate <= t.DATE)\n" +
                "group by employerId\n" +
                ") AS RATEDADE \n" +
                "WHERE RATEDADE.employerId=t.EMPLOYERID\n" +
                ") ) AS rate \n" +
                "FROM TimeRecordingForEmployers t\n" +
                ")AS timerec  left JOIN  EMPLOYER e\n" +
                "ON timerec.EMPLOYERID=e.id\n";
        String viewSalaryByMonth= "Create  view SalaryByMonth  as " +
                "SELECT * FROM (\n" +
                "SELECT SUM(SALARY) AS SALARY, EMPLOYERID,  MONTH(\"DATE\") AS sMonth, YEAR(\"DATE\") AS sYear\n" +
                "  FROM TIMERECORDINGANDSALARY\n" +
                " GROUP BY MONTH(DATE),YEAR(\"DATE\"), EMPLOYERID) AS salary\n" +
                " LEFT JOIN Employer ON Employer.id=salary.EMPLOYERID";
        String viewSalaryByYear=  "Create  view SalaryByYear  as "
                +"SELECT * FROM (\n" +
                "SELECT * FROM (\n" +
                " SELECT SUM(SALARY) AS SALARY, EMPLOYERID,  YEAR(DATE) AS YSALARY\n" +
                "                  FROM TIMERECORDINGANDSALARY\n" +
                "                 GROUP BY YEAR(DATE), EMPLOYERID) AS SALARY\n" +
                "                LEFT JOIN EMPLOYER ON EMPLOYER.ID=SALARY.EMPLOYERID)";
        String viewTotalSalaryByYear=  "Create  view TotalSalaryByYear  as "
                +"\n" +
                " SELECT SUM(SALARY) AS SALARY  ,ySalary  \n" +
                "                  FROM SalaryByYear\n" +
                "                 GROUP BY ySalary";
        String viewTotalSalaryByMonth=  "Create  view TotalSalaryByMonth  as "
                +"\n" +
                "  SELECT SUM(SALARY) AS SALARY  , SMONTH   \n" +
                "        FROM SalaryByMonth   \n" +
                "         GROUP BY SMONTH";

        String viewtotalproductcostandamount=  "Create  view totalproductcostandamount  as "
                +"SELECT\n" +
                "\tN_rods,\n" +
                "\tpr_Id,\n" +
                "\tj_id,\n" +
                "\tOut_D,\n" +
                "\tout_id,\n" +
                "\teqp_id,\n" +
                "\tn_Pr_by_W,\n" +
                "\tpr_Am,\n" +
                "\tPACKETID,\n" +
                "\tp.PRICE,\n" +
                "\tp.STARTDATE AS START_d,\n" +
                "\tp.PRICE*pr_Am AS total_cost\n" +
                "\tfrom \n" +
                "\t( SELECT * from(\n" +
                "\t\tSELECT\n" +
                "\t\to.rodsnumber AS N_rods,\n" +
                "\t\to.PRODUCTID AS pr_Id,\n" +
                "\t\to.jumboid AS j_id,\n" +
                "\t\to.date AS Out_D, \n" +
                "\t\to.ID AS out_id ,\n" +
                "\t\to.PACKETID,\n" +
                "\t\to.EQUIPMENTID AS eqp_id,\n" +
                "\t\tj.numberofproduct AS n_Pr_by_W ,\n" +
                "\t\to.rodsnumber*j.numberofproduct AS pr_Am \n" +
                "\t\tFROM\n" +
                "\t\tOUTPUTPERDAY o, jumbo j \n" +
                "\t\tWHERE o.jumboid= j.ID\n" +
                "\t) )AS amount, PRODUCTPRICE AS p\n" +
                "\t\tWHERE p.startdate<=amount.Out_D \n" +
                "\t\tAND amount.pr_Id=p.PRODUCTID";


        String viewtotalpacketcostandamount=  "Create  view totalpacketcostandamount  as "
                +"SELECT\n" +
                "\tpr_Id,\n" +
                "\tpr_Am,\n" +
                "\tPACKETID,\n" +
                "\tOut_D,\n" +
                "\tpprice.STARTDATE AS START_d,\n" +
                "\tpprice.PRICE,\n" +
                "\tpack.PACKETSIZEID,\n" +
                "\tACCORDANCE.NUMBER AS capacity,\n" +
                "\tpr_Am/ACCORDANCE.NUMBER AS packetAmount,\n" +
                "\tpprice.PRICE*pr_Am/ACCORDANCE.NUMBER AS total_cost\n" +
                "\tfrom \n" +
                "\t\tTOTALPRODUCTCOSTANDAMOUNT AS amount, \n" +
                "\t\tPACKETPrice AS pprice,\n" +
                "\t\tPACKET AS pack, \n" +
                "\t\tPACKETPRODUCTACCORDANCE AS ACCORDANCE\n" +
                "\t\t\tWHERE\n" +
                "\t\t\tpprice.startdate<=amount.Out_D\n" +
                "\t\t\tAND amount.PACKETID=pprice.PACKETID\n" +
                "\t\t\tAND pack.PACKETSIZEID=PACKETID\n";

        String outputPerDay= "CREATE TABLE IF NOT EXISTS outputPerDay ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " EquipmentId INTEGER,   "
                + " productId INTEGER,     "
                + " rodsNumber INTEGER,     "
                + " jumboId INTEGER,       "
                + " packetId INTEGER,       "
                + " paperCounterpartyId INTEGER,   "
                + " date Date,  "
                + " FOREIGN KEY (EquipmentId) REFERENCES Equipment(id)  on delete cascade, "
                + " FOREIGN KEY (productId) REFERENCES product(id)  on delete cascade, "
                + " FOREIGN KEY (packetId) REFERENCES packet(id)  on delete cascade, "
                + " FOREIGN KEY (jumboId) REFERENCES jumbo(id)  on delete cascade, "
                + " FOREIGN KEY (paperCounterpartyId) REFERENCES Counterparty(id)  on delete cascade "
                + ")";
        create(
                equipment,
                currency,
                counterparty,
                employer,
                ratePerHourHistory,
                timeRecordingForEmployers,
                exchangeRates,
                product,
                productPriceStore,
                packetSize,
                packet,
                packetPriceStore,
                packetProductAccordance,
                label,
                labelPriceStore,
                sleeve,
                sleevePrice,
                paper,
                paperPriceStore,
                Jumbo,
                outputPerDay,
                jumboAccounting,
                jumboAccounting
//                ,
//
//                viewFired,
//                viewTimeRecordingAndSalary,
//                viewSalaryByMonth,
//                viewSalaryByYear,
//                viewActualRate,
//                viewTotalSalaryByYear,
//                viewTotalSalaryByMonth,
//                viewtotalproductcostandamount,
//                viewtotalpacketcostandamount

        );

    }
    
    private void create(String ...val){
    
        for (String tableName : val) {
          try {
              Connection connection = Db.connection;
              connection.createStatement().execute(tableName);
//
            } catch (SQLException e) {
                System.out.println("Не создалась таблица");
                System.err.println(tableName.toUpperCase());
                System.err.println(e);


            }
        }
        
    }
    

        
      
   
        
 
}
//SELECT * FROM SLEEVEPRICE WHERE YEAR(STARTDATE) =YEAR(CURRENT_DATE);
//SELECT * FROM SLEEVEPRICE WHERE YEAR(STARTDATE) =2016
//SELECT * FROM SLEEVEPRICE WHERE STARTDATE > (NOW() - INTERVAL 1 DAY) AND STARTDATE <= NOW() ;
//SELECT * FROM SLEEVEPRICE   ORDER BY STARTDATE DESC LIMIT 2   ;
//SELECT * FROM SLEEVEPRICE WHERE STARTDATE >= '2019-01-11' AND STARTDATE <= '2019-01-15' ;