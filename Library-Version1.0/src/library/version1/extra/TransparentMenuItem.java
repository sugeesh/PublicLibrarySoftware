/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.extra;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JMenuItem;

/**
 *
 * @author Neo_
 */
public class TransparentMenuItem extends JMenuItem{
	   public TransparentMenuItem(String text) {
	       super(text);
	       setOpaque(false);
               setContentAreaFilled(false); //to make the content area transparent
               setBorderPainted(false);
               
           }    
           public void paint(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g.create();
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
	        super.paint(g2);
	        g2.dispose();
	    }
}

