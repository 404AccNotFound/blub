package bla;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class RuneInfo {
	
	public static HashMap<String, HashMap<Integer,String>> mapping = new HashMap<>();
	
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
	
	public static String commonRarity = "commmon";
	public static String magicRarity = "magic";
	public static String rareRarity = "rare";
	public static String epicRarity = "epic";
	public static String legendaryRarity = "legendary";
	
	public static String energyKey = "energy";
	public static String guardKey = "guard";
	public static String swiftKey = "swift";
	public static String bladeKey = "blade";
	public static String rageKey = "rage";
	public static String focusKey = "focus";
	public static String endureKey = "endure";
	public static String fatalKey = "fatal";
	public static String despairKey = "despair";
	public static String vampireKey = "vampire";
	public static String violentKey = "violent";
	public static String nemesisKey = "nemesis";
	public static String willKey = "will";
	public static String shieldKey = "shield";
	public static String revengeKey = "revenge";
	public static String destroyKey = "destroy";
	public static String fightKey = "fight";
	public static String determinationKey = "determination";
	public static String enhanceKey = "enhance";
	public static String accuracyKey = "accuracy";
	public static String toleranceKey = "tolerance";
	
	public static HashMap<Integer, String> rarityMap;
	public static HashMap<Integer, String> setMap;
	public static HashMap<Integer, String> effectTypesMap;
	
	/*
	 * sets: {
      1: 'Energy',
      2: 'Guard',
      3: 'Swift',
      4: 'Blade',
      5: 'Rage',
      6: 'Focus',
      7: 'Endure',
      8: 'Fatal',
      10: 'Despair',
      11: 'Vampire',
      13: 'Violent',
      14: 'Nemesis',
      15: 'Will',
      16: 'Shield',
      17: 'Revenge',
      18: 'Destroy',
      19: 'Fight',
      20: 'Determination',
      21: 'Enhance',
      22: 'Accuracy',
      23: 'Tolerance'
	 */
	
	public static void init() throws IOException {
		
		boolean checkLine = true;
		int depth = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(new File("files\\mapping.js")))){
			String line = br.readLine();
			String regexStart = "(.*)(: {)";
			String regexEnd = "(.*)(})(.*)";
			String tempMapName = "";
			while(line != null && checkLine) {
				if(line.contains(regexStart)) {
					tempMapName = line.replaceAll(regexStart, "$1").trim();
					System.out.println(tempMapName);
				}
				line = br.readLine();
			}
		}
		
//		rarityMap.put(0, commonRarity);
//		rarityMap.put(1, magicRarity);
//		rarityMap.put(2, rareRarity);
//		rarityMap.put(3, epicRarity);
//		rarityMap.put(4, legendaryRarity);
//		
//		setMap.put(1, energyKey);
//		setMap.put(2, guardKey);
//		setMap.put(3, swiftKey);
//		setMap.put(4, bladeKey);
//		setMap.put(5, rageKey);
//		setMap.put(6, focusKey);
//		setMap.put(7, endureKey);
//		setMap.put(8, fatalKey);
//		setMap.put(10, despairKey);
	}
	
}
