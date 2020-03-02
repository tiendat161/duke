package duke.task;

import duke.exception.DukeException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Tasks that need to be done before a specific date.
 * Deadline extends class Task.
 * It is constructed with deadline, follows by a description.
 * and /by with a DateTime in yyyy-mm-dd format in the command.
 */
public class Deadline extends Task {
    private static final String DATE_FORMAT = "dd-MM-yyyy";

    protected LocalDate time;

    /**
     * Constructs a Deadlines object.
     * @param description The activity description.
     * @param time    The date and time described in /by command.
     */
    public Deadline(String description, String time) throws DateTimeException, DukeException {
        super(description);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            this.time = LocalDate.parse(time, formatter);
        } catch (DateTimeException e) {
            throw new DukeException("OOPS! It seems that your deadline date "
                    + "is not properly formatted. The date should be in form of 'dd-MM-yyyy");
        }
    }

    /**
     * Show the type of the task. Return a String "D" represent deadline task.
     * @return "D".
     */
    @Override
    public String getType() {
        return "D";
    }

    /**
     * Show the time formatted of the task.
     * @return String represents DateTime in pattern MMM d yyyy.
     */
    @Override
    public String getTimeFormatted() {
        return this.time.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    /**
     * Show the time of the task.
     * @return LocalDate time.
     */
    @Override
    public String getTime() {
        return this.time.format(DateTimeFormatter.ofPattern(DATE_FORMAT));
    }

    /**
     * Override toString() method.
     * @return String represents this object.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.getTimeFormatted() + ")";
    }
}
