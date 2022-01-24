package ArraysListsData.Week3;
import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<LogEntry>();
    }

    public void readFile(String filename) {
        FileResource fr = new FileResource(filename);
        for (String line : fr.lines()) {
            records.add(WebLogParser.parseEntry(line));
        }
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

    public int countUniqueIPs() {
        ArrayList<String> newIPs = new ArrayList<String>();
        for (LogEntry le : records) {
            String currentIp = le.getIpAddress();
            if (!newIPs.contains(currentIp)) {
                newIPs.add(currentIp);
            }
        }

        return newIPs.size();
    }

    public void printAllHigherThanNum(int num) {
        for (LogEntry le : records) {
            int currentStatusCode = le.getStatusCode();
            if (currentStatusCode > num) {
                System.out.println(currentStatusCode);
            }
        }
    }

    public ArrayList uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> newVisits = new ArrayList<String>();
        for (LogEntry le : records) {
            String day = le.getAccessTime().toString();
            String currentIp = le.getIpAddress();
            if (day.contains(someday) && !newVisits.contains(currentIp)) {
                newVisits.add(currentIp);
            }
        }
        System.out.println(newVisits.size());
        return newVisits;
    }

    public int countUniqueIPsInRange(int low, int high) {
        ArrayList<String> newVisits = new ArrayList<String>();
        for (LogEntry le : records) {
            String currentIp = le.getIpAddress();
            int statusCode = le.getStatusCode();
            if (!newVisits.contains(currentIp) && statusCode >= low && statusCode <= high) {
                newVisits.add(currentIp);
            }
        }

        return newVisits.size();
    }

    public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> counts = new HashMap<String, Integer>();

        for (LogEntry le : records) {
            String ip = le.getIpAddress();
            if (!counts.containsKey(ip)) {
                counts.put(ip, 1);
            } else {
                counts.put(ip, counts.get(ip) + 1);
            }
        }
        return counts;
    }

    public int mostNumberVisitsByIP(HashMap<String, Integer> counts) {
        int mostVisits = 0;
        for (String key : counts.keySet()) {
            if (counts.get(key) > mostVisits) {
                mostVisits = counts.get(key);
            }
        }
        return mostVisits;
    }

    public ArrayList<String> iPsMostVisits(HashMap<String, Integer> counts) {
        ArrayList<String> ips = new ArrayList<String>();
        int mostVisits = mostNumberVisitsByIP(counts);
        for (String key : counts.keySet()) {
            if (counts.get(key) == mostVisits) {
                ips.add(key);
            }
        }
        return ips;
    }
}