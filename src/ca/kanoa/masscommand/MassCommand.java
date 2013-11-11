package ca.kanoa.masscommand;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

public class MassCommand extends JavaPlugin {

	private static MassCommand instance;
	private String command;
	
	@Override
	public void onEnable() {
		if (!new File(getDataFolder(), "config.yml").exists()) {
			saveResource("config.yml", false);
		}
		instance = this;
		getCommand("mass").setExecutor(new CommandExecutor());
		command = getConfig().getString("command");
	}
	
	public static MassCommand getInstance() {
		return instance;
	}
	
	public static String getCommand() {
		return instance.command;
	}
	
}
