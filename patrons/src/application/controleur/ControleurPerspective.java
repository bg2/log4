package application.controleur;

import application.modele.ImageModele;
import application.modele.PerspectiveModele;
import application.vues.VuePerspective;
import application.vues.VueThumbnail;
import framework.Controleur;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.util.EventListener;

public class ControleurPerspective extends Controleur<PerspectiveModele, VuePerspective> implements EventListener, MouseListener,
		MouseWheelListener{

	int positionXinitiale = 0;
	int positionYinitiale =0;
	int positionYfinale=0; 
	int positionXfinale =0;
	int deplacement=0;
	
	public ControleurPerspective(PerspectiveModele perspectiveModele, VuePerspective vue){
		modele(perspectiveModele);
		vue(vue);
	}

	public void ouvrirFichier(File fichierImage){
		modele.ouvrirFichier(fichierImage);
	}





	public void addModel(ImageModele imageModele) {
		// TODO Auto-generated method stub

	}

		public void addModel (PerspectiveModele perspectiveModele){
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Perspective");
		System.out.println("Controller: acting on Model");
	}


	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println("Mousewheel rotating");
		zoom(-e.getWheelRotation());
	}

	public void zoom(int e){
		if (this != null)
			modele.setZoomScale(e);
	}
	
	@Override
	public void mousePressed(final MouseEvent e) {
		positionXinitiale = e.getX();
		positionYinitiale = e.getY();

	}

	@Override
	public void mouseReleased(final MouseEvent e) {
		System.out.println("Perspective released");
		System.out.println("Controller: acting on Model");
		positionYfinale = e.getY();
		positionXfinale = e.getX();
		modele.moveAction(mouvementX(positionXfinale), mouvementY(positionYfinale));

	}
	
	private int mouvementY(int positionXfinale) {
		deplacement = positionYfinale - positionYinitiale;
		return deplacement;
	}
	
	private int mouvementX( int positionYfinale) {
		deplacement = positionYfinale - positionYinitiale;
		return deplacement;
	}

}


