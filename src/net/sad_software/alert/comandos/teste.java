package net.sad_software.alert.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.sad_software.alert.Main;

public class teste implements CommandExecutor {
	
	private static Main m = (Main)Bukkit.getPluginManager().getPlugin("S-Alert");
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
        Player p = (Player)sender;
        p.sendMessage(m.getConfig().getString("texto").replace('&', '§').replace("{jogador}", p.getName()));
        
        return true;
	}
}
