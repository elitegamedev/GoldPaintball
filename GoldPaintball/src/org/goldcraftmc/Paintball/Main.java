package org.goldcraftmc.Paintball;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import mc.alk.arena.BattleArena;
import mc.alk.arena.util.Log;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable(){
		BattleArena.registerCompetition(this, "Paintball", "pb", PaintballArena.class);
		saveDefaultConfig();
		loadConfig();
		Log.info("[" + getName()+ "] v" + getDescription().getVersion()+ " enabled!");
	}

	@Override
	public void onDisable(){
		Log.info("[" + getName()+ "] v" + getDescription().getVersion()+ " stopping!");
	}

	@Override
	public void reloadConfig(){
		super.reloadConfig();
		loadConfig();
	}

	public void loadConfig(){
		FileConfiguration config = getConfig();
		PaintballArena.damage = config.getInt("damage", 20);
	}
	
}
