package application.modele;

import framework.Modele;

import javax.imageio.ImageIO;

import java.awt.*;
import java.io.File;
import java.io.Serializable;

public class PerspectiveModele extends Modele{

	private transient Image image;
	private int xPerspective;
	private int yPerspective;
	private double zoomScale = 1;


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

	public void chargerImage(){}

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
		System.out.println("ici");
		xPerspective = x;
		yPerspective =  y;
		setChanged();
		notifyObservers();
	}

	public void charger(PerspectiveModele perspectiveModele){
//		image = perspectiveModele.getImage();
		xPerspective = perspectiveModele.getXcoordinate();
		yPerspective = perspectiveModele.getYcoordinate();
		zoomScale = perspectiveModele.getZoomScale();

		setChanged();
		notifyObservers();
	}
}
