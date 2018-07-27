package net.cubespace.geSuitWarps;

import net.cubespace.geSuitWarps.commands.DeleteWarpCommand;
import net.cubespace.geSuitWarps.commands.ListWarpsCommand;
import net.cubespace.geSuitWarps.commands.SetWarpCommand;
import net.cubespace.geSuitWarps.commands.SetWarpDescCommand;
import net.cubespace.geSuitWarps.commands.SilentWarpCommand;
import net.cubespace.geSuitWarps.commands.WarpCommand;
import net.cubespace.geSuitWarps.listeners.WarpsListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class geSuitWarps extends JavaPlugin {
	public static geSuitWarps instance;
	public static String CHANNEL_NAME = "bungeecord:gesuitwarps";

	@Override
	public void onEnable() {
		instance=this;
		registerListeners();
		registerChannels();
		registerCommands();
	}

	private void registerCommands() {
		getCommand("warp").setExecutor(new WarpCommand());
		getCommand("warps").setExecutor(new ListWarpsCommand());
		getCommand("setwarp").setExecutor(new SetWarpCommand());
		getCommand("setwarpdesc").setExecutor(new SetWarpDescCommand());
		getCommand("silentwarp").setExecutor(new SilentWarpCommand());
		getCommand("delwarp").setExecutor(new DeleteWarpCommand());
	}

	private void registerChannels() {
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, CHANNEL_NAME);
	}

	private void registerListeners() {
		getServer().getPluginManager().registerEvents(
				new WarpsListener(), this);
	}

    public static geSuitWarps getInstance() {
        return instance;
    }

}
