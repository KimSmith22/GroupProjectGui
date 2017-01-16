package guiGroupProject;

public class Bet {

	private String winner;
	private Player p1;
	private Player p2;
	private int wager;

	public Bet(Player p1, Player p2, int wager) {
		this.p1 = p1;
		this.p2 = p2;
		this.wager = wager;
	}

	public void race() {
		if (p1.getVehicle().getQuarterMileTime() > p2.getVehicle().getQuarterMileTime()) {
			p1.setCash(wager);
			p2.youLost(wager);
			winner = p1.getName() + " wins!" + "\nYou win: " + wager + "\nPlayer 1 balance: " + p1.getCash()
					+ "\nPlayer 2 balance: " + p2.getCash();

			System.out.println(winner);

		}else
		if (p2.getVehicle().getQuarterMileTime() > p1.getVehicle().getQuarterMileTime()) {
			p2.setCash(wager);
			p1.youLost(wager);
			winner = p2.getName() + " wins!" + "\nYou win: " + wager + "\nPlayer 2 balance: " + p2.getCash()
					+ "\nPlayer 1 balance: " + p1.getCash();

			System.out.println(winner);
		}
	}

}
