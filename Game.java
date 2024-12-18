import java.util.Scanner;

public class Game {
    
    public static void main(String[] args) {
        Adventurer player = null, enemy = null;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Choose a role for the player: Air, Water, Ground");

        boolean finishedPlayer = false;

        while(!finishedPlayer) {
            String next = sc.next();
            if(next.equals("Water")) {
                player = new WaterDrinker();
                finishedPlayer = true;
            }
            else if(next.equals("Air")) {
                player = new AirBreather();
                finishedPlayer = true;
            }
            else if(next.equals("Ground")) {
                player = new GroundWalker();
                finishedPlayer = true;
            } else {
                System.out.println("Didn't work. Try again!");
                System.out.println("Choose a role for the player: Air, Water, Ground");
            }
        }

        System.out.println("Choose a role for the enemy: Air, Water, Ground");

        boolean finishedEnemy = false;

        while(!finishedEnemy) {
            String next = sc.next();
            if(next.equals("Water")) {
                enemy = new WaterDrinker("Enemy Chugger");
                finishedEnemy = true;
            }
            else if(next.equals("Air")) {
                enemy = new AirBreather("Enemy Breather");
                finishedEnemy = true;
            }
            else if(next.equals("Ground")) {
                enemy = new GroundWalker("Enemy Walker");
                finishedEnemy = true;
            } else {
                System.out.println("Didn't work. Try again!");
                System.out.println("Choose a role for the enemy: Air, Water, Ground");
            }
        }

        System.out.println("Let's look at their stats\n");
        System.out.println("Player stats:");
        System.out.println("Player name: " + player.getName());
        System.out.println("Player HP: " + player.getHP());
        System.out.println("Player special amount: " + player.getSpecial());
        System.out.println("Player special name: " + player.getSpecialName());
        System.out.println("Player special max: " + player.getSpecialMax());

        System.out.println("\nEnemy stats:");
        System.out.println("Enemy name: " + enemy.getName());
        System.out.println("Enemy HP: " + enemy.getHP());
        System.out.println("Enemy special amount: " + enemy.getSpecial());
        System.out.println("Enemy special name: " + enemy.getSpecialName());
        System.out.println("Enemy special max: " + enemy.getSpecialMax());
        
        while(enemy.getHP() > 0 && player.getHP() > 0) {
            System.out.println("\nChoose an action. Type a (attack), sp (special), su (support).");

            boolean finishedAction = false;
            while(!finishedAction) {
                String next = sc.next();
                if(next.equals("a")) {
                    System.out.println(player.attack(enemy));
                    finishedAction = true;
                }
                else if(next.equals("sp")) {
                    System.out.println(player.specialAttack(enemy));
                    finishedAction = true;
                }
                else if(next.equals("su")) {
                    System.out.println(player.support());
                    finishedAction = true;
                } else {
                    System.out.println("\nDidn't work. Try again!");
                    System.out.println("Choose an action. Type a (attack), sp (special), su (support).\n");
                }
            }

            boolean quit = false;
            while(!quit) {
                System.out.println("Do you wish to quit? Y or n");
                String next = sc.next();
                if(next.equals("Y")) {
                    return;
                } else if (next.equals("n")) {
                    break;
                }
            }

            System.out.println("\nNow it is the enemy's turn!");
            if(enemy.getHP() > 0) {
                int choose = (int)(Math.random() * 3.0);
                if(choose == 0) {
                    System.out.println(enemy.attack(player));
                }
                else if(choose == 1) {
                    System.out.println(enemy.specialAttack(player));
                }
                else if(choose == 2) {
                    System.out.println(enemy.support(enemy));
                }
            }

            System.out.println("\nPlayer health: " + player.getHP());
            System.out.println("Enemy health: " + enemy.getHP());
        }
        if(player.getHP() > 0) {
            System.out.print("\u001b[32m");
            System.out.println("\nPlayer is the winner!");
        } else if(enemy.getHP() > 0) {
            System.out.print("\u001b[31m");
            System.out.println("\nEnemy is the winner!");
        } else {
            System.out.print("\u001b[33m");
            System.out.println("\nNeither won!");
        }

        sc.close();
    }
    
    

    
}
