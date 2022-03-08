
package com.sayem.chainsupershopmanagement.service;

import com.sayem.chainsupershopmanagement.model.Branchsale;
import com.sayem.chainsupershopmanagement.model.Purchase;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface BranchsaleService {
    
    public List<Branchsale> viewAllBranchsale();
    
    public Branchsale viewOneBranchsale(int bsaleid);
    
    public List<Branchsale> viewBranchsaleByDate(Date saledate);
    
    public Branchsale insertBranchsale(Branchsale bsale);
    
    public void updateBranchsale(Branchsale bsale);
    
    public void deleteBranchsale(int bsaleid);
}
