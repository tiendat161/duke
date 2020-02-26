package duke.task;

import duke.exception.DukeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Tasks that happens at a specific DateTime.
 * Event extends class Task.
 * It is constructed with event, follows by a description
 * and /at with a DateTime in yyyy-mm-dd format in the command
 */
public class Event extends Task {

    protected LocalDate time;

    /**
     * Constructs a Event object
     * @param description The activity description
     * @param time    The date and time described in /at command
     */
    public Event(String description, String time) throws DukeException {
        super(description);
        this.time = LocalDate.parse(time);
    }

    /**
     * Show the type of the task. Return a String "E" represent event task
     * @return "E"
     */
    @Override
    public String getType() {
        return "E";
    }

    /**
     * Show the time formatted of the task
     * @return String represents DateTime in pattern MMM d yyyy
     */
    @Override
    public String getTimeFormatted() {
        return this.time.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    /**
     * Show the time of the task
     * @return LocalDate time
     */
    @Override
    public LocalDate getTime() {
        return this.time;
    }

    /**
     * Override toString() method
     * @return String represents this object
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (on: " + this.getTimeFormatted() + ")";
    }
}
