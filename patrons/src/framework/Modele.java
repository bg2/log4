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
 Nom du fichier: Modele.java
 Date cree: 2017-03-22
 Date dern. modif. 2017-03-31
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Khoi Tran-Quang
2017-03-22	Version initiale
 *******************************************************/

package framework;

import java.io.Serializable;
import java.util.Observable;

/**
 *  Classe modele dans le framework qui herite du Observable et qui implemente Serializable qui la permet de faire
 *  une sauvegarde
 */
public abstract class Modele extends Observable implements Serializable {

}


