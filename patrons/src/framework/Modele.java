package framework;

import java.util.Observable;

public class Modele extends Observable {


//    protected final Hashmap _register = Hashmap.getInstance();


    public final void changed() {
        // Mark the model as having been changed.
        setChanged();

        // Notify observers about the change.
        this.notifyObservers();
    }


    protected final void changed(final Object value) {
        // Mark the model as having been changed.
        setChanged();

        // Notify observers about the change.
        this.notifyObservers(value);
    }
}


