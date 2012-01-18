package me.pandemic.monetary;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Map;
import org.bukkit.plugin.java.JavaPlugin;

public class Monetary extends JavaPlugin
{
	  public AccountManager accountManager = new AccountManager();
	
	  public void onDisable()
	  {
		  
	  }
	
	@SuppressWarnings("unchecked")
	public void onEnable()
	{
<<<<<<< HEAD
		System.out.println("[Monetary] Monetary is loading accounts...");
=======
		System.out.println("[Monetary] Monetary is loading accounts");
>>>>>>> 64f5801c6ebb018e337cc0ffaffa3ea03049d4d4
	    FileInputStream fis = null;
	    ObjectInputStream in = null;
	    try
	    {
		      fis = new FileInputStream("accounts.pan");
		      in = new ObjectInputStream(fis);
		      accountManager.setAccounts((Map<String, Account>)in.readObject());
		      in.close();
	    }
	    catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
}