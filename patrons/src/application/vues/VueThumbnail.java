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
 Nom du fichier: VueThumbnail.java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-31
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/

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
     * @param g Objet de Graphics
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
