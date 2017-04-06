package application.controleur;

import application.modele.ImageModele;
import application.modele.PerspectiveModele;
import application.vues.VueThumbnail;
import framework.Controleur;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.EventListener;

public class ControleurPerspective extends Controleur<ImageModele, VueThumbnail> implements EventListener, MouseListener,
		MouseWheelListener{


		public void addModel (PerspectiveModele perspectiveModele){
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("Perspective");
		System.out.println("Controller: acting on Model");
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Perspective released");
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
	}
}


