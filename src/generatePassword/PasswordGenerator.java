package generatePassword;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import static generatePassword.Message.*;

public class PasswordGenerator {

    private int passwordLength = 0;
    private boolean anyValidInput = false;

    private Random random;
    private StringBuilder passwordBuilder;
    private StringBuilder charSetBuilder;
    private String finalPassword = "";

    public PasswordGenerator()
    {
        random = new Random();

        passwordBuilder = new StringBuilder();

        charSetBuilder = new StringBuilder();

    }

    public void orderOfMethods() {
        wellComeMessage();
        composeQuestion(QuestionType.NUMBER);
        composeQuestion(QuestionType.SPECIALCHARACTER);
        composeQuestion(QuestionType.LOWERCASE);
        composeQuestion(QuestionType.UPPERCASE);
        composeQuestion(QuestionType.LENGTH);
        combine();
        end();
        System.exit(0);
      //  continueOrExit();
    }

    private void createStars ()
    {
        System.out.println("******************************************************");
    }

    private void wellComeMessage() {
        createStars();
        System.out.println(WELLCOME_TITLE);
        createStars();
    }

    private void end() {
        if(anyValidInput) writeFinalPasswordToConsole();
    }

   private void composeQuestion(QuestionType sentValue){
        switch (sentValue) {

            case NUMBER: callQuestionFromConsole(QUESTION_NUMBER, QuestionType.NUMBER);
            break;
            case LOWERCASE: callQuestionFromConsole(QUESTION_LOWERCASE,QuestionType.LOWERCASE);
                break;
            case UPPERCASE: callQuestionFromConsole(QUESTION_UPPERCASE, QuestionType.UPPERCASE);
            break;

            case SPECIALCHARACTER: callQuestionFromConsole(QUESTION_SPECIAL_CHARACTERS, QuestionType.SPECIALCHARACTER);
            break;

            case LENGTH: readLengthFromConsole(QUESTION_LENGTH);
            break;
        }
    }

    private void callQuestionFromConsole(String question, QuestionType allowedType)
    {
       String temp;
        Scanner typeAllowed = new Scanner(System.in);
        System.out.println(question);
        temp= typeAllowed.next();

        boolean validType = checkValidityOfInputs(temp);

        if(!validType){
            System.out.println(ASK_FOR_VALID_INPUT);
            callQuestionFromConsole(question, allowedType);
        } else {
            if(isAllowed(temp)) {
                anyValidInput = true;
                addToCharset(allowedType);
            }
        }
    }


    private void readLengthFromConsole(String question) {
        String input = "";
        int number = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(question);
            input = bufferedReader.readLine();
            number = Integer.parseInt(input);

            if(!checkValidityOfIntegerInput(number)) {
                System.out.println(ASK_FOR_VALID_NUMBER_INPUT);
                readLengthFromConsole(question);
            } else {
                passwordLength = number;
            }
        } catch (NumberFormatException ex) {
            System.out.println(ASK_FOR_VALID_NUMBER_INPUT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addToCharset(QuestionType questionTypeLocal)
    {
        switch (questionTypeLocal) {

            case NUMBER: charSetBuilder.append(NUMBER_LIB);
                break;
            case LOWERCASE: charSetBuilder.append(LOWER_CASE_CHARACTERS);
                break;
            case UPPERCASE: charSetBuilder.append(UPPER_CASE_CHARACTERS);
                break;

            case SPECIALCHARACTER: charSetBuilder.append(SPECIAL_CHARACTERS);
                break;

            default:
            System.out.println(ASK_FOR_ANY_VALID_INPUT);
                break;
        }
    }

    private void combine() {
        if(anyValidInput && passwordLength >0) {
            String charSet = charSetBuilder.toString();

            for (int i = 0; i < passwordLength; i++)
            {
                int randomIndex = random.nextInt(charSet.length());

                passwordBuilder.append(charSet.charAt(randomIndex));
            }

            finalPassword = passwordBuilder.toString();
        } else {
            System.out.println(ASK_FOR_ANY_VALID_INPUT);
            return;
        }



    }

    private boolean checkValidityOfInputs (String consoleInput) {
       boolean result = (consoleInput.equals("y") || consoleInput.equals("Y") || consoleInput.equals("N") || consoleInput.equals("n")) ? true : false;
       return result;
    }

    private boolean isAllowed(String input) {
        boolean result = (input.equals("y") || input.equals("Y")) ? true : false;
        return result;
    }

    private boolean checkValidityOfIntegerInput(int input) {
        if (input > 0)  return true ;
        else return false;
    }

  /*  private void continueOrExit() {
        String temp;
        System.out.println("Do you want to continue?");
        Scanner typeAllowed = new Scanner(System.in);
        temp= typeAllowed.next();
        if(isAllowed(temp)){
            passwordLength= 0;
            finalPassword = "";
            charSetBuilder =
            orderOfMethods();
        }
        else System.exit(0);
    }*/


    private void writeFinalPasswordToConsole ()
    {
        System.out.println("**************************************************");
        System.out.println(finalPassword);
        System.out.println("**************************************************");
        return;
    }


}
