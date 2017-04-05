package application.controleur;

import application.modele.ImageModele;
import framework.Controleur;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;


public class ControleurImage extends Controleur {

	public void addModel(ImageModele imageModele) {
		// TODO Auto-generated method stub
		
	}

	public void choisirFichierAOuvrir() {
		JFileChooser fc = new JFileChooser();

		FileFilter imageFilter = new FileNameExtensionFilter(
				"Fichiers image", ImageIO.getReaderFileSuffixes());

		fc.setFileFilter(imageFilter);
		fc.setCurrentDirectory(new File("."));
		fc.setDialogTitle("Choisir une Image");

		int response = fc.showOpenDialog(new JFrame());

		if (response == JFileChooser.APPROVE_OPTION) {
			//		String filePath = fc.getCurrentDirectory().toString() + "/" + fc.getSelectedFile().getName();
			File fichierImage = fc.getSelectedFile();
//			imageModele.ouvrirFichier(fichierImage);
		} else if (response == JFileChooser.CANCEL_OPTION){
			System.out.println("L'opération a été annulée.");
		}

//		setChanged();
//		notifyObservers();
	}

}
