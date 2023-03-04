import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initialize scanner and random
        Scanner in = new Scanner(System.in);
        Random random = new Random();

        //Initialize variables
        //Point which is set by the first dice roll
        int point = 0;
        //Dice variables
        int die1;
        int die2;
        //Sum of the dice rolls
        int sum;
        boolean continuePlaying = true;
        //continuePlaying functions as the game loop. Can end the game by setting this to false
        while (continuePlaying) {
            // Initial roll
            die1 = random.nextInt(6) + 1; // Random number between 1 and 6
            die2 = random.nextInt(6) + 1;
            sum = die1 + die2;
            //Print results of first roll
            System.out.println("Roll: " + die1 + " + " + die2 + " = " + sum);
            //If statements for potential outcomes of first roll
            //Crap out if 2, 3 or 12
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose.");
                System.out.print("Play again? (y/n): ");
                String choice = in.nextLine();
                continuePlaying = choice.equalsIgnoreCase("y");
            //Win if 7 or 11
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win.");
                System.out.print("Play again? (y/n): ");
                String choice = in.nextLine();
                continuePlaying = choice.equalsIgnoreCase("y");
                //Tell the user the point and keep rolling.
            } else {
                //Current sum is the point
                point = sum;
                System.out.println("Point is " + point);
                    // Subsequent rolls
                    die1 = random.nextInt(6) + 1;
                    die2 = random.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("Roll: " + die1 + " + " + die2 + " = " + sum);
                    //Player wins by hitting point
                    if (sum == point) {
                        System.out.println("Made point! You win.");
                        System.out.print("Play again? (y/n): ");
                        String choice = in.nextLine();
                        continuePlaying = choice.equalsIgnoreCase("y");
                    //If roll is a 7, player loses
                    } else if (sum == 7) {
                        System.out.println("Seven! You lose.");
                        //Prompt to play again
                        System.out.print("Play again? (y/n): ");
                        String choice = in.nextLine();
                        continuePlaying = choice.equalsIgnoreCase("y");
                    }
                }
        }
        //If user chooses "N" for play again, thank them
        System.out.println("Thanks for playing!");
    }
}
