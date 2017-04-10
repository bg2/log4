package application.modele;


import framework.Modele;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;

public class ImageModele extends Modele {

	private transient Image image;

	/**
	 * Ouvre le fichier image sélectionné
	 *
	 * @param fichierImage Le fichier image
	 */
	public void ouvrirFichier(File fichierImage) {
		try {
			image = ImageIO.read(fichierImage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		setChanged();
		notifyObservers();
	}

	/**
	 * Charge l'image de la sauvegarde de perspectives
	 *
	 * @param image L'image de la sauvegarde
	 */
	public void charger(Image image) {
		setImage(image);
		setChanged();
		notifyObservers();
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image){
		this.image = image;

		setChanged();
		notifyObservers();
	}
}
