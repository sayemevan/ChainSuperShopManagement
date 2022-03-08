/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.service;

import com.sayem.chainsupershopmanagement.model.Pcategory;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PcategoryService {
    
    public List<Pcategory> viewAllPcategory();
    
    public List<Pcategory> viewAllPcategoryName();
    
    public Pcategory viewOneCategory(int catid);
    
    public Pcategory viewCategoryByName(String cname);
    
    public Pcategory insertCategory(Pcategory pcat);
    
    public void updateCategory(Pcategory pcat);
    
    public void deleteCategory(int catid);
}
