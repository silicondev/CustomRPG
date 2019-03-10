package io.github.silicondev.customrpg;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

public class PlayerData {
	private Player player;
	private int level;
	private List<SkillSlot> skills = new ArrayList<SkillSlot>();
	private int addCombatSkills = 0;
	private int addNoCombatSkills = 0;
	
	public PlayerData(Player player, int level, List<SkillSlot> skills) {
		this.player = player;
		this.level = level;
		this.skills = skills;
	}
	
	public void setupNewPlayer(Player player) {
		this.player = player;
		this.level = ConfigHandle.minLevel;
		this.skills = new ArrayList<SkillSlot>();
		this.addCombatSkills = 0;
		this.addNoCombatSkills = 0;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public int getLevel() {
		return this.level;
	}
	
	public SkillSlot getSkill(int index) {
		return skills.get(index);
	}
	
	public List<SkillSlot> getAllSkills() {
		return skills;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public void addLevel() {
		this.level = this.level + 1;
	}
	
	public boolean addSkill(SkillSlot skill) {
		if (skill.getSkill().getType().equals(SkillType.SKILL_COMBAT)) {
			
			int activeCombatSkills = 0;
			for (int c = 0; c < this.skills.size(); c++) {
				if (this.skills.get(c).getSkill().getType().equals(SkillType.SKILL_COMBAT)) {
					activeCombatSkills++;
				}
			}
			
			if (activeCombatSkills < (ConfigHandle.baseComSlots + this.addCombatSkills)) {
				this.skills.add(skill);
				return true;
			} else {
				return false;
			}
			
		} else if (skill.getSkill().getType().equals(SkillType.SKILL_NON_COMBAT)) {

			int activeNonCombatSkills = 0;
			for (int c = 0; c < this.skills.size(); c++) {
				if (this.skills.get(c).getSkill().getType().equals(SkillType.SKILL_NON_COMBAT)) {
					activeNonCombatSkills++;
				}
			}
			
			if (activeNonCombatSkills < (ConfigHandle.baseComSlots + this.addNoCombatSkills)) {
				this.skills.add(skill);
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
	
	public boolean addCombatSlots(int num) {
		
		if ((this.addCombatSkills + num) <= ConfigHandle.addComSlots) {
			this.addCombatSkills += num;
			return true;
		}
		
		return false;
	}
	
	public boolean addNonCombatSlots(int num) {
		
		if ((this.addNoCombatSkills + num) <= ConfigHandle.addNoComSlots) {
			this.addNoCombatSkills += num;
			return true;
		}
		
		return false;
	}
	
	public boolean setCombatSlots(int num) {
		
		if (num <= ConfigHandle.addComSlots) {
			this.addCombatSkills = num;
			return true;
		}
		
		return false;
	}
	
	public boolean setNonCombatSlots(int num) {
		
		if (num <= ConfigHandle.addNoComSlots) {
			this.addNoCombatSkills = num;
			return true;
		}
		
		return false;
	}
}
