import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {

    protected LocalDate time;

    public Event(String description, String time) throws DukeException {
        super(description);
        this.time = LocalDate.parse(time);
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
