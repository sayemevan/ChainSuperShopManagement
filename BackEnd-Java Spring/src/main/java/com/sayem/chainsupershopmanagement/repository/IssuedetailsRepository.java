/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sayem.chainsupershopmanagement.repository;

import com.sayem.chainsupershopmanagement.model.Issuedetails;
import com.sayem.chainsupershopmanagement.model.Issueproduct;
import com.sayem.chainsupershopmanagement.service.IssuedetailsService;
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
public class IssuedetailsRepository implements IssuedetailsService{
    
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Issuedetails> viewAllIssuedetails() {
        
        Session session = sessionFactory.getCurrentSession();
        List<Issuedetails> issuedetailslist = session.createQuery("from Issuedetails").list();
        
        return issuedetailslist;
    }

    @Override
    public Issuedetails viewOneIssuedetails(int issuedetid) {
        
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Issuedetails.class);
        crit.add(Restrictions.eq("issuedetid", issuedetid));
        Issuedetails issueDetail = (Issuedetails)crit.uniqueResult();
        
        return issueDetail;
    }

    @Override
    public Issuedetails insertIssuedetails(Issuedetails issuedetails) {
        
        Session session = sessionFactory.getCurrentSession();
        session.save(issuedetails);
        
        return issuedetails;
    }

    @Override
    public void updateIssuedetails(Issuedetails issuedetails) {
        
        Session session = sessionFactory.getCurrentSession();
        session.update(issuedetails);
    }

    @Override
    public void deleteIssuedetails(int issuedetid) {
        Session session = sessionFactory.getCurrentSession();
        Issuedetails issuedetails = (Issuedetails)session.get(Issuedetails.class, issuedetid);
        session.delete(issuedetails);
    }
    
}
