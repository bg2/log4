package application.vues;

import application.controleur.ControleurImage;
import application.modele.ImageModele;
import framework.Vue;

import java.awt.*;
import java.util.Observable;

public class VueThumbnail extends Vue<ImageModele, ControleurImage> {

    public VueThumbnail(ImageModele imageModele, ControleurImage controleurImage){
        modele(imageModele);
        controleur(controleurImage);
    }
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


    @Override
    public void update(final Observable model, final Object value) {
        repaint();

    }
}
