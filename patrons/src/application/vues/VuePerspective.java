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
 Nom du fichier: .java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/

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
