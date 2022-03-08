/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.service;

import com.sayem.chainsupershopmanagement.model.Receiveproduct;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ReceiveproductService {
    
    public List<Receiveproduct> viewAllReceiveproduct();
    
    public Receiveproduct viewOneReceiveproduct(int recid);
    
    public Receiveproduct insertReceiveproduct(Receiveproduct receiveproduct);
    
    public void updateReceiveproduct(Receiveproduct receiveproduct);
    
    public void deleteReceiveproduct(int recid);
}
