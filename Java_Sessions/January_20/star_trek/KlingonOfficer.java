package star_trek;

import java.util.List;

public class KlingonOfficer implements ICrewMember {
    protected String name;
    protected double strength;
    protected String rank;

    public KlingonOfficer(String name, double strength, String rank){
        this.name = name;
        this.strength = strength;
        this.rank = rank;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void train(List<String> trainingHistory){
        //pretend there's stuff to calculate a number to add to the strength

        System.out.println("This officer has gotten stronger!");
    }

    @Override
    public String getRank() {
        return "";
    }

    @Override
    public void setRank(String rank) {

    }

    @Override
    public IReport writeReport(List<String> personalLog) {
        return null;
    }
}
