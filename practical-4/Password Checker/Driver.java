import java.util.Scanner;

class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Password :");
        String pw = sc.nextLine();
        PasswordChecker check = new PasswordChecker();

        System.out.println("Password :" + pw);
        System.out.println("Length :" + check.checkLength(pw));
        System.out.println("Uppercase :" + check.checkUppercase(pw));
        System.out.println("Digit :" + check.checkDigit(pw));
        System.out.println("Special :" + check.checkSpecial(pw));
        System.out.println("Strength :" + check.strength(pw));
    }
}
