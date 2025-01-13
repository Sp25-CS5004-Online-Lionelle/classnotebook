class Driver {

    public static void main(String[] args) {
        Pet myDog = new Pet("Her Majesty", "dog");
        myDog.printPet();
        System.out.println("now I'm going to change the species for my dog to be chihuahua");
        myDog.setSpecies("chihuahua");
        myDog.printPet();

        Pet friendsCat = new Pet("Cory", "cat");
        friendsCat.printPet();

        // TODO: create a pet object based on someone's pet
//        Pet studentsPet = new Pet("", "");
//        studentsPet.printPet();

    }
}