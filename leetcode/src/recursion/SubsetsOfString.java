package recursion;

import java.util.ArrayList;

public class SubsetsOfString {

    public static void main(String[] args) {
        printSubsets("", "abc");
        System.out.println(getSubsets("", "abc"));
        System.out.println(getSubsetsWithAscii("", "abc"));
    }

    private static void printSubsets(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char c = up.charAt(0);

        printSubsets(p+c, up.substring(1));
        printSubsets(p, up.substring(1));
    }

    private static ArrayList<String> getSubsets(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> result = new ArrayList<>();
            if (!p.isEmpty()) {
                result.add(p);
            }
            return result;
        }

        char c = up.charAt(0);

        ArrayList<String> left = getSubsets(p+c, up.substring(1));
        ArrayList<String> right = getSubsets(p, up.substring(1));

        left.addAll(right);
        return left;
    }

    private static ArrayList<String> getSubsetsWithAscii(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> result = new ArrayList<>();
            if (!p.isEmpty()) {
                result.add(p);
            }
            return result;
        }

        char c = up.charAt(0);

        ArrayList<String> left = getSubsetsWithAscii(p+c, up.substring(1));
        ArrayList<String> right = getSubsetsWithAscii(p, up.substring(1));
        ArrayList<String> mid = getSubsetsWithAscii(p+ (c+0), up.substring(1));

        left.addAll(right);
        left.addAll(mid);
        return left;
    }
}
