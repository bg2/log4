package application.controleur;

import application.controleur.commandes.CommandeTranslate;
import application.controleur.commandes.CommandeZoom;
import application.controleur.commandes.GestionnaireDeCommande;
import application.modele.ImageModele;
import application.modele.PerspectiveModele;
import application.vues.VuePerspective;
import application.vues.VuePerspective2;
import framework.Controleur;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.util.EventListener;

public class ControleurPerspective2 extends Controleur<PerspectiveModele, VuePerspective2> implements EventListener, MouseListener,
        MouseWheelListener{
    GestionnaireDeCommande gestionnaireDeCommande = GestionnaireDeCommande.getInstance();

    int positionXinitiale = 0;
    int positionYinitiale =0;
    int positionYfinale=0;
    int positionXfinale =0;
    int deplacement=0;
    Point initialClick;

    public ControleurPerspective2(PerspectiveModele perspectiveModele, VuePerspective2 vue){
        modele(perspectiveModele);
        vue(vue);
    }

    public void ouvrirFichier(File fichierImage){
        modele.ouvrirFichier(fichierImage);
    }

//
//
//
//
//    public void addModel(ImageModele imageModele) {
//        // TODO Auto-generated method stub
//
//    }
//
//    public void addModel (PerspectiveModele perspectiveModele){
//        // TODO Auto-generated method stub
//
//    }

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

    public void zoom(double e){
//		if (this != null)
//			modele.setZoomScale(e);

        //Perspective perspective = perspectives.get(perspectiveIndex);
        CommandeZoom zoom = new CommandeZoom(modele, e);
        GestionnaireDeCommande gestionnaireDeCommande = GestionnaireDeCommande.getInstance();
        gestionnaireDeCommande.execute2(zoom);

    }

    public void translate(Point p){
        CommandeTranslate translate = new CommandeTranslate(modele, p);
        GestionnaireDeCommande gestionnaireDeCommande = GestionnaireDeCommande.getInstance();
        gestionnaireDeCommande.execute2(translate);
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
        //modele.moveAction(X, Y);
    }



    private int mouvementY(int positionXfinale) {
        deplacement = positionYfinale - positionYinitiale;
        return deplacement;
    }

    private int mouvementX( int positionYfinale) {
        deplacement = positionYfinale - positionYinitiale;
        return deplacement;
    }


    public void defaire() {
            gestionnaireDeCommande.defaire2();
    }

    public void refaire() {
        gestionnaireDeCommande.refaire2();
    }
}


