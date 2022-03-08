/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.repository;

import com.sayem.chainsupershopmanagement.model.Purchase;
import com.sayem.chainsupershopmanagement.service.PurchaseService;
import java.util.Date;
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
public class PurchaseRepository implements PurchaseService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Purchase> viewAllPurchase() {
        
        Session session = sessionFactory.getCurrentSession();
        List<Purchase> purlist = session.createQuery("from Purchase").list();
        return purlist;
    }

    @Override
    public Purchase viewOnePurchase(int purid) {
        
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Purchase.class);
        crit.add(Restrictions.eq("purid", purid));
        Purchase pur = (Purchase)crit.uniqueResult();

        return pur;
    }

    @Override
    public List<Purchase> viewPurchaseByDate(Date purdate) {
        
        Session session = sessionFactory.getCurrentSession();

        Criteria crit = session.createCriteria(Purchase.class);
        crit.add(Restrictions.eq("purdate", purdate));
        List<Purchase> pur = crit.list();

        return pur;
    }

    @Override
    public Purchase insertPurchase(Purchase pur) {
        
        Session session = sessionFactory.getCurrentSession();

        session.save(pur);
        
        return pur;
    }

    @Override
    public void updatePurchase(Purchase pur) {
        
        Session session = sessionFactory.getCurrentSession();
        session.update(pur);
    }

    @Override
    public void deletePurchase(int purid) {
        
        Session session = sessionFactory.getCurrentSession();
        Purchase pur = (Purchase)session.get(Purchase.class, purid);
        session.delete(pur);
    }
    
    
}
