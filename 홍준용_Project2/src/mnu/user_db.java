/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mnu;

import java.sql.*;
import org.mariadb.jdbc.Connection;

/**
 *
 * @author MNU
 */
public class user_db {
    private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;
    
    public user_db () {
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

    boolean searchId(String id) throws SQLException {
        boolean result = false;
        String sql = null;
        ResultSet val;
        
        sql = "SELECT * FROM user WHERE id = 'lim2'";
        // DB에 id가 있는지 검사
        val = stmt.executeQuery(sql);
        
        if(val.getRow() >= 1){
            result = true;
        } else {
            result = false;
        }
        
        return result;
    }

    void insertDB(String id, String password, String name, String address, String number) throws SQLException{
        
        String sql;
        
        sql = "insert into user (id, password, name, address, number) values (?,?,?,?,?)";
        
        pstmt = con.prepareStatement(sql);
            
        // sql과 연결 작업: set
        pstmt.setString(1, id);
        pstmt.setString(2, password);
        pstmt.setString(3, name);
        pstmt.setString(4,number);
           
        pstmt.executeUpdate();
    }
        void DeleteDB(String id, String password, String name, String address, String number) throws SQLException{
        
        String sql;
        
        sql = "DELETE FROM user WHERE id = ? AND password = ? AND name = ? AND number = ? ";
        
        pstmt = con.prepareStatement(sql);
            
        // sql과 연결 작업: set
        pstmt.setString(1, id);
        pstmt.setString(2, password);
        pstmt.setString(3, name);
        pstmt.setString(4,number);
   
           
        pstmt.executeUpdate();
    }

    void DeleteDB(String id, String password, String name, String number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
