/**
 * Parser class deals with making sense of the user command
 */

public class Parser {
    /**
     * Parser formats the user input and output a command c
     * @param userInput String of the user input.
     * @return Command c. A command that contains the name of the command (string) and the description of the command (string).
     */
    public static Command parse(String userInput) {
        Command c;
        if (userInput.equals("bye")) {
            c = new Command("exit", "");
        }
        else if (userInput.equals("list")) {
            c = new Command("list", "");
        }
        else if (userInput.startsWith("done")) {
            c = new Command("done", userInput.replace("done ", ""));
        }
        else if (userInput.startsWith("find")) {
            c = new Command("find", userInput.replace("find ", ""));
        }
        else if (userInput.startsWith("delete")) {
            c = new Command("delete", userInput.replace("delete ", ""));
        }
        else if (userInput.startsWith("deadline")) {
            c = new Command("deadline", userInput.replace("deadline ", ""));
        }
        else if (userInput.startsWith("event")) {
            c = new Command("event", userInput.replace("event ", ""));
        }
        //Add the task into the task array
        else if (userInput.startsWith("todo")) {
            c = new Command("todo", userInput.replace("todo ", ""));
        }
        else {
            c = new Command("invalid", "");
            Ui.showError();
        }
        return c;
    }
}
