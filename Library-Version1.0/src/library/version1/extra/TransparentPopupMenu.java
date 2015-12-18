/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.extra;

import java.awt.AlphaComposite;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPopupMenu;

/**
 *
 * @author Neo_
 */
public class TransparentPopupMenu extends JPopupMenu {
    public TransparentPopupMenu() {
        super();
        setOpaque(false);
       // setBorderPainted(false);
        setCursor(Cursor.getPredefinedCursor(java.awt.Cursor.HAND_CURSOR));
    }
    public void paint(Graphics g) {
	        Graphics2D g2 = (Graphics2D) g.create();
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.7f));
	        super.paint(g2);
	        g2.dispose();
    }
}

