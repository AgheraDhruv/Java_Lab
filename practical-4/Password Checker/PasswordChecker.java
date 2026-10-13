class PasswordChecker {
    boolean checkUppercase(String pw) {
        if (pw.matches(".*[A-Z].*")) {
            return true;
        } else
            return false;
    }

    boolean checkDigit(String pw) {
        if (pw.matches(".*[0-9].*")) {
            return true;
        } else
            return false;
    }
    boolean checkSpecial(String pw) {
        if(pw.matches(".*[^a-zA-Z0-9].*")) {
            return true;
        }
        else return false;
    }
    boolean checkLength(String pw) {
        if(pw.length() >= 8) {
            return true;
        }
        else return false;
    }
    String strength(String pw) {
        int count=0;
        if(checkLength(pw)) 
            count++;
        if(checkUppercase(pw)) count++;
        if(checkDigit(pw)) count++;
        if(checkSpecial(pw)) count++;

        if(count >= 0 && count <= 1) return "Weak";
        else if(count >=2 && count <=3) return "Medium";
        else if (count == 4) return "Strong";
        else return "Invalid";
    }
}
