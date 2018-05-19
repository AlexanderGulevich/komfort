/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basisFx.domainModel;

import basisFx.appCore.dataSource.Db;
import java.sql.SQLException;

/**
 *
 * @author Alek
 */
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

        String ratePerHour= "CREATE TABLE IF NOT EXISTS RateTemplates( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " rate DOUBLE "
                + ")";

        String currentEmployeesState= "CREATE TABLE IF NOT EXISTS Employer( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " isFired Boolean,   "
                + "	name VARCHAR(40) "
                + ")";

        String ratePerHourHistory= "CREATE TABLE IF NOT EXISTS RateStore ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " employerId INTEGER,   "
                + " rate DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (employerId) REFERENCES Employer(id) "
                + ")";

        String exchangeRates= "CREATE TABLE IF NOT EXISTS ExchangeRates ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " currencyId INTEGER,   "
                + " rate DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (currencyId) REFERENCES Currency(id) "
                + ")";

        String product= "CREATE TABLE IF NOT EXISTS Product( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	name VARCHAR(40), "
                + "	sleeve Boolean "
                + ")";

        String productPriceStore= "CREATE TABLE IF NOT EXISTS ProductPriceStore ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " productId INTEGER,   "
                + " price DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (productId) REFERENCES Product(id) "
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

        String packetPriceStore= "CREATE TABLE IF NOT EXISTS PacketPriceStore ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " packetId INTEGER,   "
                + " price DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (packetId) REFERENCES Packet(id) "
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

        String labelPriceStore= "CREATE TABLE IF NOT EXISTS LabelPriceStore ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " labelId INTEGER,   "
                + " price DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (labelId) REFERENCES Label(id) "
                + ")";

        String sleeve= "CREATE TABLE IF NOT EXISTS Sleeve ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	counterpartyId INTEGER, "
                + " FOREIGN KEY (counterpartyId) REFERENCES Counterparty(id) "
                + ")";

        String sleevePriceStore= "CREATE TABLE IF NOT EXISTS SleevePriceStore ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " sleeveId INTEGER,   "
                + " price DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (sleeveId) REFERENCES Sleeve(id) "
                + ")";

        String paper= "CREATE TABLE IF NOT EXISTS Paper ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	counterpartyId INTEGER, "
                + " FOREIGN KEY (counterpartyId) REFERENCES Counterparty(id) "
                + ")";

        String paperPriceStore= "CREATE TABLE IF NOT EXISTS PaperPriceStore ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " paperId INTEGER,   "
                + " price DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (paperId) REFERENCES Paper(id) "
                + ")";




        create(
                equipment,
                currency,
                counterparty,
                ratePerHour,
                currentEmployeesState,
                ratePerHourHistory,
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
                sleevePriceStore,
                paper,
                paperPriceStore

        );

    }
    
    private void create(String ...val){
    
        for (String tableName : val) {
          try {
                Db.getConnection().createStatement().execute(tableName);

            } catch (SQLException e) {
              System.out.println("Не создалась таблица");
              System.err.println(tableName.toUpperCase());
              System.err.println(e);


            }
        }
        
    }
    
        
        
      
   
        
 
}
