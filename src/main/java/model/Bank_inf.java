package model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@Entity
public class Bank_inf {
	@Id
	@Column(name="id")
	   private Long id;
	
	@Column(name="name")
	   private String fullName;
	
	@Column(name="balance")
	   private double balance;
	 
	   public Bank_inf() {
	 
	   }
	 
	   // Used in JPA query.
	   public Bank_inf(Long id, String fullName, double balance) {
	      this.id = id;
	      this.fullName = fullName;
	      this.balance = balance;
	   }
	 
	   public Long getId() {
	      return id;
	   }
	 
	   public void setId(Long id) {
	      this.id = id;
	   }
	 
	   public String getFullName() {
	      return fullName;
	   }
	 
	   public void setFullName(String fullName) {
	      this.fullName = fullName;
	   }
	 
	   public double getBalance() {
	      return balance;
	   }
	 
	   public void setBalance(double balance) {
	      this.balance = balance;
	   }
	}