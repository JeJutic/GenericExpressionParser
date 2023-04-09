package expression.exceptions;

public class OverflowException extends ArithmeticException {
    public OverflowException(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return "Overflow in context: " + super.getMessage();
    }
}
