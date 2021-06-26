import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import com.atilika.kuromoji.ipadic.Tokenizer.Builder;

public class KuromojiExampleUserDic{

    public static void main(String[] args) {
        String input = "一風堂のラーメンが食べたい";
        Tokenizer tokenizer = new Tokenizer();
        Builder builder = new Tokenizer.Builder();

        try {
            tokenizer = builder.userDictionary("src/main/userDic.csv").build();
        } catch (IOException e1) {
            System.out.println("独自辞書コンパイルエラー");
        }
        List<Token> tokens = tokenizer.tokenize(input);
        tokens
                .stream()
                .map(e -> e.getSurface()+ " "+ e.getAllFeatures())
                .forEach(System.out::println);

    }

}