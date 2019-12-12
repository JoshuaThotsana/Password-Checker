public class  PasswordChecker {

    private Validations validations = new Validations();

    
    /* In this method we will initialize an empty string "errors", and then append the string with every
     * error we encounter as the program runs. Next we check if the string is empty. And if it is not,
     * we throw an exception with the error messages.
     * The method needs to be synchronized because we need to make sure that we are protected from the thread.
     */
    synchronized void passwordIsValid(String password) throws Exception{
        String errors = "";

        if (!validations.existence(password)) {
            errors += "1. Password should exist.\n";
        }
        if (!validations.longer(password)) {
            errors += "2. Password should be longer than than 8 characters.\n";
        }
        if (!validations.lowerCase(password)) {
            errors += "3. Password should have at least one lowercase letter.\n";
        }
        if (!validations.upperCase(password)) {
            errors += "4. Password should have at least one uppercase letter.\n";
        }
        if (!validations.digit(password)) {
            errors += "5. Password should have at least one digit.\n";
        }
        if (!validations.character(password)) {
            errors += "6. Password should have at least one special character.\n";
        }

        if (errors.length() > 0) {
            throw new Exception(errors);
        }
    }

    /* In the method below we check for each and every condition and return 1 if the condition is met. Otherwise
     * we return 0. Then we count how many one's we have and if they are more than or equals to three, then the
     * method returns true.
     */
     boolean passwordIsOk(String password) {

        int existence = (validations.existence(password)) ? 1:0;
        int longer = (validations.longer(password)) ? 1:0;
        int lowerCase = (validations.lowerCase(password)) ? 1:0;
        int upperCase = (validations.upperCase(password)) ? 1:0;
        int digit = (validations.digit(password)) ? 1:0;
        int character = (validations.character(password)) ? 1:0;

        if (existence+longer+lowerCase+upperCase+digit+character >= 3) {
            return true;
        }

        if (existence + longer != 2) {
            System.err.println("\nPassword is never okay if both condition 1 and 2 are not met.\n");
        }
        return false;
    }
}
