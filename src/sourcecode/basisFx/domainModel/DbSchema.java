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
                + "	name VARCHAR(20),"
                + "	rodWidth INTEGER"
                + ")";

        String counterparty= "CREATE TABLE IF NOT EXISTS Counterparty ( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,  "
                + "	name VARCHAR(20),  "
                + " countryId INTEGER,  "
                + " currencyId INTEGER,  "
                + " FOREIGN KEY (countryId) REFERENCES  Country(id), "
                + " FOREIGN KEY (currencyId) REFERENCES Currency(id) "
                + ")";

        String country= "CREATE TABLE IF NOT EXISTS Country( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	name VARCHAR(20)"
                + ")";

        String currency= "CREATE TABLE IF NOT EXISTS Currency( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	name VARCHAR(20)"
                + ")";

        String ratePerHour= "CREATE TABLE IF NOT EXISTS RatePerHour( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " ratePerHour DOUBLE "
                + ")";

        String employees= "CREATE TABLE IF NOT EXISTS Employees( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + "	name VARCHAR(40), "
                + " isFired BOOLEAN   "
                + ")";

        String ratePerHourHistory= "CREATE TABLE IF NOT EXISTS RatePerHourStory( "
                + "	id INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,   "
                + " employerId INTEGER,   "
                + " ratePerHourId DOUBLE,   "
                + " startDate Date,   "
                + " FOREIGN KEY (employerId) REFERENCES Employees(id) "
                + ")";


//todo
        create(
                equipment,
                counterparty,
                country,
                currency,
                ratePerHour,
                employees,
                ratePerHourHistory
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
