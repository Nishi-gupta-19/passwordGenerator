	import java.util.Scanner;

public class Generator {
	

	

	    public static class Password {
	        private String value;
	        private int length;

	        public Password(String s) {
	            value = s;
	            length = s.length();
	        }

	        public int charType(char c) {
	            int val;

	            // Char is Uppercase Letter
	            if (c >= 'A' && c <= 'Z') {
	                val = 1;
	            }
	            // Char is Lowercase Letter
	            else if (c >= 'a' && c <= 'z') {
	                val = 2;
	            }
	            // Char is Digit
	            else if (c >= '0' && c <= '9') {
	                val = 3;
	            }
	            // Char is Symbol
	            else {
	                val = 4;
	            }

	            return val;
	        }

	        public int passwordStrength() {
	            boolean usedUpper = false;
	            boolean usedLower = false;
	            boolean usedNum = false;
	            boolean usedSym = false;

	            int score = 0;

	            for (int i = 0; i < value.length(); i++) {
	                char c = value.charAt(i);
	                int type = charType(c);

	                if (type == 1) usedUpper = true;
	                if (type == 2) usedLower = true;
	                if (type == 3) usedNum = true;
	                if (type == 4) usedSym = true;
	            }

	            if (usedUpper) score++;
	            if (usedLower) score++;
	            if (usedNum) score++;
	            if (usedSym) score++;

	            if (length >= 8) score++;
	            if (length >= 16) score++;

	            return score;
	        }

	        public String calculateScore() {
	            int score = this.passwordStrength();

	            if (score == 6) {
	                return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
	            } else if (score >= 4) {
	                return "This is a good password :) but you can still do better";
	            } else if (score >= 3) {
	                return "This is a medium password :/ try making it better";
	            } else {
	                return "This is a weak password :( definitely find a new one";
	            }
	        }

	        @Override
	        public String toString() {
	            return value;
	        }
	    }

	    public static final Scanner keyboard = new Scanner(System.in);

	    public void mainLoop() {
	        System.out.print("Enter a password: ");
	        String passwordInput = keyboard.nextLine();

	        Password password = new Password(passwordInput);

	        System.out.println("Password: " + password);
	        System.out.println("Password Strength: " + password.calculateScore());
	    }

	    public static void main(String[] args) {
	        Generator generator = new Generator();
	        generator.mainLoop();
	        keyboard.close();
	    }
	}



