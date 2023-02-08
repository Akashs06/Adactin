package PageObjectManager;

import org.openqa.selenium.WebDriver;

import Adactin.com.Baseclass.BaseClass;
import Adactin.com.Locators.Cart_page;
import Adactin.com.Locators.Home_page;
import Adactin.com.Locators.Login_page;

public class PageObjectManager extends BaseClass{
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	private Login_page Login_page;
	private Home_page Home_page;
	private Cart_page Cart_page;
	
	
	public Cart_page getCart_page() {
		if (Cart_page == null) {
			Cart_page=new Cart_page(driver);
		}
		return Cart_page;
	}
	public Login_page getLogin_page() {
		if (Login_page == null) {
			Login_page=new Login_page(driver);
		}
		return Login_page;
	}
	public Home_page getHome_page() {
		if (Home_page == null) {
			Home_page= new Home_page(driver);
		}
		return Home_page;
	}

}
