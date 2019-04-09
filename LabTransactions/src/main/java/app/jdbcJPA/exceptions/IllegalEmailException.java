package app.jdbcJPA.exceptions;

public class IllegalEmailException extends Exception {
    public IllegalEmailException(String message) {
        super(message);
    }
}
