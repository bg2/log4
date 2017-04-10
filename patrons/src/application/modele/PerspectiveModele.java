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
 Nom du fichier: PerspectiveModele.java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-31
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/

package application.modele;

import framework.Modele;
import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

/**
 * Classe modèle des perspectives
 */
public class PerspectiveModele extends Modele{

	private transient Image image;
	private int xPerspective;
	private int yPerspective;
	private double zoomScale = 1;


	/**
	 * Ouvre l'image sélectionnée
	 *
	 * @param fichierImage Le fichier de l'image
	 */
	public void ouvrirFichier(File fichierImage) {
		try {
			image = ImageIO.read(fichierImage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		setPosition(0,0);
		setThisZoomScale(1);

		setChanged();
		notifyObservers();
	}

	/**
	 * Change les attributs de la perspective pour ceux chargés
	 *
	 * @param perspectiveModele Le modèle chargé
	 */
	public void charger(PerspectiveModele perspectiveModele){

		xPerspective = perspectiveModele.getXcoordinate();
		yPerspective = perspectiveModele.getYcoordinate();
		zoomScale = perspectiveModele.getZoomScale();

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

	public double getZoomScale(){
		return zoomScale;
	}

	public void setThisZoomScale(double zoomScale){
		this.zoomScale = zoomScale;
		setChanged();
		notifyObservers();
	}

	public void setZoomScale(double facteurDeZoom) {
		double delta = 0.05f * facteurDeZoom;
		this.zoomScale += delta;

		setChanged();
		notifyObservers();
	}

	public int getImageScaledHeight() {
		return (int) (image.getHeight(null) * zoomScale);
	}

	public int getImageScaledWidth() {
		return (int) (image.getWidth(null) * zoomScale);
	}

	public int getXcoordinate() {
		return xPerspective;
	}

	public int getYcoordinate() {
		return yPerspective;
	}

	public void setPosition(int x, int y) {

		xPerspective = x;
		yPerspective =  y;
		setChanged();
		notifyObservers();
	}
}
