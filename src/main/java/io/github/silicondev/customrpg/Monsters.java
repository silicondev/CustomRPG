package io.github.silicondev.customrpg;

import org.bukkit.entity.EntityType;

public enum Monsters {
	
	ZOMBIE(EntityType.ZOMBIE),
	SKELETON(EntityType.SKELETON),
	CREEPER(EntityType.CREEPER),
	SPIDER(EntityType.SPIDER),
	DROWNED(EntityType.DROWNED),
	ENDERMAN(EntityType.ENDERMAN),
	GUARDIAN(EntityType.GUARDIAN),
	SLIME(EntityType.SLIME),
	PHANTOM(EntityType.PHANTOM),
	ZOMBIE_VILLAGER(EntityType.ZOMBIE_VILLAGER),
	EVOKER(EntityType.EVOKER),
	VEX(EntityType.VEX),
	VINDICATOR(EntityType.VINDICATOR),
	WITCH(EntityType.WITCH),
	CAVE_SPIDER(EntityType.CAVE_SPIDER);
	
	EntityType entity;
	
	Monsters(EntityType entity) {
		this.entity = entity;
	}
	
	public EntityType getEntity() {
		return this.entity;
	}
}
