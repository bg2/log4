/******************************************************
 Cours:   LOG121
 Session: H2017
 Groupe: 02
 Projet: Laboratoire #4
 Étudiant(e)s:
 Alexandre Trepanier
 Vanessa Baquero
 Nam Vu Khanh
 Khoi Tran-Quang
 Professeur : Francis Cardinal
 Nom du fichier: .java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/

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
