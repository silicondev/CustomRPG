package io.github.silicondev.customrpg;

import java.util.Random;
import org.bukkit.entity.LivingEntity;

public class MonsterData {
	private LevelNotator baseGenLevel;
	private int level;
	private LivingEntity entity;
	
	public MonsterData(LevelNotator baseLevel, LivingEntity entity, int level) {
		this.entity = entity;
		this.baseGenLevel = baseLevel;
		this.level = level;
	}
	
	public void reRollLevel(LevelNotator newGenLevel) {
		if (newGenLevel != null) {
			this.baseGenLevel = newGenLevel;
		}
		Random rng = new Random();
		this.level = rng.nextInt((baseGenLevel.getMin() - baseGenLevel.getMax()) + 1) + baseGenLevel.getMin();
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setEntity(LivingEntity entity) {
		this.entity = entity;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public LivingEntity getEntity() {
		return this.entity;
	}
}
