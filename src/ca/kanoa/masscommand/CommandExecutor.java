package ca.kanoa.masscommand;

import java.io.File;

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
		
		String[] lines = FileReader.readTextFile(mass).split("\n");
		
		return false;
	}

}
