package duke.exception;

/**
 * Signals that an Error with Duke programme has occurred.
 */
public class DukeException extends Exception {
    public DukeException(String s) {
        super(s);
    }
}
