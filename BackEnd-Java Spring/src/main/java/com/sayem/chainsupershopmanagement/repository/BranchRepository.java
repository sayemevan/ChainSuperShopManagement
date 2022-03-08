/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.repository;

import com.sayem.chainsupershopmanagement.model.Branchinfo;
import com.sayem.chainsupershopmanagement.model.Product;
import com.sayem.chainsupershopmanagement.service.BranchService;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BranchRepository implements BranchService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Branchinfo> viewAllBranch() {
        Session session = sessionFactory.getCurrentSession();
        List<Branchinfo> branchlist = session.createQuery("from Branchinfo").list();
        
        return branchlist;
    }

    @Override
    public List<Branchinfo> viewAllBranchLocation() {
        Session session = sessionFactory.getCurrentSession();
        List<Branchinfo> branchlist = session.createQuery("select b.blocation from Branchinfo b").list();
        
        return branchlist;
    }

    @Override
    public Branchinfo viewOneBranch(int bid) {
        Session session = sessionFactory.getCurrentSession();
        Branchinfo branch = (Branchinfo)session.get(Branchinfo.class, bid);
        
        return branch;
    }

    @Override
    public Branchinfo viewBranchByLocation(String bname) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Branchinfo.class);
        crit.add(Restrictions.eq("blocation", bname));
        Branchinfo branch = (Branchinfo)crit.uniqueResult();
        
        return branch;
    }

    @Override
    public Branchinfo insertBranchLocation(Branchinfo branch) {
        
        Session session = sessionFactory.getCurrentSession();
        session.save(branch);
        
        return branch;
    }

    @Override
    public void updateBranch(Branchinfo branch) {
        Session session = sessionFactory.getCurrentSession();
        session.update(branch);
    }

    @Override
    public void deleteBranch(int bid) {
        Session session = sessionFactory.getCurrentSession();
        Branchinfo branch = (Branchinfo)session.get(Branchinfo.class, bid);
        session.delete(branch);
    }
    
}
