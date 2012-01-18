package me.pandemic.monetary;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AccountManager implements Serializable
{
	  private static final long serialVersionUID = 1L;
	  private Map<String, Account> accounts = new HashMap<String, Account>();
	
	  public Map<String, Account> getAccounts()
	  {
		  return this.accounts;
	  }
	
	  public void setAccounts(Map<String, Account> map)
	  {
		  this.accounts = map;
	  }
	
	  public Account getAccount(String name)
	  {
		  return (Account)this.accounts.get(name);
	  }
	
	  public void addAccount(Account account)
	  {
		  this.accounts.put(account.name, account);
	  }
}