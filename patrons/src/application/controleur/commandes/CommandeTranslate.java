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
 Nom du fichier: CommandeTranslate.java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-31
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/

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



