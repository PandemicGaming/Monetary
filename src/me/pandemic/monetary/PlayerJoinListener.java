package me.pandemic.monetary;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;

public class PlayerJoinListener extends PlayerListener
{	
	private Monetary plugin;
	
	public PlayerJoinListener(final Monetary plugin)
	{
		this.plugin = plugin;
	}
	
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		AccountManager accountManager = plugin.getAccountManager();
		Player p = event.getPlayer();
		if(!accountManager.accountExists(p.getName()))
		{
			accountManager.addAccount(new Account(p.getName(), 30.0f));
		}
	}
}
