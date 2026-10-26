public class Goal {
    private String _goalName;
    private boolean _isCompleted;

    public Goal() {
        _goalName = "";
        _isCompleted = false;
    }

    public Goal(String name) {
        _goalName = name;
        _isCompleted = false;
    }

    public String GetFormattedString(String name, boolean isCompleted) {
        String notFormattedString = "[%b] %s";
        String formattedString = String.format(notFormattedString, isCompleted, name);

        return formattedString;
    }
}