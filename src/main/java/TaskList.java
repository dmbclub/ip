/**
 * TaskList contains the list of the added tasks implemented by Arraylist
 */

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasks;

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Return the size of the task list
     * @return the size as integer.
     */
    public static int size(){
        return tasks.size();
    }

    /**
     * Return the task corresponding to the index
     * @param i integer. Index of the task.
     * @return task corresponding to the index
     */
    public static Task get(int i) {
        return tasks.get(i);
    }

    /**
     * Delete the task corresponding to the index
     * @param index indeger. Index of the task.
     */
    public static void remove(int index) {
        tasks.remove(index);
    }

    /**
     * Add a task to the task list.
     * @param size the size of the current task list.
     * @param t the task object that user wants to add into the task list. It can be a to do, deadline or event task.
     */
    public static void add(int size, Task t) {
        tasks.add(size, t);
    }

    /**
     * Mark the tasks as done
     * @param userInput A string containing the indexes of tasks to be marked as done, separated by ' '.
     */
    public static void markAsDone(String userInput) {
        String[] words = userInput.split(" ");
        if (words.length == 0) {
            Ui.showDoneNumberFormatError();
            return;
        }
        Ui.showMarkAsDoneMessage(words);
    }

    /**
     * Delete a task. Show warning messages if delete 0 or more than 1 task.
     * @param userInput A string containing the indexes of tasks to be deleted, separated by ' '.
     * @param count Integer. Number of currect tasks in the task list.
     */
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
}
