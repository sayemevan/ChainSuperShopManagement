/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.service;

import com.sayem.chainsupershopmanagement.model.Purchase;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PurchaseService {
    
    public List<Purchase> viewAllPurchase();
    
    public Purchase viewOnePurchase(int purid);
    
    public List<Purchase> viewPurchaseByDate(Date purdate);
    
    public Purchase insertPurchase(Purchase pur);
    
    public void updatePurchase(Purchase pur);
    
    public void deletePurchase(int purid);
}
