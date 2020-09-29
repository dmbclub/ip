/**
 * Deadline is a class that inherits from the Task class.
 * It contains the description (string) and the deadline date (LocalDate).
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {

    private LocalDate by;

    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    public void setBy(LocalDate by) {
        this.by = by;
    }

    public LocalDate getBy() {
        return by;
    }

    /**
     * Override the deadline task
     * @return deadline task in the format [D][tick or cross] + description + (by: MMM d yyyy)
     */
    public String toString() {
        return "[D]" + super.toString() + " (by:" + by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}