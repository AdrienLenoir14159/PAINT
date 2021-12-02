import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FenetreSave extends FenetreSaveOpen{

	public FenetreSave() {
		super("Sauvegarder ?",
				"  Veuillez inscrire le nom du fichier de sauvegarde  ",
				"Sauvegarder", true);
		
		// Titre, Descriptif, Intitulé du bouton
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(!this.champ.getText().isBlank()) {
			Drawing.save(this.champ.getText());
		} else {
			Drawing.save("DefaultName.txt");
		}
		
		this.dispose();
	}
}
