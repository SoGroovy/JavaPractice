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

    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord lowestHumidity = null;
        for (CSVRecord currentRow : parser) {
            String currentH = currentRow.get("Humidity");
            if (lowestHumidity == null) {
                lowestHumidity = currentRow;
            } else if (currentH == "N/A") {
                continue;
            } else {
                int currentHumidity = Integer.parseInt(currentRow.get("Humidity"));
                int lowHumidity = Integer.parseInt(lowestHumidity.get("Humidity"));
                if (currentHumidity < lowHumidity) {
                    lowestHumidity = currentRow;
                }
            }
        }
        return lowestHumidity;
    }

    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }

    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord lowestHumidityInMany = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            String currentH = currentRow.get("Humidity");
            if (lowestHumidityInMany == null) {
                lowestHumidityInMany = currentRow;
            } else if (currentH == "N/A") {
                continue;
            } else {
                int currentHumidity = Integer.parseInt(currentRow.get("Humidity"));
                int lowHumidity = Integer.parseInt(lowestHumidityInMany.get("Humidity"));
                if (currentHumidity < lowHumidity) {
                    lowestHumidityInMany = currentRow;
                }
            }
        }
        return lowestHumidityInMany;
    }


    public void testlowestHumidityInManyFiles() {
        CSVRecord csv = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }

    public double averageTemperatureInFile(CSVParser parser) {
        double avgTemp = 0.0;
        double count = 0.0;
        for (CSVRecord currentRow : parser) {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            avgTemp += currentTemp;
            count++;
        }
        return avgTemp / count;
    }

    public void testaverageTemperatureInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avgTemp = averageTemperatureInFile(parser);
        System.out.println("Average temperature in file is " + avgTemp);

    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double avgTempWithHH = 0.0;
        double count = 0.0;
        for (CSVRecord currentRow : parser) {
            double currentHumidity = Double.parseDouble(currentRow.get("Humidity"));
            if (currentHumidity >= value) {
                count++;
                avgTempWithHH += Double.parseDouble(currentRow.get("TemperatureF"));
            }
        }
        return avgTempWithHH / count;
    }

    public void testaverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double avgTempWithHH = averageTemperatureWithHighHumidityInFile(parser, 80);
        if (avgTempWithHH == 0.0) {
            System.out.println("No temperatures with that humidity");
        } else {
            System.out.println("Average Temp when high Humidity is " + avgTempWithHH);
        }
    }
}
