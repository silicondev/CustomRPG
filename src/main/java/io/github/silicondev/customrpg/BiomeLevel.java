package io.github.silicondev.customrpg;

import org.bukkit.block.Biome;

public enum BiomeLevel {
	
	MUSHROOM(LevelNotator.SAFE, new Biome[] {Biome.MUSHROOM_FIELDS, Biome.MUSHROOM_FIELD_SHORE}),
	PLAINS(LevelNotator.SAFE, new Biome[] {Biome.PLAINS, Biome.RIVER, Biome.SUNFLOWER_PLAINS}),
	BEACH(LevelNotator.SAFE, new Biome[] {Biome.BEACH, Biome.STONE_SHORE}),
	FOREST(LevelNotator.SAFE, new Biome[] {Biome.BIRCH_FOREST, Biome.BIRCH_FOREST_HILLS, Biome.FLOWER_FOREST, Biome.FOREST, Biome.TALL_BIRCH_FOREST, Biome.TALL_BIRCH_HILLS, Biome.WOODED_HILLS}),
	EXTREME_HILLS(LevelNotator.SAFE, new Biome[] {Biome.GRAVELLY_MOUNTAINS, Biome.MODIFIED_GRAVELLY_MOUNTAINS, Biome.MOUNTAIN_EDGE, Biome.MOUNTAINS, Biome.SNOWY_MOUNTAINS, Biome.SNOWY_TAIGA_MOUNTAINS, Biome.TAIGA_MOUNTAINS, Biome.WOODED_MOUNTAINS}),
	ICE_PLAINS(LevelNotator.SAFE, new Biome[] {Biome.FROZEN_RIVER, Biome.SNOWY_BEACH, Biome.SNOWY_TUNDRA}),
	SWAMP(LevelNotator.SAFE, new Biome[] {Biome.SWAMP, Biome.SWAMP_HILLS}),
	SAVANNA(LevelNotator.SAFE, new Biome[] {Biome.SAVANNA, Biome.SAVANNA_PLATEAU, Biome.SHATTERED_SAVANNA, Biome.SHATTERED_SAVANNA_PLATEAU}),
	OCEAN(LevelNotator.SAFE, new Biome[] {Biome.COLD_OCEAN, Biome.FROZEN_OCEAN, Biome.LUKEWARM_OCEAN, Biome.OCEAN, Biome.WARM_OCEAN}),
	TAIGA(LevelNotator.SAFE, new Biome[] {Biome.GIANT_SPRUCE_TAIGA, Biome.GIANT_SPRUCE_TAIGA_HILLS, Biome.GIANT_TREE_TAIGA, Biome.GIANT_TREE_TAIGA_HILLS, Biome.TAIGA, Biome.TAIGA_HILLS}),
	DESERT(LevelNotator.SAFE, new Biome[] {Biome.DESERT, Biome.DESERT_HILLS, Biome.DESERT_LAKES}),
	ROOFED_FOREST(LevelNotator.SAFE, new Biome[] {Biome.DARK_FOREST, Biome.DARK_FOREST_HILLS}),
	DEEP_OCEAN(LevelNotator.SAFE, new Biome[] {Biome.DEEP_COLD_OCEAN, Biome.DEEP_FROZEN_OCEAN, Biome.DEEP_LUKEWARM_OCEAN, Biome.DEEP_OCEAN, Biome.DEEP_WARM_OCEAN}),
	COLD_TAIGA(LevelNotator.SAFE, new Biome[] {Biome.SNOWY_TAIGA, Biome.SNOWY_TAIGA_HILLS}),
	JUNGLE(LevelNotator.SAFE, new Biome[] {Biome.JUNGLE, Biome.JUNGLE_HILLS, Biome.JUNGLE_EDGE, Biome.MODIFIED_JUNGLE, Biome.MODIFIED_JUNGLE_EDGE}),
	ICE_SPIKES(LevelNotator.SAFE, new Biome[] {Biome.ICE_SPIKES}),
	MESA(LevelNotator.SAFE, new Biome[] {Biome.BADLANDS, Biome.BADLANDS_PLATEAU, Biome.ERODED_BADLANDS, Biome.MODIFIED_BADLANDS_PLATEAU, Biome.MODIFIED_WOODED_BADLANDS_PLATEAU, Biome.WOODED_BADLANDS_PLATEAU});
	
	private LevelNotator level;
	private Biome[] handledBiomes;
	
	BiomeLevel(LevelNotator level, Biome[] handledBiomes) {
		this.level = level;
		this.handledBiomes = handledBiomes;
	}
	
	public LevelNotator getLevel() {
		return this.level;
	}
	
	public Biome[] getHandledBiomes() {
		return this.handledBiomes;
	}
	
	public void setLevel(LevelNotator level) {
		this.level = level;
	}
	
	public void setHandledBiomes(Biome[] handledBiomes) {
		this.handledBiomes = handledBiomes;
	}
}
