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
 Nom du fichier: ControleurPerspective2.java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-31
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/

package application.controleur;

import application.controleur.commandes.CommandeTranslate;
import application.controleur.commandes.CommandeZoom;
import application.controleur.commandes.GestionnaireDeCommande;
import application.modele.PerspectiveModele;
import application.vues.VuePerspective2;
import framework.Controleur;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.util.EventListener;

/**
 * Classe controleur de la deuxième perspective
 */
public class ControleurPerspective2 extends Controleur<PerspectiveModele, VuePerspective2> implements EventListener, MouseListener,
        MouseWheelListener{

    private GestionnaireDeCommande gestionnaireDeCommande = GestionnaireDeCommande.getInstance();
    private Point initialClick;

    /**
     * Constructeur
     *
     * @param perspectiveModele Modèle de la perspective
     * @param vue Vue de la perspective
     */
    public ControleurPerspective2(PerspectiveModele perspectiveModele, VuePerspective2 vue){
        modele(perspectiveModele);
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

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        zoom(-e.getPreciseWheelRotation());
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        initialClick = e.getPoint();
    }

    @Override
    public void mouseReleased(final MouseEvent e) {
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

    /**
     * Méthode de zoom
     *
     * @param facteurZoom Le niveau de zoom appliqué
     */
    public void zoom(double facteurZoom){
        CommandeZoom zoom = new CommandeZoom(modele, facteurZoom);
        GestionnaireDeCommande gestionnaireDeCommande = GestionnaireDeCommande.getInstance();
        gestionnaireDeCommande.execute2(zoom);

    }

    /**
     * Méthode de translation
     *
     * @param p La nouvelle coordonnée de l'image
     */
    public void translate(Point p){
        CommandeTranslate translate = new CommandeTranslate(modele, p);
        GestionnaireDeCommande gestionnaireDeCommande = GestionnaireDeCommande.getInstance();
        gestionnaireDeCommande.execute2(translate);
    }

    /**
     * Annule la dernière commande
     */
    public void defaire() {
            gestionnaireDeCommande.defaire2();
    }

    /**
     * Refait la dernière commande annulée
     */
    public void refaire() {
        gestionnaireDeCommande.refaire2();
    }

    /**
     * Charge les perspectives sauvegardées
     *
     * @param perspectiveModele Modèle de la perspective
     * @param image Image des perspectives chargées
     */
    public void chargerPerspectiveModele(PerspectiveModele perspectiveModele, Image image){
        modele.charger(perspectiveModele);
        modele.setImage(image);
    }
}


