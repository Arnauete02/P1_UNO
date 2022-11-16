package dao;

import utils.Constants;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private Connection connection;
    private Constants constants;

    public Database() {
        this.constants = new Constants();
    }

    public void connect() throws SQLException {
        connection = DriverManager.getConnection(constants.CONNECTION, constants.USER_CONNECTION, constants.PASS_CONNECTION);
    }

    public void disconnect() throws SQLException{
        if (connection != null) connection.close();
    }
}
