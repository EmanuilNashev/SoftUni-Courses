package ForLoop.MoreExercises;

public class Clock {
    public static void main(String[] args) {
        int hour = 0;
        int min = 0;

        for (int i = 0; i < 1440; i++) {
            System.out.println(hour + " : " + min);
            min++;

            if (min == 60){
                min = 0;
                hour++;
            }
        }
    }
}
