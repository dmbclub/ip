public class Parser {
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
