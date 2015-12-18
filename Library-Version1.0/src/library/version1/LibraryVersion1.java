/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1;



import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import library.version1.view.SPlashScreen;


import library.version1.view.UserLogin;

/**
 *
 * @author Neo_
 */
public class LibraryVersion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       //set Look and Feel
        try {
            UIManager.setLookAndFeel(new AcrylLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LibraryVersion1.class.getName()).log(Level.SEVERE, null, ex);
        }
          new UserLogin().setVisible(true);       // TODO code application logic here
          
        
       
    }
}
