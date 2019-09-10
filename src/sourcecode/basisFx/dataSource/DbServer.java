package basisFx.dataSource;

import basisFx.DbSchemaPrice;

import java.sql.DriverManager;
import java.sql.Statement;

import basisFx.appCore.utils.PropertiesUtils;
import basisFx.appCore.utils.Registry;
import org.hsqldb.persist.HsqlProperties;

public class DbServer extends Db{

    protected Statement statement = null;
    private String db_name=PropertiesUtils.getProperty("db_name");
        private String db_path=PropertiesUtils.getProperty("db_path");
    private String db_folder=PropertiesUtils.getProperty("db_folder");
    private DbSchema dbSchema;

    public DbServer(DbSchema dbSchema)  {

        this.dbSchema=dbSchema;

        if (db_path == null) {
            Registry.windowFabric.infoWindow("В локальных свойствах не задан путь БД");
        }else {
                init();
                dbSchema.create();
            }
    }

    private void init() {
        HsqlProperties props = new HsqlProperties();

        props.setProperty("server.database.0", "file:" + db_path +db_folder+"/"+ db_name);
        props.setProperty("server.dbname.0", db_name);


        sonicServer = new org.hsqldb.Server();

        try {
            sonicServer.setProperties(props);
        } catch (Exception e) {

            Registry.windowFabric.infoWindow("sonicServer.setProperties(props)   не сработал!!\n\n".toUpperCase()+ e.getMessage() );
            System.err.println(e.getMessage());
        }

        try {
               sonicServer.start();
        } catch (Exception e) {
            Registry.windowFabric.infoWindow("sonicServer.start()   не сработал!!\n\n".toUpperCase()+ e.getMessage() );
            System.err.println(e.getMessage());
        }

//           sonicServer.shutdown();

        createConnection();
    }

    private void createConnection() {
        try {

            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
            Db.connection= DriverManager.getConnection(
//                    "jdbc:hsqldb:hsql://localhost:9001/", "SA", "");
                    "jdbc:hsqldb:hsql://localhost/"+db_name, "SA", "");
            statement=this.connection.createStatement();
            statement.setQueryTimeout(30);

        } catch (Exception e) {
            Registry.windowFabric.infoWindow("Не получилось подключиться к базе данных!!\n\n".toUpperCase()+ e.getMessage() );
            System.err.println(e.getMessage());

        }
    }


}
