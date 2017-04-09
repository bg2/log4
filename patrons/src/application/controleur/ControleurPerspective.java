package application.controleur;

import application.controleur.commandes.CommandeTranslate;
import application.controleur.commandes.CommandeZoom;
import application.controleur.commandes.GestionnaireDeCommande;
import application.modele.ImageModele;
import application.modele.PerspectiveModele;
import application.vues.VuePerspective;
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

	GestionnaireDeCommande gestionnaireDeCommande = GestionnaireDeCommande.getInstance();
	Point initialClick;
	
	public ControleurPerspective(PerspectiveModele perspectiveModele, VuePerspective vue){
		modele(perspectiveModele);
		vue(vue);
	}

	public void ouvrirFichier(File fichierImage){
		modele.ouvrirFichier(fichierImage);
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
		zoom(-e.getPreciseWheelRotation());
	}

	public void zoom(double e){
		CommandeZoom zoom = new CommandeZoom(modele, e);
		GestionnaireDeCommande gestionnaireDeCommande = GestionnaireDeCommande.getInstance();
		gestionnaireDeCommande.execute(zoom);

	}

	public void translate(Point p){
		CommandeTranslate translate = new CommandeTranslate(modele, p);
		GestionnaireDeCommande gestionnaireDeCommande = GestionnaireDeCommande.getInstance();
		gestionnaireDeCommande.execute(translate);
	}

	
	@Override
	public void mousePressed(final MouseEvent e) {
		initialClick = e.getPoint();
	}

	@Override
	public void mouseReleased(final MouseEvent e) {
		System.out.println("Perspective released");
		System.out.println("Controller: acting on Model");
		Point p = new Point();

		int thisX = modele.getXcoordinate();
		int thisY = modele.getYcoordinate();

		// Combien la souris a bouge depuis initialClick
		int xMoved = (thisX + e.getX()) - (thisX + initialClick.x);
		int yMoved = (thisY + e.getY()) - (thisY + initialClick.y);

		// Bouge l'image a cette position
		int X = thisX + xMoved;
		int Y = thisY + yMoved;

		p.setLocation(X,Y);
		translate(p);
	}

	public void defaire() {
			gestionnaireDeCommande.defaire1();
	}


	public void refaire() {
		gestionnaireDeCommande.refaire1();
	}

	public void chargerPerspectiveModele(PerspectiveModele perspectiveModele, Image image){
		modele.charger(perspectiveModele);
		modele.setImage(image);
	}
}

