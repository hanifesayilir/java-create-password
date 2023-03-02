package generatePassword;

import java.util.Random;

public class PasswordGenerator {

            static final String NUMBER_LIB = "0123456789";
            static final String LOWER_CASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
            static final String UPPER_CASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            static final String SPECIAL_CHARACTERS = "!@#$%^&*()";

            private Random random;
            private StringBuilder passwordBuilder;
            private StringBuilder charSetBuilder;

            public PasswordGenerator()
            {
                random = new Random();

                passwordBuilder = new StringBuilder();

                charSetBuilder = new StringBuilder();

            }

    public String Generate(GeneratePasswordDto generatePasswordDto)
    {

        if (generatePasswordDto.IncludeNumbers) charSetBuilder.append(NUMBER_LIB);

        if (generatePasswordDto.IncludeLowerCaseCharacters) charSetBuilder.append(LOWER_CASE_CHARACTERS);

        if (generatePasswordDto.IncludeUpperCaseCharacters) charSetBuilder.append(UPPER_CASE_CHARACTERS);

        if (generatePasswordDto.IncludeSpecialCharacters) charSetBuilder.append(SPECIAL_CHARACTERS);

        if (!generatePasswordDto.IncludeNumbers && !generatePasswordDto.IncludeLowerCaseCharacters &&
        !generatePasswordDto.IncludeUpperCaseCharacters && !generatePasswordDto.IncludeSpecialCharacters)
            return "";



        String charSet = charSetBuilder.toString();

        for (int i = 0; i < generatePasswordDto.Length; i++)
        {
            int randomIndex = random.nextInt(charSet.length());

            passwordBuilder.append(charSet.charAt(randomIndex));
        }

        return passwordBuilder.toString();
    }

}
