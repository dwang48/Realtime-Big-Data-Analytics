package mr;

import com.google.common.base.Splitter;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<String> tokenize(String line, String splitters){
        Splitter tokenizer = Splitter.on(splitters).omitEmptyStrings().trimResults();
        Iterable<String> tokens = tokenizer.split(line);
        ArrayList<String> tokenList = new ArrayList<String>();
        for(String str : tokens){
            tokenList.add(str);
        }
        return tokenList;
    }
}
