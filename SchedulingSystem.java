
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class SchedulingSystem {
    private static final int DAYS = 5;
    private static final int TIMESLOTS = 5;
    private static final int SLOT_DURATION = 80;
    private static final int START_HOUR = 8;
    private static final int START_MINUTE = 30;

    private List<List<String>> schedule;//
    

    public SchedulingSystem() {
        this.schedule = new ArrayList<>(DAYS);
        initializeSchedule();
        
    }

    private void initializeSchedule() {
        for (int i = 0; i < DAYS; i++) {
            schedule.add(new ArrayList<>(Arrays.asList("-", "-", "-", "-", "-")));
        }
    }
//anis's part
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
    
        int subjectNumber;
    
        // Loop until a valid subject number is entered
        do {
            System.out.print("\nEnter subject number: ");
            subjectNumber = scanner.nextInt();
    
            if (subjectNumber < 1 || subjectNumber > 8) {
                System.out.println("\nInvalid subject number. Please enter a number between 1 and 8, try again.");
            }
        } while (subjectNumber < 1 || subjectNumber > 8);
    
        String subject = getSubjectByNumber(subjectNumber);
        int day;
        int timeSlot;
    
            // Loop until a valid day is entered
            do {
                System.out.print("Enter day (1-5 for Mon-Fri): ");
                day = scanner.nextInt() - 1;
    
                if (day < 0 || day >= DAYS) {
                    System.out.println("\nInvalid day. Please enter a number between 1 and 5, try again.");
                }
            } while (day < 0 || day >= DAYS);
    
            // Loop until a valid time slot is entered
            do {
                System.out.print("Enter time slot (1-5): ");
                timeSlot = scanner.nextInt() - 1;
    
                if (timeSlot < 0 || timeSlot >= TIMESLOTS) {
                    System.out.println("\nInvalid time slot. Please enter a number between 1 and 5.");
                }
            } while (timeSlot < 0 || timeSlot >= TIMESLOTS);
    
            if (countOccurrences(subject) >= 2) {
                System.out.println("\nThis subject is already taken.");
            } else if (!isSlotFilled(day, timeSlot)) {
                schedule.get(day).set(timeSlot, subject);
                schedule.get(getCorrespondingDay(day)).set(timeSlot, subject);
                System.out.println("\nSubject added successfully.");
            } else {
                System.out.println("\nOverlapping with other subjects. Try again.");
            }

    }
    
    
    private int countOccurrences(String subject) {
        int count = 0;
        for (List<String> day : schedule) {
            for (String slot : day) {
                if (slot.equals(subject)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isSlotFilled(int day, int timeSlot) {
        return !schedule.get(day).get(timeSlot).equals("-");
    }
//hajar's part
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
        int subjectNumber;

    // Loop until a valid subject number is entered
    do {
        System.out.print("\nEnter subject number: ");
        subjectNumber = scanner.nextInt();

        if (subjectNumber < 1 || subjectNumber > 8) {
            System.out.println("\nInvalid subject number. Please enter a number between 1 and 8.");
        }
    } while (subjectNumber < 1 || subjectNumber > 8);


        String subject = getSubjectByNumber(subjectNumber);
        boolean found = false;

            for (List<String> day : schedule) {
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
    }
//part nana
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


    public void displaySchedule() {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        System.out.printf("%-10s %-10s %-12s%n", "\nDay", "Time", "Subject\n");

        for (int i = 0; i < DAYS; i++) {
            for (int j = 0; j < TIMESLOTS; j++) {
                if (j < schedule.get(i).size()) {
                    System.out.printf("%-10s %-10s %-12s%n", days[i], getTimeSlot(j), schedule.get(i).get(j));
                } else {
                    System.out.printf("%-10s %-10s %-12s%n", days[i], getTimeSlot(j), "-");
                }
            }
            System.out.println();
        }
    }

    public List<List<String>> getSchedule() {// we need this to get the schedule in the main class
        return schedule;
    }

    public void setTimetable(List<List<String>> schedule) {// we need this to set the schedule in the main class
        this.schedule = schedule;
    }
}