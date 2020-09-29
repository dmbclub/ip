import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public static int size(){
        return tasks.size();
    }

    public static Task get(int i) {
        return tasks.get(i);
    }

    public static void remove(int index) {
        tasks.remove(index);
    }

    public static void add(int size, Task t) {
        tasks.add(size, t);
    }

    public static void markAsDone(String userInput) {
        String[] words = userInput.split(" ");
        if (words.length == 0) {
            Ui.showDoneNumberFormatError();
            return;
        }
        Ui.showMarkAsDoneMessage(words);
    }

    public static void deleteTasks(String userInput, int count) {
        switch (userInput.length()) {
            case 0:
                Ui.showDeleteNothingError();
                break;
            case 1:
                int index = Integer.parseInt(userInput) - 1;
                Ui.printTask(get(index));
                remove(index);
                Ui.showDeleteTaskMessage(count);
                break;
            default:
                Ui.showTooManyDeletionsError();
        }
    }

    public static ArrayList<Task> findTasks(String userInput) {
        ArrayList<Task> tasksFound = new ArrayList<>();
        for(int i = 0; i < size(); i++) {
            if(get(i).description.contains(userInput)) {
                tasksFound.add(get(i));
            }
        }
        return tasksFound;
    }
}
