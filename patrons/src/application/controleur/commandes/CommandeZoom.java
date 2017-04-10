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
 Nom du fichier: CommandeZoom.java
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

/**
 * Classe de la commande zoom
 */
public class CommandeZoom implements ICommande {

    private PerspectiveModele perspectiveModele;
    private double zoomScale;
    private double facteurDeZoom;

    /**
     * Constructeur
     *
     * @param perspectiveModele Modèle de la perspective
     * @param facteurDeZoom Le nouveau niveau de zoom
     */
    public CommandeZoom(PerspectiveModele perspectiveModele, double facteurDeZoom){
        this.perspectiveModele = perspectiveModele;
        zoomScale = perspectiveModele.getZoomScale();
        this.facteurDeZoom = facteurDeZoom;
    }

    @Override
    public void execute() {
        perspectiveModele.setZoomScale(facteurDeZoom);
    }

    @Override
    public void undo() {
        perspectiveModele.setThisZoomScale(zoomScale);
    }
}
