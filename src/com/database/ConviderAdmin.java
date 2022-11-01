/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.database;

import com.model.ModelAdmin;
import com.model.ModelDecentralization;
import com.model.ModelPermission;
import com.model.ModelTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OverLord
 */
public class ConviderAdmin {
    Statement st = null;
    ResultSet rs = null;
    DBConnection getConnect = new DBConnection();
//    ModelTable model = new ModelTable();
    
     public int getAdmin_id() {
        String sql = "Select MAX(admin_id) FROM addmin";
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
    
    public List<ModelAdmin> getDB(){
       List<ModelAdmin> list = new ArrayList<>();
        Connection conn = getConnect.getConnection();
        String sql = "SELECT * FROM addmin";
        try {
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                ModelAdmin model = new ModelAdmin();
                model.setAdmin_id(rs.getInt("admin_id"));
                model.setUserName(rs.getString("username"));
                model.setPassWord(rs.getString("password"));
                model.setFullName(rs.getString("fullname"));
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
    
    public ModelAdmin getAdmin(String username, String password) {
        ModelAdmin obj = null;
        Connection conn = getConnect.getConnection();
        String sql = "SELECT * FROM addmin WHERE username = ? AND password = ?";
        try {
            
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            rs = st.executeQuery();
            while(rs.next()) {
                obj = new ModelAdmin();
                obj.setAdmin_id(rs.getInt("admin_id"));
                obj.setUserName(rs.getString("username"));
                obj.setPassWord(rs.getString("password"));
                obj.setFullName(rs.getString("fullname"));
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
           try {
               conn.close();
           } catch (SQLException ex) {
               Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        return obj; 
    }
    
    public ModelPermission getQuyen(int id) {
               
        ModelPermission obj = null;
        Connection conn = getConnect.getConnection();
        String sql = "select q.quyen_id, q.tenquyen \n" +
                    "from addmin a \n" +
                    "join phanquyen pq on a.admin_id = pq.admin_id \n" +
                    "join quyen q on q.quyen_id = pq.quyen_id \n" +
                    "where a.admin_id = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            
            rs = st.executeQuery();
            while (rs.next()) {
                obj = new ModelPermission();
                obj.setQuyen_id(rs.getInt("quyen_id"));
                obj.setTenquyen(rs.getString("tenquyen"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Convider.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return obj;
    }
    
    public void create(ModelAdmin modelAd, ModelDecentralization modelDe) {
        PreparedStatement ps = null;
        Connection conn = getConnect.getConnection();
        String sql_ad = "INSERT INTO addmin (admin_id, username, password, fullname) VALUE ( ?, ?, ?, ?)";
        String sql_de = "INSERT INTO phanquyen (admin_id, quyen_id) VALUE ( ?, ?)";
        try {
            ps = conn.prepareStatement(sql_ad);
            ps.setInt(1, modelAd.getAdmin_id());
            ps.setString(2, modelAd.getUserName());
            ps.setString(3, modelAd.getPassWord());
            ps.setString(4, modelAd.getFullName());                    
            ps.execute();
            ps = conn.prepareStatement(sql_de);
            ps.setInt(1, modelDe.getAdmin_id());
            ps.setInt(2, modelDe.getQuyen_id());
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
    
    public void deleteUser(int id){
        PreparedStatement ps = null;
        Connection conn = getConnect.getConnection();        
        try {
            String sql_Ad = "DELETE FROM addmin WHERE admin_id = ?";
            String sql_De = "DELETE FROM phanquyen WHERE admin_id = ?";
            ps = conn.prepareStatement(sql_Ad);
            ps.setInt(1, id);
            ps.execute();
            ps = conn.prepareStatement(sql_De);
            ps.setInt(1, id);
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
