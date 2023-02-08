package Adactin.com.Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static WebDriver driver;
	

	public static void browserLauch(String Browsername) {

		if (Browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("Webdriver.chrome.driver", ".\\src\\test\\resources\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public static void getUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println("unable to get URL " + e.getMessage());
		}
	}

	public static boolean elementDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element is not Displayed : " + e.getMessage());
		}
		return displayed;
	}

	public static void sentValue(WebElement element, String name) {
		try {
			clear(element);
			element.sendKeys(name);
		} catch (Exception e) {
			System.out.println("Unable to enter name  : " + e.getMessage());
		}
	}

	public static void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			System.out.println("Unable to clear  : " + e.getMessage());
		}
	}

	public static void elementClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("Unable to click  : " + e.getMessage());
		}
	}

	public static String getText(WebElement element) {
		String text = null;
		try {
			text = element.getText();
		} catch (Exception e) {
			System.out.println("Unable to get text  : " + e.getMessage());
		}
		return text;
	}

	public static void dropdown(WebElement element, String option, String i) {
		Select s = new Select(element);
		try {
			if (option.equals("index")) {
				s.selectByIndex(Integer.parseInt(i));

			} else if (option.equals("text")) {
				s.selectByVisibleText(i);
			} else if (option.equals("value")) {
				s.selectByValue(i);
			}
		} catch (NumberFormatException e) {
			System.out.println("Unable to Select  : " + e.getMessage());

		}
	}

	public static String Value_get(WebElement element, String value) {
		String text_value = null;
		try {
			text_value = element.getAttribute(value);
		} catch (Exception e) {
			System.out.println("Unable to get attribute value  : " + e.getMessage());
		}
		return text_value;
	}

	public static int converting_to_int(WebElement element, String value) {

		int intget = 0;
		try {
			String text_value = element.getAttribute(value);
			String trim = text_value.trim();
			String day = trim.replaceAll("[^0-9]", "");
			intget = Integer.parseInt(day);
		} catch (Exception e) {
			System.out.println("Unable to convert string to int  : " + e.getMessage());
		}
		return intget;

	}

	public static String Hotel_cart(List<WebElement> element, String value) {
		String names = null;
		for (WebElement webElement : element) {

			String attribute = webElement.getAttribute("value");
			if (attribute.contains(names)) {

			}
		}
		return names;

	}

	public static Map<String, String> read_property() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		String path = ".\\src\\test\\resources\\Property_file\\config.properties";
		FileReader file = new FileReader(path);
		Properties pro = new Properties();

		pro.load(file);

		Enumeration<Object> keys = pro.keys();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			String value = pro.getProperty(key);
			map.put(key, value);
		}
		return map;
	}

//	public static void write_data(int r, int c, String value) throws IOException {
//		
//		String path = ".\\src\\test\\resources\\TestData\\Test Data.xlsx";
//		File f = new File(path);
//		FileInputStream fis = new FileInputStream(f);
//		
//		Workbook wb = new XSSFWorkbook();
//		Sheet sheet = wb.getSheetAt(0);
//		Row row = sheet.getRow(r);
//		
//		int rowno=0;
//		for (Entry<String, String> entry : entrySet) {
//			Row createRow = sheet.createRow(rowno++);
//			createRow.createCell(0).setCellValue(entry.getKey());
//			createRow.createCell(1).setCellValue(entry.getValue());	
//		}
//
//		FileOutputStream fos = new FileOutputStream(f);
//		wb.write(fos);
//		fos.close();
//		
//	}

	public static void get_cell_data(String Sheetname, int rownum, int colnum, String data) throws IOException {
		String path = ".\\src\\test\\resources\\TestData\\Test Data.xlsx";
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);

		if (!f.exists()) {
			Workbook wb = new XSSFWorkbook();
			FileOutputStream fos = new FileOutputStream(f);
			wb.write(fos);
		}
		fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);

		if (wb.getSheetIndex(Sheetname) == -1)
			wb.createSheet(Sheetname);

		Sheet sheet = wb.getSheet(Sheetname);

		if (sheet.getRow(rownum) == null)
			sheet.createRow(rownum);
		Row row = sheet.getRow(rownum);

		Cell Cell = row.createCell(colnum);
		Cell.setCellValue(data);

		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
		fos.close();

	}

	public static String getAttribute(WebElement element, String value) {
		String a = null;
		try {
			a = element.getAttribute(value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
	}

	public static void write_xl(int r, int c, String value) throws IOException {

		File f = new File(".\\src\\test\\resources\\TestData\\Test Data.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		Row row = sheetAt.getRow(r);
		if (row == null) {
			row = sheetAt.createRow(r);
		}
		Cell cell = row.getCell(c);
		if (cell == null) {
			cell = row.createCell(c);
			cell.setCellValue(value);
			FileOutputStream out = new FileOutputStream(f);
			wb.write(out);
			out.close();
		}

	}

	public static String getAttribute1(WebElement element, String value) {
		String a = null;
		try {
			getAttribute(element, value);
			a = element.getAttribute(value);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
	}

	
}
