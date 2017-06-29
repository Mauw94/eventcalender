package be.pxl.eventcalender.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Maurits on 29-6-2017.
 */
public class MySQLConnUtils {

    public static Connection getMySQLConnection() throws ClassNotFoundException, SQLException{
        String hostName = "localhost";
        String dbName = "events";
        String user = "root";
        String password = null;
        return getMySQLConnection(hostName, dbName, user, password);
    }

    public static Connection getMySQLConnection(String hostName, String dbName, String user, String password)
        throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:msql://" + hostName + "/" + dbName, user, password);
    }
}
