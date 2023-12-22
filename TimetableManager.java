import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class TimetableManager {
    private static final int DAYS = 5; // Monday to Friday
    private static final int TIMESLOTS = 5; // Number of time slots in a day
    private static final int SLOT_DURATION = 80; // Time duration for each subject in minutes
    private static final int START_HOUR = 8;
    private static final int START_MINUTE = 30;

    private static List<List<String>> timetable = new ArrayList<>(DAYS);

    public static void main(String[] args) {
        initializeTimetable();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Subject  2. Drop Subject  3. Display Timetable  4. Exit");
            System.out.print("\nSelect option: ");
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
                    System.out.println("\nExiting program. Goodbye!\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private static void initializeTimetable() {
        for (int i = 0; i < DAYS; i++) {
            timetable.add(new ArrayList<>(Arrays.asList("-", "-", "-", "-")));
        }
    }

    private static void displaySubjects() {
        System.out.println("\n1. Object Oriented Programming         ");
        System.out.println("2. Introduction to Information Technology");
        System.out.println("3. Discrete Mathematics                  ");
        System.out.println("4. Data Structures and Algorithms        ");
        System.out.println("5. Computer Organization and Architecture");
        System.out.println("6. Digital Electronics                   ");
        System.out.println("7. Data Communication and Networking     ");
        System.out.println("8. Operating Systems                     ");
    }
    
    private static int countOccurrences(String subject) {
        int count = 0;
        for (List<String> day : timetable) {
            for (String slot : day) {
                if (slot.equals(subject)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    private static void addSubject(Scanner scanner) {
        System.out.println("\nAvailable subjects:");
        displaySubjects();
        System.out.print("\nEnter subject number: ");
        int subjectNumber = scanner.nextInt();
    
        String subject = getSubjectByNumber(subjectNumber);
        if (subject != null) {
            System.out.print("Enter day (1-5 for Mon-Fri): ");
            int day = scanner.nextInt() - 1;
    
            System.out.print("Enter time slot (1-4): ");
            int timeSlot = scanner.nextInt() - 1;
    
            if (countOccurrences(subject) >= 2) {
                System.out.println("\nThis subject is already taken.");
            } else if (isValidSlot(day, timeSlot) && !isSlotFilled(day, timeSlot)) {
                timetable.get(day).set(timeSlot, subject);
                // Automatically schedule the same subject on the corresponding day
                timetable.get(getCorrespondingDay(day)).set(timeSlot, subject);
                System.out.println("\nSubject added successfully.");
            } else {
                System.out.println("\nInvalid time slot or overlapping with other subject. Try again.");
            }
        } else {
            System.out.println("\nInvalid subject number. Try again.");
        }
    }

    private static void dropSubject(Scanner scanner) {
        System.out.print("\nEnter day (1-5 for Mon-Fri): ");
        int day = scanner.nextInt() - 1;

        System.out.print("Enter time slot (1-4): ");
        int timeSlot = scanner.nextInt() - 1;

        if (!isValidSlot(day, timeSlot)) {
            System.out.println("\nInvalid time slot. Try again.");
        } else if (!isSlotFilled(day, timeSlot)) {
            System.out.println("\nThe subject you want to drop is not available in this slot.");
        } else {
            timetable.get(day).set(timeSlot, "-");
            System.out.println("\nSubject dropped successfully.");
        }
    }

    private static boolean isValidSlot(int day, int timeSlot) {
        // Check if within class hours and not overlapping with lunch break
        return (timeSlot >= 0 && timeSlot < TIMESLOTS) &&
                (day >= 0 && day < DAYS) &&
                !(timeSlot >= 2 && timeSlot <= 3); // Lunch break is time slot 2 and 3
    }

    private static boolean isSlotFilled(int day, int timeSlot) {
        // Check if the slot is already filled
        return !timetable.get(day).get(timeSlot).equals("-");
    }

    private static void displayTimetable() {
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    System.out.printf("%-10s %-10s %-12s%n", "\nDay", "Time", "Subject\n");

    for (int i = 0; i < DAYS; i++) {
        for (int j = 0; j < TIMESLOTS; j++) {
            if (j < timetable.get(i).size()) {
                System.out.printf("%-10s %-10s %-12s%n", days[i], getTimeSlot(j), timetable.get(i).get(j));
            } else {
                System.out.printf("%-10s %-10s %-12s%n", days[i], getTimeSlot(j), "-");
            }
        }
        System.out.println(); // This will print a newline after each day
    }
}

    private static String getSubjectByNumber(int subjectNumber) {
        switch (subjectNumber) {
            case 1:
                return "Object Oriented Programming";
            case 2:
                return "Introduction to Information Technology";
            case 3:
                return "Discrete Mathematics";
            case 4:
                return "Data Structures and Algorithms";
            case 5:
                return "Computer Organization and Architecture";
            case 6:
                return "Digital Electronics";
            case 7:
                return "Data Communication and Networking";
            case 8:
                return "Operating Systems";
            default:
                return null;
        }
    }

    private static int getCorrespondingDay(int day) {
        // 2 slot per week
        // if slot is on monday, next slot is on wednesday
        return (day + 2) % DAYS;
    }

    private static String getTimeSlot(int timeSlot) {
        // Convert time slot index to corresponding time
        int totalMinutes = (START_HOUR * 60 + START_MINUTE) + (timeSlot * (SLOT_DURATION + 10));
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        // If the hour is 1 PM, add the lunch duration to totalMinutes
        if (hours == 13) {
            totalMinutes = 14 * 60;

        }

        // If the hour is 14 (2 PM), skip to 3:30 PM
         if (hours == 14) {
         totalMinutes = 15 * 60 + 30;
        }

        // Recalculate hours and minutes after possibly adding lunch duration
        hours = totalMinutes / 60;
        minutes = totalMinutes % 60;

        int endHour = (totalMinutes + SLOT_DURATION) / 60;
        int endMinutes = (totalMinutes + SLOT_DURATION) % 60;

        return String.format("%02d:%02d - %02d:%02d", hours, minutes, endHour, endMinutes);
    }
}