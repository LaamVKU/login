/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giaodien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class thanhvienSqlite {
    Connection con = null ;
    public static ResultSet rs = null;
   
    
    public  thanhvienSqlite(){
    con = sqliteConnection.dbConnector();
    }
    
    
    // select table Thanhvien
    
    public ResultSet selectThanhvien(){
     
        String query ="select ID_user,Username,Hesotien,naptien,thucpham,no from thanhvien";
        try {
            PreparedStatement pst = con.prepareStatement(query);
             rs = pst.executeQuery();
        } catch (SQLException ex) {
            System.out.println(""+ex.toString());
        }
        return rs;
    }
    
    // show data is selected
	public void showData(ResultSet rs) {
		try {
			while (rs.next()) {
				System.out.printf("%-10s %-20s %-20s \n", rs.getInt(1),
						rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
		}
	}
        
        
        // insert thanh vien 
        
        public void addthanhvien(thanhvien tv){
            String query ="insert into thanhvien values (? , ? , ? , ? , ? , ?)";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, tv.getID_user());
            pst.setString(2, tv.getName());
            pst.setInt(3, tv.getHesotien());
            pst.setString(4, tv.getNaptien());
            pst.setString(5, tv.getThucpham());
            pst.setString(6, tv.getNo());
            
            // khi them hoac update phai co ham nay
            pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Thêm mới thành công");
                  

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "thêm k thành công !" +ex.toString());
           
        }
        }
        
        
        // UPDATE THANH VIEN
        public void updatethanhvien(int id,thanhvien tv){
            String query ="Update thanhvien set Username = ? ,Hesotien = ? ,naptien = ? ,thucpham = ? ,no = ? where ID_user = ? ";
        try {
            PreparedStatement pst = con.prepareStatement(query);
              pst.setString(1, tv.getName());
                            pst.setInt(2, tv.getHesotien());
                            pst.setString(3, tv.getNaptien());
                            pst.setString(4, tv.getThucpham());
                            pst.setString(5, tv.getNo());
                            pst.setInt(6, tv.getID_user());
                            
                            // phải có hàm này mới đc
                            pst.executeUpdate();
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "cập nhật k thành công"+ex.toString());
        }
        }
        
        
        //DELETE THÀNH VIÊN
        
        public void delete(int id){
        String query ="delete from thanhvien where ID_user= ?";
        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,id);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã xóa thành công");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Xóa k thành công erro :" +ex.toString());
        }
        }
    
    
    public static void main(String[] args) {
        thanhvienSqlite tvi = new thanhvienSqlite();
      //  tvi.addthanhvien(new thanhvien(4,"test",3,"dv","vv","vvv"));
      // tvi.showData(tvi.selectThanhvien());
      
        
    }
    
}
