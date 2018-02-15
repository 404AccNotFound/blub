package bla;

import java.util.HashMap;

import org.json.JSONObject;

public class Rune {

	public static String speedKey = "spd";
	public static String hpPercKey = "hpPerc";
	public static String hpFlatKey = "hpFlat";
	public static String attPercKey = "attPerc";
	public static String attFlatKey = "attFlat";
	public static String defPercKey = "defPerc";
	public static String defFlatKey = "defFlat";
	public static String critRateKey = "critRate";
	public static String critDmgKey = "critDmg";
	public static String accKey = "acc";
	public static String resKey = "res";
	public static String fillerKey = "x";
	
	public static String rareRarity = "rare";
	public static String epicRarity = "epic";
	public static String legendaryRarity = "legendary";
	
	private int slot;
	private int stars;
	private String rarity;
	private HashMap<String, String> stats;

	public Rune(int slot, int stars, String rarity, HashMap<String, String> stats) {
		this.slot = slot;
		this.stars = stars;
		this.rarity = rarity;
		this.stats = stats;
	}

	public Rune(JSONObject runeObject) {
		//TODO: construct Rune from JsonObject
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