# CASE-STUDY-CSCI-1301
#GROUP 4#

##Group Member##
PUTERI ANIS BINTI KHALIB (2218000)
SITI HAJAR 'AAINAA BINTI HAMID (2218648)
NURLYANA IZZATI BINTI RAHMAT (2227066)


    Name      |     Task
------------- | -------------
Anis          | add subject method,display subject
Hajar         | function for add and drop method,TestSchedulingSystem class
Lyana         | drop subject,displayschedule


In SchedulingSytem.java. in this case study, we build a simple scheduling system where the user able to add subjects, drop subjects, display timetable and exit the program. We have fulfill all the requirements neeeded. It contains 25 slots in a week from Monday to Friday excluding lunch time. For add subject function, 1 subject only have 2 meetings in a week. The next class will be scheduled the day after the first class of the week. For drop subject function, user can drop subjects after adding the subject into schedule. However, drop function only works to subject that available in the slot that user selected. For display subject, there will be day, time and courses that user have added into the schedulingsystem.


+--------------------------+
|   SchedulingSystem       |
+--------------------------+
| - DAYS: int               |
| - TIMESLOTS: int           |
| - SLOT_DURATION: int       |
| - START_HOUR: int          |
| - START_MINUTE: int        |
| - schedule: List<List<String>>|
+--------------------------+
| + SchedulingSystem()      |
| + initializeSchedule(): void|
| + displaySubjects(): void |
| + addSubject(Scanner): void|
| + countOccurrences(String): int|
| + isSlotFilled(int, int): boolean|
| + getSubjectByNumber(int): String|
| + getCorrespondingDay(int): int|
| + dropSubject(Scanner): void|
| + getTimeSlot(int): String|
| + displaySchedule(): void |
| + getSchedule(): List<List<String>>|
| + setSchedule(List<List<String>>): void|
+--------------------------+
