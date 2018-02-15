package bla;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.stream.Stream;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Core {
	
	public static String directory = "files";

	public static void main(String[] args) throws IOException {
		JSONObject object = new JSONObject(new JSONTokener(new FileInputStream(new File("files\\3774351-live-1518209630.json"))));
		if(object.get("action").equals("new_rune")) {
			JSONObject runeObject = object.getJSONObject("rune");
			Rune rune = new Rune(runeObject);
		}
		
    	HashMap<String, String> runeMap = new HashMap<String, String>();
    	runeMap.put(Rune.critRateKey, "5");
    	runeMap.put(Rune.critDmgKey, "6");
    	runeMap.put(Rune.hpFlatKey, "20");
		Rune rune = new Rune(1, 6, Rune.legendaryRarity, runeMap);
		RuneKeepOptionData.init();
		Core core = new Core();
		System.out.println(core.keepOrNotToKeep(rune));
	}	
	
//	public static void main(String[] args) {
//      Toolkit.getDefaultToolkit().addAWTEventListener(
//        new Listener(), AWTEvent.MOUSE_EVENT_MASK | AWTEvent.FOCUS_EVENT_MASK);
//      JFrame frame = new JFrame();
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.setVisible(true);
//  }
//
//  private static class Listener implements AWTEventListener {
//      public void eventDispatched(AWTEvent event) {
//          System.out.println(MouseInfo.getPointerInfo().getLocation() + " | ");
//      }
//  }
  
  /*
   * ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
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
  
  /*
   * Rune:	HashMap<String, String>
   * 		slot = 1
   * 		stars = 6
   * 		rarity = epic
   * 		critRate = 5
   * 		hpPerc = 6
   * 		hpFlat = 20
   * 
   * checkMap:	runeKeepOption
   * 		slot = 1
   * 		stars = 6		String/int
   * 		rarity = epic	String
   * 		statMap = 	HashMap<String, Boolean>
   * 					hpPerc = false
   * 					critRate = false
   * 					critDamage = false
   * 					x = false
   */
	
	public boolean keepOrNotToKeep(Rune rune) {
		for (RuneKeepOption option : RuneKeepOption.runeKeepOptionsList) {
			//preconditions
			if (rune.getStars() == option.getStars() && rune.getSlot() == option.getSlot() && rune.getRarity().equals(option.getRarity())) {
				int counter = 0;
				//checking throug stats
				for (String runeStat : rune.getStats().keySet()) {
					for (String optionStat : option.getOptions().keySet()) {
						if ((runeStat.equals(optionStat) || optionStat.equals(Rune.fillerKey)) && !option.getOptions().get(optionStat)) {
							counter++;
							option.getOptions().put(optionStat, true);
							break;
						}
					}
				}
				if (counter == rune.getStats().size()) {
					return true;
				}
			}
		}
		return false;
	}
	
	public void watchOutForNewFile () throws IOException {
		try (Stream<Path> paths = Files.walk(Paths.get(Core.directory))) {
		    paths
		        .filter(Files::isRegularFile)
		        .forEach(System.out::println);
		} 
	}
}
