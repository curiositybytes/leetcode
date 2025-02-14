package recursion;

public class SkipCharacter {

    public static void main(String[] args) {
        System.out.println(skipCharacter("baccad", 'a'));
    }

    private static String skipCharacter(String s, Character c) {
        if (s.isEmpty()) {
            return "";
        }

        String result = "";

        if (s.charAt(0) != c) {
            result += s.charAt(0);
        }

        return result + skipCharacter(s.substring(1), c);
    }
}
