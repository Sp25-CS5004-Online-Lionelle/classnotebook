package star_trek;

public interface IReport {
    double getStarDate();

    double getAuthorName();

    double getDetails();

    void prettyPrintReport();

    String toCSV();
}
