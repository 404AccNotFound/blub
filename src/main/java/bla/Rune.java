package bla;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

public class Rune {
	
	private int slot;
	private int stars;
	private String rarity;
	private String set;
	private String primaryStat;
	private String prefixStat;
	private ArrayList<String> secondStats;

	public Rune(int slot, int stars, String rarity, ArrayList<String> stats) {
		this.slot = slot;
		this.stars = stars;
		this.rarity = rarity;
		this.secondStats = stats;
	}

	public Rune(JSONObject runeObject) {
		//TODO: construct Rune from RuneObject
		this.slot = runeObject.getInt("slot_no");
		this.stars = runeObject.getInt("class");
		int rarity = runeObject.getInt("rank");
		this.rarity = RuneInfo.rarityMap.get(rarity);
		this.set = RuneInfo.setMap.get(runeObject.getInt("set_id"));
		this.primaryStat = RuneInfo.effectTypesMap.get(runeObject.getJSONArray("pri_eff").get(0));
		this.prefixStat = RuneInfo.effectTypesMap.get(runeObject.getJSONArray("prefix_eff").get(0));
		this.secondStats = getStatMapFromArray(runeObject.getJSONArray("sec_eff"), rarity);
	}

	private ArrayList<String> getStatMapFromArray(JSONArray array, int rarity) {
		ArrayList<String> resultList = new ArrayList<String>();
		for(int i = 0; i < rarity-1; i++) {
			resultList.add(RuneInfo.effectTypesMap.get(array.getJSONArray(i).getInt(0)));
		}
		return resultList;
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
	
	public String getPrimStat() {
		return primaryStat;
	}

	public void setPrimStat(String primStat) {
		this.primaryStat = primStat;
	}

	public ArrayList<String> getSecondStats() {
		return secondStats;
	}

	public void setSecondStats(ArrayList<String> list) {
		this.secondStats = list;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public String getSet() {
		return set;
	}

	public void setSet(String set) {
		this.set = set;
	}

	public String getPrefixStat() {
		return prefixStat;
	}

	public void setPrefixStat(String prefixStat) {
		this.prefixStat = prefixStat;
	}

}