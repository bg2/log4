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
 Nom du fichier: Controleur.java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-31
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/

package framework;

import java.util.EventListener;

/**
 * Classse abstraite Controleur du cadre
 *
 * @param <M> Le modele
 * @param <V> La vue
 */
public abstract class Controleur<M extends Modele, V extends Vue> implements
        EventListener {

    /**
     * Modele que le controleur fonctionne sur.
     */
    protected M modele;


    /**
     * La vue que la controleur va recevoir des notifications a faire des changements
     */
    protected V vue;

    /**
     * Retourne le modele
     *
     * @return modele Le modele
     */
    protected final M modele() {
        return this.modele;
    }

    /**
     * Set le modele
     *
     * @param modele Le modele
     */
    protected final void modele(final M modele) {
        if (modele == null)
            return;

        this.modele = modele;
    }

    /**
     *  Retourne la vue
     *
     * @return vue La vue
     */
    protected final V vue() {
        return this.vue;
    }


    /**
     * Set la vue
     *
     * @param vue La vue
     */
    protected final void vue(final V vue) {
        if (vue == null)
            return;

        this.vue = vue;
    }
}