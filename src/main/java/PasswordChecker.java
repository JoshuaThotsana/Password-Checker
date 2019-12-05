public class PasswordChecker {

    boolean existence = true, longer = true, lowerCase = true, upperCase = true, digit = true, character = true;

    int count = 6;

    Validations validations = new Validations();

    void passwordIsValid(String password)  {

        if (!validations.existence(password)) {
            System.err.println("1. Password should exist.");
            existence = false;
            count --;
        }
        if (!validations.longer(password)) {
            System.err.println("2. Password should be longer than than 8 characters.");
            longer = false;
            count --;
        }
        if (!validations.lowerCase(password)) {
            System.err.println("3. Password should have at least one lowercase letter.");
            lowerCase = false;
            count --;
        }
        if (!validations.upperCase(password)) {
            System.err.println("4. Password should have at least one uppercase letter.");
            upperCase = false;
            count --;
        }
        if (!validations.digit(password)) {
            System.err.println("5. Password should have at least have one digit.");
            digit = false;
            count --;
        }
        if (!validations.character(password)) {
            System.err.println("6. Password should have at least one special character.");
            character = false;
            count --;
        }
        if (existence && longer && lowerCase && upperCase && digit && character) {
            System.out.println("Password meets all the minimum requirements.");
        }
        if (!validations.longer(password)) {
            System.err.println("\nPassword is never okay if both condition 1 and 2 are not met.\n");
        }
    }

    boolean passwordIsOk() {

        boolean results = true;
        if (count < 3) {
            results = false;
        }
        return results;
    }
}
