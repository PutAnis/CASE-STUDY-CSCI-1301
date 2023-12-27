import java.util.Scanner;
public class TestTimetable {
    public static void main(String[] args) {
        TimetableManager timetableManager = new TimetableManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Subject  2. Drop Subject  3. Display Timetable  4. Exit");
            System.out.print("\nSelect option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    timetableManager.addSubject( scanner);
                    break;
                case 2:
                    timetableManager.dropSubject(scanner);
                    break;
                case 3:
                    timetableManager.displayTimetable();
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
}