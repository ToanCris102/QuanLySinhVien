/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.database.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.model.ModelTable;
import java.sql.Date;
/**
 *
 * @author OverLord
 */
public class Convider {
    Statement st = null;
    ResultSet rs = null;
    DBConnection getConnect = new DBConnection();
//    ModelTable model = new ModelTable();
    public List<ModelTable> getDB(){
       List<ModelTable> list = new ArrayList<>();
        Connection conn = getConnect.getConnection();
        String sql = "SELECT * FROM student";
        try {
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                ModelTable model = new ModelTable();
                model.setId(rs.getInt("id"));
                model.setHoSV(rs.getString("hosv"));
                model.setTenSV(rs.getString("tensv"));
                model.setMssv(rs.getString("mssv"));
                model.setKhoa(rs.getInt("khoa"));
                model.setMaNganh(rs.getString("manganh"));
                model.setGioiTinh(rs.getString("gioitinh"));
                model.setNgaySinh(rs.getString("ngaysinh"));
                model.setSoDienThoai(rs.getString("sodienthoai"));              
                list.add(model);
                
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
           try {
               conn.close();
           } catch (SQLException ex) {
               Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        
        
        return null;        
    }
    public int getID() {
        String sql = "Select MAX(id) FROM student";
        Connection conn = getConnect.getConnection();
        int max = 0;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            rs.next();
            max = rs.getInt(1);
            return max;
        } catch (SQLException ex) {
            Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return 0;
    }

    public void save(ModelTable model) {
        PreparedStatement ps = null;
        Connection conn = getConnect.getConnection();
        String sql = "INSERT INTO student (id, hosv, tensv, mssv, khoa, manganh, gioitinh, ngaysinh, sodienthoai) VALUE ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, model.getId());
            ps.setString(2, model.getHoSV());
            ps.setString(3, model.getTenSV());
            ps.setString(4, model.getMssv());
            ps.setInt(5, model.getKhoa());
            ps.setString(6, model.getMaNganh());
            ps.setString(7, model.getGioiTinh());
            ps.setString(8, model.getNgaySinh());
            ps.setString(9, model.getSoDienThoai());            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
        
    }

    public void update(ModelTable model) {
        PreparedStatement ps = null;
        Connection conn = getConnect.getConnection();
        
        try {
            String sql = "UPDATE student SET hosv = ?,tensv = ?, mssv = ?, khoa = ?, manganh = ?, gioitinh = ?, ngaysinh = ?, sodienthoai = ? WHERE id = ?";
            ps = conn.prepareStatement(sql);            
            ps.setString(1, model.getHoSV());
            ps.setString(2, model.getTenSV());            
            ps.setString(3, model.getMssv());
            ps.setInt(4, model.getKhoa());
            ps.setString(5, model.getMaNganh());
            ps.setString(6, model.getGioiTinh());
            ps.setString(7, model.getNgaySinh());
            ps.setString(8, model.getSoDienThoai());
            ps.setInt(9, model.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
    
    public void delete(ModelTable model) {
        PreparedStatement ps = null;
        Connection conn = getConnect.getConnection();        
        try {
            String sql = "DELETE FROM student WHERE id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, model.getId());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }
}
