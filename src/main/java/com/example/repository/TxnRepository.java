package com.example.repository;

import java.util.List;

import com.example.model.Txns;
import com.example.model.TxnType;

public interface TxnRepository {

	void save(Txns txn);
	List<Txns> findAll();
	
	List<Txns> findByLimit(int limit);
	List<Txns> findTxnType(TxnType txnType);
	
	
	
}
