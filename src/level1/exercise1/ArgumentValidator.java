package level1.exercise1;

public class ArgumentValidator {
    public static boolean validate(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide the path as an argument.");
            return false;
        }
        return true;
    }
}


