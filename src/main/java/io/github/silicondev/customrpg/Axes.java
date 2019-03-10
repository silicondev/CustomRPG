package io.github.silicondev.customrpg;

import org.bukkit.Material;

public enum Axes {

	WOODEN_AXE(Material.WOODEN_AXE),
	STONE_AXE(Material.STONE_AXE),
	IRON_AXE(Material.IRON_AXE),
	GOLDEN_AXE(Material.GOLDEN_AXE),
	DIAMOND_AXE(Material.DIAMOND_AXE);
	
	Material type;
	
	Axes(Material type) {
		this.type = type;
	}
	
	public Material getType() {
		return this.type;
	}
}
