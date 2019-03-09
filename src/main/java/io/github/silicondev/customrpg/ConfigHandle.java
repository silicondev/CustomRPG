package io.github.silicondev.customrpg;

public class ConfigHandle {
	CustomRPG plugin;
	
	public int minLevel;
	public int maxLevel;
	public String levelCalc;
	
	public int baseComSlots;
	public int baseNoComSlots;
	public int addComSlots;
	public int addNoComSlots;
	public float comSlotCost;
	public float noComSlotCost;
	
	public LevelNotator areaMUSHROOM;
	public LevelNotator areaPLAINS;
	public LevelNotator areaBEACH;
	public LevelNotator areaFOREST;
	public LevelNotator areaEXTREMEHILLS;
	public LevelNotator areaICEPLAINS;
	public LevelNotator areaSWAMP;
	public LevelNotator areaSAVANNAH;
	public LevelNotator areaOCEAN;
	public LevelNotator areaTAIGA;
	public LevelNotator areaDESERT;
	public LevelNotator areaROOFEDFOREST;
	public LevelNotator areaDEEPOCEAN;
	public LevelNotator areaCOLDTAIGA;
	public LevelNotator areaJUNGLE;
	public LevelNotator areaICESPIKES;
	public LevelNotator areaMESA;
	
	public ConfigHandle(CustomRPG plugin) {
		this.plugin = plugin;
	}
	
	public void load() {
		this.minLevel = plugin.getConfig().getInt("min-level");
		this.maxLevel = plugin.getConfig().getInt("max-level");
		this.levelCalc = plugin.getConfig().getString("total-level-calculation");
		
		LevelNotator.VERY_LOW.setMinMax(getAreaInt(plugin.getConfig().getString("level-verylow")));
		LevelNotator.LOW.setMinMax(getAreaInt(plugin.getConfig().getString("level-low")));
		LevelNotator.MEDIUM.setMinMax(getAreaInt(plugin.getConfig().getString("level-medium")));
		LevelNotator.MEDIUM_HIGH.setMinMax(getAreaInt(plugin.getConfig().getString("level-mediumhigh")));
		LevelNotator.HIGH.setMinMax(getAreaInt(plugin.getConfig().getString("level-high")));
		LevelNotator.VERY_HIGH.setMinMax(getAreaInt(plugin.getConfig().getString("level-veryhigh")));
		
		this.baseComSlots = plugin.getConfig().getInt("base-combat-slots");
		this.baseNoComSlots = plugin.getConfig().getInt("base-noncombat-slots");
		this.addComSlots = plugin.getConfig().getInt("additional-combat-slots");
		this.addNoComSlots = plugin.getConfig().getInt("additional-noncombat-slots");
		this.comSlotCost = Float.valueOf(plugin.getConfig().getLong("combat-slot-cost"));
		this.noComSlotCost = Float.valueOf(plugin.getConfig().getLong("noncombat-slot-cost"));
		
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
		
		this.areaMUSHROOM = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaPLAINS = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaBEACH = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaFOREST = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaEXTREMEHILLS = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaICEPLAINS = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaSWAMP = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaSAVANNAH = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaOCEAN = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaTAIGA = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaDESERT = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaROOFEDFOREST = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaDEEPOCEAN = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaCOLDTAIGA = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaJUNGLE = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaICESPIKES = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
		this.areaMESA = getLevel(plugin.getConfig().getString("area-MUSHROOM"));
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
