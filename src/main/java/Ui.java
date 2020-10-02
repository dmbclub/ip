
/**
 * Ui class deals with interactions with the user.
 */


import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    /**
     * Shows greeting messages.
     */
    public static void greet() {
        showLine();
        print(" Hello! I'm Duke");
        print(" What can I do for you?");
        showLine();
    }

    /**
     * Prints the text.
     * @param text String that will be printed out.
     */
    public static void print(String text) {
        System.out.println(text);
    }

    /**
     * Prints the task.
     * @param t Task that will be printed out.
     */
    public static void printTask(Task t) {
        System.out.println(t);
    }

     /**
     * Prints the tasklist
     * @param tasklist to be printed out.
     */
    public static void printTaskList(ArrayList<Task> tasklist) {
        for (int i = 0; i < tasklist.size(); i++) {
            print((i + 1) + "." + tasklist.get(i));
        }
    }

     /**
     * Reads the user input
     * @return String of the user input.
     */
    public static String readCommand() {
        Scanner input = new Scanner(System.in);
        String userInput;
        userInput = input.nextLine();
        return userInput;
    }

    /**
     * Prints a horizontal line.
     */
    public static void showLine() {
        print("____________________________________________________________");
    }

    /**
     * Shows the message when loading error occurs.
     */
    public static void showLoadingError() {
        showLine();
        print("Loading error occurs! Maybe because this is your first time. The file will be automatically created later.");
        showLine();
    }

    /**
     * Shows the message when user inputs an invalid command.
     */
    public static void showError() {
        showLine();
        print("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        showLine();
    }

    /**
     * Shows the message when user enters a non-number after done command.
     */
    public static void showDoneNumberFormatError() {
        showLine();
        print(" ☹ OOPS!!! Please enter a number after 'done' command.");
        showLine();
    }

    /**
     * Shows the message when user enters a number that beyond the length of the current task list after done command.
     */
    public static void showDoneNullPointerError() {
        showLine();
        print(" ☹ OOPS!!! Please enter valid numbers after 'done' command.");
        showLine();
    }

    /**
     * Marks the corresponding tasks as don, and show the message
     * that the tasks has been successfully marked as done.
     * @param words An array of String indicating the indexes of tasks that the user wants to mark as done.
     */
    public static void showMarkAsDoneMessage(String[] words) {
        showLine();
        print("Nice! I've marked this task as done:");
        for (int j = 0; j < words.length; j++) {
            int index = Integer.parseInt(words[j]) - 1;
            TaskList.get(index).markTheStatusAsDone();
            print("[" + TaskList.get(index).getStatusIcon() + "] " + TaskList.get(index).description);
        }
        showLine();
    }

    /**
     * Shows the message when user just enters a delete without any number.
     */
    public static void showDeleteNothingError() {
        showLine();
        print(" ☹ OOPS!!! You are not deleting any task.");
        showLine();
    }

    /**
     * Shows the message when user wants to delete many tasks at the same time.
     */
    public static void showTooManyDeletionsError() {
        showLine();
        print(" ☹ OOPS!!! Please enter just one number after 'delete' command.");
        showLine();
    }

    /**
     * Shows the message when the deadline that user types in is not in the format yyyy-mm-dd.
     */
    public static void showDateTimeError() {
        showLine();
        print("Please enter the deadline date in the format yyyy-mm-dd");
        showLine();
    }

    /**
     * Shows the message when user enters a non-number after delete command.
     */
    public static void showDeleteNumberFormatError () {
        showLine();
        print(" ☹ OOPS!!! Please enter a number after 'delete' command.");
        showLine();
    }

    /**
     * Shows the message when user enters a number that beyond the length of the current task list after delete command.
     */
    public static void showDeleteIndexOutOfBoundsError(){
        showLine();
        print(" ☹ OOPS!!! Please enter a valid number after 'delete' command.");
        showLine();
    }

    /**
     * Shows how many task left in the task list after removing a task.
     * @param count integer. Number of current tasks in the task list.
     */
    public static void showDeleteTaskMessage(int count) {
        showLine();
        print("Noted. I've removed this task:");
        print(("Now you have " + count + " tasks in the list").replace("1 tasks", "1 task"));
        showLine();
    }

    /**
     * Shows the message when user just enters deadline without any description.
     */
    public static void showDeadlineArrayIndexOutOfBoundsError() {
        showLine();
        print(" ☹ OOPS!!! The description of a deadline cannot be empty.");
        showLine();
    }

    /**
     * Shows the message when user does not enter the date of the deadline after "/by".
     */
    public static void showDeadlineNoTimeError() {
        showLine();
        print(" ☹ OOPS!!! You also need to specify the time of a deadline.");
        showLine();
    }

    /**
     * Shows the message when user just enters event without any description.
     */
    public static void showEventArrayIndexOutOfBoundsError() {
        showLine();
        print(" ☹ OOPS!!! The description of an event cannot be empty.");
        showLine();
    }

    /**
     * Shows the message when user does not enter the time of the event after "/at".
     */
    public static void showEventNoTimeError() {
        showLine();
        print(" ☹ OOPS!!! You also need to specify the time of an event.");
        showLine();
    }

    /**
     * Shows the tasks that match the user input.
     */
    public static void showFindList(ArrayList<Task> tasksFound) {
        showLine();
        print("Here are the matching tasks in your list:");
        printTaskList(tasksFound);
        showLine();
    }

    /**
     * Shows the message when user just enters find without any description.
     */
    public static void showFindNothingError() {
        showLine();
        print("☹ OOPS!!! Please enter something after find command.");
        showLine();
    }

    /**
     * Shows the message when user just enters to do without any description.
     */
    public static void showTodoArrayIndexOutOfBoundsError() {
        showLine();
        print(" ☹ OOPS!!! The description of a todo cannot be empty.");
        showLine();
    }

    /**
     * Shows the error message
     * @param e An exception caught when writing the task list to file.
     */
    public static void showIOError(Exception e) {
        System.out.println("Something went wrong: " + e.getMessage());
    }

    /**
     * Shows the message to tell the user that the task has been successfully added.
     * @param count Integer. Number of current tasks in the task list.
     */
    public static void getAddTaskMessage(int count) {
        showLine();
        printTask(TaskList.get(count - 1));
        print("Got it. I've added this task.");
        if (count == 1) {
            print("Now you have " + count + " task in the list");
        } else {
            print("Now you have " + count + " tasks in the list");
        }
        showLine();
    }

    /**
     * Prints the current task list.
     * @param count Integer. Number of current tasks in the task list.
     */
    public static void listTasks(int count) {
        showLine();
        print("Here are the tasks in your list:");
        for(int i = 0; i < count; i++) {
            print((i + 1) + "." + TaskList.get(i));
        }
        showLine();
    }

    /**
     * Prints the goodbye message.
     */
    public static void goodbye() {
        showLine();
        print("Bye. Hope to see you again soon!");
        showLine();
    }
}
