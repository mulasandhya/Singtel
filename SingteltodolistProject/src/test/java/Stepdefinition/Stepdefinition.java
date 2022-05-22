package Stepdefinition;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Stepdefinition {
	WebDriver drivers=null;
	@Given("user is entering todomvc.com")
	public void user_is_entering_todomvc_com() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sandy\\Downloads\\chromedriver_win32\\chromedriver.exe");
		drivers=new ChromeDriver();
		drivers.get("https://todomvc.com/examples/vue/");
		System.out.println("Page title is:" + drivers.getTitle()); 
	    
	}

	@And("user is on MVC To do list application page")
	public void user_is_on_mvc_to_do_list_application_page() {
	System.out.println("User is on the to do list application page");
	}

	@Given("user enters item in the ToDo list")
	public void user_enters_item_in_the_to_do_list(DataTable dataTable) throws InterruptedException {
	 	
		List<Map<String, String>> listdata =dataTable.asMaps(String.class, String.class);
	  		drivers.findElement(By.xpath("/html/body/section/header/input")).sendKeys(listdata.get(0).get("Item1")); 
			drivers.findElement(By.xpath("/html/body/section/header/input")).sendKeys(Keys.RETURN);
			Thread.sleep(500);
			drivers.findElement(By.xpath("/html/body/section/header/input")).sendKeys(listdata.get(1).get("Item1")); 
			drivers.findElement(By.xpath("/html/body/section/header/input")).sendKeys(Keys.RETURN);
			Thread.sleep(50);
			drivers.findElement(By.xpath("/html/body/section/header/input")).sendKeys(listdata.get(2).get("Item1")); 
			drivers.findElement(By.xpath("/html/body/section/header/input")).sendKeys(Keys.RETURN);
			Thread.sleep(50);
			drivers.findElement(By.xpath("/html/body/section/header/input")).sendKeys(listdata.get(3).get("Item1"));
			drivers.findElement(By.xpath("/html/body/section/header/input")).sendKeys(Keys.RETURN);
			Thread.sleep(1000);
	}
	
	//Scenario1: All active items in the todolist after user adds the item in Todolist
	
	@Then("user to do list should contain {string} in the footer")
	public void user_to_do_list_should_contain_in_the_footer(String string) {
		String fouritemsleft =drivers.findElement(By.xpath("/html/body/section/footer/ul")).getAttribute(string);
		System.out.println("fouritemsleft");
	}

	@Then("user checks the radiobutton for Cheese item from the todolist")
	public void user_checks_the_radiobutton_for_cheese_item_from_the_todolist() throws InterruptedException {
		drivers.findElement(By.xpath("/html/body/section/section/ul/li[1]/div/input")).click();
		Thread.sleep(1000);
		  
	}
	//Scenario2: All Completed items in the to do list once user add one item in the todolist
	
	@Given("user clicks on Completed task list")
	public void user_clicks_on_completed_task_list() throws InterruptedException {
	    drivers.findElement(By.xpath("/html/body/section/footer/ul/li[3]/a")).click();
	    Thread.sleep(1000);
	}
	
	@Given("user verifies Items in Completed task list")
	public void user_verifies_items_in_completed_task_list() {
	String threeitemsleft=drivers.findElement(By.xpath("/html/body/section/section/ul/li/div/label")).getText();   
	System.out.println("threeitemsleft");
	}
	
	//Scenario 3: After one item moved to Completed, verify the Clear completed To do list
	@Then("user click on Clear Completed to do list")
	public void user_click_on_clear_completed_to_do_list() throws InterruptedException {
	 drivers.findElement(By.xpath("/html/body/section/footer/button")).click(); 
	 Thread.sleep(1000);
	}

	@Then("user verifies Item should be cleared from the Clear completed list of todolist")
	public void user_verifies_item_should_be_cleared_from_the_clear_completed_list_of_todolist() {
		String threeitemsleft =drivers.findElement(By.xpath("/html/body/section/footer/ul")).getText();
		System.out.println("threeitemsleft");
	}
	
	//Scenario 4: Verify the Active todolist once the one to do item is cleared from the todo list
	@Then("user clicks on Active To do list")
	public void user_clicks_on_active_to_do_list() {
	drivers.findElement(By.xpath("/html/body/section/footer/ul/li[2]/a")).click();
	}

	@Then("user verifies Items in Active Todo list")
	public void user_verifies_items_in_active_todo_list() {
		String threeitemsleft =drivers.findElement(By.xpath("/html/body/section/footer/ul")).getText();
		System.out.println("threeitemsleft");
	}

}

	

