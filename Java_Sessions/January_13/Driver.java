class OldDriver {

    public static void main(String[] args) {
        Pet myDog = new Pet("dog", "Her Majesty");
        myDog.printPet();
        System.out.println("now I'm going to change the species for my dog to be chihuahua");
        myDog.setSpecies("chihuahua");
        myDog.printPet();

        Pet friendsCat = new Pet("cat", "Cory");
        friendsCat.printPet();

        // TODO: create a pet object based on someone's pet
        Pet studentsPet = new Pet("dog", "Pokemon");
        studentsPet.printPet();

        System.out.println(studentsPet);

    }
}