package application.controleur.commandes;

import application.modele.PerspectiveModele;

/**
 * Created by Khoi on 2017-04-07.
 */
public class CommandeZoom implements Commande {

    private PerspectiveModele perspectiveModele;
    private double zoomDeBase;
    private double facteurDeZoom;

    public CommandeZoom(PerspectiveModele perspectiveModele, double facteurDeZoom){
        this.perspectiveModele = perspectiveModele;
        zoomDeBase = perspectiveModele.getZoomIndex();
        this.facteurDeZoom = facteurDeZoom;
    }

    @Override
    public void execute() {
        perspectiveModele.setZoomScale(zoomDeBase * facteurDeZoom);
    }

    @Override
    public void unexecute() {
        perspectiveModele.setZoomScale(zoomDeBase);
    }
}
