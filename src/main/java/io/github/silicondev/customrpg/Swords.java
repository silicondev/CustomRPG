package io.github.silicondev.customrpg;

import org.bukkit.Material;

public enum Swords {
	
	WOODEN_SWORD(Material.WOODEN_SWORD),
	STONE_SWORD(Material.STONE_SWORD),
	IRON_SWORD(Material.IRON_SWORD),
	GOLDEN_SWORD(Material.GOLDEN_SWORD),
	DIAMOND_SWORD(Material.DIAMOND_SWORD);
	
	Material type;
	
	Swords(Material type) {
		this.type = type;
	}
	
	public Material getType() {
		return this.type;
	}
}
