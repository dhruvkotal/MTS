package com.example.repository;
import com.example.model.Account;
import com.example.model.Txns;

import java.util.List;

public interface AccountRepository {

	  void save(Account account);
	  Account findById(String number);
	  Account update(Account account);
	  List<Account> findAll();
	  List<Account> findByLimit(int limit);



}
