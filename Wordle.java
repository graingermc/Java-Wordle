import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Wordle {
    public static void main(String[] args) throws Exception{
        int randLine = (int) Math.floor(Math.random() * 821) + 1;

        String puzzleWord = Files.readAllLines(Paths.get("Words.txt")).get(randLine);

        HiddenWord puzzle = new HiddenWord(puzzleWord);
        boolean[] foundChecker;
        Scanner reader = new Scanner(System.in);
        boolean wordGuessed = false;

        int i = 1;
        while(wordGuessed == false && i <= 5){
            System.out.print("Guess " + i + ": ");
            String guess = reader.nextLine();

            if(guess.length() != 5){
                System.out.println("That guess is not the right length. Guess must be five letters long.");
            }
            if(guess.length() == 5){
                System.out.println("Hint: " + puzzle.getHint(guess));
                System.out.println("------------------");
                i++;
            }
            if(puzzle.checkCorrect(guess) == true){
                System.out.println("You got it! The word was " + guess + ".");
                System.out.println("------------------------");
                wordGuessed = true;
            }
        }

        if(wordGuessed == false){
            System.out.println("So close! The word was " + puzzle.getWord() + ".");
            System.out.println("----------------------");
        }
    }
}
