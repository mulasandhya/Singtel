Feature: Feature to test the ToDo list of application

  Scenario Outline: Verify the ToDolist of the application
    Given user is entering todomvc.com
    And user is on MVC To do list application page
    And user enters item in the ToDo list
      | Item1  |
      | Sunday |
      | Monday |
      | Tuesday |
      | Wednesday |
    Then user to do list should contain "4 Items Left" in the footer
    And user checks the radiobutton for Cheese item from the todolist
    And user clicks on Completed task list
    And user verifies Items in Completed task list
    And user click on Clear Completed to do list
    And user verifies Item should be cleared from the Clear completed list of todolist 
    And user clicks on Active To do list
    And user verifies Items in Active Todo list
    

