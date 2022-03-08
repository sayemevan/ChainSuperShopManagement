/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.controller;

import com.sayem.chainsupershopmanagement.model.Staffdetail;
import com.sayem.chainsupershopmanagement.service.StaffdetailService;
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
public class StaffdetailController {
    
    @Autowired
    private StaffdetailService staffdetailService;
    
    @GetMapping("/staffdetail")
    public List<Staffdetail> getAllStaffdetail(){
        return staffdetailService.viewAllStaffdetail();
    }
    
    @GetMapping("/staffdetail/{staffid}")
    public ResponseEntity<Staffdetail> getOneStaffdetail(@PathVariable("staffid") int staffid){
        Staffdetail staff = staffdetailService.viewOneStaffdetail(staffid);
        if (staff == null){
            return new ResponseEntity<Staffdetail>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Staffdetail>(staff, HttpStatus.OK);
    }
    
    @GetMapping("/staffdetail/staff/{branchid}")
    public ResponseEntity<List<Staffdetail>> getStaffdetailByBranchId(@PathVariable("branchid") int branchid){
        List<Staffdetail> staffs = staffdetailService.viewStaffdetailByBranchId(branchid);
        if (staffs == null){
            return new ResponseEntity<List<Staffdetail>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Staffdetail>>(staffs, HttpStatus.OK);
    }
    
    @PostMapping("/staffdetail")
    public Staffdetail createStaffdetail(@RequestBody Staffdetail staff){
        return staffdetailService.insertStaffdetail(staff);
    }
    
    @PutMapping("/staffdetail/{staffid}")
    public ResponseEntity<Staffdetail> updateProduct(@PathVariable("staffid") int staffid, @RequestBody Staffdetail staff){
        
        Staffdetail currentstaff = staffdetailService.viewOneStaffdetail(staffid);
        
        if (currentstaff == null){
            return new ResponseEntity<Staffdetail>(HttpStatus.NOT_FOUND);
        }
        
        currentstaff.setStaffid(staff.getStaffid());
        currentstaff.setBranchid(staff.getBranchid());
        currentstaff.setName(staff.getName());
        currentstaff.setSemail(staff.getSemail());
        currentstaff.setDob(staff.getDob());
        currentstaff.setGender(staff.getGender());
        currentstaff.setAddress(staff.getAddress());
        currentstaff.setJdate(staff.getJdate());
        currentstaff.setStatus(staff.isStatus());
        currentstaff.setDesignation(staff.getDesignation());
        currentstaff.setStaffimg(staff.getStaffimg()); 

        
        staffdetailService.updateStaffdetail(currentstaff);
        
        return new ResponseEntity<Staffdetail>(currentstaff, HttpStatus.OK);
    }
    
    @DeleteMapping("/staffdetail/{staffid}")
    public ResponseEntity<Staffdetail> deleteProduct(@PathVariable("staffid") int staffid){
        Staffdetail staff = staffdetailService.viewOneStaffdetail(staffid);
        if (staff == null){
            return new ResponseEntity<Staffdetail>(HttpStatus.NOT_FOUND);
        }
        staffdetailService.deleteStaffdetail(staffid);
        return new ResponseEntity<Staffdetail>(HttpStatus.NO_CONTENT);
    }
}
