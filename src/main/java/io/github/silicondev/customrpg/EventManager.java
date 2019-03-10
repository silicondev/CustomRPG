package io.github.silicondev.customrpg;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
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
		
		Random rng = new Random();
		int level = rng.nextInt((biomeLevel.getMin() - biomeLevel.getMax()) + 1) + biomeLevel.getMin();
		
		entity.setCustomName("§cLv. " + Integer.toString(level));
		entity.setCustomNameVisible(true);
		
		CustomRPG.monsters.add(new MonsterData(biomeLevel, entity, level));
	}
	
	@EventHandler
	public boolean onMobDeath(EntityDeathEvent e) {
		LivingEntity initEntity = e.getEntity();
		int mobType = 0;
		Player killer = initEntity.getKiller();
		
		if (killer != null) {
			boolean found = false;
			for (int p = 0; p < CustomRPG.players.size() && !found; p++) {
				if (killer.getUniqueId().equals(CustomRPG.players.get(p).getPlayer().getUniqueId())) {
					int playerIndex = p;
					PlayerData data = CustomRPG.players.get(p);
					found = true;
					
					for (int m = 0; m < Monsters.values().length && mobType == 0; m++) {
						if (Monsters.values()[m].getEntity().equals(initEntity.getType())) {
							mobType = 2;
						}
					}
					for (int a = 0; a < Animals.values().length && mobType == 0; a++) {
						if (Animals.values()[a].getEntity().equals(initEntity.getType())) {
							mobType = 1;
						}
					}
					
					if (mobType != 0) {
						if (mobType == 1) {
							//ANIMAL KILL
							return CustomRPG.players.get(p).addXpForSkill(Skill.FARMING, 1);
						} else if (mobType == 2) {
							//MONSTER KILL
							Material itemUsed = killer.getInventory().getItemInMainHand().getType();
							
							for (int s = 0; s < Swords.values().length; s++) {
								if (Swords.values()[s].getType().equals(itemUsed)) {
									return CustomRPG.players.get(p).addXpForSkill(Skill.SWORDSMANSHIP, 0);
								}
							}
							for (int a = 0; a < Axes.values().length; a++) {
								if (Axes.values()[a].getType().equals(itemUsed)) {
									return CustomRPG.players.get(p).addXpForSkill(Skill.AXEWIELDING, 0);
								}
							}
							if (itemUsed.equals(Material.BOW)) {
								return CustomRPG.players.get(p).addXpForSkill(Skill.ARCHERY, 0);
							} else if (itemUsed.equals(Material.TRIDENT)) {
								return CustomRPG.players.get(p).addXpForSkill(Skill.SPEARMANSHIP, 0);
							} else if (itemUsed.equals(Material.POTION)) { //THIS WONT WORK
								return CustomRPG.players.get(p).addXpForSkill(Skill.ALCHEMY, 0);
							} else if (itemUsed.equals(Material.AIR)) {
								return CustomRPG.players.get(p).addXpForSkill(Skill.MARTIALARTS, 0);
							}
						}
					}
				}
			}
		}
		return false;
	}
}
