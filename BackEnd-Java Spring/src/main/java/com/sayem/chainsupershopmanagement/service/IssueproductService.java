/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.service;

import com.sayem.chainsupershopmanagement.model.Issueproduct;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IssueproductService {
    
    public List<Issueproduct> viewAllIssueproduct();
    
    public Issueproduct viewOneIssueproduct(int issueid);
    
    public Issueproduct insertIssueproduct(Issueproduct issueproduct);
    
    public void updateIssueproduct(Issueproduct issueproduct);
    
    public void deleteIssueproduct(int issueid);
}
