package bla;

import java.io.IOException;
import java.util.HashMap;

public class RuneInfo {
	
	public static HashMap<String, HashMap<Integer,String>> mapping = new HashMap<>();
	
	public static String emptyKey = "";
	public static String speedKey = "spd";
	public static String hpPercKey = "hpPerc";
	public static String hpFlatKey = "hpFlat";
	public static String atkPercKey = "attPerc";
	public static String atkFlatKey = "attFlat";
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
	
	public static HashMap<Integer, String> rarityMap = new HashMap<Integer, String>();
	public static HashMap<Integer, String> setMap = new HashMap<Integer, String>();
	public static HashMap<Integer, String> effectTypesMap = new HashMap<Integer, String>();
	
	public static void init() throws IOException {
		
//		boolean checkLine = true;
//		int depth = 0;
//		try(BufferedReader br = new BufferedReader(new FileReader(new File("files\\mapping.js")))){
//			String line = br.readLine();
//			String regexStart = "(.*)(: {)";
//			String regexEnd = "(.*)(})(.*)";
//			String tempMapName = "";
//			while(line != null && checkLine) {
//				if(line.contains(regexStart)) {
//					tempMapName = line.replaceAll(regexStart, "$1").trim();
//					System.out.println(tempMapName);
//				}
//				line = br.readLine();
//			}
//		}
		
		rarityMap.put(1, commonRarity);
		rarityMap.put(2, magicRarity);
		rarityMap.put(3, rareRarity);
		rarityMap.put(4, epicRarity);
		rarityMap.put(5, legendaryRarity);
		
		setMap.put(1, energyKey);
		setMap.put(2, guardKey);
		setMap.put(3, swiftKey);
		setMap.put(4, bladeKey);
		setMap.put(5, rageKey);
		setMap.put(6, focusKey);
		setMap.put(7, endureKey);
		setMap.put(8, fatalKey);
		setMap.put(10, despairKey);
		setMap.put(11, vampireKey);
		setMap.put(13, violentKey);
		setMap.put(14, nemesisKey);
		setMap.put(15, willKey);
		setMap.put(16, shieldKey);
		setMap.put(17, revengeKey);
		setMap.put(18, destroyKey);
		setMap.put(19, fightKey);
		setMap.put(20, determinationKey);
		setMap.put(21, enhanceKey);
		setMap.put(22, accuracyKey);
		setMap.put(23, toleranceKey);
		
		effectTypesMap.put(0, emptyKey);
		effectTypesMap.put(1, hpFlatKey);
		effectTypesMap.put(2, hpPercKey);
		effectTypesMap.put(3, atkFlatKey);
		effectTypesMap.put(4, atkPercKey);
		effectTypesMap.put(5, defFlatKey);
		effectTypesMap.put(6, defPercKey);
		effectTypesMap.put(8, speedKey);
		effectTypesMap.put(9, critRateKey);
		effectTypesMap.put(10, critDmgKey);
		effectTypesMap.put(11, resKey);
		effectTypesMap.put(12, accKey);
	}
	
}
