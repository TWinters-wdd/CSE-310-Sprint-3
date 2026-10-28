import java.util.Scanner;

public class ForeverGoal extends Goal {
    private int _timesCompleted;
    
    public ForeverGoal() {
        super();
        _timesCompleted = 0;
    }

    public ForeverGoal(int timesCompleted) {
        super();
        _timesCompleted = timesCompleted;
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
    public void MarkCompleted() {
        if (!_isCompleted)
            _isCompleted = true;
        _timesCompleted++;
    }
}
