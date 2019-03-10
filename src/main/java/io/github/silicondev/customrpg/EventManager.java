package io.github.silicondev.customrpg;

import java.util.ArrayList;

import org.bukkit.block.Biome;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventManager implements Listener {
	
	@EventHandler
	public void onPlayerSpawn(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		
		for (int i = 0; i < CustomRPG.players.size(); i++) {
			if (!player.getUniqueId().equals(CustomRPG.players.get(i).getPlayer().getUniqueId())) {
				CustomRPG.players.add(new PlayerData(player, ConfigHandle.minLevel, new ArrayList<SkillSlot>()));
				
				//PROMPT PLAYER TO PICK SKILLS
			}
		}
	}
	

	@EventHandler
	public void onMobSpawn(CreatureSpawnEvent e) {
		LivingEntity entity = e.getEntity();
		
		Biome spawnBiome = e.getLocation().getWorld().getBiome(entity.getLocation().getBlockX(), entity.getLocation().getBlockZ());
		
		LevelNotator biomeLevel = LevelNotator.SAFE;
		
		boolean found = false;
		for (int i = 0; i < BiomeLevel.values().length && !found; i++) {
			for (int b = 0; b < BiomeLevel.values()[i].getHandledBiomes().length && !found; b++) {
				if (spawnBiome.equals(BiomeLevel.values()[i].getHandledBiomes()[b])) {
					biomeLevel = BiomeLevel.values()[i].getLevel();
					found = true;
				}
			}
		}
		
		CustomRPG.monsters.add(new MonsterData(biomeLevel, entity));
	}
}
