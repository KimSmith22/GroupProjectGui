package guiGroupProject;

import java.util.*;

public class Demo {

	public static void main(String[] args) {
		String make;
		String model;
		String name;
		int wager;
		int wager2;
		int totalBet;
		final int CASH = 100;
		String choice;
		
		Scanner k = new Scanner(System.in);
		
	System.out.println("Player 1 Enter name:");
	name = k.nextLine();
	
	System.out.println("Enter make of car:");
	make = k.nextLine();
	
	System.out.println("Enter model:");
	model = k.nextLine();
	
	Car car = new Car(make, model);
	Player p1 = new Player(name ,CASH, car);
	
	
	System.out.println("Player 2 Enter name:");
	name = k.nextLine();
	
	System.out.println("Enter make of car:");
	make = k.nextLine();
	
	System.out.println("Enter model:");
	model = k.nextLine();
	
	Car car2 = new Car(make, model);
	Player p2 = new Player(name ,CASH, car);
	
	do{
	System.out.println("Enter wager:");
	wager = k.nextInt();
		
	
	Bet bet = new Bet(p1, p2, wager);
	
	k.nextLine();
	
	bet.race();
		
	System.out.println("Bet again? y/n");
	choice = k.nextLine();
	
	}while(choice.equalsIgnoreCase("y"));
		if(choice.equalsIgnoreCase("n")){
			System.out.println("Thanks for playing.");
		}
		
		k.close();
	}

}
