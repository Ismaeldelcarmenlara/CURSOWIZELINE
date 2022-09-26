package com.wizeline.DTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import com.wizeline.enums.AccountType;


public class BankAccountDTO {
	Map<String, List<BankAccountDTO>> groupedAccounts;
	Function<BankAccountDTO, String> groupFunction = (account) -> account.getAccountType().toString();
	
	private Double accountNumber;
	
	
    public Double getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Double accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public boolean isAccountActive() {
		return accountActive;
	}
	public void setAccountActive(boolean accountActive) {
		this.accountActive = accountActive;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	private String accountName;
    private String user;
    private double accountBalance;
    private String country;
    private boolean accountActive;
    private AccountType accountType;
    private LocalDateTime creationDate;
    public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDateTime getLastUsage() {
		return lastUsage;
	}
	public void setLastUsage(LocalDateTime lastUsage) {
		this.lastUsage = lastUsage;
	}
	private LocalDateTime lastUsage;
}
