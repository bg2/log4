package application.controleur.commandes;

import application.modele.PerspectiveModele;

import java.awt.*;

/**
 * Classe pour la commande de translation
 */
public class CommandeTranslate implements Commande {

    private PerspectiveModele perspectiveModele;
    private Point initial = new Point();
    private Point update = new Point();

    /**
     * Constructeur
     *
     * @param perspectiveModele Le modèle d'une perspective
     * @param p La nouvelle coordonnée de l'image
     */
    public CommandeTranslate(PerspectiveModele perspectiveModele, Point p){
        this.perspectiveModele = perspectiveModele;
        initial.x = perspectiveModele.getXcoordinate();
        initial.y = perspectiveModele.getYcoordinate();

        update = p;
    }

    @Override
    public void execute() {
        perspectiveModele.setPosition(update.x, update.y);
    }

    @Override
    public void undo() {
        perspectiveModele.setPosition(initial.x,initial.y);
    }
}



