package application.vues;

import application.controleur.ControleurImage;
import application.modele.ImageModele;
import framework.Vue;

import java.awt.*;
import java.util.Observable;

/**
 * Classe pour la vue globale de l'image
 */
public class VueThumbnail extends Vue<ImageModele, ControleurImage> {

    /**
     * Constructeur
     *
     * @param imageModele Modele de l'image
     * @param controleurImage Controleur de l'image
     */
    public VueThumbnail(ImageModele imageModele, ControleurImage controleurImage){
        modele(imageModele);
        controleur(controleurImage);
    }

    /**
     * Affichage de l'image
     *
     * @param g Curseur
     */
    @Override
    public void paint(final Graphics g) {
        super.paintComponent(g);
        try {
        	if(modele.getImage().getWidth(null)>300||modele.getImage().getHeight(null)>300)         		
        		g.drawImage(modele.getImage(), 0, 0,300, 200, null);
        	else
            g.drawImage(modele.getImage(), 0, 0, null);
        } catch (final NullPointerException e) {
        }
    }

    @Override
    protected void render() {

    }

    /**
     * Met à jour l'affichage
     *
     * @param model Le modele observé
     * @param value Valeur passée par le modèle
     */
    @Override
    public void update(final Observable model, final Object value) {
        repaint();
    }
}
