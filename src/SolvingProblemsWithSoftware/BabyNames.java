
/**
 * Write a description of Part1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
public class Part1 {
    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int girlBirths = 0;
        int boyBirths = 0;
        for (CSVRecord rec: fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                boyBirths += numBorn;
            } else  {
                girlBirths += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("total girl births = " + girlBirths);
        System.out.println("total boy births = " + boyBirths);
    }

    public void testTotalBirths() {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

    public int getRank(int year, String name, String gender) {
        int rank = 0;
        FileResource fr = new FileResource("us_babynames_by_year/yob" + year + ".csv");

        for (CSVRecord rec: fr.getCSVParser(false)) {
            String thisName = rec.get(0);
            String thisGender = rec.get(1);
            if (thisGender.equals(gender)){
                rank++;
                if (thisName.equals(name)) {
                    return rank;
                }
            }
        }
        return -1;
    }

    public void testGetRank() {
        int year = 1971;
        String name = "Frank";
        String gender = "M";
        System.out.println("Rank = " + getRank(year, name, gender));
    }

    public String getName (int year, int rank, String gender) {
        FileResource fr = new FileResource("us_babynames_by_year/yob" + year + ".csv");
        int currentRank = 0;

        for(CSVRecord rec: fr.getCSVParser(false)) {
            String thisGender = rec.get(1);
            if (thisGender.equals(gender)) {
                currentRank++;
                if (currentRank == rank) {
                    return rec.get(0);
                }
            }
        }
        return "NO NAME";
    }

    public void testGetName() {
        System.out.println("The name at this rank is: " + getName(1982, 450, "M"));
    }

    public void whatIsNameInYear (String name, int year, int newYear, String gender) {
        int rank = getRank(year, name, gender);
        String newName = getName(newYear, rank, gender);
        System.out.println(name + " was born in " + year + " would be " + newName + " if they were born in " + newYear);
    }

    public int yearOfHighestRank (String name, String gender) {
        int highestRank = Integer.MAX_VALUE;
        int highestYear = -1;
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()) {
            String yearS = f.getName().substring(3,7);
            int year = Integer.parseInt(yearS);
            int currentRank = getRank(year, name, gender);
            if (currentRank != -1 && currentRank < highestRank) {
                highestRank = currentRank;
                highestYear = year;
            }
        }
        return highestYear;
    }

    public void testYearOfHighestRank () {
        System.out.println("The year with the highest rank is: " + yearOfHighestRank("Mich", "M"));
    }

    public double getAverageRank (String name, String gender) {
        double avgRank = 0.0;
        int count = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()) {
            count++;
            String yearS = f.getName().substring(3,7);
            int year = Integer.parseInt(yearS);
            avgRank += (double) getRank(year, name, gender);
        }
        return avgRank / count;
    }

    public void testGetAverageRank () {
        System.out.println("The average rank of the selected files is: " + getAverageRank("Susan", "F"));
        System.out.println("The average rank of the selected files is: " + getAverageRank("Robert", "M"));
    }

    public int getTotalBirthsRankedHigher (int year, String name, String gender) {
        int totalBirths = 0;
        int nameRank = getRank(year, name, gender);
        int currentRank = 0;
        FileResource fr = new FileResource("us_babynames_by_year/yob" + year + ".csv");
        for (CSVRecord rec: fr.getCSVParser(false)) {
            String thisGender = rec.get(1);
            if (thisGender.equals(gender)) {
                int thisBirth = Integer.parseInt(rec.get(2));
                currentRank = getRank(year, rec.get(0), gender);
                if (currentRank < nameRank) {
                    totalBirths += thisBirth;
                }
            }
        }
        if (totalBirths > 0) {
            return totalBirths;
        }else {
            return -1;
        }
    }

    public void testGetTotalBirthsRankedHigher () {
        System.out.println("The total births ranked higher than Emily is: " + getTotalBirthsRankedHigher(1990, "Emily", "F"));
    }
}
