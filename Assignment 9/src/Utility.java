public class Utility {
    static String[] Repeated(String text) {
        int repeated = 0, mostRepeated = 0;
        String[] arrayText;
        String[] arrayWords;
        String[] mostRepeatedWord = new String[2];
        text = RefactorText(text);
        int numberWords = NumberWords(text);
        arrayText = FillText(text, numberWords);
        arrayWords = FillWords(text, numberWords);
        for (String words : arrayWords) {
            for (String wordsText : arrayText) {
                if (words.equals(wordsText)){
                    repeated++;
                }
            }
            if (repeated > mostRepeated) {
                mostRepeated = repeated;
                mostRepeatedWord[0] = words;
                mostRepeatedWord[1] = String.valueOf(mostRepeated);
            }
            repeated = 0;
        }
        return mostRepeatedWord;
    }

    static String RefactorText(String text) {
        text = text.replace(".", "");
        text = text.replace(",", "");
        text = text.replace("!", "");
        text = text.toLowerCase();
        text += ' ';
        return text;
    }

    static int NumberWords(String text) {
        int numberWords = 0;
        for (int i = 0; i < text.length(); i++) {
            if(text.charAt(i) == ' ')
                numberWords++;
        }
        return numberWords;
    }

    static String[] FillText(String text, int numberWords) {
        StringBuilder createWord = new StringBuilder();
        String[] arrayText = new String[numberWords];
        int posArray = 0;

        for(int i = 0; i < text.length(); i++) {
            if(text.charAt(i) != ' ')
                createWord.append(text.charAt(i));
            else {
                arrayText[posArray++] = String.valueOf(createWord);
                createWord = new StringBuilder();
            }
        }
        return arrayText;
    }

    static String[] FillWords(String text, int numberWords) {
        StringBuilder createWord = new StringBuilder();
        String[] arrayWordsNulls = new String[numberWords];
        int posArray = 0;
        int countNull = 0;

        for (int i = 0; i < text.length(); i++){
            boolean repeated = false;
            if (text.charAt(i) != ' ')
                createWord.append(text.charAt(i));
            else {
                for (String wordsText : arrayWordsNulls) {
                    if (String.valueOf(createWord).equals(wordsText)) {
                        repeated = true;
                        countNull++;
                    }
                }
                if (!repeated) {
                    arrayWordsNulls[posArray++] = String.valueOf(createWord);
                }
                createWord = new StringBuilder();
            }
        }
        String[] arrayWords = new String[numberWords - countNull];
        System.arraycopy(arrayWordsNulls, 0, arrayWords, 0, arrayWords.length);
        return arrayWords;
    }
}