package io.github.silicondev.customrpg;

public enum Skill {
	
	SWORD("Swordsmanship", 0.0f, false, SkillType.SKILL_COMBAT, "-"),
	AXE("Axe-Wielding", 0.0f, false, SkillType.SKILL_COMBAT, "-"),
	ARCHERY("Archery", 0.0f, false, SkillType.SKILL_COMBAT, "-"),
	FIST("Martial-Arts", 0.0f, false, SkillType.SKILL_COMBAT, "-"),
	SPEAR("Spearmanship", 0.0f, false, SkillType.SKILL_COMBAT_PREMIUM, "-"),
	ALCHEMY("Alchemy", 0.0f, false, SkillType.SKILL_COMBAT_PREMIUM, "-"),
	
	FISH("Fishing", 0.0f, false, SkillType.SKILL_NON_COMBAT, "-");
	
	private String name;
	private float xpMod;
	private boolean enabled;
	private SkillType type;
	private String desc;
	
	
	Skill(String name, float xpMod, boolean enabled, SkillType type, String desc) {
		this.name = name;
		this.xpMod = xpMod;
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
	
	public float getXpMod() {
		return this.xpMod;
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
	
	public void setXpMod(float xpMod) {
		this.xpMod = xpMod;
	}
}
