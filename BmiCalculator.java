import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

// This program calculates the Body Mass Index (BMI) based on the user's input for height and weight.
// The program ensures accuracy by rounding inputs and outputs to two decimal places,
// and provides health-related feedback based on the calculated BMI value.

class BmiCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Requesting the user's height in meters
        System.out.println("\n");
        System.out.print("Please type in your height in m: ");
        double height = scanner.nextDouble();

        // Ensuring the height input is accurate and rounded to two decimal places
        BigDecimal height_rounded = new BigDecimal(height);
        height_rounded = height_rounded.setScale(2, RoundingMode.HALF_UP);

        // Acknowledging the user's input and displaying the rounded height
        System.out.println("Thank you now we now that your height is: " + height_rounded + " m");

        // Requesting the user's weight in kilograms
        System.out.print("Please type in your current weight in kilo: ");
        double weight = scanner.nextDouble();

        // Ensuring the weight input is accurate and rounded to two decimal places
        BigDecimal weight_rounded = new BigDecimal(weight);
        weight_rounded = weight_rounded.setScale(2, RoundingMode.HALF_UP);

        // Acknowledging the user's input and displaying the rounded weight
        System.out.println("Thank you now we know that your weight is: " + weight_rounded + " kilo");
        
        // Performing the BMI calculation using the formula: BMI = weight / (height * height)
        double bmi_calculation = weight / (height * height);

        // Ensuring the BMI calculation is rounded to two decimal places for better readability
        BigDecimal bmi_rounded = new BigDecimal(bmi_calculation);
        bmi_rounded = bmi_rounded.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Your BMI based on your height and weight is: " + bmi_rounded);

        // Converting the BMI to a double for further classification into BMI categories
        double bmi_as_float = bmi_rounded.doubleValue();
        double bmi_as_double = (double) Math.round(bmi_as_float);

        // Providing health-related feedback based on the BMI categories defined by WHO
        if (bmi_as_double < 16.0) {
            System.out.println("Based on your BMI you have severely underweight");
        } else if (bmi_as_double >= 16.0 && bmi_as_double < 17.0) {
            System.out.println("Based on your BMI you have moderate underweight");
        } else if (bmi_as_double >= 17.0 && bmi_as_double < 18.5) {
            System.out.println("Based on your BMI you have mild underweight");
        } else if (bmi_as_double >= 18.5 && bmi_as_double < 25.0) {
            System.out.println("Based on your BMI you have normal weight");
        } else if (bmi_as_double >= 25.0 && bmi_as_double < 30.0) {
            System.out.println("Based on your BMI you have overweight");
        } else if (bmi_as_double >= 30.0 && bmi_as_double < 35.0) {
            System.out.println("Based on your BMI you have obesity (Class 1)");
        } else if (bmi_as_double >= 35.0 && bmi_as_double < 40.0) {
            System.out.println("Based on your BMI you have obesity (Class 2)");
        } else if (bmi_as_double >= 40.0) {
            System.out.println("Based on your BMI you have obesity (Class 3)");
        } else {
            System.out.println("Invalid input please follow the directions");
        }

        // Closing the scanner to free up system resources
        scanner.close();
    }
}
