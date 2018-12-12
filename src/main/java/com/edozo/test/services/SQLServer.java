package com.edozo.test.services;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.sql.*;

@Service
public class SQLServer {

    /**
     * Get an active connection to the database
     *
     * @return Connection
     */
    public static Connection getConnection() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/edozo";
        Connection con = null;

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(connectionUrl, "admin", "test");
        } catch (Exception e) {
            // Do nothing
            System.out.println("connection error " + e.getMessage());
        }
        return con;
    }

    /**
     * Convert Result set to JSONArray
     *
     * @param resultSet Result set data from Database
     * @return JSONArray
     * @throws SQLException Any SQL Exception
     */
    public static JSONArray convertToJSON(ResultSet resultSet)
            throws SQLException {
        JSONArray jsonArray = new JSONArray();
        while (resultSet.next()) {
            int total_rows = resultSet.getMetaData().getColumnCount();
            JSONObject obj = new JSONObject();
            for (int i = 0; i < total_rows; i++) {
                obj.put(resultSet.getMetaData().getColumnLabel(i + 1),
                        resultSet.getObject(i + 1));
            }
            jsonArray.put(obj);
        }
        return jsonArray;
    }

    /**
     * Get SQL result from database as a JSONArray
     *
     * @param query Statement as a String
     * @return Result set in a JSONArray
     * @throws SQLException Any SQL Exception
     */
    public static JSONArray getSQL(String query) throws SQLException {
        Connection conn = SQLServer.getConnection();
        Statement statement = conn.createStatement();
        ResultSet set = statement.executeQuery(query);

        // Convert result set to JSONArray
        JSONArray value = SQLServer.convertToJSON(set);
        // Close connection
        conn.close();
        return value;
    }
}
