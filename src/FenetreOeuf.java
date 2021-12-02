import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class FenetreOeuf extends FenetreSaveOpen{
	/*
	 * Cette classe est potentiellement impliquée dans la mise en place d'un easterEgg.
	 */

	static public String aDessiner;
	
	static private Random rd;
	
	static private JPanel champEtRandomizer;
	static private ShapeButton randomizer;
	
	static private ArrayList<String> listeMots;
	
	static private Timer tim;
	static private TimerTask tTtim;
	
	public FenetreOeuf() {

		super("Pictionary",
				"  Vous avez découvert le Pictionary !"
				+ " Quand vous cliquerez sur \"Jouer\", vous aurez"
				+ " 30 secondes pour dessiner et faire deviner le mot"
				+ " aux autres participants.",
				"Jouer", false);
		// Titre, Descriptif, Intitulé du bouton, présentation classique
		// Ici false car on a un bouton supplémentaire.
		
		listeMots = new ArrayList<String>();
		initListeMots(listeMots);
		
		champEtRandomizer = new JPanel();
		randomizer = new ShapeButton("Graphismes\\ALEA.png","alea");
		randomizer.addActionListener(this);
		rd = new Random();
		
		aDessiner = nomAlea();
		this.champ.setText(aDessiner);
		
		tTtim = new TimerTask() {
			int counter = 31;  // Un timer de 30 secondes.
			@Override
			public void run() {
				if(counter > 0) {
					counter = counter - 1;
					champ.setText("Plus que " + counter + " secondes !");
				} else if (counter <= 0 && counter >= -3) {
					// A la fin du temps imparti (ici, 30 secondes)
					champ.setText("Fin du temps imparti !");
					counter = counter - 1;
				} else if (counter < -3){
					// On laisse ce message affiché 4 secondes.
					tim.cancel();
					dispose();
				}
			}
		};
		
		champEtRandomizer.setLayout(new GridLayout(1,2));
		champEtRandomizer.add(champ);
		champEtRandomizer.add(randomizer);
		
		this.contentPanel.setLayout(new GridLayout(3,1));
		this.contentPanel.add(this.text);
		this.contentPanel.add(champEtRandomizer);
		this.contentPanel.add(this.bouton);
		
		this.pack();
	}
	
	public void actionPerformed(ActionEvent ae) {
		String caller = ae.getActionCommand();
		
		switch(caller) {
			case "alea" :
				aDessiner = nomAlea();
				this.champ.setText(aDessiner);
				break;
			
			case "Jouer" :
				tim = new Timer();
				tim.scheduleAtFixedRate(tTtim, 0, 1000);
				break;
		}
	}
	
	private void initListeMots(ArrayList<String> liste) {
		try {
			Scanner sc = new Scanner(new File("liste_de_mots.txt"));
			
			while(sc.hasNextLine()) {
				listeMots.add(sc.nextLine());
			}
			
			sc.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private String nomAlea() {
		return listeMots.get( rd.nextInt(listeMots.size()) );
	}
	
	private void lancerJeu(String aDessiner) {
		///////////////////////////////
	}
}