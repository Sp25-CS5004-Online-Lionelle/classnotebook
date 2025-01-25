package star_trek;

import java.util.List;

public interface ICrewMember {
    String getName();
    void setName(String name);

    String getRank();
    void setRank(String rank);

    IReport writeReport(List<String> personalLog);
}
