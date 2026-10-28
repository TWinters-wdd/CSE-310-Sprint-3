import java.util.Scanner;

public class Goal {
    protected String _goalName;
    protected boolean _isCompleted;

    public Goal() {
        _goalName = "";
        _isCompleted = false;
    }

    public Goal(String name) {
        _goalName = name;
        _isCompleted = false;
    }

    public String GetFormattedString() {

        return "[" + _isCompleted + "] " + _goalName;
    }

    public void CreateGoal() {
        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter the name for your goal: ");

        String goalName = myScanner.nextLine();
        _goalName = goalName;
    }

    public void MarkCompleted() {
        _isCompleted = true;
    }
}