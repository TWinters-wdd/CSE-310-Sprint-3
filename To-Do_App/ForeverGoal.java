import java.util.Scanner;

public class ForeverGoal extends Goal {
    private int _timesCompleted;
    
    public ForeverGoal() {
        super();
        _timesCompleted = 0;
        _goalType = "Forever";
    }

    public ForeverGoal(int timesCompleted) {
        super();
        _timesCompleted = timesCompleted;
        _goalType = "Forever";
    }

    @Override
    public void CreateGoal() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the name of the goal: ");

        _goalName = inputScanner.nextLine();
    }

    @Override
    public String GetFormattedString() {
        return "[" + _timesCompleted + "] " + _goalName;
    }

    @Override
    public String GetFileString() {
        return _timesCompleted + "#" + _goalName + "#" + _goalType + "\n";
    }

    @Override
    public void MarkCompleted() {
        if (!_isCompleted)
            _isCompleted = true;
        _timesCompleted++;
    }
}
