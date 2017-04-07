package application.modele;

import application.vues.VueThumbnail;
import framework.Modele;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;

public class ImageModele extends Modele {

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
