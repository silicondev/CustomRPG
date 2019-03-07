package io.github.silicondev.customrpg;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomRPG extends JavaPlugin {
	public static String pluginName = "CustomItemManager";
	public boolean debugMode = false;
	public static String version = "Beta 0.2.1";
	
	CommandOut comOut = new CommandOut(this);
	static List<CommandCRPG> commands = new ArrayList<CommandCRPG>();
	
	public void onEnable() {
		getLogger().info("Startup Initialized!");
		
		//getServer().getPluginManager().registerEvents(new EventManager(), this);
		
		int errNum = 0;
		try {
			//COMMANDS GO HERE
		} catch (NullPointerException e) {
			errNum++;
			getLogger().info("Error loading commands!");
		}
		
		
		getLogger().info("Initialization complete with " + Integer.toString(errNum) + " errors.");
	}
	
	public void onDisable() {
		getLogger().info("Shutting Down!");
	}
	
	
}
