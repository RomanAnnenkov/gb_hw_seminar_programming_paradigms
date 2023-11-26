import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("hw seminar one");

        List<Integer> intList = getRandomIntegerList(10, 1, 100);
        System.out.println("Before sort: " + intList);
        sortImperative(intList);
        System.out.println("After sort: " + intList);
        System.out.println();

        intList = getRandomIntegerList(10, 1, 100);
        System.out.println("Before sort: " + intList);
        sortDeclarative(intList);
        System.out.println("After sort: " + intList);

    }

    public static void sortImperative(List<Integer> intList) {
        int unsortedListSize = intList.size();
        while (unsortedListSize > 0) {
            for (int i = 0; i < unsortedListSize - 1; i++) {
                int currentElement = intList.get(i);
                int nextElement = intList.get(i + 1);
                if (currentElement > nextElement) {
                    intList.set(i + 1, currentElement);
                    intList.set(i, nextElement);
                }
            }
            unsortedListSize -= 1;
        }
    }

    public static void sortDeclarative(List<Integer> intList) {
        Collections.sort(intList);
    }

    public static List<Integer> getRandomIntegerList(int size, int leftBorder, int rightBorder) {
        List<Integer> result = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            result.add(rnd.nextInt(leftBorder, rightBorder + 1));
        }
        return result;
    }

}
