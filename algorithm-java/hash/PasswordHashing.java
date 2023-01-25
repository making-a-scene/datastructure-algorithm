public class PasswordHashing {
    public static void main(String[] args) {
        User user = new User("myemail@dmail.com", "MyStRoNg P@$$word");

        System.out.println(
            String.format("ID: %s", user.getId())
        );
        System.out.println(
            String.format("Email: %s", user.getEmail())
        );
        System.out.println(
            String.format("Password Hash: %s", user.getPasswordHash())
        );

        boolean wrongPw = user.isValidPassword("wrong password!");
        System.out.println("Expected: false, Actual:  " + wrongPw);
        boolean rightPw = user.isValidPassword("MyStRoNg P@$$word");
        System.out.println("Expected: true, Actual:  " + rightPw);
    }
}