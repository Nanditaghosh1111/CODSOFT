import java.util.Random;
import java.util.Scanner;

public class number_Game {

	public static void main(String[] args) {

		Random rand=new Random();
		Scanner sc=new Scanner(System.in);
		int totalScore=0;
		int totalRounds=0;
		char playAgain='y';
		while(playAgain=='y' || playAgain=='Y')
		{
			totalRounds++;
			int random_no = rand.nextInt(100)+1;
			int tryCount=0;
			int maxTry=10;
			System.out.println("I'm thinking of a number between 1 and 100.");
			System.out.println("you have "+maxTry+" attempts to guess it.");
			while(tryCount<maxTry)
			{
				System.out.println("Enter your guess (1=100) : ");
				if(sc.hasNextInt())
				{
					int playerGuess = sc.nextInt();
					tryCount++;
					if(playerGuess == random_no)
					{
						System.out.println("Correct You win!");
						System.out.println("It took you " + tryCount +" tries.");
						totalScore++;
						break;
					}
					else if(playerGuess>random_no)
					{
						System.out.println("Nope! The number is higher.Guess again");
					}
					else
					{
						System.out.println("Nope! The number is lower. Guess again");
					}
				}
				else
				{
					System.out.println("Invalid input. Please enter a number.");
					sc.next();
				}
			}
			if(tryCount==maxTry)
			{
				System.out.println("Sorry you didn't guess the number. The number was "+random_no);
			}
			System.out.print("\n Do you want to play again? (y/n): ");
			playAgain=sc.next().charAt(0);
		}
		System.out.println("Game Over!");
		System.out.println("Your final score is "+totalScore+" out of "+totalRounds+".");
		sc.close();
	}

}
