package org.pageobject;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FcLoginPage extends BaseClass {
		public FcLoginPage() {
			PageFactory.initElements(driver, this);
		     }
		@FindBy(id="email")
		private WebElement Txtusername;
		@FindBy(id= "pass")
		private WebElement Txtpassword;
		@FindBy(name="login")
		private WebElement btnLogin;

		// Source -> Getters & Setters -> Select Getters
		public WebElement getTxtusername() {
			return Txtusername;
		 }
		public WebElement getTxtpassword() {
			return Txtpassword;
		 }
		public WebElement getBtnLogin() {
			return btnLogin;
		 }
}
