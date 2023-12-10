import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("hw seminar four");
        int[] arrayA = new int[]{1, 2, 3, 4, 5};
        int[] arrayB = new int[]{11, 12, 13, 14, 15};
        System.out.println(getPearson(arrayA, arrayB));

    }

    public static double getPearson(int[] arrayA, int[] arrayB) {
        if (arrayA.length != arrayB.length) {
            throw new RuntimeException("arrays length must be equal");
        }
        double averageA = average(arrayA);
        double averageB = average(arrayB);
        double divident = 0;
        double divider = 0;
        for (int i = 0; i < arrayA.length; i++) {
            double deviationFromTheAverageA = arrayA[i] - averageA;
            double deviationFromTheAverageB = arrayB[i] - averageB;
            divident += deviationFromTheAverageA * deviationFromTheAverageB;
            divider += (deviationFromTheAverageA * deviationFromTheAverageA) *
                    (deviationFromTheAverageB * deviationFromTheAverageB);
        }
        return divident / Math.sqrt(divider);
    }

    public static double average(int[] array) {
        return (double) Arrays.stream(array).sum() / array.length;
    }

}
