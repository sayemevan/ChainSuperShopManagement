/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.controller;

import com.sayem.chainsupershopmanagement.model.Receiveproduct;
import com.sayem.chainsupershopmanagement.service.ReceiveproductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ReceiveProductController {
    
    @Autowired
    private ReceiveproductService receiveproductService;
    
    @GetMapping("/receiveproduct")
    public List<Receiveproduct> getAllReceiveproduct(){
        return receiveproductService.viewAllReceiveproduct();
    }
    
    @GetMapping("/receiveproduct/{recid}")
    public ResponseEntity<Receiveproduct> getOneReceiveproduct(@PathVariable("recid") int recid){
        Receiveproduct receiveproduct = receiveproductService.viewOneReceiveproduct(recid);
        if (receiveproduct == null){
            return new ResponseEntity<Receiveproduct>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Receiveproduct>(receiveproduct, HttpStatus.OK);
    }
    
    @PostMapping("/receiveproduct")
    public Receiveproduct createReceiveproduct(@RequestBody Receiveproduct receiveproduct){
        return receiveproductService.insertReceiveproduct(receiveproduct);
    }
    
    @PutMapping("/receiveproduct/{recid}")
    public ResponseEntity<Receiveproduct> updateReceiveproduct(@PathVariable("recid") int recid, @RequestBody Receiveproduct receiveproduct){
        
        Receiveproduct currentreceiveproduct = receiveproductService.viewOneReceiveproduct(recid);
        
        if (currentreceiveproduct == null){
            return new ResponseEntity<Receiveproduct>(HttpStatus.NOT_FOUND);
        }
        
        currentreceiveproduct.setRecid(receiveproduct.getRecid());
        currentreceiveproduct.setBranchid(receiveproduct.getBranchid());
        currentreceiveproduct.setRecdate(receiveproduct.getRecdate());
        currentreceiveproduct.setIssueid(receiveproduct.getIssueid());
        currentreceiveproduct.setIssuedetid(receiveproduct.getIssuedetid());
        currentreceiveproduct.setStatus(receiveproduct.getStatus());
        
        
        
        
        receiveproductService.updateReceiveproduct(currentreceiveproduct);
        
        return new ResponseEntity<Receiveproduct>(currentreceiveproduct, HttpStatus.OK);
    }
    
    @DeleteMapping("/receiveproduct/{recid}")
    public ResponseEntity<Receiveproduct> deleteReceiveproduct(@PathVariable("recid") int recid){
        Receiveproduct receiveproduct = receiveproductService.viewOneReceiveproduct(recid);
        if (receiveproduct == null){
            return new ResponseEntity<Receiveproduct>(HttpStatus.NOT_FOUND);
        }
        receiveproductService.deleteReceiveproduct(recid);
        return new ResponseEntity<Receiveproduct>(HttpStatus.NO_CONTENT);
    }
    
}
