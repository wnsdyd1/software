/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mnu;

/**
 *
 * @author admin
 */
package mnu;

import java.sql.*;
import org.mariadb.jdbc.Connection;

public class pet_db {
    private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    
    public pet_db() {
        this.con = null;
        this.stmt = null;
        this.pstmt = null;
    }
    
    public void db_connect() {
        String id, password, url;
        String driverName;        
    
        // 초기화
        id = "test";
        password = "1234";
        url = "jdbc:mariadb://localhost:3307/test";
        driverName = "org.mariadb.jdbc.Driver";
    
        try {
            // DB에 연결시키기
            Class.forName(driverName);
            con = (Connection) DriverManager.getConnection(url, id, password);
        
            stmt = con.createStatement();
        
        } catch (ClassNotFoundException ex) {         
            System.out.println("클래스 에러 틀린 내용");
        } catch (SQLException ex) {          
            System.out.println("SQL 에러 내용");
        }
    }
    
    public void close() throws SQLException{
        stmt.close();
        pstmt.close();
        con.close();
    }

    boolean searchPetId(String spe) throws SQLException {
        boolean result = false;
        String sql = null;
        ResultSet val;
        
        sql = "SELECT * FROM pet WHERE spe = ?";
        // DB에 spe가 있는지 검사
        pstmt = con.prepareStatement(sql);
        pstmt.setString(1, spe);
        val = pstmt.executeQuery();
        
        if (val.next()) {
            result = true;
        } else {
            result = false;
        }
        
        return result;
    }

    void insertPetDB(String spe, int age, String gender, String med) throws SQLException{
        
        String sql;
        
        sql = "INSERT INTO pet (spe, age, gender, med) VALUES (?, ?, ?, ?)";
        
        pstmt = con.prepareStatement(sql);
            
        // sql과 연결 작업: set
        pstmt.setString(1, spe);
        pstmt.setInt(2, age);
        pstmt.setString(3, gender);
        pstmt.setString(4, med);
           
        pstmt.executeUpdate();
    }
    
    void deletePetDB(String spe, int age, String gender, String med) throws SQLException{
        
        String sql;
        
        sql = "DELETE FROM pet WHERE spe = ? AND age = ? AND gender = ? AND med = ?";
        
        pstmt = con.prepareStatement(sql);
            
        // sql과 연결 작업: set
        pstmt.setString(1, spe);
        pstmt.setInt(2, age);
        pstmt.setString(3, gender);
        pstmt.setString(4, med);
   
        pstmt.executeUpdate();
    }

    void deletePetDB(String spe) throws SQLException{
        
        String sql;
        
        sql = "DELETE FROM pet WHERE spe = ?";
        
        pstmt = con.prepareStatement(sql);
            
        // sql과 연결 작업: set
        pstmt.setString(1, spe);
   
        pstmt.executeUpdate();
    }
}
