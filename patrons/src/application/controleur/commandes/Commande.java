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

package application.controleur.commandes;

/**
 * Created by Khoi on 2017-04-07.
 */
public interface Commande {

    public abstract void execute();
    public abstract void undo();

}