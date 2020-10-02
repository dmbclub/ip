/**
 * To do is a class that inherits from the Task class.
 * It contains the description of the to do task.
 */
public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    /**
     * Overrides the to do task
     * @return to do task in the format [T][tick or cross] + description
     */
    public String toString() {
        return "[T]" + super.toString();
    }
}
