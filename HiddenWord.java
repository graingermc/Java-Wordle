public class HiddenWord {
    private String word;

    public HiddenWord(String puzzWord){
        word = puzzWord;
    }
    public String getWord(){
        return word;
    }


    public String getHint(String guessWord){
        char[] hintArr = new char[5];
        char[] tempWord = new char[5];



        for(int i = 0; i < 5; i++){
            tempWord[i] = word.charAt(i);
            hintArr[i] = '0';
        }

        //check for characters that are correct
        for(int i = 0; i < 5; i++){
            if(guessWord.charAt(i) == tempWord[i]){
                hintArr[i] = guessWord.charAt(i);
                tempWord[i] = '!';
            }
        }
        //check for characters that are in the word but arent correct or are not in the word at all
        for(int i = 0; i < 5; i++){
            boolean hintFilled = true;
            if(guessWord.charAt(i) != tempWord[i]){
                for(int g = 0; g < 5; g++){
                    if(guessWord.charAt(i) == tempWord[g] && hintArr[i] == '0'){
                        hintFilled = true;
                        hintArr[i] = '+';
                        tempWord[g] = '!';
                        break;
                    }
                    //letter is not in the word
                    else if(hintArr[i] == '0')
                        hintFilled = false;
                }
            }
            if(hintFilled == false)
                hintArr[i] = '*';
        }

        String hint = "";
        for(int i = 0; i < 5; i++){
            hint += hintArr[i];
        }
        return hint;
    }



    public boolean checkCorrect(String guessWord){
        if(guessWord.equals(word))
            return true;
        return false;
    }
}
