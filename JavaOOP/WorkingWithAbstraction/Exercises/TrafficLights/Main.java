package OOP.WorkingWithAbstraction.Exercises.TrafficLights;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] signals = scanner.nextLine().split("\\s+");

        List<TrafficLight> trafficLights = new ArrayList<>();

        createAndCollectTrafficLights(signals, trafficLights);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            changeColor(trafficLights);

            printTraficLights(trafficLights);
        }
    }

    private static void printTraficLights(List<TrafficLight> trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            System.out.print(trafficLight + " ");
        }
        System.out.println();
    }

    private static void changeColor(List<TrafficLight> trafficLights) {
        for (TrafficLight trafficLight : trafficLights) {
            trafficLight.changeColor();
        }
    }

    private static void createAndCollectTrafficLights(String[] signals, List<TrafficLight> trafficLights) {
        for (int i = 0; i < signals.length; i++) {
            TrafficLight trafficLight = new TrafficLight(Enum.valueOf(Color.class, signals[i]));
            trafficLights.add(trafficLight);
        }
    }
}
