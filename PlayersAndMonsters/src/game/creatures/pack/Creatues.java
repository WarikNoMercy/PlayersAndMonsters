package game.creatures.pack;

class Player{
	
	private int maxHealth;
	private int health;
	private int attack;
	private int defense;
	private int minDamage;
	private int maxDamage;
	private int healCount = 0;
	private boolean dead = false;
	
	public Player(int maxHealth, int attack, int defense, int minDamage, int maxDamage) {
		if(maxHealth > 0 && attack >=1 && attack <=30 && defense >= 1 && defense <= 30 && minDamage >= 1 && maxDamage > minDamage) {
			this.maxHealth = maxHealth;
			this.health = maxHealth;
			this.attack = attack;
			this.defense = defense;
			this.minDamage = minDamage;
			this.maxDamage = maxDamage;
			System.out.println("You created player with: " + maxHealth + " hp, " +
					attack + " attack, " + defense + " defense and with damage : " + minDamage + " - " + maxDamage);
		}else {
			System.out.println("Incorrect values");
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void heal() {
		if(healCount >= 4 || dead) {
			System.out.println("You can't heal" + (dead ?  ", you're dead" : ""));
		}else {
			health = health + (maxHealth * 30 / 100) > maxHealth ? maxHealth : health + (maxHealth * 30 / 100);
			System.out.println("You were healed, now your health is : " + health + " hp");
			healCount++;
		}
	}
	
	public void hit(Monster monster) {
		int attackModifier = attack - monster.getDefense() + 1;
		boolean successfulHit = false;
		
		//Roll a Dice;
		if(attackModifier > 1) {
			for(int i = 1; i <= attackModifier;i++) {
				int dice = (int) (Math.random() * 7);
				if(dice==5 || dice==6) {
					successfulHit = true;
					break;
				}
			}
		}else {
			int dice = (int)(Math.random() * 7);
			if(dice==5 || dice==6) {
				successfulHit = true;
			}
		}
		
		if(successfulHit) {
			int hit = minDamage + (int) (Math.random() * ((maxDamage - minDamage) + 1));
			monster.getHit(hit);
			if(monster.getHealth() > 0) {
				System.out.println("You hit the monster for " + hit + " hp");
				System.out.println("Now monster's health is : " + monster.getHealth() + "hp");
			}else {
				System.out.println("You killed the monster");
			}
		}else {
			System.out.println("Hit wasn't successful");
		}
	}
	
	public void getHit(int damage) {
		health -= damage;
		if(health <=0) {
			dead = true;
		}
	}
	
}



class Monster{
	
	private int maxHealth;
	private int health;
	private int attack;
	private int defense;
	private int minDamage;
	private int maxDamage;
	private int healCount = 0;
	private boolean dead = false;
	
	public Monster(int maxHealth, int attack, int defense, int minDamage, int maxDamage) {
		if(maxHealth > 0 && attack >=1 && attack <=30 && defense >= 1 && defense <= 30 && minDamage >= 1 && maxDamage > minDamage) {
			this.maxHealth = maxHealth;
			this.health = maxHealth;
			this.attack = attack;
			this.defense = defense;
			this.minDamage = minDamage;
			this.maxDamage = maxDamage;
			System.out.println("You created monster with: " + maxHealth + " hp, " +
					attack + " attack, " + defense + " defense and with damage : " + minDamage + " - " + maxDamage);
		}else {
			System.out.println("Incorrect values");
		}
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void heal() {
		if(healCount >= 4 || dead) {
			System.out.println("You can't heal" + (dead ?  ", you're dead" : ""));
		}else {
			health = health + (maxHealth * 30 / 100) > maxHealth ? maxHealth : health + (maxHealth * 30 / 100);
			System.out.println("You were healed, now your health is : " + health + " hp");
			healCount++;
		}
	}
	
	public void hit(Player player) {
		int attackModifier = attack - player.getDefense() + 1;
		boolean successfulHit = false;
		
		//Roll a Dice;
		if(attackModifier > 1) {
			for(int i = 1; i <= attackModifier;i++) {
				int dice = (int) (Math.random() * 7);
				if(dice==5 || dice==6) {
					successfulHit = true;
					break;
				}
			}
		}else {
			int dice = (int)(Math.random() * 7);
			if(dice==5 || dice==6) {
				successfulHit = true;
			}
		}
		
		if(successfulHit) {
			int hit = minDamage + (int) (Math.random() * ((maxDamage - minDamage) + 1));
			player.getHit(hit);
			if(player.getHealth() > 0) {
				System.out.println("You hit the player for " + hit + " hp");
				System.out.println("Now he's health is : " + player.getHealth());
			}else {
				System.out.println("You killed the player");
			}
		}else {
			System.out.println("Hit wasn't successful");
		}
	}
	
	public void getHit(int damage) {
		health -= damage;
		if (health <=0) {
			dead = true;
		}
	}
}


