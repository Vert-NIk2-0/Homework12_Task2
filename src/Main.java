import java.util.*;
import java.util.concurrent.*;

public class Main {
    private static final List<Integer> MASS = new ArrayList<>();
    private static final List<Integer> RESULTS = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();

        main.fillingArray();
        ExecutorService executor = Executors.newFixedThreadPool(5);
        ComputingClass task = new ComputingClass(MASS);

        Future<Integer> future1 = executor.submit(task);
        Future<Integer> future2 = executor.submit(task);
        Future<Integer> future3 = executor.submit(task);
        Future<Integer> future4 = executor.submit(task);
        Future<Integer> future5 = executor.submit(task);

        try {
            RESULTS.add(future1.get());
            RESULTS.add(future2.get());
            RESULTS.add(future3.get());
            RESULTS.add(future4.get());
            RESULTS.add(future5.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executor.shutdown();
        main.printResults();
    }

    private void fillingArray() {
        Random rand = new Random();
        int numberOfElements = 10;
        validateNumberOfElements(numberOfElements);//Кол-во элементов массива
        for (int i = 0; i < numberOfElements; i++) {
            MASS.add(rand.nextInt(101));         //Размер элементов массива
            System.out.print(MASS.get(i) + " ");
            if (i % 10 == 9) {
                System.out.println();
            }
        }
        if (MASS.size() < 10) {
            System.out.println();
        }
    }

    private void validateNumberOfElements(int numberOfElements) {
        if (numberOfElements < 5) {
            throw new InvalidNumberOfElements("Number of elements must be at least 5");
        }
    }

    private void printResults() {
        if (RESULTS.stream().max(Integer::compareTo).isPresent()) {
            System.out.println("Result: " + RESULTS.stream().max(Integer::compareTo).get());
        }
    }
}