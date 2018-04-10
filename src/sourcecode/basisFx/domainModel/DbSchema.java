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


//todo
        create(
                equipment,
                counterparty,
                country,
                currency,
                ratePerHour,
                currentEmployeesState,
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
