package framework;

import javax.swing.*;

/**
 * Created by Khoi on 2017-04-05.
 */


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

        // And register it.
 //       _register.add("window.frame", _frame);

        // Exit the application when the main frame is closed.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Start the application.
        initModeles();
    initControleurs();

        this.start(frame);
//        // Initiates the models
        //  initModeles();
//
//        // Initiates the controllers
//        initControllers();
//
//        // Start the application.
//        start();

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

   // protected abstract void initApplication();
}
