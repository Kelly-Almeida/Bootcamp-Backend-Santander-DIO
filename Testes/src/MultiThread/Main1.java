package MultiThread;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Main1 {

    private final static Queue<Integer> numbers = new LinkedBlockingQueue<>(250_000);

    private static void inc(int number){
        numbers.add(number);
    }

    private static void show(){
        System.out.println(numbers);
    }
    public static void main(String[] args){
        Runnable inc =() -> {
            for (int i = 0; i < 100; i++){
                inc(i);
            }

        };

        Runnable dec = () -> {
            for (int i = 100; i > -100 ; i--){
                inc(i);
            }
        };

        Runnable show = () -> {
            for(int i = 0; i < 250; i++){
                show();
            }
        };

        var exercInc = new Thread(inc);
        exercInc.setName("ExercInc");
        var exercDec  = new Thread(dec);
        exercDec.setName("ExercDec");
        var exercShow = new Thread(show);
        exercShow.setName("ExercShow");

        exercInc.start();
        exercDec.start();
        exercShow.start();

        System.out.println(exercInc.getName());
        System.out.println(exercDec.getName());
        System.out.println(exercShow.getName());
    }
}
