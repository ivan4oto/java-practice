package gasstations;

import java.util.Scanner;
import java.util.Vector;

public class GasStations {

    public static Vector<Integer> getGasStations(int tripDistance, int tankSize, Vector<Integer> gasStations) {

        Vector<Integer> result = new Vector<Integer>();
        Integer currentDistance = tankSize;
        Integer pointer = 0;
        Integer lastStation = gasStations.get(0);

        do {
            if (currentDistance > tripDistance) {
                return result;
            }

            if (gasStations.get(pointer) <= currentDistance) {
                lastStation = gasStations.get(pointer);

            } else {
                result.add(lastStation);
                currentDistance = lastStation + tankSize;
                lastStation = gasStations.get(pointer);
            }
            
            if (pointer == gasStations.size()-1) {
                result.add(lastStation);
            }
            pointer += 1;
            
        } while (
            pointer < gasStations.size()
        );

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tripDistance = scanner.nextInt();
        int tankSize = scanner.nextInt();
        int gasStationsCount = scanner.nextInt();
        Vector<Integer> gasStations = new Vector<Integer>();

        for (int i = 0; i < gasStationsCount; i++) {
            gasStations.add(scanner.nextInt());
        }


        scanner.close();
        Vector<Integer> result = getGasStations(tripDistance, tankSize, gasStations);

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

    }
}