import java.util.Arrays;
import java.util.Scanner;

public class TimetableManager {
    static final int DAYS = 5; // Monday to Friday
    static final int TIMESLOTS = 6; // Number of time slots in a day

    static String[][] timetable = new String[DAYS][TIMESLOTS];

    public static void main(String[] args) {
        initializeTimetable();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Subject  2. Drop Subject  3. Display Timetable  4. Exit 5. Display Subjects");
            System.out.print("Select option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addSubject(scanner);
                    break;
                case 2:
                    dropSubject(scanner);
                    break;
                case 3:
                    displayTimetable();
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                case 5:
                    displaySubjcets();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    static void initializeTimetable() {
        for (String[] day : timetable) {
            Arrays.fill(day, "-"); // Initialize all slots with "-"
        }
    }

    static void displaySubjcets() {
        System.out.println("Object Oriented Programming");
        System.out.println("Introduction to Information Technology");
        System.out.println("Discrete Mathematics");
        System.out.println("Data Structures and Algorithms");
        System.out.println("Computer Organization and Architecture");
        System.out.println("Digital Electronics");
        System.out.println("Data Communication and Networking");
        System.out.println("Operating Systems");
        }

    static void addSubject(Scanner scanner) {
        System.out.print("Enter day (1-5 for Mon-Fri): ");
        int day = scanner.nextInt() - 1;

        System.out.print("Enter time slot (1-6): ");
        int timeSlot = scanner.nextInt() - 1;

        if (isValidSlot(day, timeSlot)) {
            System.out.print("Enter subject name: ");
            String subject = scanner.next();

            timetable[day][timeSlot] = subject;
            System.out.println("Subject added successfully.");
        } else {
            System.out.println("Invalid time slot or overlapping with lunch break. Try again.");
        }
    }

    static void dropSubject(Scanner scanner) {
        System.out.print("Enter day (1-5 for Mon-Fri): ");
        int day = scanner.nextInt() - 1;

        System.out.print("Enter time slot (1-6): ");
        int timeSlot = scanner.nextInt() - 1;

        if (isValidSlot(day, timeSlot)) {
            timetable[day][timeSlot] = "-";
            System.out.println("Subject dropped successfully.");
        } else {
            System.out.println("Invalid time slot or no subject scheduled. Try again.");
        }
    }

    static boolean isValidSlot(int day, int timeSlot) {
        // Check if within class hours and not overlapping with lunch break
        return (timeSlot >= 0 && timeSlot < TIMESLOTS) &&
               (day >= 0 && day < DAYS) &&
               !(timeSlot >= 3 && timeSlot <= 4); // Lunch break is time slot 3 and 4
    }

    static void displayTimetable() {
        System.out.println("Day\tTime\t\tSubject");
        for (int i = 0; i < DAYS; i++) {
            for (int j = 0; j < TIMESLOTS; j++) {
                System.out.println((i + 1) + "\t" + getTimeSlot(j) + "\t\t" + timetable[i][j]);
            }
        }
    }

    static String getTimeSlot(int timeSlot) {
        // Convert time slot index to corresponding time
        double startHour = 8.30;
        int startMinute = 40;
        int slotDuration = 80; // 1 hour 30 minutes

        double totalMinutes = (startHour * 60 + startMinute) + (timeSlot * slotDuration);
        double hours = totalMinutes / 60;
        double minutes = totalMinutes % 60;

        return String.format("%02d:%02d", hours, minutes);
    }
}