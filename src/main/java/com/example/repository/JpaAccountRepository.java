package com.example.repository;
import com.example.config.JpaConfiguration;
import com.example.model.Account;
import com.example.model.Txns;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JpaAccountRepository implements AccountRepository{
    @Override
    public Account findById(String number) {
        EntityManager em= JpaConfiguration.em();
        Account account=em.find(Account.class,number);
        em.close();
        return account;
    }

    @Override
    public Account update(Account account) {
        EntityManager em= JpaConfiguration.em();
        em.getTransaction().begin();
        Account updatedAccount=em.merge(account);
        em.getTransaction().commit();
        em.close();
        return updatedAccount;
    }
    @Override
    public List<Account> findAll() {
        EntityManager em=JpaConfiguration.em();
        List<Account> acc=em.createQuery("from Account").getResultList();
        em.close();
        return acc;
    }

    @Override
    public List<Account> findByLimit(int limit) {
        EntityManager em=JpaConfiguration.em();
        Query query=em.createQuery("from Account");
        query.setFirstResult(0);
        query.setMaxResults(limit);
        List<Account> acc=query.getResultList();
        em.close();
        return acc;
    }
    @Override
    public void save(Account account)
    {
        EntityManager em=JpaConfiguration.em();
        em.getTransaction().begin();
        em.persist(account);
        em.getTransaction().commit();
        em.close();
    }
}
