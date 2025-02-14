package recursion;

public class SkipString {

    public static void main(String[] args) {
        System.out.println(skipString("baccappledapplea", "apple"));
    }

    private static String skipString(String s, String target) {
        if (s.isEmpty()) {
            return "";
        }

        String result = "";

        if (s.startsWith(target)) {
            return skipString(s.substring(target.length()), target);
        } else {
            result += s.charAt(0);
        }


        return result + skipString(s.substring(1), target);
    }
}
