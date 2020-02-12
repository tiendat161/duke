public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public String getDescription() {
        return this.description;
    }

    public String getType() {
        return "Task";
    }

    public String getTime() {
        return "";
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public void markDone() {
        this.isDone = true;
    }

    @Override
    public String toString() {
        return String.format("[" + this.getStatusIcon() + "] " + this.description);
    }
}
