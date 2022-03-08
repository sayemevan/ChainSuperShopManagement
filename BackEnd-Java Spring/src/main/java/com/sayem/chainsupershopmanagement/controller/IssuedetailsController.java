/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.controller;

import com.sayem.chainsupershopmanagement.model.Issuedetails;
import com.sayem.chainsupershopmanagement.service.IssuedetailsService;
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
public class IssuedetailsController {
    
    @Autowired
    private IssuedetailsService issuedetailsService;
    
    @GetMapping("/issuedetails")
    public List<Issuedetails> getAllIssuedetails(){
        return issuedetailsService.viewAllIssuedetails();
    }
    
    @GetMapping("/issuedetails/{issuedetid}")
    public ResponseEntity<Issuedetails> getOneIssuedetails(@PathVariable("issuedetid") int issuedetid){
        Issuedetails issuedetails = issuedetailsService.viewOneIssuedetails(issuedetid);
        if (issuedetails == null){
            return new ResponseEntity<Issuedetails>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Issuedetails>(issuedetails, HttpStatus.OK);
    }
    
    @PostMapping("/issuedetails")
    public Issuedetails createIssuedetails(@RequestBody Issuedetails issuedetails){
        return issuedetailsService.insertIssuedetails(issuedetails);
    }
    
    @PutMapping("/issuedetails/{issuedetid}")
    public ResponseEntity<Issuedetails> updateIssueproduct(@PathVariable("issuedetid") int issuedetid, @RequestBody Issuedetails issuedetails){
        
        Issuedetails currentissuedetails = issuedetailsService.viewOneIssuedetails(issuedetid);
        
        if (currentissuedetails == null){
            return new ResponseEntity<Issuedetails>(HttpStatus.NOT_FOUND);
        }
        
        currentissuedetails.setIssuedetid(issuedetails.getIssuedetid());
        currentissuedetails.setIssueid(issuedetails.getIssueid());
        currentissuedetails.setPid(issuedetails.getPid());
        currentissuedetails.setIssueqty(issuedetails.getIssueqty());
        currentissuedetails.setSpricerate(issuedetails.getSpricerate());
        currentissuedetails.setStatus(issuedetails.getStatus());
        currentissuedetails.setBranchid(issuedetails.getBranchid());
        
        
        
        
        issuedetailsService.updateIssuedetails(currentissuedetails);
        
        return new ResponseEntity<Issuedetails>(currentissuedetails, HttpStatus.OK);
    }
    
    @DeleteMapping("/issuedetails/{issuedetid}")
    public ResponseEntity<Issuedetails> deleteIssueproduct(@PathVariable("issuedetid") int issuedetid){
        Issuedetails issuedetails = issuedetailsService.viewOneIssuedetails(issuedetid);
        if (issuedetails == null){
            return new ResponseEntity<Issuedetails>(HttpStatus.NOT_FOUND);
        }
        issuedetailsService.deleteIssuedetails(issuedetid);
        return new ResponseEntity<Issuedetails>(HttpStatus.NO_CONTENT);
    }
}
