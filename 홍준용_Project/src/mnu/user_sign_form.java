/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mnu;
import java.lang.System.Logger;
import mnu.Result_Join;
import mnu.Result_Join;
import mnu.User;
import mnu.User;
import mnu.user_management;
/**
 *
 * @author admin
 */
public class user_sign_form extends javax.swing.JFrame {
    // 속성
    user_management userObj; // 객체 선언
    Result_Join resultObj;
    private User user; // 객체 선언
  
    /**
     * Creates new form user_sign
     */
    public user_sign_form() {
        initComponents();
        userObj = new user_management();
        resultObj = new Result_Join();
        user = new User();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_pwd = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        lbl_num = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();
        txt_num = new javax.swing.JTextField();
        txt_pwd = new javax.swing.JTextField();
        btn_join = new javax.swing.JButton();
        lbl_id = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_pwd.setText("패스워드");

        lbl_name.setText("이름");

        lbl_num.setText("전화번호");
        lbl_num.setToolTipText("");

        btn_join.setText("회원가입하기");
        btn_join.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_joinjoin(evt);
            }
        });

        lbl_id.setText("아이디");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_id)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(lbl_num)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_name)
                                .addComponent(lbl_pwd, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(40, 40, 40)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(246, 246, 246))
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btn_join)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_pwd)
                    .addComponent(txt_pwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_name)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_num))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(61, 61, 61)
                .addComponent(btn_join)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_joinjoin(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_joinjoin
        // TODO add your handling code here:
        // 변수 선언
        String id, password, name, address, number;

        boolean isJoin = false;

        // 1. 사용자 정보 입력하기
        id = txt_id.getText();
        password = txt_pwd.getText();
        name = txt_name.getText();
        number = txt_num.getText();

        try {
            // 2. 회원 가입하기
            isJoin = userObj.join(id, password, name,  number);
        } catch (Exception e) {

        }

        // 3. 가입유무 출력하기
        if (isJoin ) {
            // 결과를 전송하기
            resultObj.setID(id);
            resultObj.setVisible(true);
        } else {

        }

    }//GEN-LAST:event_btn_joinjoin

    
        private void join(java.awt.event.MouseEvent evt) {                      
        // TODO add your handling code here:
        // 변수 선언
        String id, password, name, address, number;
        
        boolean isJoin = false;
        
        // 1. 사용자 정보 입력하기
        id = txt_id.getText();
        password = txt_pwd.getText();
        name = txt_name.getText();
        number = txt_num.getText();
        
        
        try {
            // 2. 회원 가입하기
            isJoin = userObj.join(id, password, name,  number);
        } catch (Exception e) {
            
        }
        
        // 3. 가입유무 출력하기
        if (isJoin ) {
            // 결과를 전송하기
            resultObj.setID(id);
            resultObj.setVisible(true);
        } else {
            
        }
 
    }   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(user_sign_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_sign_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_sign_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_sign_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user_sign_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_join;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_num;
    private javax.swing.JLabel lbl_pwd;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_num;
    private javax.swing.JTextField txt_pwd;
    // End of variables declaration//GEN-END:variables
}
