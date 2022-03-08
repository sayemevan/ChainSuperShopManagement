/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.service;

import com.sayem.chainsupershopmanagement.model.Purchasedetails;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PurchaseDetailsService {
    
    public List<Purchasedetails> viewAllPurchasedetails();
    
    public Purchasedetails viewOnePurchasedetails(int purdetid);
    
    public Purchasedetails insertPurchasedetails(Purchasedetails purdet);
    
    public void updatePurchasedetails(Purchasedetails purdet);
    
    public void deletePurchasedetails(int purdetid);
}
