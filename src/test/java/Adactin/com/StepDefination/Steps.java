package Adactin.com.StepDefination;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import Adactin.com.Baseclass.BaseClass;
import PageObjectManager.PageObjectManager;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Steps extends BaseClass {
	static Map<String, String>tdata=new LinkedHashMap<String, String>();
	PageObjectManager obj = new PageObjectManager(driver);
	
	@Given("user Launch the {string} browser")
	public void user_launch_the_browser(String string) throws IOException {
	    browserLauch(read_property().get(string));
	}

	@Given("user navigate to the URL {string}")
	public void user_navigate_to_the_url(String string) throws IOException {
	    getUrl(read_property().get(string));  
	}
	@After (order=1)
	@Then("user validate the login page") 
	public void user_validate_the_login_page() {
		Assert.assertTrue(elementDisplayed(obj.getLogin_page().getLogo()));     
	}

	@Then("user enter the valid Username {string}")
	public void user_enter_the_valid_username(String string) throws IOException {
    sentValue(obj.getLogin_page().username, read_property().get(string));
	}

	@Then("user enter the valid password {string}")
	public void user_enter_the_valid_password(String string) throws IOException {
    sentValue(obj.getLogin_page().password, read_property().get(string));
	}

	@Then("user click the Login button")
	public void user_click_the_login_button() {
	elementClick(obj.getLogin_page().login_btn);
	}

	@Then("user verify the login successful")
	public void user_verify_the_login_successful() {
    Assert.assertTrue(elementDisplayed(obj.getHome_page().verify_loginname));
	}
	@Then("user verify the error message {string}")
	public void user_verify_the_error_message(String string) {
	Assert.assertEquals(string, getText(obj.getLogin_page().Error_msg));
	}

	@Then("Select location as {string}")
	public void select_location_as(String string) throws IOException {
	    dropdown(obj.getHome_page().select_location, "text", read_property().get(string));
	    tdata.put("Location", read_property().get(string));
	}
	@Then("Select Hotel as {string}")
	public void select_hotel_as(String string) throws IOException {
		dropdown(obj.getHome_page().select_hotel, "text", read_property().get(string));
	    tdata.put("Hotel Name", read_property().get(string));
	}
	@Then("Select Room Type as {string}")
	public void select_room_type_as(String string) throws IOException {
		dropdown(obj.getHome_page().select_room_type, "text", read_property().get(string));	
		tdata.put("Room Type", read_property().get(string));
	}
	
	@Then("Select Number of Rooms as {string}")
	public void select_number_of_rooms_as(String string) throws IOException {
		dropdown(obj.getHome_page().select_room_number, "value", read_property().get(string));
		tdata.put("Number_of_rooms", read_property().get(string));
	}
	@Then("Select Check-in-date as  {string}")
	public void select_check_in_date_as(String string) throws IOException {
	    sentValue(obj.getHome_page().Select_check_in_date, read_property().get(string));
	    tdata.put("Check_in_date", read_property().get(string));
	    
	}
	@Then("Select Check-out-date as {string}")
	public void select_check_out_date_as(String string) throws IOException {
		sentValue(obj.getHome_page().Select_check_out_date, read_property().get(string));
		 tdata.put("Check_out_date", read_property().get(string));
	}
	@Then("user click the submit button")
	public void user_click_the_submit_button() {
	    elementClick(obj.getHome_page().submit_btn);
	}
	@Then("user verify the date error message {string}")
	public void user_verify_the_date_error_message(String string) {
	    Assert.assertEquals(string, getText(obj.getHome_page().Error_message));  
	}
	
	@Then("Verify Hotel name is same as selected in search Hotel form {string}")
	public void verify_hotel_name_is_same_as_selected_in_search_hotel_form(String string) {	
		Assert.assertEquals(tdata.get("Hotel Name"), Value_get(obj.getCart_page().getHotel_name(),"value"));
	}
	
	@Then("User Verify the that check-in-date and check-outdates are the same as selected in search hotel")
	public void user_verify_the_that_check_in_date_and_check_outdates_are_the_same_as_selected_in_search_hotel() {
	    Assert.assertEquals(tdata.get("Check_in_date"),Value_get(obj.getCart_page().Check_in_date, "value") );
	    Assert.assertEquals(tdata.get("Check_out_date"), Value_get(obj.getCart_page().Check_out_date, "value"));
	}
	
	@Then("user validate the total price as price per nights = no. of nights * no. of rooms")
	public void user_validate_the_total_price_as_price_per_nights_no_of_nights_no_of_rooms() {
	    
		int days = converting_to_int(obj.getCart_page().no_of_days, "value");
	    int room = converting_to_int(obj.getCart_page().no_of_rooms,"value");
	    int price_per_night = converting_to_int(obj.getCart_page().price_per_night, "value");
	    int Expected_price= (days*room)*price_per_night;
	    int actual_price = converting_to_int(obj.getCart_page().total_price, "value");
	    Assert.assertEquals(Expected_price, actual_price);  
	}
	
	@Then("user click the Logout button")
	public void user_click_the_logout_button() {
	    elementClick(obj.getCart_page().Logout_btn);
	}
	@Then("user verify the application logout successful {string}")
	public void user_verify_the_application_logout_successful(String string) {
	   Assert.assertEquals(string, getText(obj.getCart_page().Logout_text));   
	}
	@Given("get all the entries from Map")
	public void get_all_the_entries_from_map() throws IOException {
		
		String Actual = getAttribute(obj.getCart_page().getHotel_name(), "value");
		
		Assert.assertEquals(tdata.get("Hotel Name"), Actual);
		
		
		List<WebElement>l=obj.getCart_page().Hotel_Details;
		
		for (int i = 0; i < l.size(); i++) {
			write_xl(0, i, getAttribute(l.get(i), "value"));
		}
		
		
		
//		Set<Entry<String, String>> entrySet = tdata.entrySet();
//		
//		String path=".\\src\\test\\resources\\TestData\\Test Data.xlsx";
//		File f=new File(path);
//		FileInputStream fis=new FileInputStream(f);
//		Workbook wb=new XSSFWorkbook(fis);
//		Sheet sheet = wb.getSheetAt(0);
//		
//		int rowno=0;
//
//		for (Entry<String, String> entry : entrySet) {
//			Row createRow = sheet.createRow(rowno++);
//			createRow.createCell(0).setCellValue(entry.getKey());
//			createRow.createCell(1).setCellValue(entry.getValue());	
//		}
//		FileOutputStream out=new FileOutputStream(f);
//		wb.write(out);
//		out.close();		
}
	
	
	
	
	
	
	
	
	
	
}