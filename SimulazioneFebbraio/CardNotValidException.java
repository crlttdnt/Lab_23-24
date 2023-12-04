public class CardNotValidException extends Exception {
    public CardNotValidException(){
        super();
    }

    public CardNotValidException(String s) {
        super(s);
    }
}

//se unchecked è extends RuntimeException
//se checked solo extends Exception 