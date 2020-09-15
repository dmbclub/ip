import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Duke {
    public static void main(String[] args) {
        String FILEPATH = "data/duke.txt";
        File f = new File("data");
        f.mkdir();
        Scanner input = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();
        greet();
        String userInput;

        do {
            userInput = input.nextLine();
            //Print the list if input is 'list'
            if (userInput.equals("list")) {
                listTasks(tasks.size(), tasks);
                continue;
            }
            //Mark the tasks as done
            else if (userInput.startsWith("done")) {
                try {
                    markAsDone(tasks, userInput);
                } catch (NumberFormatException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! Please enter a number after 'done' command.");
                    System.out.println("____________________________________________________________");
                } catch (NullPointerException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! Please enter valid numbers after 'done' command.");
                    System.out.println("____________________________________________________________");
                }
                continue;
            }
            else if (userInput.startsWith("delete")) {
                try {
                    deleteTasks(tasks, userInput, tasks.size() - 1);
                } catch (NumberFormatException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! Please enter a number after 'delete' command.");
                    System.out.println("____________________________________________________________");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! Please enter valid numbers after 'delete' command.");
                    System.out.println("____________________________________________________________");
                }
                continue;
            }
            else if (userInput.startsWith("deadline")) {
                try {
                    String check = userInput.split(" ")[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! The description of a deadline cannot be empty.");
                    System.out.println("____________________________________________________________");
                    continue;
                }
                try {
                    String[] words = userInput.replace("todo ", "").split(" /by ");
                    tasks.add(tasks.size(), new Deadline(words[0], words[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! You also need to specify the time of a deadline.");
                    System.out.println("____________________________________________________________");
                    continue;
                }
                getAddTaskMessage(input, tasks.size(), tasks);
            }
            else if (userInput.startsWith("event")) {
                try {
                    String check = userInput.split(" ")[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! The description of an event cannot be empty.");
                    System.out.println("____________________________________________________________");
                    continue;
                }
                try {
                    String[] words = userInput.replace("todo ", "").split(" /at ");
                    tasks.add(tasks.size(), new Event(words[0], words[1]));
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! You also need to specify the time of an event.");
                    System.out.println("____________________________________________________________");
                    continue;
                }
                getAddTaskMessage(input, tasks.size(), tasks);
            }
            //Add the task into the task array
            else if (userInput.startsWith("todo")) {
                try {
                    String check = userInput.split(" ")[1];
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("____________________________________________________________");
                    System.out.println(" ☹ OOPS!!! The description of a todo cannot be empty.");
                    System.out.println("____________________________________________________________");
                    continue;
                }
                tasks.add(tasks.size(), new Todo(userInput.replace("todo ", "")));
                getAddTaskMessage(input, tasks.size(), tasks);
            }
            else {
                System.out.println("____________________________________________________________");
                System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println("____________________________________________________________");
            }
            try {
                writeToFile(FILEPATH,tasks);
            } catch (IOException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        } while(!userInput.equals("bye"));
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }

    private static void getAddTaskMessage(Scanner input, int count, ArrayList<Task> tasks) {
        String userInput;
        System.out.println("____________________________________________________________");
        System.out.println(tasks.get(count - 1));
        if (count == 1) {
            System.out.println("Got it. I've added this task:");
            System.out.println("Now you have " + count + " task in the list");
        } else {
            System.out.println("Got it. I've added this task:");
            System.out.println("Now you have " + count + " tasks in the list");
        }
        System.out.println("____________________________________________________________");
    }

    private static void markAsDone(ArrayList<Task> tasks, String userInput) {
        String[] words = userInput.split(" ");
        if (words.length == 1) {
            System.out.println("____________________________________________________________");
            System.out.println(" ☹ OOPS!!! You are not marking any task as done.");
            System.out.println("____________________________________________________________");
            return;
        }
        System.out.println("____________________________________________________________");
        System.out.println("Nice! I've marked this task as done:");
        for (int j = 1; j < words.length; j++) {
            int index = Integer.parseInt(words[j]) - 1;
            tasks.get(index).markAsDone();
            System.out.println("[" + tasks.get(index).getStatusIcon() + "] " + tasks.get(index).description);
        }
        System.out.println("____________________________________________________________");
    }

    private static void listTasks(int count, ArrayList<Task> tasks) {
        System.out.println("____________________________________________________________");
        System.out.println("Here are the tasks in your list:");
        for(int i = 0; i < count; i++) {
            System.out.println((i + 1) + "." + tasks.get(i));
        }
        System.out.println("____________________________________________________________");
    }

    private static void greet() {
        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
    }

    private static void deleteTasks(ArrayList<Task> tasks, String userInput, int count) {
        String[] words = userInput.split(" ");
        switch (words.length) {
            case 1:
                System.out.println("____________________________________________________________");
                System.out.println(" ☹ OOPS!!! You are not deleting any task.");
                System.out.println("____________________________________________________________");
                break;
            case 2:
                System.out.println("____________________________________________________________");
                System.out.println("Noted. I've removed this task:");
                int index = Integer.parseInt(words[1]) - 1;
                System.out.println(tasks.get(index));
                tasks.remove(index);
                System.out.println(("Now you have " + count + " tasks in the list").replace("1 tasks", "1 task"));
                System.out.println("____________________________________________________________");
                break;
            default:
                System.out.println("____________________________________________________________");
                System.out.println(" ☹ OOPS!!! Please enter just one number after 'delete' command.");
                System.out.println("____________________________________________________________");
                break;
        }
    }

    private static void writeToFile(String filePath, ArrayList<Task> textToAdd) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        for (Task t : textToAdd) {
            fw.write(formatOutput(String.valueOf(t)) + System.lineSeparator());
        }
        fw.close();
    }

    private static String formatOutput(String str) {
        return str.replace("][", " | ").replace("]", " | ").replace("[", " ").replace("\u2713", "1").replace("\u2718","0");
    }
}