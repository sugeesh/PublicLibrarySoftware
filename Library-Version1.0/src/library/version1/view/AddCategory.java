/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.view;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import library.version1.controller.CategoryController;
import library.version1.extra.IdGenarate;
import library.version1.extra.Validate;
import library.version1.model.Category;

/**
 *
 * @author Neo_
 */
public class AddCategory extends javax.swing.JDialog {
    int close; 
    
    /**
     * Creates new form AddCategory
     */
    public AddCategory(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        setTitle("Add Category Form");
        setLocationRelativeTo(parent);
        
        setNewForm();
        
        
    }
    
    public AddCategory(java.awt.Frame parent, boolean modal, int close) {
        super(parent, modal);
        initComponents();
        
        this.close = close;
        setTitle("Add Category Form");
        setLocationRelativeTo(parent);
        
        setNewForm();
        
        
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
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        categoryPanel = new javax.swing.JPanel();
        idText = new javax.swing.JTextField();
        deweyNumberText = new javax.swing.JTextField();
        deweyNumberLabel = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        idLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Documents-icon.png"))); // NOI18N
        titleLabel.setText("New Category");

        addButton.setText("Add");
        addButton.setEnabled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        categoryPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Category"));

        idText.setEditable(false);
        idText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextActionPerformed(evt);
            }
        });

        deweyNumberText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deweyNumberTextActionPerformed(evt);
            }
        });
        deweyNumberText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                deweyNumberTextFocusGained(evt);
            }
        });
        deweyNumberText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deweyNumberTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                deweyNumberTextKeyReleased(evt);
            }
        });

        deweyNumberLabel.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        deweyNumberLabel.setText("Dewey Decimal Classification Number");

        nameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextActionPerformed(evt);
            }
        });
        nameText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nameTextKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTextKeyReleased(evt);
            }
        });

        idLabel.setText("Category Id");

        nameLabel.setText("Category Name");

        javax.swing.GroupLayout categoryPanelLayout = new javax.swing.GroupLayout(categoryPanel);
        categoryPanel.setLayout(categoryPanelLayout);
        categoryPanelLayout.setHorizontalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(categoryPanelLayout.createSequentialGroup()
                        .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel)
                            .addComponent(idLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameText)
                            .addComponent(idText)))
                    .addGroup(categoryPanelLayout.createSequentialGroup()
                        .addComponent(deweyNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deweyNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        categoryPanelLayout.setVerticalGroup(
            categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(categoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(categoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deweyNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deweyNumberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(categoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(categoryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void setNewForm(){
        try {
            idText.setText(IdGenarate.getId("C", "CId","Category"));
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Connection Error ","Error Message", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database Error ","Error Message", JOptionPane.ERROR_MESSAGE);
        }
        addButton.setEnabled(false);
        nameText.setText(null);
        deweyNumberText.setText(null);        
        nameText.requestFocus();
    }
    
    
    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {
           // NumberFormat numberFormat = NumberFormat.getInstance();
           // numberFormat.setMinimumIntegerDigits(3);
          //  numberFormat.setGroupingUsed(false);
            
            String id=idText.getText();
            String name=nameText.getText();
            String dewyNumber=deweyNumberText.getText();              //numberFormat.format(Double.parseDouble(deweyNumberText.getText()));
            Category category =new Category(id,name,dewyNumber);
            
            int result = CategoryController.addCategory(category);
            if(result==1){                         // TODO add your handling code here:
                JOptionPane.showMessageDialog(this,"Category Added");
            }
            setNewForm(); 
            if(close!=0){
               this.setVisible(false);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Connection Error ","Error Message", JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Database Error ","Error Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_addButtonActionPerformed

    
    
    
    private void deweyNumberTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deweyNumberTextActionPerformed
        addButton.doClick();         // TODO add your handling code here:
    }//GEN-LAST:event_deweyNumberTextActionPerformed

    private void nameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextActionPerformed
       deweyNumberText.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);         // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void nameTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextKeyPressed
       
       if(!Validate.validateLettersName(evt.getKeyChar()+"")){
           nameText.setEditable(false);
       }else{
           nameText.setEditable(true);
       }
                   // TODO add your handling code here:
    }//GEN-LAST:event_nameTextKeyPressed

    private void deweyNumberTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deweyNumberTextKeyPressed
       if(!Validate.validateDeweyNumber(deweyNumberText.getText()+evt.getKeyChar()+"")){
           if(evt.getKeyCode()!= KeyEvent.VK_BACK_SPACE){
               deweyNumberText.setEditable(false);
           }else{
               deweyNumberText.setEditable(true);
           }
       }else{
           deweyNumberText.setEditable(true);
       }            // TODO add your handling code here:
    }//GEN-LAST:event_deweyNumberTextKeyPressed

    private void nameTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTextKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextKeyReleased

    private void deweyNumberTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_deweyNumberTextFocusGained
        if(nameText.getText().isEmpty()){
            nameText.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_deweyNumberTextFocusGained

    private void deweyNumberTextKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deweyNumberTextKeyReleased
        if(!deweyNumberText.getText().isEmpty()){
            addButton.setEnabled(true);
        }else{
            addButton.setEnabled(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_deweyNumberTextKeyReleased

    private void idTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextActionPerformed

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
            java.util.logging.Logger.getLogger(AddCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCategory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddCategory dialog = new AddCategory(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton addButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel categoryPanel;
    private javax.swing.JLabel deweyNumberLabel;
    private javax.swing.JTextField deweyNumberText;
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idText;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameText;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
