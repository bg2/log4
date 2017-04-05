package framework;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Khoi on 2017-04-05.
 */
public abstract class Vue<M extends Modele, C extends Controleur> extends
        JPanel implements Observer {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3205795086954026886L;

    /** The register. */
 //   protected final Hashmap _register = Hashmap.getInstance();
    /**
     * The application.controleur operating on the view.
     */
    protected C controleur;

    /**
     * The application.modele that the view operates on.
     */
    protected M modele;

    /**
     * Initialize the view.
     */
    public Vue() {
        // Run view initialization such as loading controleurs and modeles.
        this.initialize();

        // Render the view now that the controleurs and modeles are available.
        this.render();
    }


    protected final C controleur() {
        return this.controleur;
    }


    @SuppressWarnings("unchecked")
    protected final void controleur(final C controleur) {
        if (controleur == null)
            return;

        this.controleur = controleur;
        this.controleur.vue(this);

        // Set the application.modele on the application.controleur if the application.modele eixsts.
        if (this.modele != null)
            this.controleur.modele(this.modele);
    }


    protected void initialize() {
        ; // Do nothing by default.
    }


    protected final M modele() {
        return this.modele;
    }


    @SuppressWarnings("unchecked")
    protected final void modele(final M modele) {
        if (modele == null)
            return;

        // If a application.modele has already been associated with the view, remove the view
        // as an observer from the old application.modele.
        // if (this.application.modele != null)
        // this.application.modele.deleteObserver(this);

        this.modele = modele;

        // Add the view as an observer of the application.modele.
        // this.application.modele.addObserver(this);

        // Set the application.modele on the application.controleur if the application.controleur exists.
        if (this.controleur != null)
            this.controleur.modele(this.modele);
    }


    protected abstract void render();


    protected void update(final M modele, final Object value) {
        throw new UnsupportedOperationException();
    }


    @Override
    public void update(final Observable observable, final Object object) {
        this.update(observable, object);
    }
}