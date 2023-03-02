package generatePassword;

public class GeneratePasswordDto {

    public boolean IncludeNumbers ;

    public boolean IncludeLowerCaseCharacters;

    public boolean IncludeUpperCaseCharacters;

    public boolean IncludeSpecialCharacters;

    public int Length;

    public GeneratePasswordDto(){
        IncludeNumbers = true;
        IncludeLowerCaseCharacters = true;
        Length = 25;
    }
}
