package io.github.silicondev.customrpg;

import org.bukkit.entity.EntityType;

public enum Animals {
	
	CHICKEN(EntityType.CHICKEN),
	COW(EntityType.COW),
	MOOSHROOM(EntityType.MUSHROOM_COW),
	PIG(EntityType.PIG),
	RABBIT(EntityType.RABBIT),
	SHEEP(EntityType.SHEEP),
	WOLF(EntityType.WOLF);
	
	EntityType entity;
	
	Animals(EntityType entity) {
		this.entity = entity;
	}
	
	public EntityType getEntity() {
		return this.entity;
	}
}
