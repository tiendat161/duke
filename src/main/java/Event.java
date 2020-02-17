import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected LocalDate time;

    public Event(String description, LocalDate time) {
        super(description);
        this.time = time;
    }

    @Override
    public String getType() {
        return "E";
    }

    @Override
    public String getTimeFormatted() {
        return this.time.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
    }

    @Override
    public LocalDate getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (on: " + this.getTimeFormatted() + ")";
    }
}
