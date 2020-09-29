import java.util.ArrayList;
import java.util.Scanner;

public class Ui {
    public static void greet() {
        showLine();
        print(" Hello! I'm Duke");
        print(" What can I do for you?");
        showLine();
    }

    public static void print(String text) {
        System.out.println(text);
    }

    public static void printTask(Task t) {
        System.out.println(t);
    }

    public static void printTaskList(ArrayList<Task> tasklist) {
        for (int i = 0; i < tasklist.size(); i++) {
            print((i + 1) + "." + tasklist.get(i));
        }
    }

    public static String readCommand() {
        Scanner input = new Scanner(System.in);
        String userInput;
        userInput = input.nextLine();
        return userInput;
    }

    public static void showLine() {
        print("____________________________________________________________");
    }

    public static void showLoadingError() {
        showLine();
        print("Loading error occurs! Maybe because this is your first time. The file will be automatically created later.");
        showLine();
    }

    public static void showError() {
        showLine();
        print("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
        showLine();
    }

    public static void showDoneNumberFormatError() {
        showLine();
        print(" ☹ OOPS!!! Please enter a number after 'done' command.");
        showLine();
    }

    public static void showDoneNullPointerError() {
        showLine();
        print(" ☹ OOPS!!! Please enter valid numbers after 'done' command.");
        showLine();
    }

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

    public static void showDeleteNothingError() {
        showLine();
        print(" ☹ OOPS!!! You are not deleting any task.");
        showLine();
    }

    public static void showTooManyDeletionsError() {
        showLine();
        print(" ☹ OOPS!!! Please enter just one number after 'delete' command.");
        showLine();
    }

    public static void showDateTimeError() {
        showLine();
        print("Please enter the deadline date in the format yyyy-mm-dd");
        showLine();
    }

    public static void showDeleteNumberFormatError () {
        showLine();
        print(" ☹ OOPS!!! Please enter a number after 'delete' command.");
        showLine();
    }

    public static void showDeleteIndexOutOfBoundsError(){
        showLine();
        print(" ☹ OOPS!!! Please enter a valid number after 'delete' command.");
        showLine();
    }

    public static void showDeleteTaskMessage(int count) {
        showLine();
        print("Noted. I've removed this task:");
        print(("Now you have " + count + " tasks in the list").replace("1 tasks", "1 task"));
        showLine();
    }

    public static void showDeadlineArrayIndexOutOfBoundsError() {
        showLine();
        print(" ☹ OOPS!!! The description of a deadline cannot be empty.");
        showLine();
    }

    public static void showDeadlineNoTimeError() {
        showLine();
        print(" ☹ OOPS!!! You also need to specify the time of a deadline.");
        showLine();
    }

    public static void showEventArrayIndexOutOfBoundsError() {
        showLine();
        print(" ☹ OOPS!!! The description of an event cannot be empty.");
        showLine();
    }

    public static void showEventNoTimeError() {
        showLine();
        print(" ☹ OOPS!!! You also need to specify the time of an event.");
        showLine();
    }

    public static void showFindList(ArrayList<Task> tasksFound) {
        showLine();
        print("Here are the matching tasks in your list:");
        printTaskList(tasksFound);
        showLine();
    }

    public static void showFindNothingError() {
        showLine();
        print("☹ OOPS!!! Please enter something after find command.");
        showLine();
    }

    public static void showTodoArrayIndexOutOfBoundsError() {
        showLine();
        print(" ☹ OOPS!!! The description of a todo cannot be empty.");
        showLine();
    }

    public static void showIOError(Exception e) {
        System.out.println("Something went wrong: " + e.getMessage());
    }

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

    public static void listTasks(int count) {
        showLine();
        print("Here are the tasks in your list:");
        for(int i = 0; i < count; i++) {
            print((i + 1) + "." + TaskList.get(i));
        }
        showLine();
    }

    public static void goodbye() {
        showLine();
        print("Bye. Hope to see you again soon!");
        showLine();
    }
}
