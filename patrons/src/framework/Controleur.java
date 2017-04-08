package framework;

import java.util.EventListener;

/**
 * Created by Khoi on 2017-04-05.
 */
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