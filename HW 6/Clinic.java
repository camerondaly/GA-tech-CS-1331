import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;


/** 
 * take in appointments.csv info and write to patients.csv
 */
public class Clinic {
    private int day;
    private File patientFile;
    private Scanner input = new Scanner(System.in);
    static HashSet<String> nameSet = new HashSet<String>();

    public Clinic(String fileName) {
        this(new File(fileName));
    }

    public Clinic(File file) {
        this.patientFile = file;
        this.day = 1;
    }

    // Methods
    public String nextDay(String fileName) throws FileNotFoundException {
        return nextDay(new File(fileName));
    }

    public String nextDay(File file) throws FileNotFoundException {
        String result = "";
        Scanner fileScan = null;
        Scanner patientScan = null;
        try {
            fileScan = new Scanner(file);
            String line = null;
            while (fileScan.hasNextLine()) {
                line = fileScan.nextLine();
                patientScan = new Scanner(line);
                patientScan.useDelimiter(",");
                String name = patientScan.next();
                String type = patientScan.next();
                if (!type.equals("Cat") && !type.equals("Dog")) {
                    patientScan.close();
                    throw new InvalidPetException();
                }
                double mouseOrDrool = patientScan.nextDouble();
                String timeIn = patientScan.next();
                double health = -1;
                int painLevel = -1;
                System.out.printf("Consultation for %s the %s at %s.\nWhat is the health of %s?\n", name, type, timeIn, name);
                Boolean validDouble = false;
                while (!validDouble) {
                    try {
                        health = input.nextDouble();
                        validDouble = true;
                    } catch(InputMismatchException e) {
                        input.nextLine();
                        System.out.println("Enter a double.");
                    }
                }
                System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
                Boolean validPainLevel = false;
                while (!validPainLevel) {
                    try {
                        painLevel = input.nextInt();
                        validPainLevel = true;
                    } catch(InputMismatchException e) {
                        input.nextLine();
                        System.out.println("Please enter an integer.");
                    }
                }
                String timeOut = "ERROR";
                if (type.equals("Cat")) {
                    Cat patientcat = new Cat(name, health, painLevel, (int)mouseOrDrool);
                    patientcat.speak();
                    timeOut = this.addTime(timeIn, patientcat.treat());
                } else if (type.equals("Dog")) {
                    Dog patient = new Dog(name, health, painLevel, mouseOrDrool);
                    patient.speak();
                    timeOut = this.addTime(timeIn, patient.treat());
                }
                result = result.concat(name + "," + type + "," + mouseOrDrool + "," + day + "," + timeIn + "," + timeOut + "," + health + "," + painLevel + "/n");
            }
        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            day += 1;
            if (fileScan != null) {
                fileScan.close();
            }
        }
        System.out.println(result);
        return result;
    }

    // Add day's patients String to a file
    // *** PRINTING AT FIRST TO TEST.
    public boolean addToFile(String patientInfo) {
        PrintWriter filePrint = null;
        Scanner lineScanner = null;
        // HOW TO CHECK IF A NAME IS IN THE CSV WITHOUT IMPORTING CSV ):
        // Hashset? idk if prof wants this.
        try {
            lineScanner = new Scanner(patientInfo);
            filePrint = new PrintWriter(this.patientFile);
            String line = lineScanner.nextLine();
            filePrint.println(line);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (filePrint != null) {
                filePrint.close();
            }
            if (lineScanner != null) {
                lineScanner.close();
            }
        }
        return true;
    }

    private String addTime(String timeIn, int treatmentTime) {
        int timeOut = Integer.valueOf(timeIn) + treatmentTime;
        return Integer.toString(timeOut);
    }
}
