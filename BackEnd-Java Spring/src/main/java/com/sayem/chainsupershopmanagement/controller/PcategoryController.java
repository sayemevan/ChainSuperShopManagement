/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.controller;

import com.sayem.chainsupershopmanagement.model.Pcategory;
import com.sayem.chainsupershopmanagement.service.PcategoryService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class PcategoryController {
    
    @Autowired
    private PcategoryService pcategoryService;
    
    @GetMapping("/pcategory")
    public List<Pcategory> getAllPcategory(){
        return pcategoryService.viewAllPcategory();
    }
    
    @GetMapping("/pcategory/catnamelist")
    public List<Pcategory> getAllPcategoryName(){
        return pcategoryService.viewAllPcategoryName();
    }
    
    @GetMapping("/pcategory/{catid}")
    public ResponseEntity<Pcategory> getOneCategory(@PathVariable("catid") int catid){
        Pcategory pcategory = pcategoryService.viewOneCategory(catid);
        if (pcategory == null){
            return new ResponseEntity<Pcategory>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pcategory>(pcategory, HttpStatus.OK);
    }
    
    @GetMapping("/pcategory/cat/{cname}")
    public ResponseEntity<Pcategory> getCategoryByName(@PathVariable("cname") String cname){
        Pcategory pcategory = pcategoryService.viewCategoryByName(cname);
        if (pcategory == null){
            return new ResponseEntity<Pcategory>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Pcategory>(pcategory, HttpStatus.OK);
    }
    
    @GetMapping("/pcategory/id/{cname}")
    public ResponseEntity<Integer> getCategoryIdByName(@PathVariable("cname") String cname){
        Pcategory pcategory = pcategoryService.viewCategoryByName(cname);
        if (pcategory == null){
            return new ResponseEntity<Integer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Integer>(pcategory.getCatid(), HttpStatus.OK);
    }
    
    @GetMapping("/pcategory/name/{catid}")
    public ResponseEntity<String> getOneCategoryNameById(@PathVariable("catid") int catid){
        Pcategory pcategory = pcategoryService.viewOneCategory(catid);
        if (pcategory == null){
            return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(pcategory.getCatname(), HttpStatus.OK);
    }
    
    @PostMapping("/pcategory")
    public Pcategory createPcategory(@RequestBody Pcategory pcategory){
        return pcategoryService.insertCategory(pcategory);
    }
    
    @PutMapping("/pcategory/{catid}")
    public ResponseEntity<Pcategory> updateCategory(@PathVariable("catid") int catid, @RequestBody Pcategory pcategory){
        
        Pcategory currentpcategory = pcategoryService.viewOneCategory(catid);
        
        if (currentpcategory == null){
            return new ResponseEntity<Pcategory>(HttpStatus.NOT_FOUND);
        }
        
        currentpcategory.setCatid(pcategory.getCatid());
        currentpcategory.setCatname(pcategory.getCatname());
        currentpcategory.setCatdesc(pcategory.getCatdesc());
        
        pcategoryService.updateCategory(currentpcategory);
        
        return new ResponseEntity<Pcategory>(currentpcategory, HttpStatus.OK);
    }
    
    @DeleteMapping("/pcategory/{catid}")
    public ResponseEntity<Pcategory> deleteCategory(@PathVariable("catid") int catid){
        Pcategory pcategory = pcategoryService.viewOneCategory(catid);
        if (pcategory == null){
            return new ResponseEntity<Pcategory>(HttpStatus.NOT_FOUND);
        }
        pcategoryService.deleteCategory(catid);
        return new ResponseEntity<Pcategory>(HttpStatus.NO_CONTENT);
    }
 
}
