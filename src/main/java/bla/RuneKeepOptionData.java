package bla;

import java.util.HashMap;

public class RuneKeepOptionData {

	/*
	* 5* legend speed
    * 6* legend x
    * 6* epic speed
    * 6* epic attack / critRate / critDamage / x
    * 6* epic defense / critRate / critDamage / x
    * 6* epic hp / critRate / critDamage / x
    * 6* epic critRate / critDamage / x
    * 6* epic defense / hp / x
    * 6* rare speed / nonFlatStat
    * 6* rare attack / critRate / critDamage
    * 6* rare defense / critRate / critDamage
    * 6* rare hp / critRate / critDamage
    * 6* rare critRate / critDamage
    * 6* rare defense / hp
	 */
	public static void init() {
		addRuneKeepOption(7, 5, Rune.legendaryRarity, new String[] { Rune.speedKey, Rune.fillerKey, Rune.fillerKey, Rune.fillerKey });
		addRuneKeepOption(7, 6, Rune.legendaryRarity, new String[] { Rune.fillerKey, Rune.fillerKey, Rune.fillerKey, Rune.fillerKey });
		addRuneKeepOption(7, 6, Rune.epicRarity, new String[] { Rune.speedKey, Rune.fillerKey, Rune.fillerKey, Rune.fillerKey });
		addRuneKeepOption(7, 6, Rune.epicRarity, new String[] { Rune.attPercKey, Rune.critRateKey, Rune.critDmgKey, Rune.fillerKey });
		addRuneKeepOption(7, 6, Rune.epicRarity, new String[] { Rune.defPercKey, Rune.critRateKey, Rune.critDmgKey, Rune.fillerKey });
		addRuneKeepOption(7, 6, Rune.epicRarity, new String[] { Rune.hpPercKey, Rune.critRateKey, Rune.critDmgKey, Rune.fillerKey });
		addRuneKeepOption(7, 6, Rune.epicRarity, new String[] { Rune.critRateKey, Rune.critDmgKey, Rune.fillerKey });
		addRuneKeepOption(7, 6, Rune.epicRarity, new String[] { Rune.defPercKey, Rune.hpPercKey, Rune.fillerKey });
		addRuneKeepOption(7, 6, Rune.rareRarity, new String[] { Rune.speedKey, Rune.hpPercKey, Rune.defPercKey, Rune.attPercKey, Rune.critRateKey, Rune.critDmgKey, Rune.accKey, Rune.resKey });
		addRuneKeepOption(7, 6, Rune.rareRarity, new String[] { Rune.attPercKey, Rune.critRateKey, Rune.critDmgKey });
		addRuneKeepOption(7, 6, Rune.rareRarity, new String[] { Rune.defPercKey, Rune.critRateKey, Rune.critDmgKey });
		addRuneKeepOption(7, 6, Rune.rareRarity, new String[] { Rune.hpPercKey, Rune.critRateKey, Rune.critDmgKey });
		addRuneKeepOption(7, 6, Rune.rareRarity, new String[] { Rune.hpPercKey, Rune.defPercKey });
	}
	
	public static void addRuneKeepOption(int slot, int stars, String rarity, String[] keys) {
		HashMap<String, Boolean> optionMap = new HashMap<String, Boolean>();
		int fillerCounter = 0;
		for (String key : keys) {
			if(key == Rune.fillerKey) {
				fillerCounter++;
			}else {
				optionMap.put(key, false);
			}
		}
		//fillerKeys at the end cause of the Rune KeepOrNotToKeep check
		for(int i = 0; i < fillerCounter; i++) {
			optionMap.put(Rune.fillerKey, false);
		}
		if(slot == 7) {
			RuneKeepOption runeOption = new RuneKeepOption(1, stars, rarity, optionMap);
			RuneKeepOption.runeKeepOptionsList.add(runeOption);
			runeOption = new RuneKeepOption(3, stars, rarity, optionMap);
			RuneKeepOption.runeKeepOptionsList.add(runeOption);
			runeOption = new RuneKeepOption(5, stars, rarity, optionMap);
			RuneKeepOption.runeKeepOptionsList.add(runeOption);
		}else {
			RuneKeepOption runeOption = new RuneKeepOption(slot, stars, rarity, optionMap);
			RuneKeepOption.runeKeepOptionsList.add(runeOption);
		}
	}
}