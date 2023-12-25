/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mnu;

import java.sql.SQLException;

/**
 *
 * @author MNU
 */
public class user_management {
    private user_db userDB;  // userDB 객체
    
    public user_management() {
        userDB = new user_db();        
    }

    boolean join(String id, String password, String name, String address, String number) throws SQLException {
        boolean isJoin = false;
        
        // DB 연결하기
        userDB.db_connect();
        
        System.out.println("success Connection");
        
        // 회원 가입 검사
        isJoin = userDB.searchId(id);
        
        if(isJoin == true) {
            System.out.println("다른 행동을 해야함");
            System.exit(1);
        }
       
        // 회원 가입
        userDB.insertDB(id, password, name, address, number);
        
        userDB.close();
        
        // 가입 유무 결과 반환
        if(isJoin ) {
            return false; 
        } else {
            return true;
        }
        
    }
        boolean Delete(String id, String password, String name, String number) throws SQLException {
        boolean isJoin = false;
        
        // DB 연결하기
        userDB.db_connect();
        
        System.out.println("success Connection");
        
       
        isJoin = userDB.searchId(id);
        
        if(isJoin == true) {
            System.out.println("다른 행동을 해야함");
            System.exit(1);
        }
       
        //정보삭제
        userDB.DeleteDB(id, password, name, number);
        
        userDB.close();
        
        // 삭제 유무 결과 반환
        if(isJoin ) {
            return false; 
        } else {
            return true;
        }
        
    }

    boolean join2(User user) {
        boolean isJoin = false;
        
        // 회원 가입 검사
        System.out.println(user.getId());
        
        // 회원 가입
        
        // 가입 유무 결과 반환
        if(isJoin ) {
            return false; 
        } else {
            return true;
        }
    }

    boolean join(String id, String password, String name, String number) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
