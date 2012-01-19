/*
    Monetary - An economy plugin for Bukkit
    Copyright (C) 2012 Brandon Dibble (PandemicGaming)

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package me.pandemic.monetary;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AccountManager implements Serializable
{
	private static final long serialVersionUID = 731156538078729927L;
	
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
		  this.accounts.put(account.getName(), account);
	  }
	  
	  public boolean accountExists(String name)
	  {
		  return accounts.containsKey(name);
	  }
}