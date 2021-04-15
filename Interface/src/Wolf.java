import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Wolf extends Animal {
    // The age at which a wolf can start to breed.
    private static final int BREEDING_AGE = 15;
    // The age to which a wolf can live.
    private static final int MAX_AGE = 200;
    // The likelihood of a wolf breeding.
    private static final double BREEDING_PROBABILITY = 0.5;
    // The maximum number of births.
    private static final int MAX_LITTER_SIZE = 4;
    // The food value of a single rabbit. In effect, this is the
    // number of steps a fox can go before it has to eat again.
    private static final int FOX_FOOD_VALUE = 5;
    // A shared random number generator to control breeding.
    private static final Random rand = Randomizer.getRandom();

    // Individual characteristics (instance fields).

    // The wolf's age.
    private int age;

    private int foodLevel;

    public Wolf(boolean randomAge, Field field, Location location)
    {
        super(field, location);
        if(randomAge) {
            age = rand.nextInt(MAX_AGE);
            foodLevel = rand.nextInt(FOX_FOOD_VALUE);
        }
        else {
            age = 0;
            foodLevel = FOX_FOOD_VALUE;
        }
    }

    @Override
    public void act(List<Animal> newWolfs) {
        incrementAge();
        incrementHunger();
        if(isAlive()) {
            giveBirth(newWolfs);
            // Move towards a source of food if found.
            Location location = getLocation();
            Location newLocation = findFood(location);
            if(newLocation == null) {
                // No food found - try to move to a free location.
                newLocation = getField().freeAdjacentLocation(location);
            }
            // See if it was possible to move.
            if(newLocation != null) {
                setLocation(newLocation);
            }
            else {
                // Overcrowding.
                setDead();
            }
        }
    }

    private void incrementAge()
    {
        age++;
        if(age > MAX_AGE) {
            setDead();
        }
    }

    private void incrementHunger()
    {
        foodLevel--;
        if(foodLevel <= 0) {
            setDead();
        }
    }

    private Location findFood(Location location)
    {
        Field field = getField();
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while(it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if(animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if(fox.isAlive()) {
                    fox.setDead();
                    foodLevel = FOX_FOOD_VALUE;
                    // Remove the dead rabbit from the field.
                    return where;
                }
            }
        }
        return null;
    }

    private void giveBirth(List<Animal> newFoxes)
    {
        // New foxes are born into adjacent locations.
        // Get a list of adjacent free locations.
        Field field = getField();
        List<Location> free = field.getFreeAdjacentLocations(getLocation());
        int births = breed();
        for(int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
            Fox young = new Fox(false, field, loc);
            newFoxes.add(young);
        }
    }

    private int breed()
    {
        int births = 0;
        if(canBreed() && rand.nextDouble() <= BREEDING_PROBABILITY) {
            births = rand.nextInt(MAX_LITTER_SIZE) + 1;
        }
        return births;
    }

    private boolean canBreed()
    {
        return age >= BREEDING_AGE;
    }

}
