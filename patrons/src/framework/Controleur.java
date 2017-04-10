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

package framework;

import java.util.EventListener;


public abstract class Controleur<M extends Modele, V extends Vue> implements
        EventListener {

    protected M modele;


    protected V vue;


    protected final M modele() {
        return this.modele;
    }


    protected final void modele(final M modele) {
        if (modele == null)
            return;

        this.modele = modele;
    }


    protected final V vue() {
        return this.vue;
    }


    protected final void vue(final V vue) {
        if (vue == null)
            return;

        this.vue = vue;
    }
}