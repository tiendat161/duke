import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    protected LocalDate time;

    public Deadline(String description, LocalDate time) {
        super(description);
        this.time = time;
    }

    @Override
    public String getType() {
        return "D";
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
        return "[D]" + super.toString() + " (by: " + this.getTimeFormatted() + ")";
    }
}
