/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.extra;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import library.version1.db.DBConnection;
import library.version1.db.DBHandle;

/**
 *
 * @author Neo_
 */
public class IdGenarate {
    
    public static String getId(String prefix,String column,String table) throws ClassNotFoundException, SQLException{
        
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMinimumIntegerDigits(3);
        numberFormat.setGroupingUsed(false);
        
        String sql="SELECT "+column+" FROM "+table+" ORDER BY "+column+" DESC LIMIT 1";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        if(result.next()){
            String bigId=result.getString(column);
            int index=0;
            for(int i=0;i<bigId.length();i++){
                char character=bigId.charAt(i);
                if(Character.isDigit(character)){
                    index=i;
                    break;
                }
            }
            String digit=bigId.substring(index);
            int intDigit=Integer.parseInt(digit);
            intDigit++;
            
            String newId = prefix+numberFormat.format(intDigit);
            return newId;
        }else{
            return prefix+"001";
        }
        
    
    }
    
    
    
    public static String getSpecialId(String prefix,String column,String table, int number) throws ClassNotFoundException, SQLException{
        
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMinimumIntegerDigits(3);
        numberFormat.setGroupingUsed(false);
        
        String sql="SELECT "+column+" FROM "+table+" ORDER BY "+column+" DESC LIMIT 1";
        ResultSet result=DBHandle.getData(DBConnection.getDBConnection().getConnection(), sql);
        if(result.next()){
            String bigId=result.getString(column);
            int index=0;
            for(int i=0;i<bigId.length();i++){
                char character=bigId.charAt(i);
                if(Character.isDigit(character)){
                    index=i;
                    break;
                }
            }
            String digit=bigId.substring(index);
            int intDigit=Integer.parseInt(digit);
            intDigit=intDigit+number;
            
            String newId = prefix+numberFormat.format(intDigit);
            return newId;
        }else{
            return prefix+"001";
        }
    }
    
}
