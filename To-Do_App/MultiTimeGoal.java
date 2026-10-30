import java.util.Scanner;

public class MultiTimeGoal extends Goal{
    private int _timesToComplete;
    private int _timesCompleted;

    public MultiTimeGoal() {
        super();
        _timesToComplete = 0;
        _timesCompleted = 0;
        _goalType = "MultiTime";
    }

    public MultiTimeGoal(int timesToComplete, int timesCompleted) {
        super();
        _timesToComplete = timesToComplete;
        _timesCompleted = timesCompleted;
        _goalType = "MultiTime";
    }

    @Override
    public void CreateGoal() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the name of the goal: ");

        _goalName = inputScanner.nextLine();

        System.out.print("How many times do you want to complete this goal? ");
        _timesToComplete = inputScanner.nextInt();
    }

    @Override
    public String GetFormattedString() {
        return "[" + _timesCompleted + "/" + _timesToComplete + "] " + _goalName;
    }

    @Override
    public String GetFileString() {
        return _timesCompleted + "#" + _timesToComplete + "#" + _goalName + "#" + _goalType + "\n";
    }

    @Override
    public void MarkCompleted() {
        _timesCompleted++;
        if (_timesCompleted >= _timesToComplete) {
            _isCompleted = true;
        }
    }
}
