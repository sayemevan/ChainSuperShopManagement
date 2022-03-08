
package com.sayem.chainsupershopmanagement.controller;

import com.sayem.chainsupershopmanagement.model.Purchase;
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
public class PurchaseController {
    
    @Autowired
    private PurchaseService purchaseService;
    
    @GetMapping("/purchase")
    public List<Purchase> getAllPurchase(){
        return purchaseService.viewAllPurchase();
    }
    
    @GetMapping("/purchase/{purid}")
    public ResponseEntity<Purchase> getOnePurchase(@PathVariable("purid") int purid){
        Purchase purchase = purchaseService.viewOnePurchase(purid);
        if (purchase == null){
            return new ResponseEntity<Purchase>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
    }
    
    @GetMapping("/purchase/pro/{purdate}")
    public ResponseEntity<List<Purchase>> getPurchaseByDate(@PathVariable("purdate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date purdate){
        List<Purchase> purchase = purchaseService.viewPurchaseByDate(purdate);
        if (purchase == null){
            return new ResponseEntity<List<Purchase>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Purchase>>(purchase, HttpStatus.OK);
    }
    
    @PostMapping("/purchase")
    public Purchase createPurchase(@RequestBody Purchase purchase){
        return purchaseService.insertPurchase(purchase);
    }
    
    @PutMapping("/purchase/{purid}")
    public ResponseEntity<Purchase> updatePurchase(@PathVariable("purid") int purid, @RequestBody Purchase purchase){
        
        Purchase currentPurchase = purchaseService.viewOnePurchase(purid);
        
        if (currentPurchase == null){
            return new ResponseEntity<Purchase>(HttpStatus.NOT_FOUND);
        }
        
        currentPurchase.setPurid(purchase.getPurid());
        currentPurchase.setPurdate(purchase.getPurdate());
        currentPurchase.setEmailid(purchase.getEmailid());
        
        
        purchaseService.updatePurchase(currentPurchase);
        
        return new ResponseEntity<Purchase>(currentPurchase, HttpStatus.OK);
    }
    
    @DeleteMapping("/purchase/{purid}")
    public ResponseEntity<Purchase> deleteProduct(@PathVariable("purid") int purid){
        Purchase purchase = purchaseService.viewOnePurchase(purid);
        if (purchase == null){
            return new ResponseEntity<Purchase>(HttpStatus.NOT_FOUND);
        }
        purchaseService.deletePurchase(purid);
        return new ResponseEntity<Purchase>(HttpStatus.NO_CONTENT);
    }
}
