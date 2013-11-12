package ca.kanoa.masscommand;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandExecutor implements org.bukkit.command.CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if (args.length != 0) {
			return false;
		}
		
		File mass = new File(MassCommand.getInstance().getDataFolder()
				.getParentFile().getParentFile(), "mass.txt");
		if (!mass.exists()) {
			sender.sendMessage(ChatColor.RED + "Error: " + ChatColor.GRAY + 
					"mass.txt" + ChatColor.RED + " does not exist, please "
							+ "upload it to the root of the bukkit server.");
			return true;
		}
		
		sender.sendMessage("Loading mass.txt file...");
		String[] lines = FileReader.readTextFile(mass).split("\n");
		sender.sendMessage("File loading, starting command executing...");
		
		String command = MassCommand.getCommand();
		String temp = command;
		if (command.startsWith("/")) {
			command = command.substring(1);
		}
		
		for (String s : lines) {
			temp = command;
			sender.sendMessage("");
			Variables vars = new Variables(s);
			for (int i = 1; i <= vars.getNumberOfVars(); i++) {
				temp = temp.replace("%var" + i, vars.getVar(i));
			}
			sender.sendMessage("Executing " + ChatColor.RED + "/" + temp + 
					ChatColor.RESET + " now...");
			Bukkit.dispatchCommand(sender, temp);
		}
		
		return true;
	}

}
