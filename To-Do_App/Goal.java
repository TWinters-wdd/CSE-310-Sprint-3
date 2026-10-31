import java.util.Scanner;

public class Goal {
    protected String _goalName;
    protected boolean _isCompleted;
    protected String _goalType;

    public Goal() {
        _goalName = "";
        _isCompleted = false;
        _goalType = "OneTime";
    }

    public Goal(String name, String goalType, boolean isCompleted) {
        _goalName = name;
        _isCompleted = isCompleted;
        _goalType = goalType;
    }

    public String GetFormattedString() {

        return "[" + _isCompleted + "] " + _goalName;
    }

    public String GetFileString() {
        return _isCompleted + "#" + _goalName + "#" + _goalType + "\n";

    }

    @SuppressWarnings("resource")
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