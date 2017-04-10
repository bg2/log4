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
 Nom du fichier: Vue.java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-31
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/


package framework;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Classe abstraite Vue de le cadre.
 *
 * @param <M> Le Modele
 * @param <C> Le controleur
 */
public abstract class Vue<M extends Modele, C extends Controleur> extends
        JPanel implements Observer {

    /** Constante serialVersionUID. */
    private static final long serialVersionUID = 3205795086954026886L;

    /**
     * Controleur opérant sur la vue.
     */
    protected C controleur;

    /**
     * Modele que la vue fonctionne sur.
     */
    protected M modele;

    /**
     * Retourne le controleur
     *
     * @return controleur Le controleur
     */
    protected final C controleur() {
        return this.controleur;
    }


    /**
     * Set le controleur. Definissez le modele sur le controleur si le modele existe
     *
     * @param controleur Le controleur
     */
    protected final void controleur(final C controleur) {
        if (controleur == null)
            return;

        this.controleur = controleur;
        this.controleur.vue(this);


        if (this.modele != null)
            this.controleur.modele(this.modele);
    }

    /**
     * Retourne le modele
     *
     * @return modele Le modele
     */
    protected final M modele() {
        return this.modele;
    }


    /**
     * Set le modele. Definissez le modele sur le controleur si le controleur existe.
     *
     * @param modele le modele
     */
    protected final void modele(final M modele) {
        if (modele == null)
            return;

        this.modele = modele;

        if (this.controleur != null)
            this.controleur.modele(this.modele);
    }


    /**
     * Cette méthode est appelée chaque fois que l'objet observé est modifié.
     *
     * @param observable L'objet observable
     * @param object Objet pouvant être transmis
     */
    @Override
    public void update(final Observable observable, final Object object) {
        this.update(observable, object);
    }
}