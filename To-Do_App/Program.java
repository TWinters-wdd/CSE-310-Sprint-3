import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner userInput = new Scanner(System.in);
        
        menu.DisplayMenu();
        int userChoice = userInput.nextInt();

        switch (userChoice) {
            case 1:
                // Code for One Time Goal
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
                break;
            case 7:
                // Code that quits the program
                break;
            default:
                menu.DisplayMenu();
            
            userInput.close();
        }
    }
}
