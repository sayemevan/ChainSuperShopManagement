/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.repository;

import com.sayem.chainsupershopmanagement.model.Receivedetail;
import com.sayem.chainsupershopmanagement.service.ReceivedetailService;
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
public class ReceivedetailRepository implements ReceivedetailService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Receivedetail> viewAllReceivedetail() {
        
        Session session = sessionFactory.getCurrentSession();
        List<Receivedetail> receivedetaillist = session.createQuery("from Receivedetail").list();
        
        return receivedetaillist;
    }

    @Override
    public Receivedetail viewOneReceivedetail(int recdetid) {
        
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Receivedetail.class);
        crit.add(Restrictions.eq("recdetid", recdetid));
        Receivedetail receivedetail = (Receivedetail)crit.uniqueResult();
        
        return receivedetail;
    }

    @Override
    public Receivedetail insertReceivedetail(Receivedetail receivedetail) {
        
        Session session = sessionFactory.getCurrentSession();
        session.save(receivedetail);
        
        return receivedetail;
    }

    @Override
    public void updateReceivedetail(Receivedetail receivedetail) {
        
        Session session = sessionFactory.getCurrentSession();
        session.update(receivedetail);
    }

    @Override
    public void deleteReceivedetail(int recdetid) {
        
        Session session = sessionFactory.getCurrentSession();
        Receivedetail receivedetail = (Receivedetail)session.get(Receivedetail.class, recdetid);
        session.delete(receivedetail);
    }
    
    
    
}
