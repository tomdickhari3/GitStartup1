package org.pageobject;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FcRegisterPage extends BaseClass {
	public FcRegisterPage() {
		PageFactory.initElements(driver, this);
	}
// BtnCreate
@FindBy(xpath="((//a[@role='button'])[2])")
private WebElement btnCreate;

public WebElement getBtnCreate() { //Source->Getters
	return btnCreate;
	}
		
// firstname,last name :
@FindBy(name="firstname")	
private WebElement firstname;
@FindBy(name="lastname")
private WebElement surname;

public WebElement getFirstname() { //Source->Getters
	return firstname;
    }
public WebElement getSurname() {
	return surname;
	}

// date,month,year :

@FindBy(id="day")
private WebElement date;
@FindBy(xpath="//Select[@title='Month']")
private WebElement month;
@FindBy(name="birthday_year")
private WebElement year;

public WebElement getDate() { // Source-> Getters
	return date;
}
public WebElement getMonth() {
	return month;
}
public WebElement getYear() {
	return year;
}
// Gender :
@FindBy(xpath="(//label[@class='_58mt'])[1]")
private WebElement female;

public WebElement getFemale() {
	return female;
}
// Mobile No :
@FindBy(name="reg_email__")
private WebElement mobileno;

public WebElement getMobileno() {
	return mobileno;
}
@FindBy(xpath="//input[@type='password']")
private WebElement password;

public WebElement getPassword() {
	return password;
}

}
