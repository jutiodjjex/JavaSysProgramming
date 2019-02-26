
import java.util.regex.Pattern;

public class SmileReplacer{

    private static Pattern pattern = Pattern.compile("[=][)]");

    protected static String smileReplacer(String stringForReplace){
            pattern.matcher(stringForReplace);
            stringForReplace = stringForReplace.replaceAll(pattern.toString(), "=-)");
            return stringForReplace;
    }
}
