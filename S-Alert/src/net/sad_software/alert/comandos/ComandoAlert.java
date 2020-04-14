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

public class ComandoAlert implements CommandExecutor {
	
	private static Alert m = (Alert)Bukkit.getPluginManager().getPlugin("S-Alert");
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
		//a-erro1
		if(!(sender instanceof Player)) {
            sender.sendMessage(m.getConfig().getString("erro1"));
            return true;
        }
		
		//a-erro2
        Player p = (Player)sender;
        if(!p.hasPermission("s.alert")) {
            p.sendMessage(m.getConfig().getString("erro2"));
            return true;
        }
        
		//a-uso
        if(args.length == 0) {
        	sender.sendMessage(m.getConfig().getString("a-uso"));
        	return true;
        }
		
		if(cmd.getName().equalsIgnoreCase("alert")){
			 
			 String st = "";
			 for(int i = 0; i < args.length; i++) {
			    st += args[i] + " ";
			 }
			 
			 //a-alert
			 Bukkit.broadcastMessage(m.getConfig().getString("a-alert")+ChatColor.BOLD+st); 			 
		 }
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			
			//a-ms
			TitleAPI.sendTitle(player, 20, 40, 20, "§4§l"+p.getName(),m.getConfig().getString("a-ms"));
			player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 10, 1);
		}	
		
	return true;
	}
}
