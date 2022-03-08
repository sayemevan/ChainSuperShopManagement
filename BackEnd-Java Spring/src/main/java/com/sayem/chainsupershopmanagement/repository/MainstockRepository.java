/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.repository;

import com.sayem.chainsupershopmanagement.model.Mainstock;
import com.sayem.chainsupershopmanagement.service.MainstockService;
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
public class MainstockRepository implements MainstockService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Mainstock> viewAllMainstock() {
        
        Session session = sessionFactory.getCurrentSession();
        List<Mainstock> mstocklist = session.createQuery("from Mainstock").list();
        
        return mstocklist;
    }

    @Override
    public Mainstock viewOneMainstock(int mstockid) {
        
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Mainstock.class);
        crit.add(Restrictions.eq("mstockid", mstockid));
        Mainstock mstock = (Mainstock)crit.uniqueResult();
        
        return mstock;
    }
    
    @Override
    public Mainstock viewOneMainstockByPid(int pid) {
        
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Mainstock.class);
        crit.add(Restrictions.eq("pid", pid));
        Mainstock mstock = (Mainstock)crit.uniqueResult();
        
        return mstock;
    }

    @Override
    public Mainstock insertMainstock(Mainstock mstock) {
        
        Session session = sessionFactory.getCurrentSession();
        session.save(mstock);
        
        return mstock;
    }

    @Override
    public void updateMainstock(Mainstock mstock) {
        
        Session session = sessionFactory.getCurrentSession();
        session.update(mstock);
    }

    @Override
    public void deleteMainstock(int mstockid) {
        
        Session session = sessionFactory.getCurrentSession();
        Mainstock mstock = (Mainstock)session.get(Mainstock.class, mstockid);
        session.delete(mstock);
    }

    
    
}
