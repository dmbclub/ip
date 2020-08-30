import java.util.Scanner;
public class Duke {
    public static void main(String[] args) {
        String[] Tasks = new String[100];
        Scanner input = new Scanner(System.in);
        int count = 0;

        System.out.println("____________________________________________________________");
        System.out.println(" Hello! I'm Duke");
        System.out.println(" What can I do for you?");
        System.out.println("____________________________________________________________");
        String userInput = input.nextLine();
        while(!userInput.equals("bye")) {
            //Print the list if input is 'list'
            if (userInput.equals("list")) {
                System.out.println("____________________________________________________________");
                for(int i = 0; i < count; i++) {
                    System.out.println(i + 1 + ". " + Tasks[i]);
                }
                System.out.println("____________________________________________________________");
            }
            //Add the task into the task array
            else {
                Tasks[count] = userInput;
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
}
