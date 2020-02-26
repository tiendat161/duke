package duke.task;

/**
 * Tasks that needs to be done.
 * Todo extends class Task.
 * It is constructed with todo, follows by a description
 */
public class Todo extends Task {

    /**
     * Constructs a Todo object
     * @param description The activity description
     */
    public Todo(String description) {
        super(description);
    }

    /**
     * Show the type of the task. Return a String "E" represent event task
     * @return "T"
     */
    @Override
    public String getType() {
        return "T";
    }

    /**
     * Override toString() method
     * @return String represents this object
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
