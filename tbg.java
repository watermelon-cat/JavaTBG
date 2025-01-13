import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    //globals
    static String[] inventory = new String[10]; // Inventory can hold up to 10 items




    public static void main(String[] args) { //the real main
        Scanner scanner = new Scanner(System.in); // Used for user input
        int room = 1; // Starting room
        String direction;
        boolean fight = false;
        for(int i = 0; i<10; i++) {
            inventory[i] = " "; //initialize each inventory slot to 0
        }
        inventory[3] = "potato"; //give user a potato!

        while (true) { // Game loop
            System.out.println("Your inventory:");
            for (int i = 0; i < 10; i++) {
                System.out.print(inventory[i]);
                System.out.print(" ");
            }
            System.out.println(" ");
            switch (room) {
                case 1: // Room 1
                    System.out.println("You are in room 1, you can go east.");
                    if (!inventory[0].equals("sword")) {
                        inventory[0] = "sword";
                        System.out.println("You got a sword!");
                    }
                    direction = scanner.nextLine().trim().toLowerCase();
                    if ("east".equals(direction)) {
                        room = 2;
                    } else {
                        System.out.println("Invalid direction. Staying in room " + room);
                    }
                    break;

                case 2: // Room 2
                    if ( !fight) {
                        String monster = generateMonster();
                        fightMonster(monster);
                        fight = true;
                    }

                    System.out.println("You are in room 2, you can go west and south.");
                    direction = scanner.nextLine().trim().toLowerCase();
                    if ("west".equals(direction)) {
                        room = 1;
                    }
                    else if ("south".equals(direction)) {
                        room = 3;
                    }
                    else {
                        System.out.println("Invalid direction. Staying in room " + room);
                    }
                    break;
                case 3: // Room 2
                    System.out.println("You are in room 3, you can go north or east.");
                    inventory[4] = generateItem();
                    direction = scanner.nextLine().trim().toLowerCase();
                    if ("north".equals(direction)) {
                        room = 2;
                    }
                    else if ("east".equals(direction)) {
                        room = 4;
                    }else {
                        System.out.println("Invalid direction. Staying in room " + room);
                    }
                    break;
                case 4: // Room 2
                    System.out.println("You are in room 4, you can go west and east. You see a key on the floor.");
                    direction = scanner.nextLine().trim().toLowerCase();
                    if ("east".equals(direction) && inventory[2] == "key") {
                        room = 5;
                    }
                    else if ("west".equals(direction)) {
                        room = 3;
                    }
                    else if ("key".equals(direction)) {
                        inventory[2] = "key";
                    }
                    else {
                        System.out.println("Invalid direction. Staying in room " + room);
                    }
                    break;
                case 5: // Room 2
                    System.out.println("You are in room 5, You reached the gold. YOU WON!!!");
                    direction = scanner.nextLine().trim().toLowerCase();
                    if ("west".equals(direction)) {
                        room = 4;
                    } else {
                        System.out.println("Invalid direction. Staying in room " + room);
                    }
                    break;
            } // End of switch
        } // End of game loop
    } // End of main

    // Monster generator function
    public static String generateMonster() {
        Random rand = new Random();
        String[] names = {"Goblin", "Skeleton", "Orc"};
        int index = rand.nextInt(names.length);
        return names[index];
    }

    public static String generateItem() {
        Random rand = new Random();
        String[] items = {"apple", "eye", "banana"};
        int index = rand.nextInt(items.length);
        System.out.println("A wild " + items[index] + " appears!");
        return items[index];
    }


    // Battle system function
    public static void fightMonster(String monster) {
        Random rand = new Random();
        int damage = 0;
        if (inventory[0] == "sword") {
            damage = rand.nextInt(10) + 34; // Simulates damage dealt

        }
        else {
            damage = rand.nextInt(10) + 5; // Simulates damage dealt

        }
        System.out.println("A wild " + monster + " appears!");
        System.out.println("You deal " + damage + " damage and defeat the " + monster + "!");


    }
}
