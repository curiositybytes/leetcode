package extras;

public class DigitCount {
    public static void main(String[] args) {
        long number = -100000;

        // Handle negative numbers
        number = Math.abs(number);

        // Count digits using logarithm
        int digitCount = (number == 0) ? 1 : (int) Math.log10(number) + 1;

        System.out.println("The number of digits is: " + digitCount);
    }
}
