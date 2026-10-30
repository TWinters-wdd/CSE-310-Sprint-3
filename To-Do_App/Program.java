import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

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
                    try {
                        // 1. Create the file to save to if it doesn't exist
                        System.out.print("Save to which file: ");
                        String fileName = userInput.nextLine();
                        File saveFile = new File(fileName);

                        FileWriter fileWriter = new FileWriter(saveFile);
                        if (saveFile.createNewFile()) {
                            // Foreach loop to write the lines in the goalList to the file
                            for (Goal goal : goalList) {
                                fileWriter.write(goal.GetFileString());
                            }
                        } else {
                            // Code to write to the already created file
                            for (Goal goal : goalList) {
                                fileWriter.write(goal.GetFileString());
                            }
                        }
                        System.out.println("Goals saved to " + fileName + ".");
                        fileWriter.close();
                    } catch (IOException e) {
                        System.out.println("An error occured.");
                        e.printStackTrace();
                    }
                    userChoice = -1;
                    break;
                case 5:
                    // Code to load the goals from a file
                    userChoice = -1;
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
                        System.out.println((goalList.indexOf(goal) + 1) + ". " + goal._goalName);
                    }
                    System.out.print("Which goal do you want to complete: ");
                    int completeGoal = userInput.nextInt() -1;
                    goalList.get(completeGoal).MarkCompleted();
                    userChoice = -1;
                    break;
                default:
                    menu.DisplayMenu();
                    userChoice = userInput.nextInt();
                    userInput.nextLine();
            }
        } while (userChoice != 8);
        userInput.close();
    }
}
