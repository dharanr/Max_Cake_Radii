import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class CakeRadii {
    public static void main(String[] args) {
        // DYNAMIC INPUTS
        // Scanner sc = new Scanner(System.in);
        // // Input - no of cakes
        // int n = sc.nextInt();

        // // Input - Cake's radii
        // Double[] arr = new Double[n];
        // HashSet<Double> uniqueSet = new HashSet<>();
        // for (int i = 0; i < n; i++) {
        // arr[i] = getArea(sc.nextInt());
        // uniqueSet.add(arr[i]);
        // }

        // // Input - Welcoming guests
        // int guests = sc.nextInt();
        // sc.close();

        // IN MEMORY INPUTS
        // ----------------------------------------------------------------------------------------------------
        int n = 6;
        int[] inputs = { 1, 1, 1, 2, 2, 3 };
        int guests = 6;

        // automation - Input 2
        // int n = 3;
        // int[] inputs = { 4, 3, 3 };
        // int guests = 3;

        // automation - Input 3
        // int n = 1;
        // int[] inputs = { 5 };
        // int guests = 5;

        // Calculate Area and store
        Double[] arr = new Double[n];
        HashSet<Double> uniqueSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            arr[i] = getArea(inputs[i]);
            uniqueSet.add(arr[i]);
        }
        // -----------------------------------------------------------------------------------------------------

        // Sorting the array
        Arrays.sort(arr);

        // Calculate max radii
        System.out.println(maxCakeRadii(arr, guests));
    }

    // Method to Calculate maxCakeRadii
    private static Double maxCakeRadii(Double[] arr, int guests) {
        Double max = Double.MIN_VALUE;

        //For Each Cake (Bigger to Smaller)
        for (int i = arr.length - 1; i >= 0; i--) {
            Double element = arr[i];
            
            //If the element is not greater than the max radius achieved
            if (element < max)
                break;

            // Full split - for all guests
            max = Math.max(max, arr[i] / guests);

            // cutting the cake for the desired no of guests
            int guestsToHandle = guests - 1;
            
            while (guestsToHandle != 0) {
                // Current Area - Aiming for the BIGGER radius than the previous one :)
                Double radii = element / guestsToHandle;
                if (radii < max) { 
                    guestsToHandle--;
                    continue; //avoid
                }

                // Traverse right
                int right = Traverse(arr, i, radii, false, guests, guestsToHandle);

                // Traverse left
                int total = right;
                if (total < guests) {
                    total = Traverse(arr, i, radii, true, guests, total);
                }

                // Get the total count to ensure we can serve all the guests
                if (total >= guests) {
                    max = radii;
                } else {
                    break;
                }

                // compromise guests count
                guestsToHandle--;
            }
        }

        // returning max by cutting of the extra digits
        return (double) Math.round(max * 100000d) / 100000d;
    }

    // Traverse
    private static int Traverse(Double[] arr, int index, Double minRadii, boolean isLeft, int guests,
            int guestsHandled) {

        // Transition
        index = (isLeft) ? --index : ++index;

        // Base Case
        if ((isLeft && index == -1)
                || (!isLeft && index == arr.length)
                || (arr[index] < minRadii)
                || (guestsHandled >= guests))
            return guestsHandled;

        // Recursion
        guestsHandled += arr[index] / minRadii;
        guestsHandled = Traverse(arr, index, minRadii, isLeft, guests, guestsHandled);
        return guestsHandled;
    }

    // Helpers
    private static Double getArea(int x) {
        return 3.14159265359 * x * x;
    }
}
