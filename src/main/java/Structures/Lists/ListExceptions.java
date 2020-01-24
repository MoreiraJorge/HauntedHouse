package Structures.Lists;

public class ListExceptions extends Exception {

    public static final String ELEMENT_NOT_FOUND = "Elemento não existe na lista.";
    public static final String EMPTY_LIST = "Elemento não existe na lista.";


    public ListExceptions() {
    }

    public ListExceptions(String message) {
        super(message);
    }
}
