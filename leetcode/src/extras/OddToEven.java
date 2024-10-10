package extras;

/**
 * Odd To Even
 *
 * @link <a href="https://www.naukri.com/code360/problems/odd-to-even_1214553?interviewBundleRedirection=true&leftPanelTabValue=PROBLEM">...</a>
 */
public class OddToEven {

    public static void main(String[] args) {
        System.out.println(oddToEven("652345"));
    }

    private static String oddToEven(String num)
    {
        char[] numA = num.toCharArray();
        int lastVal = numA[numA.length-1];
        int lastEvenPos = -1;
        int pos = -1;
        for (int i=0; i<numA.length; ++i) {
            char c = numA[i];
            int val = c - '0';
            if (val%2 == 0) {
                lastEvenPos = i;
                if (val < lastVal) {
                    pos = i;
                    break;
                }
            }
        }

        if (pos != -1) {
            char temp = numA[pos];
            numA[pos] = numA[numA.length-1];
            numA[numA.length-1] = temp;
            String res = new String(numA);
            return res;
        } else if (lastEvenPos != -1) {
            char temp = numA[lastEvenPos];
            numA[lastEvenPos] = numA[numA.length-1];
            numA[numA.length-1] = temp;
            String res = new String(numA);
            return res;
        }

        return "-1";
    }
}
