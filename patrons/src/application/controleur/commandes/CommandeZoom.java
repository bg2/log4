package application.controleur.commandes;

import application.modele.PerspectiveModele;

/**
 * Created by Khoi on 2017-04-07.
 */
public class CommandeZoom implements Commande {

    private PerspectiveModele perspectiveModele;
    private double zoomScale;
    private double facteurDeZoom;

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
