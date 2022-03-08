/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.controller;

import com.sayem.chainsupershopmanagement.model.Branchstock;
import com.sayem.chainsupershopmanagement.service.BranchstockService;
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
public class BranchstockController {

    @Autowired
    private BranchstockService branchstockService;

    @GetMapping("/branchstock")
    public List<Branchstock> getAllBranchstock() {
        return branchstockService.viewAllBranchstock();
    }

    @GetMapping("/branchstock/{bstockid}")
    public ResponseEntity<Branchstock> getOneBranchstock(@PathVariable("bstockid") int bstockid) {
        Branchstock bstock = branchstockService.viewOneBranchstock(bstockid);
        if (bstock == null) {
            return new ResponseEntity<Branchstock>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Branchstock>(bstock, HttpStatus.OK);
    }

    @GetMapping("/branchstock/product/{branchid}")
    public ResponseEntity<List<Branchstock>> getBranchstockByBranchid(@PathVariable("branchid") int branchid) {
        List<Branchstock> bstock = branchstockService.viewOneBranchstockByBranchid(branchid);
        if (bstock == null) {
            return new ResponseEntity<List<Branchstock>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Branchstock>>(bstock, HttpStatus.OK);
    }

    @PostMapping("/branchstock")
    public Branchstock createBranchstock(@RequestBody Branchstock bstock) {
        return branchstockService.insertBranchstock(bstock);
    }

    @PutMapping("/branchstock/{bstockid}")
    public ResponseEntity<Branchstock> updateBranchstock(@PathVariable("bstockid") int bstockid, @RequestBody Branchstock bstock) {

        Branchstock currentbstock = branchstockService.viewOneBranchstock(bstockid);

        if (currentbstock == null) {
            return new ResponseEntity<Branchstock>(HttpStatus.NOT_FOUND);
        }

        currentbstock.setBstockid(bstock.getBstockid());
        currentbstock.setBranchid(bstock.getBranchid());
        currentbstock.setPid(bstock.getPid());
        currentbstock.setBstockqty(bstock.getBstockqty());

        branchstockService.updateBranchstock(currentbstock);

        return new ResponseEntity<Branchstock>(currentbstock, HttpStatus.OK);
    }

    @DeleteMapping("/branchstock/{bstockid}")
    public ResponseEntity<Branchstock> deleteBranchstock(@PathVariable("bstockid") int bstockid) {
        Branchstock bstock = branchstockService.viewOneBranchstock(bstockid);
        if (bstock == null) {
            return new ResponseEntity<Branchstock>(HttpStatus.NOT_FOUND);
        }
        branchstockService.deleteBranchstock(bstockid);
        return new ResponseEntity<Branchstock>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/dynamicinsertbstock")
    public ResponseEntity<Branchstock> dynamicUpdateBranchstock(@RequestBody Branchstock bstock) {

        Branchstock currentbstock = branchstockService.dynamicInsertBranchstock(bstock);

        if (currentbstock != null) {

            currentbstock.setBstockid(currentbstock.getBstockid());
            currentbstock.setBranchid(bstock.getBranchid());
            currentbstock.setPid(bstock.getPid());
            currentbstock.setBstockqty(currentbstock.getBstockqty()+bstock.getBstockqty());

            branchstockService.updateBranchstock(currentbstock);

            return new ResponseEntity<Branchstock>(currentbstock, HttpStatus.OK);

        } else {

            branchstockService.insertBranchstock(bstock);
            return new ResponseEntity<Branchstock>(bstock, HttpStatus.OK);
        }
    }

//    @PostMapping("/dynamicinsertbstock")
//    public Branchstock dynamicInsertBranchstock(@RequestBody Branchstock bstock){
//        return branchstockService.insertBranchstock(bstock);
//    }
}
