package me.pandemic.monetary;

import java.io.Serializable;

public class Account implements Serializable
{
	  private static final long serialVersionUID = 1L;
	  
	  public String name;
	  public float amount;
	
	  public Account(String name, float amount)
	  {
		  this.name = name;
		  this.amount = amount;
	  }
	
	  public String getName()
	  {
		  return this.name;
	  }
	
	  public void setName(String name)
	  {
		  this.name = name;
	  }
	
	  public float getAmount()
	  {
		  return this.amount;
	  }
	
	  public void setAmount(float amount)
	  {
		  this.amount = amount;
	  }
	
	  public void addAmount(float amount)
	  {
		  this.amount += amount;
	  }
	
	  public void removeAmount(float amount)
	  {
		  this.amount -= amount;
	  }
}