package Problems;
import java.util.Arrays;
import java.util.List;

public class StringProblems {

    public static String reverseString(String str) {
        String reversedString = "";

        for (int i = str.length() - 1; i >= 0; --i) {
            reversedString += str.charAt(i);
        }

        return reversedString;
    }

    public static int vowelCount(String str) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int vowelCount = 0;

        str = str.toLowerCase(); // convert to lowercase for easy identification of vowels
        
        for (int i = 0; i < str.length(); ++i) {
            for (char vowel : vowels) {
                if (str.charAt(i) == vowel) {
                    vowelCount++;
                }
            }
        }

        return vowelCount;
    }

    public static boolean isPalindrome(String str1) {
        StringBuilder str2 = new StringBuilder();

        for (int i = str1.length() - 1; i >= 0; --i) {
            str2.append(str1.charAt(i));
        }

        return str1.equalsIgnoreCase(str2.toString());
    }

    public static String reverseSentenceWords(String str) {
        StringBuilder sb = new StringBuilder();
        String[] words = str.split("\\s+");

        for (int i = 0; i < words.length; ++i) {
            StringBuilder word = new StringBuilder(words[i]);
            sb.append(word.reverse());
            sb.append(" ");
        }

        return sb.toString();
    }

    public static String removeAllVowels(String str) {
        List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");
        StringBuilder sb = new StringBuilder(str);

        for (int i = sb.length() - 1; i >= 0; --i) {
            if (vowels.contains(String.valueOf(sb.charAt(i)))) {
                sb.deleteCharAt(i);
            }
        }

        return sb.toString();
    }

    public static String removeConsecutiveDuplicateCharacters(String str) {
        StringBuilder sb = new StringBuilder(str);

        for (int i = 1; i < sb.length(); ++i) {
            if (sb.charAt(i) == sb.charAt(i - 1)) {
                sb.deleteCharAt(i);
                --i;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("The quick brown fox jumps over the fence."));
        System.out.println(vowelCount("onomatopoeia"));
        System.out.println(isPalindrome("madam"));
        System.out.println(reverseSentenceWords("The quick brown fox jumps over the fence"));
        System.out.println(removeAllVowels("What a great day to be alive!"));
        System.out.println(removeConsecutiveDuplicateCharacters("aaabbccccccdeeee"));
    }
}
