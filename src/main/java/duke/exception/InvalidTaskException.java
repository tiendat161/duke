package duke.exception;

/**
 * Signals that an Invalid Task error with Duke programme has occurred.
 */
public class InvalidTaskException extends DukeException {
    InvalidTaskException(String s) {
        super(s);
    }
}
