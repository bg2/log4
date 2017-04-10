package application.controleur;

import application.modele.ImageModele;
import application.vues.VueThumbnail;
import framework.Controleur;
import framework.Modele;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.EventListener;

/**
 * Classe controleur du thumbnail
 */
public class ControleurImage extends Controleur<ImageModele, VueThumbnail> implements EventListener, MouseListener {

	/**
	 * Constructeur
	 *
	 * @param imageModele Modèle du thumbnail
	 * @param vue Vue du thumbnail
	 */
	public ControleurImage(ImageModele imageModele, VueThumbnail vue){
		modele(imageModele);
		vue(vue);
	}

	/**
	 * Ouvre le fichier image
	 *
	 * @param fichierImage Le fichier image
	 */
	public void ouvrirFichier(File fichierImage){
		modele.ouvrirFichier(fichierImage);
	}

	/**
	 * Charge l'image des perspectives chargées
	 *
	 * @param image Image des perspectives sauvegardées
	 */
	public void chargerImageModele(Image image){
		modele.charger(image);
	}

	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}

