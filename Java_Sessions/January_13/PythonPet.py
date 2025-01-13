# noinspection PyPep8Naming
class Pet:
    def __init__(self, petSpecies, petName = "un-named pet",  petAge = 1):
        self.name = petName
        self.species = petSpecies
        self.age = petAge

    def getName(self):
        return self.name

    def getSpecies(self):
        return self.species

    def getAge(self):
        return self.age

    def setSpecies(self, newSpecies):
        self.species = newSpecies
