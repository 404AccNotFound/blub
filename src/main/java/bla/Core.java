package bla;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Core {

	public static void main(String[] args) throws IOException {
		JSONObject object = new JSONObject(new JSONTokener(new FileInputStream(new File("C:\\Users\\Nico\\Desktop\\Summoners War Exporter Files\\live\\3774351-live-1518209630.json"))));
		JSONObject rune = object.getJSONObject("rune");
		for(String s : rune.keySet()) {
			System.out.println(s);
		}
	}	
}
