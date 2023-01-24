package exception;

import java.io.IOException;

public class IncorrectArgumentException extends IOException {

    public IncorrectArgumentException(String argument) {
        this.argument = argument;
    }


    public IncorrectArgumentException(String message, String argument) {
        super(message);
        this.argument = argument;
    }

    public IncorrectArgumentException(String message, Throwable cause, String argument) {
        super(message, cause);
        this.argument = argument;
    }


    public IncorrectArgumentException(Throwable cause, String argument) {
        super(cause);
        this.argument = argument;
    }

    private String argument;

    public String getArgument() {
        return argument;
    }

    @Override
    public String toString() {
        return "IncorrectArgumentException{" +
                "argument='" + argument + '\'' +
                '}';
    }
}
