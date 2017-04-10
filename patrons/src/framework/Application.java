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
 Nom du fichier: Application.java
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

/**
 * Classe qui prend soin de faire l'application principale. Une nouvelle application MVC étendra cette classe.
 */
public abstract class Application {


    /**
     * Constructeur de la classe Application
     */
    public Application() {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initModeles();
        initControleurs();

        this.start(frame);

        frame.setVisible(true);
    }

    /**
     * Initialiser les contrôleurs
     */
    protected abstract void initControleurs();

    /**
     * Initialiser les modeles
     */
    protected abstract void initModeles();

    /**
     * Commencer l'application
     *
     * @param frame Le frame de l'application
     */
    protected abstract void start(final JFrame frame);


}
