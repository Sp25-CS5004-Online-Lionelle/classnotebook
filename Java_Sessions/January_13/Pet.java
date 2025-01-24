public class Pet {
    private String name;
    private String species;
    private int age;
    private int hungerLevel;
    private int thirstLevel;

    //OPTION 1: set all values manually
    /*
    public Pet(String petSpecies){
        this.name = "un-named pet";
        this.species = petSpecies;
        this.age = 1;
        this.hungerLevel = 0;
        this.thirstLevel = 0;
    }
    }

    public Pet(String petSpecies, String petName){
        this.name = petName;
        this.species = petSpecies;
        this.age = 1;
        this.hungerLevel = 0;
        this.thirstLevel = 0;
    }

    public Pet(String petSpecies, String petName, int petAge){
        this.name = petName;
        this.species = petSpecies;
        this.age = petAge;
        this.hungerLevel = 0;
        this.thirstLevel = 0;
    }

    */

    //OPTION 2: use constructor chaining
    public Pet(String petSpecies){
        this(petSpecies, "un-named pet");
    }

    public Pet(String petSpecies, String petName){
        this(petSpecies, petName, 1);
    }

    public Pet(String petSpecies, String petName, int petAge){
        this.species = petSpecies;
        this.name = petName;
        this.age = petAge;
        this.hungerLevel = 0;
        this.thirstLevel = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getSpecies() {
        return this.species;
    }

    public int getAge() {
        return this.age;
    }

    public void setSpecies(String newSpecies) {
        this.species = newSpecies;
    }

    //display to the terminal info about the pet
    public void printPet() {
        System.out.println(this.name + " is a " + this.species);
    }

    @Override
    public String toString(){
        return String.format("%s - %s\tage = %d\thunger level = %d", name, species, age, hungerLevel);
    }

    public int getThirstLevel() {
        return thirstLevel;
    }

    public void setThirstLevel(int thirstLevel) {
        this.thirstLevel = thirstLevel;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}