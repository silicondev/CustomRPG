package io.github.silicondev.customrpg;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomRPG extends JavaPlugin {
	public static String pluginName = "CustomRPG";
	public boolean debugMode = false;
	public static String version = "inDev 0.0.3";
	
	ConfigHandle config = new ConfigHandle(this);
	CommandOut comOut = new CommandOut(this);
	
	static List<CommandCRPG> commands = new ArrayList<CommandCRPG>();
	static List<PlayerData> players = new ArrayList<PlayerData>();
	static List<MonsterData> monsters = new ArrayList<MonsterData>();
	
	public void onEnable() {
		getLogger().info("Startup Initialized!");
		
		getServer().getPluginManager().registerEvents(new EventManager(), this);
		
		config.load();
		
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
