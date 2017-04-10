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

import javax.swing.*;


/**
 * The {@link Application} class describes a complete MVC application.
 *
 * <p>
 * The class takes care of constructing the main application frame and passing
 * it on to subclasses. To create a new MVC application one must therefore
 * extend the {@link Application} class and implement the
 * {@link #start(JFrame)} method:
 *
 * <pre>
 * public final class MyApp extends application.vues.Application {
 *   protected void start(final JFrame frame) {
 *     frame.getContentPane().add(...);
 *   }
 *
 *   public static void main(final String[] args) {
 *     new MyApp();
 *   }
 * }
 * </pre>
 *
 * @see <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller">
 *      http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller</a>
 */
public abstract class Application {



    public Application() {
        // Create the main frame of the application.
        JFrame frame = new JFrame();

        // Exit the application when the main frame is closed.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Start the application.
        initModeles();
        initControleurs();

        this.start(frame);

        // Make the application frame visible.
        frame.setVisible(true);
    }


    protected abstract void initControleurs();


     protected abstract void initModeles();

    /**
     * Start the {@link Application}.
     *
     * <p>
     * This method is called as part of the {@link Application} initialization.
     * @param frame The main frame of the {@link Application}.
     */

    protected abstract void start(final JFrame frame);


}
