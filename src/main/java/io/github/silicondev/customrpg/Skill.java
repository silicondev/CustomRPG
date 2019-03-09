package io.github.silicondev.customrpg;

public enum Skill {
	
	SWORDSMANSHIP("Swordsmanship", xpSlot.SWORD, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_COMBAT, "-"),
	AXEWIELDING("Axe-Wielding", xpSlot.AXE, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_COMBAT, "-"),
	ARCHERY("Archery", xpSlot.BOW, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_COMBAT, "-"),
	MARTIALARTS("Martial-Arts", xpSlot.FIST, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_COMBAT, "-"),
	SPEARMANSHIP("Spearmanship", xpSlot.TRIDENT, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_COMBAT_PREMIUM, "-"),
	ALCHEMY("Alchemy", xpSlot.POTION, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_COMBAT_PREMIUM, "-"),
	
	FISHING("Fishing", xpSlot.FISH, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_NON_COMBAT, "-"),
	TRADING("Trading", xpSlot.TRADE, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_NON_COMBAT, "-"),
	COOKING("Cooking", xpSlot.COOK, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_NON_COMBAT, "-"),
	FARMING("Farming", xpSlot.BREED, xpSlot.BUTCHER, xpSlot.CROP, false, SkillType.SKILL_NON_COMBAT, "-"),
	EXPLORING("Exploring", xpSlot.EXPLORE, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_NON_COMBAT, "-"),
	LUMBERJACKING("Lumberjacking", xpSlot.LUMBER, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_NON_COMBAT, "-"),
	EXCAVATION("Excavation", xpSlot.EXCAVATE, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_NON_COMBAT, "-"),
	MINING("Mining", xpSlot.MINELOW, xpSlot.MINEMED, xpSlot.MINEHIGH, false, SkillType.SKILL_NON_COMBAT, "-"),
	BLACKSMITHING("Blacksmithing", xpSlot.BLACKSMITH, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_NON_COMBAT, "-"),
	TOOLSMITHING("Toolsmithing", xpSlot.TOOLSMITH, xpSlot.NONE, xpSlot.NONE, false, SkillType.SKILL_NON_COMBAT, "-"),
	FURNISHING("Furnishing", xpSlot.CRAFT, xpSlot.BREAK, xpSlot.PLACE, false, SkillType.SKILL_NON_COMBAT, "-");
	
	private String name;
	private xpSlot slot1;
	private xpSlot slot2;
	private xpSlot slot3;
	private boolean enabled;
	private SkillType type;
	private String desc;
	
	
	Skill(String name, xpSlot slot1, xpSlot slot2, xpSlot slot3, boolean enabled, SkillType type, String desc) {
		this.name = name;
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.slot3 = slot3;
		this.enabled = enabled;
		this.type = type;
		this.desc = desc;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
	public float getXpMod(int num) {
		if (num == 0) {
			return slot1.getXp();
		} else if (num == 1) {
			return slot2.getXp();
		} else if (num == 2) {
			return slot3.getXp();
		} else {
			return -1f;
		}
	}
	
	public boolean getEnabled() {
		return this.enabled;
	}
	
	public SkillType getType() {
		return this.type;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setType(SkillType type) {
		this.type = type;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void setXpSlot(int num, xpSlot slot) {
		if (num == 0) {
			this.slot1 = slot;
		} else if (num == 1) {
			this.slot2 = slot;
		} else if (num == 2) {
			this.slot3 = slot;
		}
		
		if ((this.slot1.getXp() + this.slot2.getXp() + this.slot3.getXp()) <= 0) {
			this.enabled = false;
		} else {
			this.enabled = true;
		}
	}
}
