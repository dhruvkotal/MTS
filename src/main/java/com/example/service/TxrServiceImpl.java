package com.example.service;

import java.util.Date;

import com.example.model.Account;
import com.example.model.Txns;
import com.example.model.TxnType;
import com.example.repository.AccountRepository;
import com.example.repository.TxnRepository;

public class TxrServiceImpl implements TxrService {
    AccountRepository accountRepository;
    TxnRepository txnRepository;
    private String number;
    private double balance;

    public TxrServiceImpl(AccountRepository accountRepository, TxnRepository txnRepository) {
        super();
        this.accountRepository = accountRepository;
        this.txnRepository = txnRepository;
    }



    @Override
    public void txr(double amount, String fromAccNum, String toAccNum) {

        Account fromAccount=accountRepository.findById(fromAccNum);
        Account toAccount=accountRepository.findById(toAccNum);

        fromAccount.setBalance(fromAccount.getBalance()-amount);
        toAccount.setBalance(toAccount.getBalance()+amount);

        Txns debitTxn=new Txns();
        debitTxn.setType(TxnType.DEBIT);
        debitTxn.setAccount(fromAccount);
        debitTxn.setAmount(amount);
        debitTxn.setDate(new Date());

        Txns creditTxn=new Txns();
        creditTxn.setType(TxnType.CREDIT);
        creditTxn.setAccount(toAccount);
        creditTxn.setAmount(amount);
        creditTxn.setDate(new Date());


        accountRepository.update(fromAccount);
        accountRepository.update(toAccount);


        txnRepository.save(debitTxn);
        txnRepository.save(creditTxn);

    }

    @Override
    public void addAcc(String number, double balance) {
        Account newAcc=new Account();
        newAcc.setNumber(number);
        newAcc.setBalance(balance);
        accountRepository.save(newAcc);
    }

}
