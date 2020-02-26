package duke.exception;

/**
 * Signals that an Empty Argument error with Duke programme has occurred.
 */
public class EmptyArgumentException extends DukeException {
    EmptyArgumentException(String s) {
        super(s);
    }
}
