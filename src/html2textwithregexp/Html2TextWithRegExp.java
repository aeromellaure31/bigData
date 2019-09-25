package html2textwithregexp;

import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.text.html.parser.ParserDelegator;
import javax.swing.text.html.HTMLEditorKit.ParserCallback;
import javax.swing.text.html.HTML.Tag;
import javax.swing.text.MutableAttributeSet;

public class Html2TextWithRegExp {

    private Html2TextWithRegExp() {
    }

    public static List<String> extractText(Reader reader) throws IOException {
        final ArrayList<String> list = new ArrayList<String>();

        ParserDelegator parserDelegator = new ParserDelegator();
        ParserCallback parserCallback = new ParserCallback() {
            public void handleText(final char[] data, final int pos) {
                list.add(new String(data));
            }

            public void handleStartTag(Tag tag, MutableAttributeSet attribute, int pos) {
            }

            public void handleEndTag(Tag t, final int pos) {
            }

            public void handleSimpleTag(Tag t, MutableAttributeSet a, final int pos) {
            }

            public void handleComment(final char[] data, final int pos) {
            }

            public void handleError(final java.lang.String errMsg, final int pos) {
            }
        };
        parserDelegator.parse(reader, parserCallback, true);
        return list;
    }

    public static void main(String[] args) throws Exception {
        FileReader reader = new FileReader("mygame.html");
        List<String> lines = Html2TextWithRegExp.extractText(reader);
        int b = lines.size();
        List myList = new ArrayList();
        int counter = 0;

        for (String line : lines) {
            String[] z = line.split(" ");
            for(String x : z){
                System.out.println(x);
            }
        }
    }

}
