package com.example.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.example.config.JpaConfiguration;
import com.example.model.Txns;
import com.example.model.TxnType;

public class JpaTxnRepository implements TxnRepository{
    @Override
    public void save(Txns txn) {
        EntityManager em=JpaConfiguration.em();
        em.getTransaction().begin();
        em.persist(txn);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Txns> findAll() {
        EntityManager em=JpaConfiguration.em();
        List<Txns> txns=em.createQuery("from Txns").getResultList();
        em.close();
        return txns;
    }

    @Override
    public List<Txns> findByLimit(int limit) {
        EntityManager em=JpaConfiguration.em();
        Query query=em.createQuery("from Txns");
        query.setFirstResult(0);
        query.setMaxResults(limit);
        List<Txns> txns=query.getResultList();
        em.close();
        return txns;
    }

    @Override
    public List<Txns> findTxnType(TxnType txnType) {
        EntityManager em=JpaConfiguration.em();
        Query query=em.createQuery("from Txns where type=:txnType");
        query.setParameter("txnType", txnType);
        List<Txns> txns=query.getResultList();
        em.close();
        return txns;
    }
}
