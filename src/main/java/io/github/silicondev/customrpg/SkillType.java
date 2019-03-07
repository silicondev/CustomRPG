package io.github.silicondev.customrpg;

public enum SkillType {
	
	SKILL_COMBAT("Combat Skill", 0),
	SKILL_COMBAT_PREMIUM("Premium Combat Skill", 1),
	SKILL_NON_COMBAT("Non-Combat Skill", 2),
	SKILL_NON_COMBAT_PREMIUM("Premium Non-Combat Skill", 3);
	
	private String name;
	private int id;
	
	SkillType(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
}