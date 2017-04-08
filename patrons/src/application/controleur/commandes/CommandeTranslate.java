package application.controleur.commandes;

import application.modele.PerspectiveModele;

import java.awt.*;

/**
 * Created by Khoi on 2017-04-08.
 */
public class CommandeTranslate implements Commande {
    private PerspectiveModele perspectiveModele;
    private Point initial = new Point();
    private Point update = new Point();

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
    public void unexecute() {
        perspectiveModele.setPosition(initial.x,initial.y);
    }
}



