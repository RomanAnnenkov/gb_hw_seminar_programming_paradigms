
public class Main {
    public static void main(String[] args) {
        System.out.println("hw seminar six");
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        System.out.println(binarySearch(array, 115));
    }

    public static int binarySearch(int[] array, int searchNumber) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int halfIndex = array.length / 2;
        while (rightIndex != leftIndex) {
            if (searchNumber == array[halfIndex]) {
                return halfIndex;
            } else if (searchNumber > array[halfIndex]) {
                leftIndex = halfIndex;
                halfIndex = leftIndex + (rightIndex - leftIndex ) / 2 + 1;
            } else {
                rightIndex = halfIndex;
                halfIndex = leftIndex + (rightIndex - leftIndex) / 2;
            }
        }
        return -1;
    }
}
