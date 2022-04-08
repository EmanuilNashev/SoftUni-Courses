package ForLoop.MoreExercises;

public class ClockPart2 {
    public static void main(String[] args) {
        int hour = 0;
        int min = 0;
        int second = 0;

        for (int i = 0; i < 86400; i++) {

            System.out.println(hour + " : " + min + " : " + second);
            second++;

            if (second == 60){
                min ++;
                second = 0;
            }
            if (min == 60){
                hour++;
                min = 0;
            }

        }
    }
}
