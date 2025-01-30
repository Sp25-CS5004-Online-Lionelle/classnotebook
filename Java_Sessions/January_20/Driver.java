import star_trek.ICrewMember;
import star_trek.KlingonOfficer;
import star_trek.StarFleetOfficer;

import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        StarFleetOfficer belanna = new StarFleetOfficer("B'Elanna", 3.33, "Chief Engineer");
        KlingonOfficer martok = new KlingonOfficer("Martok", 9.9, "General");

        //calling method with parameters of different datatypes
        exampleMethodONE(belanna);
        exampleMethodONE(martok);

        System.out.println("----------------");

        exampleMethodTWO(belanna);
        //exampleMethodTWO(martok); //NOT ALLOWED

        ICrewMember janeway = new StarFleetOfficer("Janeway", 5.55, "Captain");
        //exampleMethodTWO(janeway); //NOT ALLOWED
    }

    public static void exampleMethodONE(ICrewMember crewMember){
        System.out.println(crewMember.getName());

        // NOT ALLOWED
        // because ICrewMembers don't have this method, only StarfleetOfficer objects have setExperienceLevel()
//        String[] missionHistory = ["captain", "2.3"];
//        crewMember.setExperienceLevel();
    }

    public static void exampleMethodTWO(StarFleetOfficer sfOfficer){
        System.out.println(sfOfficer.getName());

        ArrayList<String> exampleMission = new ArrayList<>();
        exampleMission.add("captain"); //rank
        exampleMission.add("5.7"); //num hours

        //this is allowed since param is explicitly a Starfleet Officer
        sfOfficer.setExperienceLevel(exampleMission);
    }

    public static void exampleMethodTHREE(ICrewMember crewMember){
        //PSEUDO CODE SINCE I FORGOT THE SYNTAX (OOPS)

        //if crewMember is a star_trek.StarFleetOfficer
        //        //use a method that only StarFleetOfficer objects have
        //        crewMember.setExperienceLevel(exampleMission);

        //elif crewMember is a star_trek.KlingonOfficer
        //        //use a method only KlingonOfficer objects have
        //        crewMember.train(exampleTraining);

    }
}
