import java.util.List;

enum Label {
    SPAM,
    NEGATIVE,
    TOO_LONG,
    OK
}

interface TextAnalyzer {
    Label processText(String text);
}

abstract class KeywordAnalyzer implements TextAnalyzer {
    private String[] keywords;

    public KeywordAnalyzer(String[] keywords) {
        this.keywords = keywords;
    }

    public abstract Label getLabel();

    @Override
    public Label processText(String text) {
        for (String word : this.keywords) {
            if (text.contains(word)) {
                return getLabel();
            }
        }

        return Label.OK;
    }
}


class SpamAnalyzer extends KeywordAnalyzer {

    public SpamAnalyzer(String[] keywords) {
        super(keywords);
    }

    @Override
    public Label getLabel() {
        return Label.SPAM;
    }
}

class NegativeTextAnalyzer extends KeywordAnalyzer {

    public NegativeTextAnalyzer() {
        super(new String[]{
                ":(", "=(", ":|"
        });
    }

    @Override
    public Label getLabel() {
        return Label.NEGATIVE;
    }
}


class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength) {
            return Label.TOO_LONG;
        }

        return Label.OK;
    }
}

class Test {
    public Label checkLabels(List<TextAnalyzer> analyzers, String text) {
        for (TextAnalyzer analyzer : analyzers) {
            Label label = analyzer.processText(text);
            if (label != Label.OK) {
                return label;
            }
        }
        return Label.OK;
    }

    public static void main() {
        SpamAnalyzer spamAnalyzer = new SpamAnalyzer(new String[]{"spam", "bad"});
        NegativeTextAnalyzer negativeTextAnalyzer = new NegativeTextAnalyzer();
        TooLongTextAnalyzer tooLongTextAnalyzer = new TooLongTextAnalyzer(20);

        List<TextAnalyzer> analyzers = List.of(spamAnalyzer, negativeTextAnalyzer, tooLongTextAnalyzer);

        Test test = new Test();

        String text = "This is a bad message with spam :(";
        System.out.println(test.checkLabels(analyzers, text));

        text = "This is a sad message :(";
        System.out.println(test.checkLabels(analyzers, text));

        text = "This is a very long message which is definitely more than twenty characters.";
        System.out.println(test.checkLabels(analyzers, text));
    }
}