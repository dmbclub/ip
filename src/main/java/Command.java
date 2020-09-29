import java.io.IOException;
import java.util.ArrayList;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Command {
    private static String command;
    private static String description;

    public Command (String command, String description) {
        this.command = command;
        this.description = description;
    }

    public static void execute() {
        switch (command) {
            case "list":
                Ui.listTasks(TaskList.size());
                return;
            case "done":
                try {
                    TaskList.markAsDone(description);
                } catch (NumberFormatException e) {
                    Ui.showDoneNumberFormatError();
                    return;
                } catch (NullPointerException e) {
                    Ui.showDoneNullPointerError();
                    return;
                }
                break;
            case "delete":
                try {
                    TaskList.deleteTasks(description, TaskList.size() - 1);
                } catch (NumberFormatException e) {
                    Ui.showDeleteNumberFormatError();
                    return;
                } catch (IndexOutOfBoundsException e) {
                    Ui.showDeleteIndexOutOfBoundsError();
                    return;
                }
                break;
            case "find":
                if (description.equals("find")) {
                    Ui.showFindNothingError();
                    return;
                }
                ArrayList<Task> tasksFound = TaskList.findTasks(description);
                Ui.showFindList(tasksFound);
                break;
            case "deadline":
                if (description.equals("deadline")) {
                    Ui.showDeadlineArrayIndexOutOfBoundsError();
                    return;
                }
                try {
                    String[] words = description.split(" /by ");
                    try {
                        TaskList.add(TaskList.size(), new Deadline(words[0], LocalDate.parse(words[1])));
                    } catch (DateTimeException e) {
                        Ui.showDateTimeError();
                        return;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    Ui.showDeadlineNoTimeError();
                    return;
                }
                Ui.getAddTaskMessage(TaskList.size());
                break;
            case "event":
                if (description.equals("event")) {
                    Ui.showEventArrayIndexOutOfBoundsError();
                    return;
                }
                try {
                    String[] words = description.split(" /at ");
                    TaskList.add(TaskList.size(), new Event(words[0], words[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    Ui.showEventNoTimeError();
                    return;
                }
                Ui.getAddTaskMessage(TaskList.size());
                break;
            case "todo":
                if (description.equals("todo")) {
                    Ui.showTodoArrayIndexOutOfBoundsError();
                    return;
                }
                TaskList.add(TaskList.size(), new Todo(description.replace("todo ", "")));
                Ui.getAddTaskMessage(TaskList.size());
                break;
        }
        storeTaskList();
    }

    public static boolean isExit() {
        if (command.equals("exit")) {
            return true;
        }
        return false;
    }

    private static void storeTaskList() {
        try {
            Storage.writeToFile();
        } catch (IOException e) {
            Ui.showIOError(e);
        }
    }

}
