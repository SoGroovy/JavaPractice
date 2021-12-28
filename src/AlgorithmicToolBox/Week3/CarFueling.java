package AlgorithmicToolBox.Week3;

import java.util.Scanner;

public class CarFueling {
    static int computeMinRefills(int dist, int tank, int[] stops) {
        int currentStop = 0;
        int numRefills = 0;
        int[] everyStop = new int[stops.length + 2];
        for(int i = 0; i < stops.length; i++) {
            everyStop[i + 1] = stops[i];
        }
        everyStop[stops.length + 1] = dist;

        if(tank > dist) {
            return 0;
        }

        while(currentStop < everyStop.length) {
            int previousStop = currentStop;
            while (currentStop < everyStop.length - 1 && tank >= everyStop[currentStop + 1] - everyStop[previousStop]){
                currentStop++;
            }
            if(currentStop == previousStop) {
                return -1;
            }

            if(currentStop == everyStop.length - 1) {
                break;
            }

            numRefills++;
        }
        return numRefills;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}

