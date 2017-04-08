package application.modele;

import framework.Modele;

import javax.imageio.ImageIO;

import java.awt.*;
import java.io.File;

public class PerspectiveModele extends Modele {

	private Image image;
	private int xPerspective;
	private int yPerspective;
	private double zoomIndex = 1;



	public Image getImage() {
		return image;
	}

	public void setImage(Image image){
		this.image = image;

		setChanged();
		notifyObservers();
	}

	public double getZoomIndex(){
		return zoomIndex;
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


	public void setZoomScale(double zoomScale) {
		if (zoomScale > 0)
			this.zoomIndex *= Math.pow(1.25, Math.abs(zoomScale));
		else
			this.zoomIndex /= Math.pow(1.25, Math.abs(zoomScale));
		try {
			setChanged();
			notifyObservers();
		} catch (final Exception e) {
		}
	}


	public int getImageScaledHeight() {
		return (int) (image.getHeight(null) * zoomIndex);
	}


	public int getImageScaledWidth() {
		return (int) (image.getWidth(null) * zoomIndex);
	}
	
	public void moveAction(final int x, final int y) {

		setPosition(x, y);
		
	}

	
	public void setPosition(int x, int y) {
		System.out.println("ici");
		xPerspective = xPerspective + x;
		yPerspective = yPerspective + y;
		try {
			setChanged();
			notifyObservers();
		} catch (final Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void addStep() {
	
	}

}
