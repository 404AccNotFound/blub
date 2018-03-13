package bla;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.JSONObject;
import org.json.JSONTokener;

public class Gui extends JFrame implements ActionListener,Runnable{
	
	public static boolean listenerCheck = true;
	
	public Gui() {
		super();
		setTitle("My Gui");
        setSize(400, 400);

        // Create JButton and JPanel
        JButton initListenerButton = new JButton("initListener");
        initListenerButton.addActionListener(this);
        JButton endListenerButton = new JButton("endListener");
        endListenerButton.addActionListener(this);
        JButton auswertungButton = new JButton("auswertung");
        auswertungButton.addActionListener(this);
        JPanel panel = new JPanel();
        
        // Add button to JPanel
		//TODO: seperate ButtonActions!!
        panel.add(initListenerButton);
        panel.add(auswertungButton);
        panel.add(endListenerButton);
        // And JPanel needs to be added to the JFrame itself!
        this.getContentPane().add(panel);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void initListener() throws IOException, InterruptedException {
		RuneInfo.init();
		RuneKeepOptionData.init();
		Core core = new Core();
		ArrayList <Path> jsonList = core.watchOutForNewFile();
		while(listenerCheck) {
			ArrayList <Path> tempJsonList = core.watchOutForNewFile();
			if(jsonList.hashCode() != tempJsonList.hashCode()) {
				tempJsonList.removeAll(jsonList);
				for(Path jsonPath : tempJsonList) {
					JSONObject object = new JSONObject(new JSONTokener(new FileInputStream(new File(jsonPath.toString()))));
					if(object.has("rune")) {
						//RUNE!!
						JSONObject runeObject = object.getJSONObject("rune");
						Rune rune = new Rune(runeObject);
						if(core.keepOrNotToKeep(rune)) {
							System.out.println("keep");
						}else {
							System.out.println("dontKeep");
						}
					}else {
						System.out.println(object.get("action"));
					}
				}
				jsonList.addAll(tempJsonList);
			}
            Thread.sleep(100);
		}
	}
	
	public void auswertung() {
		
	}
	
	public void endListener() {
		//TODO: kill thread
		listenerCheck = false;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("initListener")) {
			//TODO: seperate
			listenerCheck = true;
			Thread thread = new Thread(this);
			thread.start();
		}else if(arg0.getActionCommand().equals("auswertung")) {
			this.auswertung();
		}else if(arg0.getActionCommand().equals("endListener")) {
			this.endListener();
		}
	}

	@Override
	public void run() {
		try {
			System.out.println("Thread started!");
			this.initListener();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
