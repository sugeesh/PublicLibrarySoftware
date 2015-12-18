/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.view;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import library.version1.controller.BookController;
import library.version1.controller.BookTitleController;
import library.version1.controller.MemberController;
import library.version1.controller.OrderController;
import library.version1.extra.IdGenarate;
import library.version1.extra.Validate;
import library.version1.model.Order;
import library.version1.model.OrderBookDetail;
import library.version1.model.OrderDetail;

/**
 *
 * @author Neo_
 */
public class AddOrder extends javax.swing.JDialog {

    /**
     * Creates new form OrderBook
     */
    public AddOrder(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        
        
        try {
            String oBId= IdGenarate.getId("O","OId","OrderBook");
            orderIdText.setText(oBId);
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database Error ","Error Message", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Connection Error ","Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public AddOrder(java.awt.Frame parent, boolean modal,String title) {
        super(parent, modal);
        initComponents();
        
        setLocationRelativeTo(null);
        bookTitleText.setText(title);
        memberNumberText.requestFocus();
        try {
            String oBId= IdGenarate.getId("O","OId","OrderBook");
            orderIdText.setText(oBId);
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database Error ","Error Message", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Connection Error ","Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        orderIdLabel = new javax.swing.JLabel();
        bookTitleLabel = new javax.swing.JLabel();
        memberNumberLabel = new javax.swing.JLabel();
        orderIdText = new javax.swing.JTextField();
        bookTitleText = new javax.swing.JTextField();
        memberNumberText = new javax.swing.JTextField();
        cancelButton = new javax.swing.JButton();
        acceptButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/document-yellow-icon.png"))); // NOI18N
        titleLabel.setText("Order Book");

        orderIdLabel.setText("Order Id");

        bookTitleLabel.setText("Book Title");

        memberNumberLabel.setText("Member Number");

        orderIdText.setEnabled(false);

        bookTitleText.setEnabled(false);
        bookTitleText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bookTitleTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bookTitleTextKeyReleased(evt);
            }
        });

        memberNumberText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memberNumberTextActionPerformed(evt);
            }
        });
        memberNumberText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                memberNumberTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                memberNumberTextKeyReleased(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        acceptButton.setText("Accept");
        acceptButton.setEnabled(false);
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bookTitleLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(orderIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(memberNumberLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(memberNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(orderIdText, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookTitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(orderIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(orderIdText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(memberNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(memberNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookTitleText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookTitleTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookTitleTextKeyReleased
          if(!bookTitleText.getText().isEmpty()){   // TODO add your handling code here:
              acceptButton.setEnabled(true);
          }else{
              acceptButton.setEnabled(false);
          }
    }//GEN-LAST:event_bookTitleTextKeyReleased

    private void bookTitleTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookTitleTextKeyPressed
         // TODO add your handling code here:
    }//GEN-LAST:event_bookTitleTextKeyPressed

    private void memberNumberTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memberNumberTextKeyPressed
        if(!Validate.validateMemberNumber(memberNumberText.getText()+evt.getKeyChar()+"")){
           if(evt.getKeyCode()!=KeyEvent.VK_BACK_SPACE){
               getToolkit().beep();
               memberNumberText.setEditable(false);
           }else{
               memberNumberText.setEditable(true);
           }
       }else{
           memberNumberText.setEditable(true);
       }          // TODO add your handling code here:
    }//GEN-LAST:event_memberNumberTextKeyPressed

    private void memberNumberTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memberNumberTextActionPerformed
        if(!memberNumberText.getText().isEmpty()){
            acceptButton.setEnabled(true);        // TODO add your handling code here:
            acceptButton.doClick();
        } 
    }//GEN-LAST:event_memberNumberTextActionPerformed

    private void memberNumberTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_memberNumberTextKeyReleased
        try {
            if(!memberNumberText.getText().isEmpty() && MemberController.checkMember(memberNumberText.getText())){            // TODO add your handling code here:
                 acceptButton.setEnabled(true);
            }else{
                 acceptButton.setEnabled(false);
             }
        } catch (SQLException ex) {
              JOptionPane.showMessageDialog(this, "Database Error ","Error Message", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(this, "Connection Error ","Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_memberNumberTextKeyReleased

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        if(!bookTitleText.getText().isEmpty() && !memberNumberText.getText().isEmpty()){
            String longTitle = bookTitleText.getText();
            int index=longTitle.length();
            for(int i=0;i<longTitle.length();i++){
                if(longTitle.charAt(i)==','){
                    index=i;
                    break;
                }
            }
            String title=longTitle.substring(1, index);
            
            String memberNumber = memberNumberText.getText();
            try {
            
                ArrayList<String> accessionNumbers = BookTitleController.getAccessionNumbersForTitle(title);
                ArrayList<String> rightBooks= new ArrayList<String>();
                for(String accessionNumber : accessionNumbers){
                    String rightBook = BookTitleController.getTitleForBook(accessionNumber);
                    if(rightBook.equals(longTitle)){
                        rightBooks.add(accessionNumber);
                    }
                }
                boolean cBook = false;
                
                if(rightBooks.size()!=0){
                    for(String accessionNumber : rightBooks){
                        if(BookController.checkAvailability(accessionNumber)){
                            cBook=true;
                            JOptionPane.showMessageDialog(this, "There is a book at AccessionNumber "+accessionNumber,"Remembering", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }
                    }   
                }else{
                    cBook=true;
                }
                
                boolean cMember = OrderController.checkMember(memberNumber);
              
                if(!cBook){
                    if(!cMember){
                        
                        String oId= orderIdText.getText();
                        ArrayList<OrderBookDetail> orderBookDetailList = new ArrayList<OrderBookDetail>();
                       
                        for(String accessionNumber : accessionNumbers){
                            OrderBookDetail orderBookDetail=new OrderBookDetail(oId, accessionNumber);
                            orderBookDetailList.add(orderBookDetail);
                        }
                        Order order = new Order(oId, memberNumber, orderBookDetailList, title);
                    
                        OrderController.addOrder(order);
                    }else{
                        JOptionPane.showMessageDialog(null, "You have already Ordered a Book","Remembering", JOptionPane.INFORMATION_MESSAGE);
                    }
                }else{
                    
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database Error ","Error Message", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Connection Error ","Error Message", JOptionPane.ERROR_MESSAGE);
            }
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(this, "Please Fill the Form Completely");
        }               // TODO add your handling code here:
    }//GEN-LAST:event_acceptButtonActionPerformed

    
    
    
    
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddOrder dialog = new AddOrder(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JLabel bookTitleLabel;
    private javax.swing.JTextField bookTitleText;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel memberNumberLabel;
    private javax.swing.JTextField memberNumberText;
    private javax.swing.JLabel orderIdLabel;
    private javax.swing.JTextField orderIdText;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}