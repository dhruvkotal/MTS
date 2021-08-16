package com.example.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "txns", schema = "accounts_db")
public class Txns {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Enumerated(EnumType.STRING)
	private TxnType type;
	private double amount;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "acc_number")
	private Account account;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}