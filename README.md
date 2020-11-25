# Amdocs

This is a set of instructions loading this application in your computer.

System requirements:
OS - Windows
IDE - Netbeans
Browser - Chrome
Link: http://localhost:8080/home

Stack used

Frontend:
HTML CSS

Backend:
Thymeleaf
Spring
Springboot
Lombok


First Step: Download Zip File and Unzip
1. Open the git link in your browser.
2. Click Code green button on the upper right corner to expand.
3. Choose Download Zip on the selection, save the file.
4. Unzip the whole file and it will provide you a whole Amdocs folder that contains the code.

Second Step: Open Project in Netbeans
1. Open Netbeans IDE.
2. Click File then Open Project.
3. Navigate through the location you saved the amdocs folder.
4. Click the folders until you see the amdocs Ma package, then click again to highlight.
5. Click Open Project button. That will load the package in the IDE successfully.
6. Going back to the IDE, right click the amdocs package inside the Projects box.
7. Click on Build. This will download and install all the dependencies of the application. This is important step before running the main program.

Third Step: Run the Program
1. Right click again the amdocs package inside the Project Box. This will run the whole program.
2. Go to your browser and load this link: http://localhost:8080/home ,You should see the UI.

Fourth Step: Actual Testing

First Test Scenario: Valid input test
1. Please use the values below as these are valid values to test.
ID: 1234567
Number: 1234567890
Comment: First test
Start Date: Todays date
End Date: November 30, 2020

Click Submit. This should be a successful input.

2. Going back to IDE, Click 'Window' in the panel list above. Choose 'Files'. This should show the created file in this format: new_file_1234567_1234567890_today'sdate.txt
Second Test Scenario: Invalid/Null/Empty input Test

Second Test Scenario: Validation Testing
1. Test the empty/null/invalid input: Click submit without putting any information. Validation messages will pop up upon doing this.
2. Test invalid inputs (These tests shouldn't work and will produce a error)
ID: Try numbers more than 7 digits or try an alphabet instead of number
Number: Try numbers more than 10 digits or try an alphabet instead of number
Comment: Try numbers more than 42 characters


==End of the Documentation==


