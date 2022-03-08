/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.controller;

import com.sayem.chainsupershopmanagement.model.Branchsale;
import com.sayem.chainsupershopmanagement.model.Purchase;
import com.sayem.chainsupershopmanagement.service.BranchsaleService;
import com.sayem.chainsupershopmanagement.service.PurchaseService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class BranchsaleController {
    
    @Autowired
    private BranchsaleService branchsaleService;
    
    @GetMapping("/branchsale")
    public List<Branchsale> getAllBranchsale(){
        return branchsaleService.viewAllBranchsale();
    }
    
    @GetMapping("/branchsale/{bsaleid}")
    public ResponseEntity<Branchsale> getOneBranchsale(@PathVariable("bsaleid") int bsaleid){
        Branchsale bsale = branchsaleService.viewOneBranchsale(bsaleid);
        if (bsale == null){
            return new ResponseEntity<Branchsale>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Branchsale>(bsale, HttpStatus.OK);
    }
    
    @GetMapping("/branchsale/getsale/{saledate}")
    public ResponseEntity<List<Branchsale>> getBranchsaleByDate(@PathVariable("saledate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date saledate){
        List<Branchsale> bsale = branchsaleService.viewBranchsaleByDate(saledate);
        if (bsale == null){
            return new ResponseEntity<List<Branchsale>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Branchsale>>(bsale, HttpStatus.OK);
    }
    
    @PostMapping("/branchsale")
    public Branchsale createBranchsale(@RequestBody Branchsale bsale){
        return branchsaleService.insertBranchsale(bsale);
    }
    
    @PutMapping("/branchsale/{bsaleid}")
    public ResponseEntity<Branchsale> updatePurchase(@PathVariable("bsaleid") int bsaleid, @RequestBody Branchsale bsale){
        
        Branchsale currentBranchsale = branchsaleService.viewOneBranchsale(bsaleid);
        
        if (currentBranchsale == null){
            return new ResponseEntity<Branchsale>(HttpStatus.NOT_FOUND);
        }
        
        currentBranchsale.setBsaleid(bsale.getBsaleid());
        currentBranchsale.setBranchid(bsale.getBranchid());
        currentBranchsale.setSaledate(bsale.getSaledate());
        currentBranchsale.setStaffid(bsale.getStaffid());
        currentBranchsale.setStatus(bsale.getStatus());
       
        
        
        branchsaleService.updateBranchsale(currentBranchsale);
        
        return new ResponseEntity<Branchsale>(currentBranchsale, HttpStatus.OK);
    }
    
    @DeleteMapping("/branchsale/{bsaleid}")
    public ResponseEntity<Branchsale> deleteProduct(@PathVariable("bsaleid") int bsaleid){
        Branchsale bsale = branchsaleService.viewOneBranchsale(bsaleid);
        if (bsale == null){
            return new ResponseEntity<Branchsale>(HttpStatus.NOT_FOUND);
        }
        branchsaleService.deleteBranchsale(bsaleid);
        return new ResponseEntity<Branchsale>(HttpStatus.NO_CONTENT);
    }
}
