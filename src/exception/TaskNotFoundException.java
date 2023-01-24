package exception;

import java.io.IOException;

public class TaskNotFoundException extends IOException {

    public TaskNotFoundException() {
    }


    public TaskNotFoundException(String message) {
        super(message);
    }


    public TaskNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }


    public TaskNotFoundException(Throwable cause) {
        super(cause);
    }
}
