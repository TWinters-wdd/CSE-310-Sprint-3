import java.util.Scanner;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList<Goal> goalList = new ArrayList<Goal>();
        Scanner userInput = new Scanner(System.in);

        int userChoice = -1;

        do
        {
            switch (userChoice) {
                case 1:
                    Goal oneTimeGoal = new Goal();
                    oneTimeGoal.SetGoalName();
                    goalList.add(oneTimeGoal);
                    userChoice = -1;
                    break;
                case 2:
                    // Code for Multi-Time Goal
                    break;
                case 3:
                    // Code for Forever Goal
                    break;
                case 4:
                    // Code to save the goals to a file
                    break;
                case 5:
                    // Code to load the goals from a file
                    break;
                case 6:
                    // Code to display the goals that you currently have
                    for (Goal goal : goalList)
                    {
                        System.out.println(goal.GetFormattedString());
                    }
                    userChoice = -1;
                    break;
                default:
                    menu.DisplayMenu();
                    userChoice = userInput.nextInt();
            }
        } while (userChoice !=7);
        userInput.close();
    }
}
