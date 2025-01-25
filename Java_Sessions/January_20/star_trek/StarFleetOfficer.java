package star_trek;

import java.util.List;

public class StarFleetOfficer implements ICrewMember {
    protected String name;
    protected double experienceLevel;
    protected String rank;

    public StarFleetOfficer(String name, double exp, String rank){
        this.name = name;
        this.experienceLevel = exp;
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

    public void setExperienceLevel(List<String> missionHistory){
        //first string in list will always be a rank
        //second string will always be duration
        String rank = missionHistory.get(0);
        Double time = Double.parseDouble(missionHistory.get(1));

        if(rank == "captain"){
            this.experienceLevel += time * 2;
        }else if(rank == "cadet"){
            this.experienceLevel += time * 1.5;
        }

        System.out.println("This officer has gained experience!");
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
