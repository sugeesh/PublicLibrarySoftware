/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Neo_
 */
public class BackUpController {
     public static boolean checkName(String password){
         try {        
             String executeCmd = "mysql -uroot -p"+password;
             Runtime.getRuntime().exec(executeCmd);
             return true;
         } catch (IOException ex) {
             return false;
         }
         
     }
}
