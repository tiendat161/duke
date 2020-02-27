package duke.task;

import java.time.LocalDate;

/**
 * Parent class of ToDos, Events and Deadlines.
 */
public class Task {
    protected String description;
    protected boolean isDone;

    /**
     * Constructs a Task object.
     * @param description The activity description.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Check if this task is done.
     * @return a boolean describing if this task is done.
     */
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * Get the description of the task.
     * @return a string describing the task.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Get the type of the task.
     * @return "Task".
     */
    public String getType() {
        return "Task";
    }

    /**
     * Get the time of the task (no time for this parent class).
     * @return "".
     */
    public String getTimeFormatted() {
        return "";
    }

    /**
     * Get the time of the task (no time for this parent class).
     * @return a dummy timing.
     */
    public LocalDate getTime() {
        return LocalDate.parse("1998-01-16");
    }

    /**
     * Get the status icon that appears to users if the task is done.
     * A tick or X symbol is used.
     * @return string representing tick or x symbols.
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    /**
     * Mark a task that has been done.
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * Override toString() method.
     * @return String represents this object.
     */
    @Override
    public String toString() {
        return "[" + this.getStatusIcon() + "] " + this.description;
    }
}
