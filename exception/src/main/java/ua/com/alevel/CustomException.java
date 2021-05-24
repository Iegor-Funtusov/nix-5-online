package ua.com.alevel;

public class CustomException extends NumberFormatException {

    static final long serialVersionUID = -2848938806368998898L;

    public CustomException(String s) {
        super(s);
    }
}
