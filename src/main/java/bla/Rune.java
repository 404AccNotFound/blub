package bla;

import java.util.HashMap;

import org.json.JSONObject;

public class Rune {
	
	private int slot;
	private int stars;
	private String rarity;
	private String set;
	private HashMap<String, String> stats;

	public Rune(int slot, int stars, String rarity, HashMap<String, String> stats) {
		this.slot = slot;
		this.stars = stars;
		this.rarity = rarity;
		this.stats = stats;
	}

	public Rune(JSONObject runeObject) {
		//TODO: construct Rune from JsonObject
		slot = runeObject.getInt("slot_no");
		stars = runeObject.getInt("rank");
		rarity = RuneInfo.rarityMap.get(runeObject.getInt("class"));
		set = RuneInfo.setMap.get(runeObject.getInt("set_id"));
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getRarity() {
		return rarity;
	}

	public void setRarity(String rarity) {
		this.rarity = rarity;
	}

	public HashMap<String, String> getStats() {
		return stats;
	}

	public void setStats(HashMap<String, String> stats) {
		this.stats = stats;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

}