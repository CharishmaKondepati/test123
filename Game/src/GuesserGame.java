import java.util.Scanner;

class Guesser {
	int guessNumber;

	public int guessNum() {
		int n =10;
		Scanner scan = new Scanner(System.in);
		System.out.println("Guesser please guess the number :");
		guessNumber = scan.nextInt();
		if (guessNumber <= n) {
			return guessNumber;
		} else {
			System.out.println("Please guess the number with in range 0 to 10...");
			guessNum();
		}
		return guessNumber;
	}
}

class Player {
	int playerNumber;

	public int playerNum() {
		int n =10;
		Scanner scan = new Scanner(System.in);
		playerNumber = scan.nextInt();
		if (playerNumber <= n) {
			return playerNumber;
		} else {
			System.out.println("Please guess the number with in range 0 to 10...");
			playerNum();
		}
		return playerNumber;
	}

}

class Umpire {
	int numFromGuesser;
	int numFromPlayer1;
	int numFromPlayer2;
	int numFromPlayer3;
	int numFromPlayer4;
	int numFromPlayer5;
	int numFromPlayer6;
	
	Player p1 = new Player();
	Player p2 = new Player();
	Player p3 = new Player();
	Player p4 = new Player();
	Player p5 = new Player();
	Player p6 = new Player();

	public void collectNumFromGuesser() {
		Guesser g = new Guesser();
		numFromGuesser = g.guessNum();
	}

	public void collectNumFromPlayer() {

		System.out.println("\nTeam-1 :");
		System.out.println("Player1 kindly enter the number :");
		numFromPlayer1 = p1.playerNum();
		System.out.println("Player2 kindly enter the number :");
		numFromPlayer2 = p2.playerNum();
		
		System.out.println("\nTeam-2 :");
		System.out.println("Player3 kindly enter the number :");

		
		numFromPlayer3 = p3.playerNum();
		System.out.println("Player4 kindly enter the number :");
		numFromPlayer4 = p4.playerNum();
		
		System.out.println("\nTeam-3 :");
		System.out.println("Player5 kindly enter the number :");

		
		numFromPlayer5 = p5.playerNum();
		System.out.println("Player6 kindly enter the number :");
		numFromPlayer6 = p6.playerNum();

	}

	public void compare() {
		
	  if((numFromGuesser==numFromPlayer1 || numFromGuesser == numFromPlayer2) && (numFromGuesser==numFromPlayer3 || numFromGuesser == numFromPlayer4) && (numFromGuesser==numFromPlayer5 || numFromGuesser == numFromPlayer6) )
		{
			System.out.println("Game Tied Play One More Match.... ");
			collectNumFromGuesser();
			collectNumFromPlayer();
			compare();
		}
	  else if((numFromGuesser==numFromPlayer1 || numFromGuesser == numFromPlayer2) && (numFromGuesser==numFromPlayer3 || numFromGuesser == numFromPlayer4))
	  {
		  System.out.println("Team-1 and Team-2 Won the Game Moving to Finals!!");
		  collectNumFromGuesser();
		  System.out.println("\nTeam-1 :");
			System.out.println("Player1 kindly enter the number :");
			numFromPlayer1 = p1.playerNum();
			System.out.println("Player2 kindly enter the number :");
			numFromPlayer2 = p2.playerNum();
			
			System.out.println("\nTeam-2 :");
			System.out.println("Player3 kindly enter the number :");

			
			
			numFromPlayer3 = p3.playerNum();
			System.out.println("Player4 kindly enter the number :");
			numFromPlayer4 = p4.playerNum();
			if((numFromGuesser==numFromPlayer1 || numFromGuesser == numFromPlayer2))
			{
				System.out.println("Team-1 Won the Game!!");
			}
			else
			{
				System.out.println("Team-2 Won the Game!!");
			}
	  }
	  else if((numFromGuesser==numFromPlayer3 || numFromGuesser == numFromPlayer4) && (numFromGuesser==numFromPlayer5 || numFromGuesser == numFromPlayer6))
	  {
		  System.out.println("Team-2 and Team-3 Won the Game Moving to Finals!!");
		  collectNumFromGuesser();
		  System.out.println("\nTeam-2 :");
			System.out.println("Player3 kindly enter the number :");
			numFromPlayer3 = p3.playerNum();
			System.out.println("Player4 kindly enter the number :");
			numFromPlayer4 = p4.playerNum();
			
			System.out.println("\nTeam-3 :");
			System.out.println("Player5 kindly enter the number :");

			
			
			numFromPlayer5 = p5.playerNum();
			System.out.println("Player6 kindly enter the number :");
			numFromPlayer6 = p6.playerNum();
			if((numFromGuesser==numFromPlayer3 || numFromGuesser == numFromPlayer4))
			{
				System.out.println("Team-2 Won the Game!!");
			}
			else
			{
				System.out.println("Team-3 Won the Game!!");
			}
	  }
	  else if((numFromGuesser==numFromPlayer1 || numFromGuesser == numFromPlayer2) && (numFromGuesser==numFromPlayer5 || numFromGuesser == numFromPlayer6))
	  {
		  System.out.println("Team-1 and Team-3 Won the Game Moving to Finals!!");
		  collectNumFromGuesser();
		  System.out.println("\nTeam-1 :");
			System.out.println("Player1 kindly enter the number :");
			numFromPlayer1 = p1.playerNum();
			System.out.println("Player2 kindly enter the number :");
			numFromPlayer2 = p2.playerNum();
			
			System.out.println("\nTeam-3 :");
			System.out.println("Player5 kindly enter the number :");

			
			
			numFromPlayer5 = p5.playerNum();
			System.out.println("Player6 kindly enter the number :");
			numFromPlayer6 = p6.playerNum();
			if((numFromGuesser==numFromPlayer1 || numFromGuesser == numFromPlayer2))
			{
				System.out.println("Team-1 Won the Game!!");
			}
			else
			{
				System.out.println("Team-3 Won the Game!!");
			}
	  }
	  
	  else if((numFromGuesser==numFromPlayer1 || numFromGuesser == numFromPlayer2) )
		{
			System.out.println("Team-1 Won The Game");
		}
	  else if((numFromGuesser==numFromPlayer3 || numFromGuesser == numFromPlayer4))
		{
			System.out.println("Team-2 Won The Game");
		}
	  else if((numFromGuesser==numFromPlayer5 || numFromGuesser == numFromPlayer6))
		{
			System.out.println("Team-3 Won The Game");
		}
		else
		{
			System.out.println("Game Lost Play Again..");
			collectNumFromGuesser();
			collectNumFromPlayer();
			compare();
		}
	}
public class GuesserGame {

	public static void main(String[] args) {
		Umpire u = new Umpire();
		u.collectNumFromGuesser();
		u.collectNumFromPlayer();
		u.compare();

	}
		

	}

}
