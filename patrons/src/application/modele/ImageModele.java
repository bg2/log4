package application.modele;

import application.vues.VueThumbnail;
import framework.Modele;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.Serializable;

public class ImageModele extends Modele {

	private transient Image image;

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


	public void charger(Image image) {
		setImage(image);
		setChanged();
		notifyObservers();
	}

}
