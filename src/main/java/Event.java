/**
 * Event is a class that inherits from the Task class.
 * It contains the description (string) and the event date (String).
 */

public class Event extends Task {

    private String time;

    public Event(String description, String time) {
        super(description);
        this.time = time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    /**
     * override the event task
     * @return event task in the format [E][tick or cross] + description + (at: time)
     */
    public String toString() {
        return "[E]" + super.toString() + " (at:" + time + ")";
    }
}
