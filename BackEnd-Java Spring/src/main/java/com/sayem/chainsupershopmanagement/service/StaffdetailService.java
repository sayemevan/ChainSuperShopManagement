/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.service;

import com.sayem.chainsupershopmanagement.model.Staffdetail;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface StaffdetailService {
    
    public List<Staffdetail> viewAllStaffdetail();
    
    public Staffdetail viewOneStaffdetail(int staffid);
    
    public List<Staffdetail> viewStaffdetailByBranchId(int branchid);
    
    public Staffdetail insertStaffdetail(Staffdetail staffdetail);
    
    public void updateStaffdetail(Staffdetail staffdetail);
    
    public void deleteStaffdetail(int staffid);
    
}
