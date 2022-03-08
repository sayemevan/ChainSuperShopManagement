/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.controller;

import com.sayem.chainsupershopmanagement.model.Branchinfo;
import com.sayem.chainsupershopmanagement.model.PurchaseReport;
import com.sayem.chainsupershopmanagement.repository.JasperReportDAO;
import com.sayem.chainsupershopmanagement.service.BranchService;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class BranchController {
    
    @Autowired
    private BranchService branchService;
    
    @GetMapping("/branch")
    public List<Branchinfo> getAllBranch(){
        return branchService.viewAllBranch();
    }
    
    @GetMapping("/branch/branchlist")
    public List<Branchinfo> getAllBranchLocation(){
        return branchService.viewAllBranchLocation();
    }
    
    @GetMapping("/branch/{bid}")
    public ResponseEntity<Branchinfo> getOneBranch(@PathVariable("bid") int bid){
        Branchinfo branch = branchService.viewOneBranch(bid);
        if (branch == null){
            return new ResponseEntity<Branchinfo>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Branchinfo>(branch, HttpStatus.OK);
    }
    
    @GetMapping("/branch/pro/{bname}")
    public ResponseEntity<Branchinfo> getBranchByLocation(@PathVariable("bname") String bname){
        Branchinfo branch = branchService.viewBranchByLocation(bname);
        if (branch == null){
            return new ResponseEntity<Branchinfo>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Branchinfo>(branch, HttpStatus.OK);
    }
    
    @GetMapping("/branch/id/{bname}")
    public ResponseEntity<Integer> getBranchIdByLocation(@PathVariable("bname") String bname){
        Branchinfo branch = branchService.viewBranchByLocation(bname);
        if (branch == null){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Integer>(branch.getBranchid(), HttpStatus.OK);
    }
    
    @GetMapping("/branch/location/{bid}")
    public ResponseEntity<String> getOneBranchLocationById(@PathVariable("bid") int bid){
        Branchinfo branch = branchService.viewOneBranch(bid);
        if (branch == null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(branch.getBlocation(), HttpStatus.OK);
    }
    
    @PostMapping("/branch")
    public Branchinfo createBranch(@RequestBody Branchinfo branch){
        return branchService.insertBranchLocation(branch);
    }
    
    @PutMapping("/branch/{bid}")
    public ResponseEntity<Branchinfo> updateProduct(@PathVariable("bid") int bid, @RequestBody Branchinfo branch){
        
        Branchinfo currentbranch = branchService.viewOneBranch(bid);
        
        if (currentbranch == null){
            return new ResponseEntity<Branchinfo>(HttpStatus.NOT_FOUND);
        }
        
        currentbranch.setBranchid(branch.getBranchid());
        currentbranch.setBlocation(branch.getBlocation());
        currentbranch.setBcontact(branch.getBcontact());
        currentbranch.setBemail(branch.getBemail());
        currentbranch.setBdesc(branch.getBdesc());
        
        branchService.updateBranch(currentbranch);
        
        return new ResponseEntity<Branchinfo>(currentbranch, HttpStatus.OK);
    }
    
    @DeleteMapping("/branch/{bid}")
    public ResponseEntity<Branchinfo> deleteProduct(@PathVariable("bid") int bid){
        Branchinfo branch = branchService.viewOneBranch(bid);
        if (branch == null){
            return new ResponseEntity<Branchinfo>(HttpStatus.NOT_FOUND);
        }
        branchService.deleteBranch(bid);
        return new ResponseEntity<Branchinfo>(HttpStatus.NO_CONTENT);
    }
    
}
