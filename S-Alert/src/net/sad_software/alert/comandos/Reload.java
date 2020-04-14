package net.sad_software.alert.comandos;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import net.sad_software.alert.Alert;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;


 public class Reload implements CommandExecutor {
	 
	 private final Alert plugin;

	 public Reload(Alert plugin) { //Or in whatever other class you require your plugin
		    this.plugin = plugin;
		}
	 
	 private static Alert m = (Alert)Bukkit.getPluginManager().getPlugin("S-Alert");
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		//a-erro2
        Player p = (Player)sender;
        if(!p.hasPermission("s.alert")) {
            p.sendMessage(m.getConfig().getString("erro2"));
            return true;
        }
		
		plugin.reloadConfig();
		p.sendMessage(m.getConfig().getString("reload").replace("{player}", p.getName()));
		return false;
	}
	

	 
 }

