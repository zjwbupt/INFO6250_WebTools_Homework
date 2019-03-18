package DAO;

import java.sql.*;
import org.apache.commons.dbutils.*;

public class DAO {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/moviedb";
    private static final String user = "root";
    private static final String password = "p@ssw0rd";
    private Connection connection;
    public Connection getConnection() throws Exception {
        try {
            Connection connection = null;
            DbUtils.loadDriver(JDBC_DRIVER);
            this.connection = DriverManager.getConnection(DB_URL, user, password);
        } catch (SQLException ex) {
            System.out.println("SQL Exception");
            ex.printStackTrace();
            throw new Exception();
        }
        return this.connection;
    }
}
