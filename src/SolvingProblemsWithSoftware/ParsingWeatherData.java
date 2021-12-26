
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
    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord coldestSoFar = null;
        for (CSVRecord currentRow : parser) {
            coldestSoFar = getColdestOfTwo(currentRow, coldestSoFar);
        }
        return coldestSoFar;
    }

    public void testColdestHourInFile() {
        FileResource fr = new FileResource("E:/Projects/JavaPractice/Duke OOP/Week 3/nc_weather/2015/weather-2015-01-01.csv");
        CSVRecord coldest = coldestHourInFile(fr.getCSVParser());
        System.out.println("coldest temperature was " + coldest.get("TemperatureF") + " at " + coldest.get("TimeEST"));
    }

    public String fileWithColdestTemperature() {
        CSVRecord coldest = null;
        String coldestFile = "";
        double smallest = 99.0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if (coldest == null) {
                coldest = currentRow;
            } else {
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double coldestTemp = Double.parseDouble(coldest.get("TemperatureF"));

                if (currentTemp == -9999) {
                    currentTemp = coldestTemp;
                }
                if (currentTemp < coldestTemp) {
                    coldest = currentRow;
                    coldestFile = f.getPath();

                }
            }


        }
        return coldestFile;
    }

    public CSVRecord getColdestOfTwo(CSVRecord currentRow, CSVRecord coldestSoFar) {
        if (coldestSoFar == null) {
            coldestSoFar = currentRow;
        } else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double coldestTemp = Double.parseDouble(coldestSoFar.get("TemperatureF"));
            if (currentTemp < coldestTemp) {
                coldestSoFar = currentRow;
            }
        }
        return coldestSoFar;
    }

    public void testfileWithColdestTemperature() {
        String coldest = fileWithColdestTemperature();
        FileResource fr = new FileResource(coldest);
        CSVRecord coldestTemp = coldestHourInFile(fr.getCSVParser());

        System.out.println("Coldest day was in the file " + coldest);
        System.out.println("Coldest temperature on that day was " + coldestTemp.get("TemperatureF"));
        System.out.println("All the temperatures on the coldest day were: ");
        for (CSVRecord current : fr.getCSVParser()) {
            System.out.println(current.get("DateUTC") + ": " + current.get("TemperatureF"));
        }
    }

}
