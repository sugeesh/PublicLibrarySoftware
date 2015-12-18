/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.extra;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Neo_
 */
public class Validate {
     public static boolean validateLetters(String txt) {
        String regx = "^[a-zA-Z\\s\b(.)]*$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        boolean b = matcher.find();
        return b;
   }
     
   public static boolean validateDigits(String txt) {
        String regx = "^[0-9\b]*$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        boolean b = matcher.find();
        return b;
   }
     
   public static boolean validateFloatingPointNumbers(String txt) {
        String regx = "^[0-9\b(.)]*$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        boolean b = matcher.find();
        return b;
   }
   
   public static boolean validateDeweyNumber(String txt) {
        String regx = "^[0-9\b(.)]{0,7}+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        boolean b = matcher.find();
        System.out.println(b);
        return b;
   }
    
   public static boolean validateAccessionNumber(String txt) {
        String regx = "^[0-9\b]{0,5}+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        boolean b = matcher.find();
        return b;
   } 
   
   public static boolean validateMemberNumber(String txt) {
        String regx = "^[0-9\b]{0,4}+$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        boolean b = matcher.find();
        return b;
   }
   
   public static boolean validateDate(String txt) {
        String regx = "^[0-9\b(-)]*$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        boolean b = matcher.find();
        return b;
   }
    
    public static boolean validateLettersName(String txt) {
        String regx = "^[a-zA-Z\\s\b(.)(&)]*$";
        Pattern pattern = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(txt);
        boolean b = matcher.find();
        return b;
   }
}
