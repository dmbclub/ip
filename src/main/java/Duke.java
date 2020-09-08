import java.util.Scanner;

public class Duke {
    static int MAX_NUM_TASK = 100;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0; //total number of tasks in the list - 1
        Task[] tasks = new Task[MAX_NUM_TASK];
        greet();
        String userInput = input.nextLine();

        while(!userInput.equals("bye")) {
            //Print the list if input is 'list'
            if (userInput.equals("list")) {
                listTasks(count, tasks);
                userInput = input.nextLine();
                continue;
            }
            //Mark the tasks as done
            else if (userInput.startsWith("done")) {
                markAsDone(tasks, userInput);
                userInput = input.nextLine();
                continue;
            }
            else if (userInput.startsWith("deadline")) {
                try {
                    userInput = userInput.split(" ")[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! The description of a deadline cannot be empty.");
                    System.out.println("____________________________________________________________");
                    userInput = input.nextLine();
                    continue;
                }
                try {
                    String[] words = userInput.split(" /by ");
                    tasks[count] = new Deadline(words[0], words[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! You also need to specify the time of a deadline.");
                    System.out.println("____________________________________________________________");
                    userInput = input.nextLine();
                    continue;
                }
                count++;
            }
            else if (userInput.startsWith("event")) {
                try {
                    userInput = userInput.split(" ")[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! The description of an event cannot be empty.");
                    System.out.println("____________________________________________________________");
                    userInput = input.nextLine();
                    continue;
                }
                try {
                    String[] words = userInput.split(" /at ");
                    tasks[count] = new Event(words[0], words[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! You also need to specify the time of an event.");
                    System.out.println("____________________________________________________________");
                    userInput = input.nextLine();
                    continue;
                }
                count++;
            }
            //Add the task into the task array
            else if (userInput.startsWith("todo")) {
                try {
                    userInput = userInput.split(" ")[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
                    System.out.println("____________________________________________________________");
                    userInput = input.nextLine();
                    continue;
                }
                tasks[count] = new Todo(userInput);
                count++;
            }
            System.out.println("____________________________________________________________");
            try {
                System.out.println(tasks[count - 1]);
                if (count == 1) {
                    System.out.println("Got it. I've added this task:");
                    System.out.println("Now you have " + count + " task in the list");
                } else {
                    System.out.println("Got it. I've added this task:");
                    System.out.println("Now you have " + count + " tasks in the list");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
            }
            System.out.println("____________________________________________________________");
            userInput = input.nextLine();
        }

        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    private static void markAsDone(Task[] tasks, String userInput) {
        String[] words = userInput.split(" ");
        System.out.println("____________________________________________________________");
        System.out.println("Nice! I've marked this task as done:");
        for (int j = 1; j < words.length; j++) {
            int index = Integer.parseInt(words[j]) - 1;
            tasks[index].markAsDone();
            System.out.println("[" + tasks[index].getStatusIcon() + "] " + tasks[index].description);
        }
        System.out.println("____________________________________________________________");
    }

    private static void listTasks(int count, Task[] tasks) {
        System.out.println("____________________________________________________________");
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; i < count; i++) {
            System.out.println((i + 1) + "." + tasks[i]);
        }
        System.out.println("____________________________________________________________");
    }

    private static void greet() {
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }
}
