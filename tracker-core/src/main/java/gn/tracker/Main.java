package gn.tracker;

import com.fasterxml.jackson.core.JsonProcessingException;
import gn.dto.Point;

public class Main {
    public static void main(String... args) throws Exception {
        for (int i=0; i<5; i++) {
            extractedMethod(45, false);
        }
    }

    private static void extractedMethod(int lat, boolean isTrust) throws JsonProcessingException, InterruptedException {
        System.out.println("Main.main say Hello!!!!");
        Point point = new Point();
        point.setLat(lat, isTrust);
        System.out.println(point.toJson());
        Thread.sleep(1000);
    }
}
