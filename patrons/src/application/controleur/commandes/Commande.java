/******************************************************
 Cours:   LOG121
 Session: H2017
 Groupe: 02
 Projet: Laboratoire #4
 �tudiant(e)s:
 Alexandre Trepanier
 Vanessa Baquero
 Nam Vu Khanh
 Khoi Tran-Quang
 Professeur : Francis Cardinal
 Nom du fichier: Commande.java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-31
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/

package application.controleur.commandes;

/**
 * Interface de commande
 * Created by Khoi on 2017-04-07.
 */
public interface Commande {

    /**
     * Execute la commande
     */
    void execute();

    /**
     * Annule la commande
     */
    void undo();

}