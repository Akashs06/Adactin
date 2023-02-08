package Adactin.com.Locators;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Adactin.com.Baseclass.BaseClass;

public class Cart_page extends BaseClass{
	
	public Cart_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	
	@FindBy(xpath = "(//form[@id='select_form']//tr)[2]//tr[2]//td[2]//input")
	private WebElement Hotel_name;
	
	public WebElement getHotel_name() {
		return Hotel_name;
	}

	public void setHotel_name(WebElement hotel_name) {
		Hotel_name = hotel_name;
	}


	@FindBy(xpath = "(//form[@id='select_form']//tr)[2]//tr[2]//td//input")
	public List<WebElement> Hotel_Details;

	
	@FindBy(xpath = "(//form[@id='select_form']//tr)[2]//tr[2]//td[4]/input")
	public WebElement no_of_rooms;
	
	@FindBy(xpath = "(//form[@id='select_form']//tr)[2]//tr[2]//td[9]/input")
	public WebElement price_per_night;
	
	
	@FindBy(xpath = "(//form[@id='select_form']//tr)[2]//tr[2]//td[10]/input")
	public WebElement total_price;
	
	@FindBy(xpath = "(//form[@id='select_form']//tr)[2]//tr[2]//td[5]/input")
	public WebElement Check_in_date;
	
	@FindBy(xpath = "(//form[@id='select_form']//tr)[2]//tr[2]//td[6]/input")
	public WebElement Check_out_date;
	
	
	@FindBy(xpath = "(//form[@id='select_form']//tr)[2]//tr[2]//td[7]/input")
	public WebElement no_of_days;
	
	
	@FindBy(xpath = "(//form[@id='select_form']//tr)[2]//tr[2]//td//input")
	public List<WebElement> table;
	
	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement Logout_btn;
	
	@FindBy(xpath = "//td[@class='reg_success']")
	public WebElement Logout_text;
	
	@FindBy(xpath = "/td[@class='reg_success']")
	public WebElement text_check;
	
	
	
}
	
	

