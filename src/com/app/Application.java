/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app;

import com.form.Delete;
import com.form.Login;
import com.form.Main;
import com.form.Regist;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author OverLord
 */
public class Application {
    
    private static Login loginForm = new Login();
    private static Regist registForm = new Regist();
    private static Main mainForm = new Main();
    private static Delete delete = new Delete(); 

    public static Delete getDelete() {
        return delete;
    }

    public static void setDelete(Delete delete) {
        Application.delete = delete;
    }
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            loginForm.pack();
            loginForm.setLocationRelativeTo(null);
            loginForm.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Login getLoginForm() {
        return loginForm;
    }
    
    public static Main getMainForm() {
        return mainForm;
    }
    
    public static Regist getRegistForm() {
        return registForm;
    }
}
