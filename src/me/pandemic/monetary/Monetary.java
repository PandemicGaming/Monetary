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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Monetary extends JavaPlugin
{
	private AccountManager accountManager = new AccountManager();
	
	private PlayerJoinListener playerJoinListener = new PlayerJoinListener(this);
	private PlayerCommandListener playerCommandListener = new PlayerCommandListener(this);
	
	public void onDisable()
	{
		System.out.println("[Monetary] Monetary is shutting down...");
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try 
		{
			fos = new FileOutputStream("plugins/Monetary/accounts.pan");
			out = new ObjectOutputStream(fos);
			out.writeObject(accountManager.getAccounts());
			out.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}		
    }
	
	@SuppressWarnings("unchecked")
	public void onEnable()
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerJoinListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_COMMAND_PREPROCESS, playerCommandListener, Priority.Normal, this);
		
		System.out.println("[Monetary] Monetary is loading accounts...");
	    FileInputStream fis = null;
	    ObjectInputStream in = null;
	    try
	    {
		      fis = new FileInputStream("plugins/Monetary/accounts.pan");
		      in = new ObjectInputStream(fis);
		      accountManager.setAccounts((Map<String, Account>)in.readObject());
		      in.close();
		      fis.close();
	    }
	    catch (FileNotFoundException e) {
	    	try {
				new File("plugins/Monetary").mkdir();
				new File("plugins/Monetary/accounts.pan").createNewFile();
				FileOutputStream fos = new FileOutputStream("plugins/Monetary/accounts.pan");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(accountManager.getAccounts());
				oos.close();
				fos.close();
	    	} catch (IOException e1) {
				e1.printStackTrace();
			}
	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	    }
	}
	
	public AccountManager getAccountManager()
	{
		return accountManager;
	}
}