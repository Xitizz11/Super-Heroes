public class SuperheroRoster {
    public static void main(String[] args) {
        // 1. Declare and initialize arrays for hero names, abilities, and power levels
        String[] heroNames = {"Bat Man", "Spider Man", "Iron Man ", "Thor", "Super Man"};
        String[] abilities = {"Web-slinging", "Flying and high-tech armor", "Stealth and combat", 
                             "Lightning control", "Super strength and shield combat"};
        int[] powerLevels = {85, 90, 80, 95, 88};
        
        // 2. Print each hero's details using a loop
        System.out.println("HERO ROSTER (ARRAY-BASED):");
        System.out.println("------------------------");
        for (int i = 0; i < heroNames.length; i++) {
            System.out.println("Hero: " + heroNames[i]);
            System.out.println("Ability: " + abilities[i]);
            System.out.println("Power Level: " + powerLevels[i]);
            System.out.println("------------------------");
        }
        
        // 3. Call the searchHero method to find a specific hero by name
        System.out.println("\nSEARCH RESULTS:");
        searchHero(heroNames, abilities, powerLevels, "Thor");
        searchHero(heroNames, abilities, powerLevels, "Hulk");
        
        // 4. Calculate and display the average power level
        double avgPower = calculateAveragePower(powerLevels);
        System.out.println("\nAverage Power Level: " + avgPower);
        
        // Create an array of Superhero objects
        System.out.println("\nHERO ROSTER (OBJECT-BASED):");
        System.out.println("------------------------");
        Superhero[] heroes = new Superhero[5];
        heroes[0] = new Superhero("Bat Man", "Strong and flying", 80);
        heroes[1] = new Superhero("Spider Man", "Web-slinging", 85);
        heroes[2] = new Superhero("Iron Man", "Flying and high-tech armor", 90);
        heroes[3] = new Superhero("Thor", "Lightning control", 95);
        heroes[4] = new Superhero("Super Man", "Super strength and laser", 96);
        
        // Display heroes using the displayHero method
        for (Superhero hero : heroes) {
            hero.displayHero();
        }
        
        // Optional: Sort heroes by power level (descending)
        sortHeroesByPower(heroes);
        
        System.out.println("\nHEROES SORTED BY POWER LEVEL (DESCENDING):");
        System.out.println("------------------------");
        for (Superhero hero : heroes) {
            hero.displayHero();
        }
    }
    
    // Method: searchHero
    public static void searchHero(String[] names, String[] abilities, int[] powerLevels, String target) {
        boolean found = false;
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(target)) {
                System.out.println("Hero found: " + names[i]);
                System.out.println("Ability: " + abilities[i]);
                System.out.println("Power Level: " + powerLevels[i]);
                System.out.println("------------------------");
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("Hero not found: " + target);
            System.out.println("------------------------");
        }
    }
    
    // Method: calculateAveragePower
    public static double calculateAveragePower(int[] powerLevels) {
        if (powerLevels.length == 0) {
            return 0;
        }
        
        int sum = 0;
        for (int power : powerLevels) {
            sum += power;
        }
        
        return (double) sum / powerLevels.length;
    }
    
    // Optional: Method to sort heroes by power level (descending)
    public static void sortHeroesByPower(Superhero[] heroes) {
        for (int i = 0; i < heroes.length - 1; i++) {
            for (int j = 0; j < heroes.length - i - 1; j++) {
                if (heroes[j].getPowerLevel() < heroes[j + 1].getPowerLevel()) {
                    // Swap heroes
                    Superhero temp = heroes[j];
                    heroes[j] = heroes[j + 1];
                    heroes[j + 1] = temp;
                }
            }
        }
    }
}
