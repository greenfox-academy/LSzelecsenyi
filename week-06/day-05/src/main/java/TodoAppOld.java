import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoAppOld {


//START TODOAPP

public void start(String[] args) throws IOException {
    TodoAppOld todoApp = new TodoAppOld();

    if (args.length == 0) {
        todoApp.printUsage();
    } else if (args[0].equals("-l")) {
        todoApp.listTasks();
    } else if (args[0].equals("-c")) {
            TodoAppOld.markComplete(args);
    } else if (args.length > 1 && args[0].equals("-r")) {
        todoApp.removeTasks(args);
    } else if (args[0].length() > 1 && args[0].equals("-a")) {
        todoApp.addNewTask(args);
    } else System.out.println("Please enter valid argument!");
}

// PRINT USAGE

    public void printUsage() {
        try {
            Path myPath = Paths.get("C:\\Users\\Lenovo\\Desktop\\Green Fox\\LSzelecsenyi\\week-06\\day-05\\src\\main\\java\\PrintUsage.txt");
            List<String> lines = Files.readAllLines(myPath);
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (Exception e) {
        }

//  LISTING TASKS

        System.out.println("Unable to read file: PrintUsage.txt");
        }
    public void listTasks() {
        try {
            Path myPath = Paths.get("C:\\Users\\Lenovo\\Desktop\\Green Fox\\LSzelecsenyi\\week-06\\day-05\\src\\main\\java\\TodoList.txt");
            List<String> lines = Files.readAllLines(myPath);
            StringBuffer sb = new StringBuffer();

            if (lines.isEmpty()) {
                System.out.println("No todos for today! :)");
            } else {
                for (int i = 0; i < lines.size(); i++) {
                    if (lines.get(i).endsWith("|")) {
                        System.out.println(i + 1 + ". - [X] " + lines.get(i).substring(0, lines.get(i).length() - 1));
                    } else System.out.println(i + 1 + ". - [ ] " + lines.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println("Unable to read file: Todolist.txt");
        }
    }

//  ADDING NEW TASK

    public void addNewTask(String[] aargs){
        Path myPath = Paths.get("C:\\Users\\Lenovo\\Desktop\\Green Fox\\LSzelecsenyi\\week-06\\day-05\\src\\main\\java\\TodoList.txt");
        List<String> list = new ArrayList<>(Arrays.asList(aargs));
        list.remove(0);
        String newTask = String.join(" ", list);
        if (aargs.length < 2) {
        System.out.println("Unable to add: no task provided");
        } else
        try {
            List<String> lines = Files.readAllLines(myPath);
            lines.add(newTask);
            Files.write(myPath, lines);
        } catch (Exception e) {
            System.out.println("Unable to read file: Todolist.txt");
        }
    }

//  REMOVE TASK

    public void removeTasks(String[] aargs) throws IOException {
        int lineNumber = Integer.parseInt(aargs[1].toString()) - 1;
        try {
            Path myPath = Paths.get("C:\\Users\\Lenovo\\Desktop\\Green Fox\\LSzelecsenyi\\week-06\\day-05\\src\\main\\java\\TodoList.txt");
            List<String> lines = Files.readAllLines(myPath);
            if (aargs.length < 2) {
                System.out.println("Unable to remove: no index provided");
            } else if (Integer.parseInt(aargs[1].toString()) > lines.size()) {
                System.out.println("Unable to remove: index is out of bound");
            } else
                lines.remove(lineNumber);
            Files.write(myPath, lines);
        } catch (Exception e) {
            System.out.println("Unable to read file: Todolist.txt");
        }
    }

//  CHECK TASK

    public static void markComplete(String[] aargs) {
        Path myPath = Paths.get("C:\\Users\\Lenovo\\Desktop\\Green Fox\\LSzelecsenyi\\week-06\\day-05\\src\\main\\java\\TodoList.txt");
        int lineToCheck = Integer.parseInt(aargs[1]) - 1;
        try {
        List<String> lines = Files.readAllLines(myPath);
        if (lines.get(lineToCheck).endsWith("|")) {                     //Prevents to check something twice
            System.out.println("Task is already marked as completed!\nHave you done it again?");
        } else
        lines.set(lineToCheck, lines.get(lineToCheck) + "|");
        Files.write(myPath, lines);
        } catch (IOException e) {
            System.out.println("Unable to read TodoList.txt");;
        }
    }



//RUNNING TODOAPP

    public static void main(String[] args) throws IOException {

        TodoAppOld todoApp = new TodoAppOld();
        todoApp.start(args);
        
    }
}
