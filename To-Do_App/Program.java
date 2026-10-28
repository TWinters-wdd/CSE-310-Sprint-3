import java.util.Scanner;
import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList<Goal> goalList = new ArrayList<Goal>();
        Scanner userInput = new Scanner(System.in);

        int userChoice = -1;
        System.out.println("Welcome to the Goal Setting Application, Pick an option: ");
        do
        {
            switch (userChoice) {
                case 1:
                    Goal oneTimeGoal = new Goal();
                    oneTimeGoal.CreateGoal();
                    goalList.add(oneTimeGoal);
                    userChoice = -1;
                    break;
                case 2:
                    MultiTimeGoal multiTimeGoal = new MultiTimeGoal();
                    multiTimeGoal.CreateGoal();
                    goalList.add(multiTimeGoal);
                    userChoice = -1;
                    break;
                case 3:
                    ForeverGoal foreverGoal = new ForeverGoal();
                    foreverGoal.CreateGoal();
                    goalList.add(foreverGoal);
                    userChoice = -1;
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
                case 7:
                    // Code to mark goal as complete
                    for (Goal goal : goalList)
                    {
                        System.out.println(goal.GetFormattedString());
                    }
                    System.out.print("Which goal do you want to complete: ");
                    break;
                default:
                    menu.DisplayMenu();
                    userChoice = userInput.nextInt();
            }
        } while (userChoice != 8);
        userInput.close();
    }
}
