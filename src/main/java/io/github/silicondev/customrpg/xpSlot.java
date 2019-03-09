package io.github.silicondev.customrpg;

public enum xpSlot {
	
	NONE(0),
	SWORD(0),
	AXE(0),
	BOW(0),
	FIST(0),
	TRIDENT(0),
	POTION(0),
	
	FISH(0),
	TRADE(0),
	COOK(0),
	BREED(0),
	BUTCHER(0),
	CROP(0),
	EXPLORE(0),
	LUMBER(0),
	EXCAVATE(0),
	MINELOW(0),
	MINEMED(0),
	MINEHIGH(0),
	BLACKSMITH(0),
	TOOLSMITH(0),
	SAIL(0),
	CRAFT(0),
	BREAK(0),
	PLACE(0);
	
	private float xpMod;
	
	xpSlot(float xpMod) {
		this.xpMod = xpMod;
	}
	
	public float getXp() {
		return this.xpMod;
	}
	
	public void setXp(float xpMod) {
		this.xpMod = xpMod;
	}
}
