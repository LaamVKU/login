/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodien;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author PC
 */
public class sqliteConnection {
   
Connection conn= null;
public static Connection dbConnector(){
try{
    Class.forName("org.sqlite.JDBC");
    Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\_huynh ty\\hoctap\\FPT POLYTECHNIC\\QUAN LI SU AN VOI ANGILE\\QuanLyDuAn - Copy\\netmanager.sqlite");
     //JOptionPane.showMessageDialog(null, "Connection Successful");
    return conn;
}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    return null;
}
    


}

    public static void main(String[] args) {
        sqliteConnection.dbConnector();
    }
}
