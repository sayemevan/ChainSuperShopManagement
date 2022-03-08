/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.service;

import com.sayem.chainsupershopmanagement.model.Issuedetails;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IssuedetailsService {
    
    public List<Issuedetails> viewAllIssuedetails();
    
    public Issuedetails viewOneIssuedetails(int issuedetid);
    
    public Issuedetails insertIssuedetails(Issuedetails issuedetails);
    
    public void updateIssuedetails(Issuedetails issuedetails);
    
    public void deleteIssuedetails(int issuedetid);
}
