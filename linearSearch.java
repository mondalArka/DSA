public class linearSearch {
    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 4, 8, 6, 9, 7, 11 };
        int s = 11;
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == s) {
                index = i;
                break;
            }
        }

        if (index == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element" + s + " found at index " + (index + 1));
    }
}