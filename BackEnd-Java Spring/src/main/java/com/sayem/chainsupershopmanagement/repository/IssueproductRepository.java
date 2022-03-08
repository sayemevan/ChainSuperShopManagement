/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.repository;

import com.sayem.chainsupershopmanagement.model.Issueproduct;
import com.sayem.chainsupershopmanagement.service.IssueproductService;
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
public class IssueproductRepository implements IssueproductService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Issueproduct> viewAllIssueproduct() {
        Session session = sessionFactory.getCurrentSession();
        List<Issueproduct> issueproductlist = session.createQuery("from Issueproduct").list();
        
        return issueproductlist;
    }

    @Override
    public Issueproduct viewOneIssueproduct(int issueid) {
        
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Issueproduct.class);
        crit.add(Restrictions.eq("issueid", issueid));
        Issueproduct issueProduct = (Issueproduct)crit.uniqueResult();
        
        return issueProduct;
    }

    @Override
    public Issueproduct insertIssueproduct(Issueproduct issueproduct) {
        
        Session session = sessionFactory.getCurrentSession();
        session.save(issueproduct);
        
        return issueproduct;
    }

    @Override
    public void updateIssueproduct(Issueproduct issueproduct) {
        
        Session session = sessionFactory.getCurrentSession();
        session.update(issueproduct);
    }

    @Override
    public void deleteIssueproduct(int issueid) {
        
        Session session = sessionFactory.getCurrentSession();
        Issueproduct issueproduct = (Issueproduct)session.get(Issueproduct.class, issueid);
        session.delete(issueproduct);
    }
    
}
