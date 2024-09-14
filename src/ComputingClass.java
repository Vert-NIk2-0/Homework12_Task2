import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class ComputingClass implements Callable<Integer> {
    private static List<Integer> mass = new ArrayList<>();

    public ComputingClass(List<Integer> mass) {
        ComputingClass.mass.addAll(mass);
    }

    @Override
    public Integer call() {
        StringBuilder stringBuilder = new StringBuilder(Thread.currentThread().getName());
        switch (Integer.parseInt(stringBuilder.substring(stringBuilder.length() - 1, stringBuilder.length())) - 1) {
            case 0:
                Integer max = Collections.max(mass.subList(0, mass.size() / 5));
                System.out.println(mass.subList(0, mass.size() / 5) + "   " + Thread.currentThread().getName() + ", Max value: " + max);
                return max;
            case 1:
                Integer max1 = Collections.max(mass.subList(mass.size() / 5, mass.size() * 2 / 5));
                System.out.println(mass.subList(mass.size() / 5, mass.size() * 2 / 5) + "   " + Thread.currentThread().getName() + ", Max value: " + max1);
                return max1;
            case 2:
                Integer max2 = Collections.max(mass.subList(mass.size() * 2 / 5, mass.size() * 3 / 5));
                System.out.println(mass.subList(mass.size() * 2 / 5, mass.size() * 3 / 5) + "   " + Thread.currentThread().getName() + ", Max value: " + max2);
                return max2;
            case 3:
                Integer max3 = Collections.max(mass.subList(mass.size() * 3 / 5, mass.size() * 4 / 5));
                System.out.println(mass.subList(mass.size() * 3 / 5, mass.size() * 4 / 5) + "   " + Thread.currentThread().getName() + ", Max value: " + max3);
                return max3;
            case 4:
                Integer max4 = Collections.max(mass.subList(mass.size() * 4 / 5, mass.size()));
                System.out.println(mass.subList(mass.size() * 4 / 5, mass.size()) + "   " + Thread.currentThread().getName() + ", Max value: " + max4);
                return max4;
        }
        return 0;
    }
}
