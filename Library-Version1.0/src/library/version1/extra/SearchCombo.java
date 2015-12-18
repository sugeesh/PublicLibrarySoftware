/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.extra;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Neo_
 */
public class SearchCombo {

    private ArrayList<String> arrayList;
    private JTextField txt;

    public SearchCombo() {
    }

    public void setSearchableCombo(final JComboBox comboBox, boolean mustSort) {
        arrayList = new ArrayList<String>();
        final int itemCount = comboBox.getItemCount();

        //Adding Item to ArrayList Without Repeating
        for (int i = 0; i < itemCount; i++) {
            boolean exists = false;
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j).equalsIgnoreCase(comboBox.getItemAt(i).toString())) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                if (comboBox.getItemAt(i) != null) {
                    arrayList.add(comboBox.getItemAt(i).toString());
                }
            }
        }

        //Sort the ArrayList
        if (mustSort) {
            Collections.sort(arrayList);
        }
 
        comboBox.setEditable(true);


        txt = (JTextField) comboBox.getEditor().getEditorComponent();
        txt.addKeyListener(new KeyAdapter() {
            @Override
          public void keyReleased(KeyEvent evt) {
                int key = evt.getKeyCode();
                if (!(key == KeyEvent.VK_ESCAPE ||  key == KeyEvent.VK_ENTER || key == KeyEvent.VK_DOWN || key == KeyEvent.VK_UP)) {
                    String s = txt.getText();
                    int caret = txt.getCaretPosition();
                    comboBox.hidePopup();
                    comboBox.removeAllItems();
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i).toUpperCase().startsWith(s.substring(0, caret).toUpperCase())) {
                            comboBox.addItem(arrayList.get(i));
                        }
                    }               
                    comboBox.showPopup();
                    if (comboBox.getItemCount() == 0) {
                     //   comboBox.hidePopup();
                    }
                    txt.setText(s);
                    txt.setCaretPosition(caret);
                } else if (key == KeyEvent.VK_ESCAPE) {
                    comboBox.setSelectedItem(txt.getText());
                    comboBox.hidePopup();
                } else if (comboBox.getSelectedIndex()==-1) {
                    if(comboBox.getItemCount()==1 ){
                        if(comboBox.getSelectedIndex()!=0){
                            comboBox.setSelectedIndex(0);
                        }else{
                            System.out.println("A");
                            comboBox.setSelectedIndex(0);
 
                        }
                        
                    }else if(comboBox.getItemCount()>1){
                        comboBox.setSelectedIndex(0);
                        
                    }else if(comboBox.getItemCount()<1){
                        System.out.println("B");
  
                    }
                }
              
                
            }
  
            
        });
    }
}
