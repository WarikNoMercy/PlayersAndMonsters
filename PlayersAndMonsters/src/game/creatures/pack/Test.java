package game.creatures.pack;

public class Test {

	public static void main(String[] args) {

		Player player = new Player(100, 30, 30, 30, 100);
		Monster monster = new Monster(20, 1, 1, 1 , 5);
		monster.heal();
		monster.heal();
		player.hit(monster);
		monster.heal();
		Player player2 = new Player(20,1,1,1,5);
		Monster monster2 = new Monster(150, 30, 30, 50, 120);
		player.hit(monster2);
		player.hit(monster2);
	}

}
