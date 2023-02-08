@login
Feature: Smoke test Automation


Background:
		Given user Launch the "Browser" browser
    And user navigate to the URL "URL"
    Then user validate the login page
    And user enter the valid Username "Adactin_UserName"
    And user enter the valid password "Adactin_Password"
    And user click the Login button 
    Then user verify the login successful 

  @TC101
  Scenario: To verify valid login details
    
    And user enter the valid Username "Adactin_UserName"
    And user enter the valid password "Adactin_Password"
    And user click the Login button 
    Then user verify the login successful 
    
   @TC02 
   Scenario: To verify Invalid login details
    
    And user enter the valid Username "aka"
    And user enter the valid password "Akash0612"
    And user click the Login button 
    And user enter the valid Username "Akash061298"
    And user enter the valid password "aka"
    And user click the Login button 
    And user enter the valid Username "aka"
    And user enter the valid password "aka"
    And user click the Login button 
    Then user verify the error message "Invalid Login details or Your Password might have expired. Click here to reset your password"
    
    @TC03
    Scenario Outline:To verify Invalid login details
		
    And user enter the valid Username <username>
    And user enter the valid password <password>
    And user click the Login button 
    Then user verify the error message "Invalid Login details or Your Password might have expired. Click here to reset your password"
    Examples:
    |username|password|
    |"aka"|"Akash0612"|
    |"Akash061298"|"aka"|
    |"aka"|"aka"|
    
    @TC102 
    Scenario: To verify whether the check-outdate field accepts a later date than check-in date.
    
    And Select location as "Location"
    And Select Hotel as "Hotel"
    And Select Room Type as "Room_Type"
    And Select Number of Rooms as "Number_of_Rooms"
    And Select Check-in-date as  "13/01/2023"
    And Select Check-out-date as "11/01/2023"
    And user click the submit button
    Then user verify the date error message "Check-Out Date shall be after than Check-In Date"
    
    @TC103
    Scenario: To Check if error is date field is in the past
    
    And Select location as "Location"
    And Select Hotel as "Hotel"
    And Select Room Type as "Room_Type"
    And Select Number of Rooms as "Number_of_Rooms"
    And Select Check-in-date as  "3/01/2023"
    And Select Check-out-date as "5/01/2023"
    And user click the submit button
    Then user verify the date error message "Check-Out Date shall be after than Check-In Date"
    
    @TC102-03
    Scenario Outline: To verify whether the check-outdate field accepts a later date than check-in date and To Check if error is date field is in the past &
		And Select location as "Location"
    And Select Hotel as "Hotel"
    And Select Room Type as "Room_Type"
    And Select Number of Rooms as "Number_of_Rooms"
		And Select Check-in-date as  <check-in-date>
    And Select Check-out-date as <check-out-date>
    And user click the submit button
    Then user verify the date error message "Check-Out Date shall be after than Check-In Date"
    Examples:
    |check-in-date|check-out-date|
    |"13/01/2023"|"11/01/2023"|
    |"3/01/2023"|"5/01/2023"|
    
    
    @TC104 @smoke
    Scenario: To verify whether locations in Select Hotel page are displayed according to the location selected in Search Hotel
    And Select location as "Location"
    And Select Hotel as "Hotel"
    And Select Room Type as "Room_Type"
    And Select Number of Rooms as "Number_of_Rooms"
    And Select Check-in-date as  "Check_in_date"
    And Select Check-out-date as "Check_out_date"
    And user click the submit button
    Then Verify Hotel name is same as selected in search Hotel form "Hotel"

		@TC105
		Scenario: To verify date and Check Out date are being displayed in Select Hotel Page according to the dates selected in search Hotel.
		And Select location as "Location"
    And Select Hotel as "Hotel"
    And Select Room Type as "Room_Type"
    And Select Number of Rooms as "Number_of_Rooms"
    And Select Check-in-date as  "Check_in_date"
    And Select Check-out-date as "Check_out_date"
    And user click the submit button
		Then User Verify the that check-in-date and check-outdates are the same as selected in search hotel 
		
		
		@TC108
		Scenario: To verify whether the total price (excl.GST) is calculated as “price per night * no. of nights* no of rooms”.
    And Select location as "Location"
    And Select Hotel as "Hotel"
    And Select Room Type as "Room_Type"
    And Select Number of Rooms as "Number_of_Rooms"
    And Select Check-in-date as  "Check_in_date"
    And Select Check-out-date as "Check_out_date"
    And user click the submit button
    Then user validate the total price as price per nights = no. of nights * no. of rooms
    
    
    @TC109
    Scenario: To verify when pressed, logout button logs out from the application.
    And Select location as "Location"
    And Select Hotel as "Hotel"
    And Select Room Type as "Room_Type"
    And Select Number of Rooms as "Number_of_Rooms"
    And Select Check-in-date as  "Check_in_date"
    And Select Check-out-date as "Check_out_date"
    And user click the submit button
    And user click the Logout button
    Then user verify the application logout successful "You have successfully logged out. Click here to login again"
    
    
    @TC110 @smoke
    Scenario: get all values from Map
    And Select location as "Location"
    And Select Hotel as "Hotel"
    And Select Room Type as "Room_Type"
    And Select Number of Rooms as "Number_of_Rooms"
    And Select Check-in-date as  "Check_in_date"
    And Select Check-out-date as "Check_out_date"
    And user click the submit button
    Then get all the entries from Map
    
    
    
    
    