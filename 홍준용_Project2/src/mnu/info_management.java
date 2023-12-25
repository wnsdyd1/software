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

import java.sql.SQLException;

public class info_management {
    private pet_db petDB;  // petDB 객체
    
    public info_management() {
        petDB = new pet_db();        
    }

    boolean joinPet(String spe, int age, String gender, String med) throws SQLException {
        boolean isJoin = false;
        
        // DB 연결하기
        petDB.db_connect();
        
        System.out.println("Success Connection");
        
        // 반려동물 가입 검사
        isJoin = petDB.searchPetId(spe);
        
        if(isJoin) {
            System.out.println("다른 행동을 해야함");
            System.exit(1);
        }
       
        // 반려동물 가입
        petDB.insertPetDB(spe, age, gender, med);
        
        petDB.close();
        
        // 가입 유무 결과 반환
        return !isJoin;
    }

    boolean deletePet(String spe, int age, String gender, String med) throws SQLException {
        boolean isJoin = false;
        
        // DB 연결하기
        petDB.db_connect();
        
        System.out.println("Success Connection");
        
        // 반려동물 가입 검사
        isJoin = petDB.searchPetId(spe);
        
        if(!isJoin) {
            System.out.println("다른 행동을 해야함");
            System.exit(1);
        }
       
        // 반려동물 삭제
        petDB.deletePetDB(spe, age, gender, med);
        
        petDB.close();
        
        // 삭제 유무 결과 반환
        return isJoin;
    }

    boolean joinPet2(Pet pet) {
        boolean isJoin = false;
        
        // 반려동물 가입 검사
        System.out.println(pet.getSpe());
        
        // 반려동물 가입
        
        // 가입 유무 결과 반환
        return !isJoin;
    }

    private static class SQLException extends Exception {

        public SQLException() {
        }
    }
}
