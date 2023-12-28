# CASE-STUDY-CSCI-1301
## GROUP 4

### Group Member

* PUTERI ANIS BINTI KHALIB (2218000)
* SITI HAJAR 'AAINAA BINTI HAMID (2218648)
* NURLYANA IZZATI BINTI RAHMAT (2227066)


### Assigned Tasks


|    Name      |     Task                                                                    |
|------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------|
|Anis           1. Add subject method - Allows users to add subjects to their schedule. It takes input for subject number, day, and timeslot, and checks for validity. |
|                2. display subject - Prints a list of available subjects.                                                                                             |
|                3. Add (countOccurrences()) - Counts the occurrences of a specific subject in the schedule.                                                           |
|                4. isSlotFilled() - Checks if a specific timeslot on a given day is already filled.                                                                   |
|                                                                                                                                                                      |
|Hajar          1. Drop subject method - Allows users to drop subjects from their schedule.                                                                            |
|                2. getCorrespondingDay() - Returns the corresponding day for a given day to handle two-day slots                                                      |
|                3. getSubjectByNumber() - Returns the subject name based on the subject number                                                                        |
|                                                                                                                                                                      |
|Lyana          1. getTimeslot methods -  Returns the formatted time slot based on the given timeslot                                                                  |
|                2. displayschedule - Displays the complete schedule, showing days, timeslots, and subjects.                                                           |
|                3. TestSchedule class   - Creates an instance of SchedulingSystem.                                                                                    |
|                                        |- Uses a Scanner to interactively manage the scheduling system through a menu:                                               |
|                                         |(add subject, drop subject, display schedule, exit).                                                                        |
|                                                                                                                                                                      |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------|

### OUTPUT

* DISPLAY SUBJECT
  ![Screenshot (337)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/196223c7-297d-48ed-be6f-6c6f5744bff6)
  
* ADD
  
* successfully added
  ![Screenshot (338)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/5c077bc2-4ab0-4ce7-89ae-1b6bca9f095e)
  
* invalid number
  ![Screenshot (339)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/a70a43c6-a1d8-4235-a8a1-342e8fab0648)
  
* invalid character - exception
  ![Screenshot (340)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/9a669a4c-793b-43e8-b344-f3d3f6f05551)
  
* overlapping with another subject 
  ![Screenshot (347)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/ca1ea8bc-4c89-49e1-aa01-f03b643a431e)


* DROP
* 
* successful dropped
  ![Screenshot (351)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/82d4ec3a-7da8-4607-84ac-e2e39c88345d)
  
* subject not available, invalid number
  ![Screenshot (352)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/a67e917d-dc43-484f-b0e7-502f0a4a4868)
  
* invalid character - exception
  ![Screenshot (342)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/d94b47c9-2b8b-4279-b1b6-87105cd673b6)

* DISPLAY
  
* blank display
![Screenshot (345)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/a441dd9b-e3cc-4f68-bf1b-831cf5f17302)
![Screenshot (346)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/2617db19-ad74-43fe-a07e-e3fba4873987)

* display filled schedule
  ![Screenshot (349)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/2b452aa2-6bd3-4193-a0c8-bd90f73c10ee)

* invalid number, invalid character, EXIT
  ![Screenshot (350)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/c9e2884f-6b74-45af-a973-3682c38915ca)




  
### Description of our case study (SchedulingSystem)

In this case study named SchedulingSytem.java., we build a simple scheduling system where the user can add subjects, drop subjects, display the timetable, and exit the program. We have fulfilled all the requirements needed. It contains 25 slots a week from Monday to Friday excluding lunch time. For the add subject function, 1 subject only has 2 meetings in a week. The next class will be scheduled the day after the week's first class. For the drop subject function, the user can drop subjects after adding the subject to the schedule. However, the drop function only works for the subject that is available in the slot that the user selected. For display subjects, there will be days, times, and courses that the user has added to the scheduling system.


### UML Diagram

![Screenshot (355)](https://github.com/PutAnis/CASE-STUDY-CSCI-1301/assets/148199929/ed27d8ff-c1ed-4d30-b0e2-fa82ec2e8e9d)


### REFERENCES
* Liang, D. (2020). Introduction to Java Programming and Data Structures. 12th Edition. Pearson Education, Inc.
* W3schools. (2019). Java Tutorial. W3schools.com. https://www.w3schools.com/java/default.asp
* Overview (Java Platform SE 8 ). (2019, September 11). Oracle.com. https://docs.oracle.com/javase/8/docs/api/overview- 
  summary.html


‌
‌
