package net.sad_software.alert.comandos;

import com.connorlinfoot.titleapi.TitleAPI;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import net.sad_software.alert.Alert;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;

public class ComandoWarn implements CommandExecutor {
	
	private static Alert m = (Alert)Bukkit.getPluginManager().getPlugin("S-Alert");
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
				
        //w-erro1
		if(!(sender instanceof Player)) {
            sender.sendMessage(m.getConfig().getString("erro1"));
            return true;
        }

		//w-erro2
        Player p = (Player)sender;
        if(!p.hasPermission("s.alert")) {
            p.sendMessage(m.getConfig().getString("erro2"));
            return true;
        }
		
		//w-uso
        if(args.length == 0) {
        	sender.sendMessage(m.getConfig().getString("w-uso"));
        	return true;
        }
        
		if(cmd.getName().equalsIgnoreCase("warn")){
			 
			 String st = "";
			 for(int i = 0; i < args.length; i++) {
			    st += args[i] + " ";
			 }
			 
			 //w-warn
			 Bukkit.broadcastMessage(m.getConfig().getString("w-warn")+ChatColor.BOLD+st); 			 
		 }
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			
			//w-ms
			TitleAPI.sendTitle(player, 20, 40, 20, m.getConfig().getString("color")+p.getName(),m.getConfig().getString("w-ms"));
			player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 1);
		}
		
	return true;
	}
}
