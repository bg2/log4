package application.vues;

import application.controleur.ControleurPerspective;
import application.modele.PerspectiveModele;
import framework.Vue;
import java.awt.*;
import java.util.Observable;

/**
 * Classe Vue de la première perspective
 */
public class VuePerspective extends Vue<PerspectiveModele, ControleurPerspective> {

    /**
     * Constructeur
     *
     * @param perspectiveModele Modèle de la perspective
     * @param controleurPerspective Constrolleur de la perspective
     */
    public VuePerspective(PerspectiveModele perspectiveModele, ControleurPerspective controleurPerspective){
        modele(perspectiveModele);
        controleur(controleurPerspective);
    }

    @Override
    protected void render() {

    }

    /**
     * Affichage de la perspective
     *
     * @param g Curseur
     */
    @Override
    public void paint(final Graphics g) {
        super.paintComponent(g);
        try {
            g.drawImage(modele.getImage(), modele.getXcoordinate(), modele.getYcoordinate(),
                    modele.getImageScaledWidth(), modele.getImageScaledHeight(),null);
        } catch (final NullPointerException e) {
        }
    }

    /**
     * Met à jour l'affichage
     *
     * @param model Le modèle observé
     * @param value Valeur passée par le modèle
     */
    @Override
    public void update(final Observable model, final Object value) {
        repaint();
    }
}
