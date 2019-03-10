package io.github.silicondev.customrpg;

public class ConfigHandle {
	CustomRPG plugin;
	
	public static int minLevel;
	public static int maxLevel;
	public static String levelCalc;
	
	public static int baseComSlots;
	public static int baseNoComSlots;
	public static int addComSlots;
	public static int addNoComSlots;
	public static float comSlotCost;
	public static float noComSlotCost;
	
	public ConfigHandle(CustomRPG plugin) {
		this.plugin = plugin;
	}
	
	public void load() {
		minLevel = plugin.getConfig().getInt("min-level");
		maxLevel = plugin.getConfig().getInt("max-level");
		levelCalc = plugin.getConfig().getString("total-level-calculation");
		
		LevelNotator.VERY_LOW.setMinMax(getAreaInt(plugin.getConfig().getString("level-verylow")));
		LevelNotator.LOW.setMinMax(getAreaInt(plugin.getConfig().getString("level-low")));
		LevelNotator.MEDIUM.setMinMax(getAreaInt(plugin.getConfig().getString("level-medium")));
		LevelNotator.MEDIUM_HIGH.setMinMax(getAreaInt(plugin.getConfig().getString("level-mediumhigh")));
		LevelNotator.HIGH.setMinMax(getAreaInt(plugin.getConfig().getString("level-high")));
		LevelNotator.VERY_HIGH.setMinMax(getAreaInt(plugin.getConfig().getString("level-veryhigh")));
		
		baseComSlots = plugin.getConfig().getInt("base-combat-slots");
		baseNoComSlots = plugin.getConfig().getInt("base-noncombat-slots");
		addComSlots = plugin.getConfig().getInt("additional-combat-slots");
		addNoComSlots = plugin.getConfig().getInt("additional-noncombat-slots");
		comSlotCost = Float.valueOf(plugin.getConfig().getLong("combat-slot-cost"));
		noComSlotCost = Float.valueOf(plugin.getConfig().getLong("noncombat-slot-cost"));
		
		xpSlot.SWORD.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-swordsmanship")));
		xpSlot.AXE.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-axewielding")));
		xpSlot.BOW.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-archery")));
		xpSlot.FIST.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-martialarts")));
		xpSlot.TRIDENT.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-spearmanship")));
		xpSlot.POTION.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-alchemy")));
		
		xpSlot.FISH.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-fishing")));
		xpSlot.TRADE.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-trading")));
		xpSlot.COOK.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-cooking")));
		xpSlot.BREED.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-farming-breed")));
		xpSlot.BUTCHER.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-farming-kill")));
		xpSlot.CROP.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-farming-crops")));
		xpSlot.EXPLORE.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-exploring")));
		xpSlot.LUMBER.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-lumberjacking")));
		xpSlot.EXCAVATE.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-excavation")));
		xpSlot.MINELOW.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-mining-lowlevel")));
		xpSlot.MINEMED.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-mining-mediumlevel")));
		xpSlot.MINEHIGH.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-mining-highlevel")));
		xpSlot.BLACKSMITH.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-blacksmithing")));
		xpSlot.TOOLSMITH.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-toolsmithing")));
		xpSlot.SAIL.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-sailing")));
		xpSlot.CRAFT.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-furnishing-craft")));
		xpSlot.PLACE.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-furnishing-place")));
		xpSlot.BREAK.setXp(Float.valueOf(plugin.getConfig().getLong("xpmod-furnishing-break")));
		
		BiomeLevel.MUSHROOM.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.PLAINS.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.BEACH.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.FOREST.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.EXTREME_HILLS.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.ICE_PLAINS.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.SWAMP.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.SAVANNA.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.OCEAN.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.TAIGA.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.DESERT.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.ROOFED_FOREST.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.DEEP_OCEAN.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.COLD_TAIGA.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.JUNGLE.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.ICE_SPIKES.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
		BiomeLevel.MESA.setLevel(getLevel(plugin.getConfig().getString("area-MUSHROOM")));
	}
	
	public int[] getAreaInt(String parse) {
		int[] output = new int[1];
		
		if (parse.contains("-")) {
			String[] data = parse.split("-", 2);
			output[0] = Integer.parseInt(data[0]);
			output[1] = Integer.parseInt(data[1]);
		} else {
			output[0] = -1;
			output[1] = -1;
		}
		
		return output;
	}
	
	public LevelNotator getLevel(String id) {
		LevelNotator[] notators = LevelNotator.values();
		for (int i = 0; i < notators.length; i++) {
			if (id.equals(notators[i].getName())) {
				return notators[i];
			}
		}
		return LevelNotator.SAFE;
	}
}
