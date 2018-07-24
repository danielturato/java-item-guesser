import java.util.Scanner;

public class Prompter {
  
  Scanner scanner = new Scanner(System.in);

  public Jar adminPrompt() {
      System.out.printf("%nADMINISTRATOR SETUP %n=============%n");
      System.out.print("What type of item?  ");
      String item = scanner.nextLine();
      System.out.printf("What is the maximum amount of %s(s)?   ", item);
      int maxNum = scanner.nextInt();
    
      return new Jar(item, maxNum);
      
    }
  
  public void playerPrompt(Jar jar) {
    System.out.printf("%nPLAYER %n================%n");
    System.out.printf("%nHow many %s(s) are in the jar? Pick a number between 1 and %d %n ",
                         jar.getItem(), jar.getMaxItems());
    int guess;
    int tries = 0;
    do {
      System.out.printf("%nGuess : ");
      guess = scanner.nextInt();
      if (guess > jar.getMaxItems()) {
        System.out.printf("%nYour guess must be less than %d %n", jar.getMaxItems());
        continue;
      } else {
        tries++;
        if (guess > jar.getFillLevel()) {
          System.out.printf("Your guess is too high%n");
        } else if (guess < jar.getFillLevel()) {
          System.out.printf("Your guess is too low%n");
        }
      }
      
    } while (guess != jar.getFillLevel());
    
    winnerMessagePrompt(jar, tries);  
  
  }
  
  private void winnerMessagePrompt(Jar jar, int tries) {
    System.out.printf("%n%nCongratulations - you guessed that there are %d %s(s) in the jar! It took you %d guess(es) to get it right. %n%n",
                         jar.getFillLevel(), jar.getItem(), tries);
  }

}