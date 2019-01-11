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
                + " FOREIGN KEY (employerId) REFERENCES Employer(id) on delete cascade "
                + ")";
        String timeRecordingForEmployers= "CREATE TABLE IF NOT EXISTS TimeRecordingForEmployers ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " employerId INTEGER,   "
                + " date Date,   "
                + " hours DOUBLE,  "
                + " FOREIGN KEY (employerId) REFERENCES Employer(id) on delete cascade "
                + ")";
        String exchangeRates= "CREATE TABLE IF NOT EXISTS ExchangeRates ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " currencyId INTEGER,   "
                + " rate DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (currencyId) REFERENCES Currency(id)  on delete cascade "
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
                + " FOREIGN KEY (productId) REFERENCES Product(id)  on delete cascade "
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
                + " FOREIGN KEY (packetId) REFERENCES Packet(id)  on delete cascade "
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
                + " FOREIGN KEY (labelId) REFERENCES Label(id)  on delete cascade "
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
                + " FOREIGN KEY (paperId) REFERENCES Paper(id)  on delete cascade "
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
        String viewActualRate= "Create  view ActualEmployersRate  as " +
                " SELECT  r.employerId, r.rate, r.startDate, e.name, e.isFired"+
                " from  employer as e,"+
                " (select * from EMPLOYEESRATEPERHOUR where (employerId, startDate)"+
                " in (select employerId, max(startDate) from  EMPLOYEESRATEPERHOUR group by employerId)) as r"+

//                " where r.employerId=e.id and e.isFired = false"+
                " where r.employerId=e.id  "+
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
                "FROM TIMERECORDINGFOREMPLOYERS t\n" +
                ")AS timerec  left JOIN  EMPLOYER e\n" +
                "ON timerec.EMPLOYERID=e.id\n";

        String outputPerDay= "CREATE TABLE IF NOT EXISTS outputPerDay ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " EquipmentId INTEGER,   "
                + " productId INTEGER,   "
                + " rodsNumber INTEGER,   "
                + " jumboId INTEGER,   "
                + " packetId INTEGER,   "
                + " packetCounterpartyId INTEGER,   "
                + " paperCounterpartyId INTEGER,   "
                + " date Date,  "
                + " FOREIGN KEY (EquipmentId) REFERENCES Equipment(id)  on delete cascade, "
                + " FOREIGN KEY (productId) REFERENCES product(id)  on delete cascade, "
                + " FOREIGN KEY (packetId) REFERENCES packet(id)  on delete cascade, "
                + " FOREIGN KEY (jumboId) REFERENCES jumbo(id)  on delete cascade, "
                + " FOREIGN KEY (packetCounterpartyId) REFERENCES Counterparty(id)  on delete cascade, "
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
                outputPerDay,
                jumboAccounting,
                jumboAccounting,
                Jumbo

//                viewActualRate,
//                viewTimeRecordingAndSalary,
//                viewActualRate

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
