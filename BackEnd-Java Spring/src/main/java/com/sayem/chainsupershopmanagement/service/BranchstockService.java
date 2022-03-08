/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.service;

import com.sayem.chainsupershopmanagement.model.Branchstock;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface BranchstockService {
    
    public List<Branchstock> viewAllBranchstock();
    
    public Branchstock viewOneBranchstock(int bstockid);
    
    public List<Branchstock> viewOneBranchstockByBranchid(int branchid);
    
    public Branchstock insertBranchstock(Branchstock bstock);
    
    public void updateBranchstock(Branchstock bstock);
    
    public void deleteBranchstock(int bstockid);
    
    public Branchstock dynamicInsertBranchstock(Branchstock bstock);
}
