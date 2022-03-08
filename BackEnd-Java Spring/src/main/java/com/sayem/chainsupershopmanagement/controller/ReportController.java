/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.controller;

import com.sayem.chainsupershopmanagement.model.PurchaseReport;
import com.sayem.chainsupershopmanagement.repository.JasperReportDAO;
import java.io.File;
import java.io.FileOutputStream;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
//@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
//@RestController
@Controller
public class ReportController {

//    @RequestMapping(value = "/reportView", method = RequestMethod.GET)
//    public String loadSurveyPg(
//            @ModelAttribute("reportInputForm") PurchaseReport reportInputForm, Model model) {
//        model.addAttribute("reportInputForm", reportInputForm);
//        return "report";
//    }

    @RequestMapping(value = "/reportViewsir", method = RequestMethod.GET)
    public String generateReport( HttpServletRequest request, HttpServletResponse response) throws JRException, IOException, SQLException, NamingException {

        System.out.println("jasper report");

        String reportFileName = "test";
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            JasperReport jasperReport = jrdao.getCompiledFile(reportFileName, request);

            jrdao.generateReportPDF(response, hmParams, jasperReport, conn);

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }

        return null;
    }
    
    
    @GetMapping("/reportView")
    public void generateaReport( HttpServletRequest request, HttpServletResponse response) throws Exception, IOException, SQLException, NamingException {

        System.out.println("jasper report");

        String reportFileName = "test";
        
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            
            JasperPrint jasperReport = jrdao.getCompiledFile2(reportFileName, hmParams, request);
            
            response.setContentType("application/pdf");
            
            OutputStream out = response.getOutputStream();
            
            JasperExportManager.exportReportToPdfStream(jasperReport, out);

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }
    }
    
    @GetMapping("/reportView1/AllPurchase")
    public void generateAllPurchaseReport(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException, SQLException, NamingException {

        System.out.println("jasper report");

        String reportFileName = "test";
        
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            
            JasperPrint jasperReport = jrdao.getCompiledFile2(reportFileName, hmParams, request);
            
            response.setContentType("application/pdf");
            
            OutputStream out = response.getOutputStream();
            
            JasperExportManager.exportReportToPdfStream(jasperReport, out);

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }
    }
    
    @GetMapping("/reportView2/{fdate}/{tdate}")
    public void generateDatePurchaseReport(@PathVariable("fdate") String fdate, @PathVariable("tdate") String tdate, HttpServletRequest request, HttpServletResponse response) throws Exception, IOException, SQLException, NamingException {

        System.out.println("jasper report");

        String reportFileName = "Datepurchase";
        
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("fdate", fdate);
            hmParams.put("tdate", tdate);
            
            JasperPrint jasperReport = jrdao.getCompiledFile2(reportFileName, hmParams, request);
            
            response.setContentType("application/pdf");
            
            OutputStream out = response.getOutputStream();
            
            JasperExportManager.exportReportToPdfStream(jasperReport, out);

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }
    }
    
    @GetMapping("/reportView3/AllSale")
    public void generateAllSaleReport(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException, SQLException, NamingException {

        System.out.println("jasper report");

        String reportFileName = "Totalsale";
        
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            
            JasperPrint jasperReport = jrdao.getCompiledFile2(reportFileName, hmParams, request);
            
            response.setContentType("application/pdf");
            
            OutputStream out = response.getOutputStream();
            
            JasperExportManager.exportReportToPdfStream(jasperReport, out);

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }
    }
    
    @GetMapping("/reportView4/{fdate}/{tdate}")
    public void generateDateSaleReport(@PathVariable("fdate") String fdate, @PathVariable("tdate") String tdate, HttpServletRequest request, HttpServletResponse response) throws Exception, IOException, SQLException, NamingException {

        System.out.println("jasper report");

        String reportFileName = "Datesale";
        
        JasperReportDAO jrdao = new JasperReportDAO();
        Connection conn = null;
        try {
            conn = jrdao.getConnection();
            
            HashMap<String, Object> hmParams = new HashMap<String, Object>();
            hmParams.put("fdate", fdate);
            hmParams.put("tdate", tdate);
            
            JasperPrint jasperReport = jrdao.getCompiledFile2(reportFileName, hmParams, request);
            
            response.setContentType("application/pdf");
            
            OutputStream out = response.getOutputStream();
            
            JasperExportManager.exportReportToPdfStream(jasperReport, out);

        } catch (SQLException sqlExp) {
            System.out.println("Exception::" + sqlExp.toString());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    conn = null;
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }

        }
    }
    
//    @PostMapping("/reportView")
//    public void generateReport(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException, SQLException, NamingException {
//
//        System.out.println("jasper report");
//
//        String reportFileName = "All Purchase";
//        
//        JasperReportDAO jrdao = new JasperReportDAO();
//        Connection conn = null;
//        try {
//            conn = jrdao.getConnection();
//            
//            String title = request.getParameter("Rep_Title");
//            
//            HashMap<String, Object> hmParams = new HashMap<String, Object>();
//            hmParams.put("Rep_Title", title);
//            
//            JasperPrint jasperReport = jrdao.getCompiledFile(reportFileName, title, request);
//            
//            response.setContentType("application/pdf");
//            
//            OutputStream out = response.getOutputStream();
//            
//            JasperExportManager.exportReportToPdfStream(jasperReport, out);
//
//        } catch (SQLException sqlExp) {
//            System.out.println("Exception::" + sqlExp.toString());
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                    conn = null;
//                } catch (SQLException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//
//            }
//
//        }
//    }
    
}
    
   
