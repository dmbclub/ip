/**
 * Task is a class that has three subclasses to do, deadline and event.
 * It contains the description (string) and the status of the class (boolean, done or not).
 */

public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Gets the corresponding icon for the current status.
     * @return tick or cross symbols
     */
    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    /**
     * Sets the status of the task
     */
    public void markTheStatusAsDone() {
        this.isDone = true;
    }

    /**
     * Overrides the task
     * @return task in the format [tick or cross] + description
     */
    public String toString() {
        return "[" + getStatusIcon() + "]" + description;
    }
}