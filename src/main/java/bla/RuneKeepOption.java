package bla;

import java.util.ArrayList;
import java.util.HashMap;

public class RuneKeepOption {

	public static ArrayList<RuneKeepOption> runeKeepOptionsList = new ArrayList<RuneKeepOption>();

	private int slot;
	private int stars;
	private String rarity;
	private HashMap<String, Boolean> options;
	public RuneKeepOption(int slot, int stars, String rarity, HashMap<String, Boolean> options) {
		super();
		this.slot = slot;
		this.stars = stars;
		this.rarity = rarity;
		this.options = options;
		runeKeepOptionsList.add(this);
	}
	public static ArrayList<RuneKeepOption> getRuneKeepOptionsList() {
		return runeKeepOptionsList;
	}

	public int getSlot() {
		return slot;
	}
	public void setSlot(int slot) {
		this.slot = slot;
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
	public HashMap<String, Boolean> getOptions() {
		return options;
	}
	public void setOptions(HashMap<String, Boolean> options) {
		this.options = options;
	}
}