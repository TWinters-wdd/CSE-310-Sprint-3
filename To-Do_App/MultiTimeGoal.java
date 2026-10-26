public class MultiTimeGoal extends Goal{
    private int _timesToComplete;
    private int _timesCompleted;

    public MultiTimeGoal() {
        super();
        _timesToComplete = 0;
        _timesCompleted = 0;
    }

    public MultiTimeGoal(int timesToComplete, int timesCompleted) {
        super();
        _timesToComplete = timesToComplete;
        _timesCompleted = timesCompleted;
    }
}
