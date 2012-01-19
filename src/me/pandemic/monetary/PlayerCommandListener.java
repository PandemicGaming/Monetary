package me.pandemic.monetary;

import java.text.DecimalFormat;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerListener;

public class PlayerCommandListener extends PlayerListener {
	
	private Monetary plugin;
	private AccountManager accountManager;
	
	public PlayerCommandListener(final Monetary plugin)
	{
		this.plugin = plugin;
		accountManager = plugin.getAccountManager();
	}
	
	public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
	{
		Player p = event.getPlayer();
		String command = event.getMessage().replace('/', ' ');
		String[] args = command.split(" ");
		command = command.trim();
		switch (args[1])
		{
		case "balance":
			float balance = accountManager.getAccount(p.getName()).getAmount();
			p.sendMessage("[" + ChatColor.RED + "Monetary" + ChatColor.WHITE + "] " + ChatColor.AQUA + "Your current account's balance is: $" + ChatColor.WHITE + new DecimalFormat("#.##").format(balance) + ChatColor.AQUA + ".");
			return;
		case "addmoney":
			accountManager.getAccount(args[2]).addAmount(Float.parseFloat(args[3]));
			p.sendMessage("Send money to " + args[2]);
			return;
		}
	}
	
}
