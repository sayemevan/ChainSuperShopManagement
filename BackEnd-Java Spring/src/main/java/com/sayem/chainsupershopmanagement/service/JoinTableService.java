
package com.sayem.chainsupershopmanagement.service;

import com.sayem.chainsupershopmanagement.model.Branchsale;
import com.sayem.chainsupershopmanagement.model.Issuedetails;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface JoinTableService {
    
    public List<Object[]> getAllProductWithCatName();
    
    public List<Object[]> getAllProductAndPurchaseAndPurchaseDetail();
    
    public List<Object[]> getMainStockDetails();
    
    public List<Object[]> getIssueproductDetailsWithProductAndBranch();
    
    public List<Object[]> getReceivedproductlistwithissuedetails(int branchid);
    
    public List<Object[]> getReceiveDetailswithissuedetails(int branchid);
    
    public List<Object[]> getPendingReceivedproductlistwithissuedetails(int branchid);
    
    public List<Issuedetails> getIssueproductDetailsWithProductBranch(int branchid);
    
    public List<Object[]> getBranchStockDetails();
    
    public List<Object[]> getBranchStockDetailsViaBranchid(int branchid);
    
    public List<Branchsale> getBranchSaleIDViaBranchid(int branchid);
    
    public List<Object[]> getBranchSaleDetailsEverything();
}
