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
		addRuneKeepOption(7, 5, RuneInfo.legendaryRarity, new String[] { RuneInfo.speedKey, RuneInfo.fillerKey, RuneInfo.fillerKey, RuneInfo.fillerKey });
		addRuneKeepOption(7, 6, RuneInfo.legendaryRarity, new String[] { RuneInfo.fillerKey, RuneInfo.fillerKey, RuneInfo.fillerKey, RuneInfo.fillerKey });
		addRuneKeepOption(7, 6, RuneInfo.epicRarity, new String[] { RuneInfo.speedKey, RuneInfo.fillerKey, RuneInfo.fillerKey, RuneInfo.fillerKey });
		addRuneKeepOption(7, 6, RuneInfo.epicRarity, new String[] { RuneInfo.atkPercKey, RuneInfo.critRateKey, RuneInfo.critDmgKey, RuneInfo.fillerKey });
		addRuneKeepOption(7, 6, RuneInfo.epicRarity, new String[] { RuneInfo.defPercKey, RuneInfo.critRateKey, RuneInfo.critDmgKey, RuneInfo.fillerKey });
		addRuneKeepOption(7, 6, RuneInfo.epicRarity, new String[] { RuneInfo.hpPercKey, RuneInfo.critRateKey, RuneInfo.critDmgKey, RuneInfo.fillerKey });
		addRuneKeepOption(7, 6, RuneInfo.epicRarity, new String[] { RuneInfo.critRateKey, RuneInfo.critDmgKey, RuneInfo.fillerKey });
		addRuneKeepOption(7, 6, RuneInfo.epicRarity, new String[] { RuneInfo.defPercKey, RuneInfo.hpPercKey, RuneInfo.fillerKey });
		addRuneKeepOption(7, 6, RuneInfo.rareRarity, new String[] { RuneInfo.speedKey, RuneInfo.hpPercKey, RuneInfo.defPercKey, RuneInfo.atkPercKey, RuneInfo.critRateKey, RuneInfo.critDmgKey, RuneInfo.accKey, RuneInfo.resKey });
		addRuneKeepOption(7, 6, RuneInfo.rareRarity, new String[] { RuneInfo.atkPercKey, RuneInfo.critRateKey, RuneInfo.critDmgKey });
		addRuneKeepOption(7, 6, RuneInfo.rareRarity, new String[] { RuneInfo.defPercKey, RuneInfo.critRateKey, RuneInfo.critDmgKey });
		addRuneKeepOption(7, 6, RuneInfo.rareRarity, new String[] { RuneInfo.hpPercKey, RuneInfo.critRateKey, RuneInfo.critDmgKey });
		addRuneKeepOption(7, 6, RuneInfo.rareRarity, new String[] { RuneInfo.hpPercKey, RuneInfo.defPercKey });
	}
	
	public static void addRuneKeepOption(int slot, int stars, String rarity, String[] keys) {
		HashMap<String, Boolean> optionMap = new HashMap<String, Boolean>();
		int fillerCounter = 0;
		for (String key : keys) {
			if(key == RuneInfo.fillerKey) {
				fillerCounter++;
			}else {
				optionMap.put(key, false);
			}
		}
		//fillerKeys at the end cause of the Rune KeepOrNotToKeep check
		for(int i = 0; i < fillerCounter; i++) {
			optionMap.put(RuneInfo.fillerKey, false);
		}
		if(slot == 7) {
			RuneKeepOption runeOption = new RuneKeepOption(1, stars, rarity, optionMap);
			RuneKeepOption.runeKeepOptionsList.add(runeOption);
			runeOption = new RuneKeepOption(3, stars, rarity, optionMap);
			RuneKeepOption.runeKeepOptionsList.add(runeOption);
			runeOption = new RuneKeepOption(5, stars, rarity, optionMap);
			RuneKeepOption.runeKeepOptionsList.add(runeOption);
			
			//DELETE!!!!
			runeOption = new RuneKeepOption(2, stars, rarity, optionMap);
			RuneKeepOption.runeKeepOptionsList.add(runeOption);
			runeOption = new RuneKeepOption(4, stars, rarity, optionMap);
			RuneKeepOption.runeKeepOptionsList.add(runeOption);
			runeOption = new RuneKeepOption(6, stars, rarity, optionMap);
			RuneKeepOption.runeKeepOptionsList.add(runeOption);
			//DELETE!!!!
			
		}else {
			RuneKeepOption runeOption = new RuneKeepOption(slot, stars, rarity, optionMap);
			RuneKeepOption.runeKeepOptionsList.add(runeOption);
		}
	}
}