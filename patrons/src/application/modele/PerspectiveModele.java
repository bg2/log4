package application.modele;

import application.vues.VuePerspective;
import framework.Modele;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.Observable;

public class PerspectiveModele extends Modele {

	private Image image;

	public Image getImage() {
		return image;
	}

	public void setImage(Image image){
		this.image = image;

		setChanged();
		notifyObservers();
	}


	public void ouvrirFichier(File fichierImage) {
		try {
			image = ImageIO.read(fichierImage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setChanged();
		notifyObservers();

	}

	public void chargerImage(){}

}
