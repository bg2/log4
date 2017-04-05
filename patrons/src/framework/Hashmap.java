
package framework;

import java.util.HashMap;


public class Hashmap {


    private static final Hashmap INSTANCE = new Hashmap();


    public static Hashmap getInstance() {
        return Hashmap.INSTANCE;
    }


    private final HashMap<String, Object> REGISTER = new HashMap<String, Object>();


    private Hashmap() {
    }


//    public void add(final String key, final Object value) {
//        REGISTER.put(key, value);
//    }
//
//
//    public boolean contains(final String key) {
//        return REGISTER.containsKey(key);
//    }
//
//
//    public Object get(final String key) {
//        return REGISTER.get(key);
//    }
}