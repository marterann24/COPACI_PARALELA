package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

public class DataBaseConnection {
    private Connection connection;

    public DataBaseConnection() {
        try {
            //Carga de datos y configuración desde properties
            Properties properties = new Properties();
            InputStream input = getClass().getClassLoader()
                .getResourceAsStream("DB/config/database.properties");
            
            if (input == null) {
                throw new RuntimeException("No se encontró database.properties");
            }
            properties.load(input);
            
            // Configuración para PostgreSQL
            String url = "jdbc:postgresql://" + 
                properties.getProperty("database.server") + ":" +
                properties.getProperty("database.port") + "/" +
                properties.getProperty("database.name");
            
            String usuario = properties.getProperty("database.username");
            String password = properties.getProperty("database.password");
            
           // System.out.println("Conectando a PostgreSQL: " + url);
            
            // Driver PostgreSQL
            Class.forName("org.postgresql.Driver");
            
            // Conexión
            connection = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conexión exitosa a PostgreSQL");
            
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: Driver PostgreSQL no encontrado");
            System.err.println("Descarga: https://jdbc.postgresql.org/download/");
        } catch (SQLException e) {
            System.err.println("ERROR PostgreSQL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}