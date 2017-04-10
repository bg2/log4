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
 Nom du fichier: VuePerspective2.java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-31
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/

package application.vues;

import application.controleur.ControleurPerspective2;
import application.modele.PerspectiveModele;
import framework.Vue;
import java.awt.*;
import java.util.Observable;

/**
 * Classe Vue de la deuxième perspective
 */
public class VuePerspective2 extends Vue<PerspectiveModele, ControleurPerspective2> {

    /**
     * Constructeur
     *
     * @param perspectiveModele Modèle de la perspective
     * @param controleurPerspective Controleur de la perspective
     */
    public VuePerspective2(PerspectiveModele perspectiveModele, ControleurPerspective2 controleurPerspective){
        modele(perspectiveModele);
        controleur(controleurPerspective);
    }



    /**
     * Affichage de la perspective
     *
     * @param g Objet de Graphics
     */
    @Override
    public void paint(final Graphics g) {
        super.paintComponent(g);
        try {
            g.drawImage(modele.getImage(), modele.getXcoordinate(), modele.getYcoordinate(), modele.getImageScaledWidth(), modele.getImageScaledHeight(),null);
        } catch (final NullPointerException e) {
        }
    }

    /**
     * Met à jour l'affichage
     *
     * @param model Modèle observé
     * @param value Valeur passée par le modèle
     */
    @Override
    public void update(final Observable model, final Object value) {
        repaint();
    }

}
