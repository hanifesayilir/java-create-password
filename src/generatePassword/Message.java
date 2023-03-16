package generatePassword;

public class Message {

    static final String NUMBER_LIB = "0123456789";
    static final String LOWER_CASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    static final String UPPER_CASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    static final String QUESTION_NUMBER = "Do you want to include numbers?";
    static final String QUESTION_LOWERCASE = "How about lowercase characters?";
    static final String QUESTION_UPPERCASE =  "OK! How about uppercase characters?";
    static final String QUESTION_SPECIAL_CHARACTERS = "All right! We are almost done. Would you also want to add special characters?";
    static final String QUESTION_LENGTH = "Great! Lastly. How long do you want to keep your password length?";
    static final String WELLCOME_TITLE = "Wellcome to the Random Password Generator!!";
    static final String ASK_FOR_VALID_INPUT = "Please enter a valid input. One of the following characters 'Y', 'y', 'n', 'N' are considered valid only.";
    static final String ASK_FOR_VALID_NUMBER_INPUT = "Please enter a valid input. The length should be greater than 1.Please try Again.";
    static final String ASK_FOR_ANY_VALID_INPUT = "You should enter at least one y or Y as an answer to the questions, otherwise the password will not be created!! Please start the application again.";
}
