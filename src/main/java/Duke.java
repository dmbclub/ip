import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0; //total number of tasks in the list - 1
        Task[] Tasks = new Task[100];
        Greet();
        String userInput = input.nextLine();

        while(!userInput.equals("bye")) {
            //Print the list if input is 'list'
            if (userInput.equals("list")) {
                listTasks(count, Tasks);
                userInput = input.nextLine();
                continue;
            }
            //Mark the tasks as done
            else if (userInput.startsWith("done")) {
                markAsDone(Tasks, userInput);
                userInput = input.nextLine();
                continue;
            }
            else if (userInput.startsWith("deadline")) {
                userInput = userInput.replace("deadline ", "");
                String[] words = userInput.split(" /by ");
                Tasks[count] = new Deadline(words[0], words[1]);
                count++;
            }
            else if (userInput.startsWith("event")) {
                userInput = userInput.replace("event ", "");
                String[] words = userInput.split(" /at ");
                Tasks[count] = new Event(words[0], words[1]);
                count++;
            }
            //Add the task into the task array
            else {
                userInput = userInput.replace("todo ", "");
                Tasks[count] = new Todo(userInput);
                count++;
            }
            System.out.println("____________________________________________________________");
            System.out.println("Got it. I've added this task:");
            System.out.println(Tasks[count-1]);
            if (count == 1){
                System.out.println("Now you have " + count + " task in the list");
            }
            else {
                System.out.println("Now you have " + count + " tasks in the list");
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

    private static void Greet() {
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }
}
