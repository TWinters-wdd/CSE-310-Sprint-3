import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
// import java.util.regex.Matcher;
// import java.util.regex.Pattern;

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
                    // Loads the goals from external file into _goalList
                    System.out.print("Load goals from which file: ");
                    String fromFileName = userInput.nextLine();
                    File myFile = new File(fromFileName);

                    // Code to split the data into segments
                    try (Scanner myReader = new Scanner(myFile)) {
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            String[] dataArray = data.split("#");

                            String goalType = dataArray[dataArray.length - 1];

                            switch(goalType) {
                                case "OneTime":
                                    boolean isCompleted = Boolean.parseBoolean(dataArray[0]);
                                    String goalName = dataArray[1];
                                    Goal newGoal = new Goal(goalName, goalType, isCompleted);
                                    goalList.add(newGoal);
                                    break;
                                case "MultiTime":
                                    int toComplete = Integer.parseInt(dataArray[1]);
                                    int timesCompleted = Integer.parseInt(dataArray[0]);
                                    String multiGoalName = dataArray[2];
                                    Goal newMulti = new MultiTimeGoal(toComplete, timesCompleted, multiGoalName);
                                    goalList.add(newMulti);
                                    break;
                                case "Forever":
                                    int foreverTimesCompleted = Integer.parseInt(dataArray[0]);
                                    ForeverGoal newForeverGoal = new ForeverGoal(foreverTimesCompleted, dataArray[1]);
                                    goalList.add(newForeverGoal);
                                    break;
                            }
                        }
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    
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
