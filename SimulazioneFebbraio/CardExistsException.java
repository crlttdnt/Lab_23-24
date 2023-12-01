public class CardExistsException extends RuntimeException {
    public CardExistsException(){
        super();
    }

    public CardExistsException(String s) {
        super(s);
    }
}

//se unchecked è extends RuntimeException
//se checked solo extends Exception 