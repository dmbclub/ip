import java.util.Scanner;

public class Duke {
    public static class Task {
        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
        }

        public void markAsDone() {
            this.isDone = true;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0; //total number of tasks in the list
        Task[] Tasks = new Task[100];
        Greet();
        String userInput = input.nextLine();

        while(!userInput.equals("bye")) {
            //Print the list if input is 'list'
            if (userInput.equals("list")) {
                listTasks(count, Tasks);
            }
            //Mark the tasks as done
            else if (userInput.startsWith("done")) {
                markAsDone(Tasks, userInput);
            }
            //Add the task into the task array
            else {
                Tasks[count] = new Task(userInput);
                System.out.println("____________________________________________________________");
                System.out.println("added:" + userInput);
                System.out.println("____________________________________________________________");
                count++;
            }
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
            System.out.println(".[" + tasks[index].getStatusIcon() + "] " + tasks[index].description);
        }
        System.out.println("____________________________________________________________");
    }

    private static void listTasks(int count, Task[] tasks) {
        System.out.println("____________________________________________________________");
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; i < count; i++) {
            System.out.println(i + 1 + ".[" + tasks[i].getStatusIcon() + "] " + tasks[i].description);
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
