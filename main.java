package Text_Based_Game_Dungeon;

import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        
        //system objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //game variables
        String[] enemies = {"Skeleton", "Zombie", "Warrior", "Assassin", "Knight", "Vampire"};
        int maxEnemyHealth = 80;
        int enemyAttackDamage = 25;

        //player variables
        int health = 100;
        int attackDamage = 30;
        int numHealthPots = 3;
        int healthPotionHealAmt = 30;
        int healthPotionDropChance = 50; //percentage of having chance of having potion

        boolean running = true;
        
        System.out.println("         Welcome To The Dungeon!");

        GAME:
        while(running){
            System.out.println("----------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " Has Apperead! #\n");

            while(enemyHealth > 0){
                System.out.println("\tYour HP: "+health);
                System.out.println("\t"+enemy+"'s health: "+enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1. ATTACK!!");
                System.out.println("\t2. Drink Health Potion!");
                System.out.println("\t3.RUN!");

                String input = in.nextLine();

                if(input.equals("1")){
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t> You Strike the "+enemy+" for "+damageDealt+" damage.");
                    System.out.println("\t> You recieve "+damageTaken+" in retaliation.");

                    if(health < 1){
                        System.out.println("\t> You have taken too much damage. You are too weak to go on!");
                        break;
                    }

                }
                else if(input.equals("2")){
                    if(numHealthPots > 0){
                        health += healthPotionHealAmt;
                        numHealthPots--;
                        System.out.println("\t> You drinked a health potion, healing yourself for "+healthPotionHealAmt+"."+ "\n\t> You now have "+health+" HP."+"\n\t> You have "+numHealthPots+" health potions left.\n");
                    }
                    else{
                        System.out.println("\t> You have no health potion left! Defeat enemies for a chance to get one!\n");
                    }
                }
                else if(input.equals("3")){
                    System.out.println("\t You run away from the "+enemy+"!");
                    continue GAME;
                }
                else{
                    System.out.println("\t Invalid command!");
                }
            }
            if(health < 1){
                System.out.println("You limp out of the dungeon, weak from battle.");
                break;
            }
            System.out.println("----------------------------------------------------");
            System.out.println(" # "+enemy+" was defeated! # ");
            System.out.println(" # You have "+health+" HP left.");
            if(rand.nextInt(100) < healthPotionDropChance){
                numHealthPots++;
                System.out.println(" # The "+enemy+" dropped a health potion.");
                System.out.println(" # You have "+numHealthPots+" health potions!");
            }
            System.out.println("----------------------------------------------------");
            System.out.println("What would you like to do?");
            System.out.println("1. Continue Fighting!!");
            System.out.println("2. Exit the dungeon.");
            
            String input = in.nextLine();

            while(!input.equals("1") && !input.equals("2")){
                System.out.println("Invalid command.");
                input = in.nextLine();
            }

            if(input.equals("1")){
                System.out.println("You continue on your adventure!!");
            }
            else if(input.equals("2")){
                System.out.println("You exit the dungeon, successful from your adventure!!");
                break;
            }
        }
       System.out.println("#################################################");
       System.out.println(" # Thanks for playing, I hope to see you again! #"); 
       System.out.println("#################################################");
    }
}
