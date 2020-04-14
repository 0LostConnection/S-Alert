package net.sad_software.alert;

import org.bukkit.configuration.file.FileConfiguration;
import net.sad_software.alert.comandos.ComandoAlert;
import net.sad_software.alert.comandos.ComandoWarn;
import net.sad_software.alert.comandos.Reload;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.bukkit.ChatColor;
import java.io.InputStream;
import org.bukkit.Bukkit;
import java.io.File;

public class Alert extends JavaPlugin{
	
	File config_enFile;
	FileConfiguration config_en;
	
	public void onEnable() {
		
		config_enFile = new File(getDataFolder(), "config.en.yml");
		
		try {
	        firstRun();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		
		saveDefaultConfig();
		
		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"S-Alert 1.5");
		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"For more information: https://github.com/NioiOtaku/S-Alert/");
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA+"ontact me: https://twitter.com/0LostConnection");
		Bukkit.getConsoleSender().sendMessage(" ");
        
		getCommand("warn").setExecutor(new ComandoWarn());
		getCommand("alert").setExecutor(new ComandoAlert());
		getCommand("s-reload").setExecutor(new Reload(this));
		 		 
	}
	
	private void firstRun() throws Exception {
	    if(!config_enFile.exists()){
	        config_enFile.getParentFile().mkdirs();
	        copy(getResource("config.en.yml"), config_enFile);
	    	}
	    }
	
	    private void copy(InputStream in, File file) {
	        try {
	            OutputStream out = new FileOutputStream(file);
	            byte[] buf = new byte[1024];
	            int len;
	            while((len=in.read(buf))>0){
	                out.write(buf,0,len);
	            }
	            out.close();
	            in.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
}