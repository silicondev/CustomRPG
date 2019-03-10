package io.github.silicondev.customrpg;

public class SkillSlot {
	private Skill skill = Skill.EMPTY;
	private int level = 0;
	private float xp = 0;
	private boolean active = false;
	
	public SkillSlot(Skill skill) {
		this.skill = skill;
	}
	
	public void setActive(boolean bool) {
		this.active = bool;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void setXp(int xp) {
		this.xp = xp;
	}
	
	public void addLevel(int level) {
		this.level += level;
	}
	
	public void addXp(float xp) {
		this.xp += xp;
	}
	
	public void changeSkill(Skill newSkill) {
		this.skill = newSkill;
		this.level = 0;
		this.xp = 0;
		this.active = true;
	}
	
	public void clearSlot() {
		this.skill = null;
		this.level = 0;
		this.xp = 0;
		this.active = false;
	}
	
	public Skill getSkill() {
		return this.skill;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public float getXp() {
		return this.xp;
	}
	
	public boolean getActive() {
		return this.active;
	}
}
