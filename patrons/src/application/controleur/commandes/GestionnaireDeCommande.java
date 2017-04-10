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
 Nom du fichier: GestionnaireDeCommande.java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-31
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/

package application.controleur.commandes;

import java.util.Stack;

/**
 * Classe GestionnaireDeCommande Singleton
 */
public class GestionnaireDeCommande {

    private static GestionnaireDeCommande uniqueInstance = new GestionnaireDeCommande();

    private Stack<ICommande> commandesFaitesVue1 = new Stack<ICommande>();
    private Stack<ICommande> commandesAnnuleesVue1 = new Stack<ICommande>();

    private Stack<ICommande> commandesFaitesVue2 = new Stack<ICommande>();
    private Stack<ICommande> commandesAnnuleesVue2 = new Stack<ICommande>();

    /**
     * Constructeur privé
     */
    private GestionnaireDeCommande(){}

    /**
     * Retourne l'instance unique
     * @return uniqueInstance, Le gestionnaide de commande unique
     */
    public static GestionnaireDeCommande getInstance(){
        return uniqueInstance;
    }

    /**
     * Exécute une commande de la première perspective et l'ajoute à la liste
     *
     * @param commande ICommande à exécutée
     */
    public void execute(ICommande commande) {
        commande.execute();
        commandesFaitesVue1.push(commande);
    }

    /**
     * Exécute une commande de la deuxième perspective et l'ajoute à la liste
     *
     * @param commande La commande à exécutée
     */
    public void execute2(ICommande commande) {
        commande.execute();
        commandesFaitesVue2.push(commande);
    }

    /**
     * Vérifie si la pile de commandes faites de la première perspective est vide
     *
     * @return Si la pile est vide ou non
     */
    public boolean IsEmptyCommandesFaitesVue1() {
        return commandesFaitesVue1.empty();
    }

    /**
     * Vérifie si la pile de commandes annulées de la première perspective est vide
     *
     * @return Si la pile est vide ou non
     */
    public boolean isEmptyCommandesAnnuleesVue1() {
        return commandesAnnuleesVue1.empty();
    }

    /**
     * Vérifie si la pile de commandes faites de la deuxième perspective est vide
     *
     * @return Si la pile est vide ou non
     */
    public boolean IsEmptyCommandesFaitesVue2() {
        return commandesFaitesVue2.empty();
    }

    /**
     * Vérifie si la pile de commandes annulées de la deuxième perspective est vide
     *
     * @return Si la pile est vide ou non
     */
    public boolean isEmptyCommandesAnnuleesVue2() {
        return commandesAnnuleesVue2.empty();
    }

    /**
     * Annule la dernière commande de la première perspective
     */
    public void defaire1() {
        if(!IsEmptyCommandesFaitesVue1()) {
            ICommande derniereCommande = commandesFaitesVue1.pop();
            derniereCommande.undo();
            commandesAnnuleesVue1.push(derniereCommande);
        }
    }

    /**
     * Refait la dernière commande annulée de la première perspective
     */
    public void refaire1() {
        if(!isEmptyCommandesAnnuleesVue1()) {
            ICommande derniereCommande = commandesAnnuleesVue1.pop();
            derniereCommande.execute();
            commandesFaitesVue1.push(derniereCommande);
        }
    }

    /**
     * Annule la dernière commande de la deuxième perspective
     */
    public void defaire2() {
        if(!IsEmptyCommandesFaitesVue2()) {
            ICommande derniereCommande = commandesFaitesVue2.pop();
            derniereCommande.undo();
            commandesAnnuleesVue2.push(derniereCommande);
        }
    }

    /**
     * Refait ;a dermière commande annulée de la deuxième perspective
     */
    public void refaire2() {
        if(!isEmptyCommandesAnnuleesVue2()) {
            ICommande derniereCommande = commandesAnnuleesVue2.pop();
            derniereCommande.execute();
            commandesFaitesVue2.push(derniereCommande);
        }
    }
}
