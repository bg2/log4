package application.vues;

import application.controleur.ControleurImage;
import application.controleur.ControleurPerspective;
import application.controleur.ControleurPerspective2;
import application.modele.ImageModele;
import application.modele.PerspectiveModele;
import framework.Vue;

import java.awt.*;
import java.util.Observable;

public class VuePerspective2 extends Vue<PerspectiveModele, ControleurPerspective2> {

    public VuePerspective2(PerspectiveModele perspectiveModele, ControleurPerspective2 controleurPerspective){
        modele(perspectiveModele);
        controleur(controleurPerspective);
    }


    @Override
    protected void render() {

    }


    @Override
    public void paint(final Graphics g) {
        super.paintComponent(g);
        try {
            g.drawImage(modele.getImage(), modele.getXcoordinate(), modele.getYcoordinate(), modele.getImageScaledWidth(), modele.getImageScaledHeight(),null);
        } catch (final NullPointerException e) {
        }
    }


    @Override
    public void update(final Observable model, final Object value) {
        System.out.println("tetstst");
        repaint();
    }

}
