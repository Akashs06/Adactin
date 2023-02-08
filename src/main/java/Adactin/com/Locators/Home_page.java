package Adactin.com.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Adactin.com.Baseclass.BaseClass;

public class Home_page extends BaseClass{
	
	public Home_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username_show")
	public WebElement verify_loginname;
	
	@FindBy(id = "location")
	public WebElement select_location;
	
	@FindBy(id = "hotels")
	public WebElement select_hotel;
	
	@FindBy(id = "room_type")
	public WebElement select_room_type;
	
	@FindBy(id = "room_nos")
	public WebElement select_room_number;
	
	@FindBy(id = "datepick_in")
	public WebElement Select_check_in_date;
	
	@FindBy(id = "datepick_out")
	public WebElement Select_check_out_date;
	
	@FindBy(id = "Submit")
	public WebElement submit_btn;
	
	@FindBy(id = "checkout_span")
	public WebElement Error_message;
	

	
	
	
	
	
}
