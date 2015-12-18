/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package library.version1.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import library.version1.db.DBConnection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Neo_
 */
public class ReportController {
     
    public static void bookListReport(String source) throws JRException, ClassNotFoundException, SQLException {
        JasperReport jr = JasperCompileManager.compileReport(source);
        JasperPrint jp = JasperFillManager.fillReport(jr, null, DBConnection.getDBConnection().getConnection());
        JasperViewer.viewReport(jp, false);
    }
    
    public static void monthlyReport(String source,String member, JRMapCollectionDataSource dataSource) throws JRException, ClassNotFoundException, SQLException {
        Map param = new HashMap();
        param.put("Month", member);
        
        JasperReport jr = JasperCompileManager.compileReport(source);
        JasperPrint jp = JasperFillManager.fillReport(jr,param,dataSource);
        JasperViewer.viewReport(jp, false);
    }
  

}
