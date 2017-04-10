package application.controleur.commandes;

import application.modele.PerspectiveModele;

/**
 * Classe de la commande zoom
 */
public class CommandeZoom implements Commande {

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
