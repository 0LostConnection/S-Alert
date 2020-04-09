package net.sad_software.alert;

import net.sad_software.alert.comandos.ComandoAlert;
import net.sad_software.alert.comandos.ComandoWarn;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

public class Main extends JavaPlugin{
	
	
	public void onEnable() {
		saveDefaultConfig();
		
		Bukkit.getConsoleSender().sendMessage("§aPlugin Ativo!");
        
		getCommand("warn").setExecutor(new ComandoWarn());
		getCommand("alert").setExecutor(new ComandoAlert());	
	}
	
	public void onDisable() {
		
		Bukkit.getConsoleSender().sendMessage("§cPlugin Encerrado");
		
	} 
}
