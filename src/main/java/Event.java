public class Event extends Task {

    protected String on;

    public Event(String description, String on) {
        super(description);
        this.on = on;
    }

    @Override
    public String getType() {
        return "E";
    }

    @Override
    public String getTime() {
        return this.on;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (on: " + this.on + ")";
    }
}
