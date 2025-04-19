package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver ;
	
//  way 1 (Launch particular Browser) // Browser launch
public static WebDriver ChromeBrowser() {
WebDriver driver = new ChromeDriver();
return driver;
}
public static WebDriver EdgeDriver() {
WebDriver driver = new EdgeDriver();
return driver;
}

//(or)    way 2 (switch statements )	Real time examples (to check all browser)
public static WebDriver browserLaunch(String browser) {
switch(browser) {
case "chrome" :
driver= new ChromeDriver();
break;
case "edge"	:
driver= new EdgeDriver();
break;
case "firefox"	 :
driver= new FirefoxDriver();
break;
default :
throw new WebDriverException ();
}
return driver;
}
////(or)          way 3 ( if statements )
//public static WebDriver BrowserLaunch (String browser1)  {
//if(browser1.equalsIgnoreCase("chrome")) {
//driver = new ChromeDriver();
//}
//else if(browser1.equalsIgnoreCase("edge")) {
//driver= new EdgeDriver();
//}
//else if(browser1.equalsIgnoreCase("firefox")) {
//driver = new FirefoxDriver();
//}   
//return driver;      
//}

public static void urlLaunch (String url) {      
driver.get(url);
}

public static void maximize() {                   // maximize()
driver.manage().window().maximize();
}

public static void implicityWait(int sec) {       // implicityWait()
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
}
// without pagefactory  
public static WebElement txtusername() {
WebElement txtusername = driver.findElement(By.id("email"));
return txtusername;
}

public static void sendKeys(WebElement e,String value) { // sendKeys()
e.sendKeys(value);  
}

public static void click(WebElement e) {         //
e.click();
}
public static void selectByIndex(WebElement e, int i) {
Select s = new Select(e);
s.selectByIndex(i);
}
public static String currentUrl() {
String currentUrl = driver.getCurrentUrl();
return currentUrl;
}

public static String getAttribute(WebElement e ) {
String text = e.getAttribute("value")  ;
return text;
}
public static String getText(WebElement e) {
String text = e.getText();
return text;
}
public static void moveToElement(WebElement src) {
Actions a = new Actions(driver);
a.moveToElement(src).perform();
}
public static void dragAnddrop(WebElement src,WebElement des) {
Actions a = new Actions(driver);
a.dragAndDrop(src, des);
}
public static void WindowHandle() {
String parentId= driver.getWindowHandle();
driver.switchTo().window(parentId);
}
public static void screenshot(String f) {
TakesScreenshot tk = (TakesScreenshot)driver;
File src = tk.getScreenshotAs(OutputType.FILE);
File des = new File (f);
}
public static void Date(WebElement e,String s) {
e.sendKeys(s);
}

public static void close() {
driver.close();
}
public static void quit() {
driver.quit();
}
public static String readExcel(String filename,String sheet, int row,int c) throws IOException{
File f = new File("C:\\Users\\ibm\\eclipse-workspace\\Berlin\\NewMaven\\src\\test\\resources\\Excel\\"+filename+".xlsx");
FileInputStream st = new FileInputStream(f);
Workbook w = new XSSFWorkbook(st);
Sheet s = w.getSheet(sheet);
Row r = s.getRow(row);
Cell cell = r.getCell(c);
System.out.println(cell);
int type = cell.getCellType();
String value = null;
if(type==1) { 
value = cell.getStringCellValue();
}
else {
if(DateUtil.isCellDateFormatted(cell)) {
Date date = cell.getDateCellValue();
SimpleDateFormat sd = new SimpleDateFormat("dd-mmm-yyy");
 value = sd.format(date);
}
else {
double numeric = cell.getNumericCellValue();
long num = (long)numeric;
 value = String.valueOf(num);
}
}
return value;
}
}
