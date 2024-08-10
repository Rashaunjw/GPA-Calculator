import java.text.DecimalFormat;
import java.util.Scanner;

// Rashaun Williams 2024
// GPA Calculator



// GPA = total points / total credits
// Points = grade value * credits
// A = 4, B = 3, C = 2, D = 1, F = 0


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Integer totalPoints = 0;
        Integer totalCredits = 0;
        Integer credits = 0;
        Integer semesterCounter = 1;
        Integer classCounter = 0;        
        Integer gradeValue = 0;

        boolean runAgain = true;
        boolean validCredits = true;
        boolean validGrade = true;

        String grade = "";

        System.out.println("*");

        while (runAgain) {
            boolean validClasses = true;
            Integer classInt = 1;
            do {
                validClasses = true;
                System.out.println("How many classes did you take this semester?: ");
                String classNum = scanner.nextLine();
                try {
                    classInt = Integer.parseInt(classNum);
                    classCounter += classInt;
                }
                catch (NumberFormatException e) {
                    System.err.println("***** You didn't enter a valid number :/ *****");
                    validClasses = false;
                    continue;
                }

            }

            while (!validClasses);

            for (int i = 1; i <= classInt; i++) {
                do {
                    validCredits = true;
                    System.out.println("Enter number of credits for class " + i + ":");
                    String creditsString = scanner.nextLine();
                    try {
                        credits = Integer.parseInt(creditsString);
                    }
                    catch (NumberFormatException nfe) {
                        System.err.println("***** You didn't enter a valid number :/ *****");
                        validCredits = false;
                    }
                }

                while (!validCredits);

                do {
                    validGrade = true;
                    System.out.println("Enter letter grade:");
                    grade = scanner.nextLine(); // Read user input

                    if (grade.equalsIgnoreCase("A")) {
                        gradeValue = 4;
                    } else if (grade.equalsIgnoreCase("B")) {
                        gradeValue = 3;
                    } else if (grade.equalsIgnoreCase("C")) {
                        gradeValue = 2;
                    } else if (grade.equalsIgnoreCase("D")) {
                        gradeValue = 1;
                    } else if (grade.equalsIgnoreCase("F")) {
                        gradeValue = 0;
                    } else {
                        System.err.println("***** You didn't a valid grade :/ *****");
                        System.out.println("***** Your choices are: A,B,C,D,F *****");
                        validGrade = false;
                    }   

                }

                while (!validGrade);
                
                Integer points = gradeValue * credits;
                totalPoints += points;
                totalCredits += credits; 
            }

            while (true) {
                try {
                System.out.println("Would you like to add another semester? (Y/N)");
                String moreSemestersString= scanner.nextLine();

                if (moreSemestersString.equalsIgnoreCase("Y")) {
                    runAgain = true;
                    semesterCounter ++;
                    break;
                } else if (moreSemestersString.equalsIgnoreCase("N")) {
                    DecimalFormat df = new DecimalFormat("0.00");
                    Double gpa = Double.valueOf(totalPoints) / Double.valueOf(totalCredits);
                    if (semesterCounter == 1 && classCounter == 1) {
                        System.out.println("");
                        System.out.println("Your GPA for " + classCounter + " class is:");
                    } else if (semesterCounter == 1 && classCounter > 1){
                        System.out.println("");
                        System.out.println("Your GPA for " + classCounter + " classes is:");
                    } else {
                        System.out.println("");
                        System.out.println("Your GPA for " + classCounter + " classes, through " + semesterCounter + " semesters is:");
                    }
                    System.out.println("");
                    System.out.println("Credits: " + totalCredits);
                    System.out.println("Points: " + totalPoints);
                    System.out.println("GPA: " + df.format(gpa));
                    System.out.println("");
                    runAgain = false;
                    break;
                }
                }
                catch (Exception e) {
                    System.err.println("***** Sorry I didn't catch that message, can you repeat that? *****");
                    scanner.close();
                }
            }
        }
    }  
}