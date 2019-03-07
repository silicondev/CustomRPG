package io.github.silicondev.customrpg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandExec implements CommandExecutor {
	private final CustomRPG plugin;
	
	public CommandExec(CustomRPG plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		CommandCRPG[] getCom = new CommandCRPG[CustomRPG.commands.size()];
		CustomRPG.commands.toArray(getCom);
		
		for (int i = 0; i < getCom.length; i++) {     //Tests first word for command initialiser, then the rest as multi args.
			String currentCommand = getCom[i].inputName;
			
			if (cmd.getName().equalsIgnoreCase(currentCommand)) {     //Correct command found.
				List<String> finArgs = new ArrayList<String>(Arrays.asList(args));
				
				CommandCRPG runCmd = getCom[i];
				if (plugin.debugMode) {plugin.getLogger().info(Lang.DEB_COMMANDFOUND.toString() + runCmd.inputName);}
				
				if (getCom[i].canChildren && getCom[i].children.size() != 0) {
					if (plugin.debugMode) {plugin.getLogger().info(Lang.DEB_COMMANDCHILDREN_1.toString() + runCmd.inputName + Lang.DEB_COMMANDCHILDREN_2.toString());}
					boolean found = false;
					int argsFrom = 0;
					
					List<CommandCRPG> children = getCom[i].children;
					for (int a = 0; a < finArgs.size() && !found; a++) {
						if (plugin.debugMode) {plugin.getLogger().info(Lang.DEB_CHECKARG.toString() + "(" + finArgs.get(a) + ")");}
						
						boolean childFound = false;
						for (int c = 0; c < children.size() && !childFound; c++) {
							if (plugin.debugMode) {plugin.getLogger().info(Lang.DEB_CHECKCHILDREN.toString() + "(" + children.get(c).inputName + ")");}
							if (children.get(c).inputName.equalsIgnoreCase(finArgs.get(a))) {
								childFound = true;
								if (plugin.debugMode) {plugin.getLogger().info(Lang.DEB_MATCHFOUND.toString());}
								if (children.get(c).canChildren && children.get(c).children.size() != 0) {
									if (plugin.debugMode) {plugin.getLogger().info(Lang.DEB_GRANDCHILDREN.toString());}
									children = children.get(c).children;
								} else {
									found = true;
									if (plugin.debugMode) {plugin.getLogger().info(Lang.DEB_FINALCOMMAND.toString());}
									runCmd = children.get(c);
									if (plugin.debugMode) {plugin.getLogger().info(Lang.DEB_RUNCMDCHANGE.toString() + runCmd.inputName);}
									argsFrom = a + 1;
								}
							}
						}
					}
					
					if (plugin.debugMode) {plugin.getLogger().info(Lang.DEB_ARGNUM.toString() + Integer.toString(finArgs.size()) + Lang.DEB_REMARGNUM.toString() + Integer.toString(argsFrom));}
					if (argsFrom != 0) {
						for (int d = 0; d < argsFrom; d++) {
							if (plugin.debugMode) {plugin.getLogger().info(Lang.DEB_REMARG.toString() + "(" + Integer.toString(d) + ") " + finArgs.get(0));}
							finArgs.remove(0);
						}
						if (plugin.debugMode) {
							plugin.getLogger().info(Lang.DEB_POSTREMARGLIST.toString());
							for (int a = 0; a < finArgs.size(); a++) {
								plugin.getLogger().info(Lang.DEB_ARGPOST.toString() + "(" + Integer.toString(a) + ") " + finArgs.get(a));
							}
						}
					}
				}
				
				
				
				if (runCmd.playerOnly) {
					if (sender instanceof Player) {
						Player player = (Player) sender;
						if (player.hasPermission(runCmd.permNode) || runCmd.permNode == "default") {
							commandHandle(runCmd.outputID, finArgs, sender);
						} else {
							sender.sendMessage(Lang.TITLE.toString() + Lang.ERR_NOPERM_1.toString() + runCmd.permNode + Lang.ERR_NOPERM_2.toString());
						}
					} else {
						sender.sendMessage(Lang.TITLE.toString() + Lang.ERR_PLAYERONLY.toString());
					}
				} else {
					if (sender instanceof Player) {
						Player player = (Player) sender;
						if (player.hasPermission(runCmd.permNode) || runCmd.permNode == "default") {
							commandHandle(runCmd.outputID, finArgs, sender);
						} else {
							sender.sendMessage(Lang.TITLE.toString() + Lang.ERR_NOPERM_1.toString() + runCmd.permNode + Lang.ERR_NOPERM_2.toString());
						}
					}
				}
				return true;
			}
		}
		return false;
	}
	
	public void commandHandle(int id, List<String> args, CommandSender sender) {
		boolean hasRun = true;
		
		if (args.size() < CustomRPG.commands.get(id).reqParams) {     //Checks if command has correct amount of arguments, between the required and max. (Can allow for optional arguments)
			sender.sendMessage(Lang.TITLE.toString() + Lang.ERR_NEGARG.toString() + Integer.toString(args.size()) + "/" + Integer.toString(CustomRPG.commands.get(id).reqParams));
		} else if ((!CustomRPG.commands.get(id).noMaxParams) && args.size() > CustomRPG.commands.get(id).maxParams) {
			sender.sendMessage(Lang.TITLE.toString() + Lang.ERR_POSARG.toString() + Integer.toString(args.size()) + "/" + Integer.toString(CustomRPG.commands.get(id).maxParams));
		} else {
			if (id == 0) {
				//COMMAND OUTPUT HERE
			} else {
				hasRun = false;
			}
		}
		
		if (!hasRun) {
			sender.sendMessage(Lang.TITLE.toString() + Lang.ERR_NOCOMMAND.toString() + "(" + Integer.toString(id) + ")");
		}
	}
}
