package star_trek;

import java.util.List;

public class Cadet extends StarFleetOfficer {
    // implicitly here due to inheritance
//    protected String name;
//    protected double experienceLevel;
//    protected String rank;

    //new class field just for the child class
    private int gradeLevel; //1st grade, 2nd etc.

    public Cadet(String name) {
        this(name, 1, 3.14);
    }

    public Cadet(String name, int gradeLevel, double exp){
        // use constructor from the parent
        super(name, exp, "Cadet");

        //


        this.gradeLevel = gradeLevel;
    }

    @Override
    public void setExperienceLevel(List<String> missionHistory){
        //first option rewrite from scratch
//        this.experienceLevel += 3.14;
//        System.out.println("This officer has gained experience!");

        //second option, build off of the parent's code
        super.setExperienceLevel(missionHistory); //first execute code from parent

        if (this.experienceLevel > 100){
            this.gradeLevel += 1;
            this.experienceLevel = 0;
        }
    }


}