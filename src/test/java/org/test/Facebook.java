package org.test;

import java.util.Date;

import org.base.BaseClass;
import org.pageobject.FcLoginPage;
import org.pageobject.FcRegisterPage;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
public class Facebook extends BaseClass {
@BeforeClass
private void beforeclass() {
  browserLaunch("chrome");
  maximize();
  implicityWait(10);
  }
	  
@AfterClass
private void afterclass() {
  quit();
 }
@BeforeMethod         
private void before() {
 Date d = new Date();
 System.out.println("Stating time : " + d);
 }
@AfterMethod
 private void after() {
  Date d = new Date();
  System.out.println("Ending time : " + d);
 }
@Test(priority = -4)
private void test1() throws InterruptedException{
 SoftAssert s = new SoftAssert();
  urlLaunch ("https://www.facebook.com/")	;
  s.assertTrue(currentUrl().contains("facebook"),"Verify Url");
 FcLoginPage l = new FcLoginPage();
  Thread.sleep(1000);
  sendKeys(l.getTxtusername(),"Arun");
  s.assertEquals(getAttribute(l.getTxtusername()),"Alex","Verify Username"); // failed assert
  sendKeys(l.getTxtpassword(),"12arun@34");
  s.assertEquals(getAttribute(l.getTxtpassword()),"12arun@34","Verify Password");
  click(l.getBtnLogin());
  s.assertAll();                                                             //capture assert result
  }
@Test(priority= -1)
private void test2() {
  System.out.println(1/0); // failed testCase
 }
@Test(priority= 4, invocationCount=2)
private void test3() throws InterruptedException {
   urlLaunch ("https://www.facebook.com/")	;
 FcRegisterPage r = new FcRegisterPage();
  click(r.getBtnCreate());
  Thread.sleep(2000);
  SoftAssert s = new SoftAssert();
  s.assertTrue(currentUrl().contains("entry_point"),"Verify Registration Page");
  sendKeys(r.getFirstname(),"Arun");
  sendKeys(r.getSurname(),"Pandian");
  selectByIndex(r.getDate(), 2) ;
  selectByIndex(r.getMonth(),5);
  selectByIndex(r.getYear(), 1);
  click(r.getFemale());
  sendKeys(r.getMobileno(),"9867574538");
  s.assertEquals(getAttribute(r.getMobileno()),"9867574538");
  s.assertAll();  //capture assert result
       
		}
}

