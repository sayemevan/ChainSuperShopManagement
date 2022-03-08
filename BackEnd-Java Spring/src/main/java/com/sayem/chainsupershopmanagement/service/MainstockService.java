/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.service;

import com.sayem.chainsupershopmanagement.model.Mainstock;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MainstockService {
    
    public List<Mainstock> viewAllMainstock();
    
    public Mainstock viewOneMainstock(int mstockid);
    
    public Mainstock viewOneMainstockByPid(int pid);
    
    public Mainstock insertMainstock(Mainstock mstock);
    
    public void updateMainstock(Mainstock mstock);
    
    public void deleteMainstock(int mstockid);
}
