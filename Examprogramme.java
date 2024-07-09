import java.util.Scanner;

public class ExamProgramme {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option;

        // A Do-while loop to display menu items 
        do {
            System.out.println("Menu Option:");
            System.out.println("1. View coursework results");
            System.out.println("2. View exam results");
            System.out.println("3. Exit the program");
            System.out.print("Choose an option from the above menu: ");
            option = scan.nextInt();

            switch (option) {
                case 1:
                    viewCourseworkResults(scan);
                    break;
                case 2:
                    viewExamResults(scan);
                    break;
                case 3:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 3);

        scan.close();
    }

    // A Function to view coursework results
    private static void viewCourseworkResults(Scanner scan) {
        double[] assessments = new double[3];
        double[] cats = new double[2];
        System.out.println("Enter the marks for the Assessment 1, 2 & 3 and CAT1 & CAT2:");
        
        for (int i = 0; i < assessments.length; i++) {
            System.out.print("Assessment " + (i + 1) + ": ");
            assessments[i] = scan.nextDouble();
        }
        
        for (int i = 0; i < cats.length; i++) {
            System.out.print("CAT " + (i + 1) + ": ");
            cats[i] = scan.nextDouble();
        }
        
        double totalCoursework = computeCoursework(assessments) + computeCoursework(cats);
        System.out.println("Total coursework marks: " + totalCoursework);

        boolean completedTwoThirds = hasCompletedTwoThirds(assessments.length + cats.length);
        if (!completedTwoThirds) {
            System.out.println("You have not completed 2/3 of the coursework. You are required to repeat irrespective of your Final Exam Grade.");
        }
    }

    // A Function to view exam results
    private static void viewExamResults(Scanner scan) {
        System.out.print("Enter your final exam marks: ");
        double finalExam = scan.nextDouble();
        System.out.print("Enter your total coursework marks: ");
        double coursework = scan.nextDouble();
        double totalScore = computeTotalScore(coursework, finalExam);
        System.out.println("Your Total Score is: " + totalScore);
    }

    // A Function to compute the number of coursework assessments done in DIT409 unit
    private static int countCourseworkAssessments(int totalAssessments) {
        int count = 0;
        for (int i = 0; i < totalAssessments; i++) {
            count++;
        }
        return count;
    }

    // A Function to compute coursework marks
    private static double computeCoursework(double[] assessments) {
        double total = 0;
        for (double assessment : assessments) {
            total += assessment;
        }
        return total;
    }

    // A Function to check if the student has completed two thirds of the coursework
    private static boolean hasCompletedTwoThirds(int totalAssessments) {
        int completedAssessments = countCourseworkAssessments(totalAssessments);
        return completedAssessments >= (2 * totalAssessments / 3);
    }

    // A Function to compute the total score for a student
    private static double computeTotalScore(double coursework, double finalExam) {
        return coursework + finalExam;
    }
}