import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class TimetableManager {
    private static final int DAYS = 5;
    private static final int TIMESLOTS = 5;
    private static final int SLOT_DURATION = 80;
    private static final int START_HOUR = 8;
    private static final int START_MINUTE = 30;

    private List<List<String>> timetable;
    

    public TimetableManager() {
        this.timetable = new ArrayList<>(DAYS);
        initializeTimetable();
        
    }

    private void initializeTimetable() {
        for (int i = 0; i < DAYS; i++) {
            timetable.add(new ArrayList<>(Arrays.asList("-", "-", "-", "-", "-")));
        }
    }

    public void displaySubjects() {
        System.out.println("\n1. CSCI 1301 - Object Oriented Programming         ");
        System.out.println("2. CSCI 1302 - Introduction to Computer Organization");
        System.out.println("3. CSCI 1304 - Probability and Statistics                  ");
        System.out.println("4. CSCI 2300 - Data Structures and Algorithms I       ");
        System.out.println("5. INFO 2302 - Web Technologies                    ");
        System.out.println("6. INFO 2305 - Multimedia Technologies                   ");
        System.out.println("7. CSCI 2301 - Computer Networking     ");
        System.out.println("8. CSCI 3300 - Operating Systems                     ");
    }

    public void addSubject(Scanner scanner) {
        System.out.println("\nAvailable subjects:");
        displaySubjects();
        System.out.print("\nEnter subject number: ");
        int subjectNumber = scanner.nextInt();

        String subject = getSubjectByNumber(subjectNumber);
        if (subject != null) {
            System.out.print("Enter day (1-5 for Mon-Fri): ");
            int day = scanner.nextInt() - 1;

            System.out.print("Enter time slot (1-5): ");
            int timeSlot = scanner.nextInt() - 1;

            if (countOccurrences(subject) >= 2) {
                System.out.println("\nThis subject is already taken.");
            } else if (!isSlotFilled(day, timeSlot)) {
                timetable.get(day).set(timeSlot, subject);
                timetable.get(getCorrespondingDay(day)).set(timeSlot, subject);
                System.out.println("\nSubject added successfully.");
            } else {
                System.out.println("\nOverlapping with other subjects. Try again.");
            }
        } else {
            System.out.println("\nInvalid subject number. Try again.");
        }
    }

    private int countOccurrences(String subject) {
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

    private boolean isSlotFilled(int day, int timeSlot) {
        return !timetable.get(day).get(timeSlot).equals("-");
    }

    private String getSubjectByNumber(int subjectNumber) {
        switch (subjectNumber) {
            case 1:
                return "CSCI 1301";
            case 2:
                return "CSCI 1302";
            case 3:
                return "CSCI 1304";
            case 4:
                return "CSCI 2300";
            case 5:
                return "INFO 2302";
            case 6:
                return "INFO 2305";
            case 7:
                return "CSCI 2301";
            case 8:
                return "CSCI 3300";
            default:
                return null;
        }
    }

    private int getCorrespondingDay(int day) {
        return (day + 2) % DAYS;
    }

    public void dropSubject(Scanner scanner) {
        displaySubjects();
        System.out.print("\nEnter subject number: ");
        int subjectNumber = scanner.nextInt();

        String subject = getSubjectByNumber(subjectNumber);
        if (subject != null) {
            boolean found = false;
            for (List<String> day : timetable) {
                for (int i = 0; i < day.size(); i++) {
                    if (day.get(i).equals(subject)) {
                        day.set(i, "-");
                        found = true;
                    }
                }
            }
            if (found) {
                System.out.println("\nSubject dropped successfully.");
            } else {
                System.out.println("The subject you want to drop is not available.");
            }
        } else {
            System.out.println("Invalid subject number. Try again.");
        }
    }

    private String getTimeSlot(int timeSlot) {
        int totalMinutes = (START_HOUR * 60 + START_MINUTE) + (timeSlot * (SLOT_DURATION + 10));
        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        if (hours == 13) {
            totalMinutes = 14 * 60;
        }

        if (hours == 14) {
            totalMinutes = 15 * 60 + 30;
        }

        hours = totalMinutes / 60;
        minutes = totalMinutes % 60;

        int endHour = (totalMinutes + SLOT_DURATION) / 60;
        int endMinutes = (totalMinutes + SLOT_DURATION) % 60;

        return String.format("%02d:%02d - %02d:%02d", hours, minutes, endHour, endMinutes);
    }

    public void displayTimetable() {
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
            System.out.println();
        }
    }

    public List<List<String>> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<List<String>> timetable) {
        this.timetable = timetable;
    }
}