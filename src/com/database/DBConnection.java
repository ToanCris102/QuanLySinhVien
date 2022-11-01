/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OverLord
 */
public class DBConnection {
    private final String dbURL = "jdbc:mysql://localhost/quanlysinhvien";
    private final String userName = "root";
    private final String userPassword = "";    
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Ket noi thanh cong");
            return DriverManager.getConnection(dbURL, userName, userPassword);
      
        } catch (SQLException ex) {
            System.out.println("Connect failded");
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Connect failded");
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
