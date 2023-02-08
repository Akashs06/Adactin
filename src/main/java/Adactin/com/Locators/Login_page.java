package Adactin.com.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Adactin.com.Baseclass.BaseClass;

public class Login_page extends BaseClass{
	
	public Login_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "img[alt='AdactIn Group']")
	private WebElement Logo;

	public WebElement getLogo() {
		return Logo;
	}
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "login")
	public WebElement login_btn;
	
	@FindBy(css = "div[class='auth_error']")
	public WebElement Error_msg;
	
	
	
	
	
	
}
