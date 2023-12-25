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

    boolean join(String id, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
public class LoginManager {
    
    private UserDB userDB;  // 사용자 정보를 관리하는 데이터베이스 클래스

    public LoginManager() {
        userDB = new UserDB();
    }

    public boolean login(String enteredId, String enteredPassword) {
        try {
            // 사용자 정보를 데이터베이스에서 조회
            User user = userDB.getUserById(enteredId);

            // 사용자가 존재하고 비밀번호가 일치하면 로그인 성공
            if (user != null && user.getPassword().equals(enteredPassword)) {
                System.out.println("로그인 성공!");
                return true;
            } else {
                System.out.println("로그인 실패: 아이디 또는 비밀번호가 일치하지 않습니다.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("로그인 실패: 데이터베이스 오류 - " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        // 로그인 매니저 객체 생성
        LoginManager loginManager = new LoginManager();

        // 로그인 시도
        String inputId = "testUser";        // 사용자가 입력한 아이디
        String inputPassword = "testPassword";  // 사용자가 입력한 비밀번호

        loginManager.login(inputId, inputPassword);
    }
}