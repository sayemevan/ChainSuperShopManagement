/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.service;

import com.sayem.chainsupershopmanagement.model.Branchinfo;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface BranchService {
    
    public List<Branchinfo> viewAllBranch();
    
    public List<Branchinfo> viewAllBranchLocation();
    
    public Branchinfo viewOneBranch(int bid);
    
    public Branchinfo viewBranchByLocation(String bname);
    
    public Branchinfo insertBranchLocation(Branchinfo branch);
    
    public void updateBranch(Branchinfo branch);
    
    public void deleteBranch(int bid);
}
