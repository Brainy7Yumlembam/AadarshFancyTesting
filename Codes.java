package SimpleTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AadarshFancyProject 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver d = new FirefoxDriver();
		d.get("https://aadarshfancy.co.in/");
		d.manage().window().maximize();
		 String[] xpaths= {"//input[@placeholder='Search Product']", "//a[@href='login.php']"};
		 
		 for (String xpath : xpaths ) 
		 {
			 WebElement e = d.findElement(By.xpath(xpath));
		
			 if (e.isDisplayed()) 
			 {
				 System.out.println("The web page is displayed:" + xpath);
			 }
			 else
			 {
				 System.out.println("The web page is not displayed:" + xpath);
			 }
		 }
		 
		 // I click on the Men section
		 
		 d.findElement(By.xpath("//a[text()='Men']")).click();
		 
		 String[] xpath2= {"//h3[text()='Categories']", "//h1[text()='Category: Men']"};
		 
		 for (String xpath : xpath2 ) 
		 {
		 WebElement e1 = d.findElement(By.xpath(xpath));
		 if (e1.isDisplayed()) 
		 {
			 System.out.println("The web page is displayed:" + xpath);
		 }
		 else
		 {
			 System.out.println("The web page is not displayed:" + xpath);
		 }
		 }
		 
	//Home page done ****************************************************************
		
		 d.findElement(By.xpath("//a[text()='Home']")).click();
		 
		 //  I enter Valid search term in the search box
		 d.findElement(By.xpath("//input[@placeholder='Search Product']")).sendKeys("Shirt");
		 d.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 WebElement e2= d.findElement(By.xpath("//div[@style='background-image:url(assets/uploads/product-featured-117.jpg);']"));
		
		if (e2.isDisplayed())
		{
			System.out.println("The page is displayed");
			
		}
		else
		{
			System.out.println("The page is not displayed");
		}
		 
		//  Test search functionality with invalid inputs
		d.findElement(By.xpath("//a[text()='Home']")).click();
		
		 d.findElement(By.xpath("//input[@placeholder='Search Product']")).sendKeys("Gun");
		 d.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 WebElement e3= d.findElement(By.xpath("//span[text()='No result found']"));
		 if (e3.isDisplayed())
			{
				System.out.println("No result found is showing");
				
			}
			else
			{
				System.out.println("There is a bug in the application");
			}
		
		 //   Verify product information display    Scenario: Verify product information display
		 
		 d.findElement(By.xpath("//a[text()='Home']")).click();
		 d.findElement(By.xpath("//input[@placeholder='Search Product']")).sendKeys("Shirt");
		 d.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 d.findElement(By.xpath("//a[@href='product.php?id=123']")).click();
		 
		 WebElement e4= d.findElement(By.xpath("//div[@class='col-md-7']"));
		 if (e4.isDisplayed())
			{
				System.out.println("I see the product details, name and price");
				
			}
			else
			{
				System.out.println("There is a bug in the application");
			}
		
		 // cart and checkout process   Scenario: Add and remove items from the cart
		 
		 d.findElement(By.xpath("//input[@type='submit']")).click();
		 d.findElement(By.xpath("//a[@href='cart.php']")).click();
		 d.findElement(By.xpath("//i[@class='fa fa-trash']")).click();
		 
		 WebElement e5= d.findElement(By.xpath("//div[@class='col-md-12']"));
		 if (e5.isDisplayed())
			{
				System.out.println("Cart is empty");
				
			}
			else
			{
				System.out.println("There is a bug in the application");
			}
		
		 // Scenario: Verify the checkout process
		 
		 d.findElement(By.xpath("//input[@placeholder='Search Product']")).sendKeys("Shirt");
		 d.findElement(By.xpath("//button[@type='submit']")).click();
		 
		 d.findElement(By.xpath("//a[@href='product.php?id=123']")).click();
		 d.findElement(By.xpath("//input[@type='submit']")).click();
		 
		 d.findElement(By.xpath("//a[@href='cart.php']")).click();
		 
		 d.findElement(By.xpath("//a[@href='checkout.php']")).click();
		 WebElement e6= d.findElement(By.xpath("//h1[text()='Checkout']"));
		 if (e6.isDisplayed())
			{
				System.out.println("Checkout page is diaplayed");
				
			}
			else
			{
				System.out.println("There is a bug in the application");
			}
		 
		 //Feature: User Account Management      Scenario: Test user registration

		 d.findElement(By.xpath("//a[@href='registration.php']")).click();
		 
		 d.findElement(By.xpath("//input[@name='cust_name']")).sendKeys("Jagu");
		 d.findElement(By.xpath("//input[@name='cust_cname']")).sendKeys("MyCompany");
		 d.findElement(By.xpath("//input[@name='cust_email']")).sendKeys("brainyyumlembam3@gmail.com");
		 d.findElement(By.xpath("//input[@name='cust_phone']")).sendKeys("9846853523");
		 d.findElement(By.xpath("//textarea[@name='cust_address']")).sendKeys("Mumbai");

		 WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));

			//dynamic drop down handle
			
			WebElement menu = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='select2-selection__arrow']")));

			menu.click();

			WebElement submenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='India']")));


			submenu.click();
	
		 d.findElement(By.xpath("//input[@name='cust_city']")).sendKeys("Mumbai");
		 d.findElement(By.xpath("//input[@name='cust_state']")).sendKeys("Maharastra");
		 d.findElement(By.xpath("//input[@name='cust_zip']")).sendKeys("400001");
		 d.findElement(By.xpath("//input[@name='cust_password']")).sendKeys("Jagu@123");
		 d.findElement(By.xpath("//input[@name='cust_re_password']")).sendKeys("Jagu@123");
		 d.findElement(By.xpath("//input[@name='form1']")).click();
		 
		 WebElement e7= d.findElement(By.xpath("//div[text()='Registration Successful!!! Please Login now to continue Shopping']"));
		 if (e7.isDisplayed())
			{
				System.out.println("Registration Successful page is diaplayed");
				
			}
			else
			{
				System.out.println("There is a bug in the application");
			}
		// Scenario: Test user login and logout
		 
		 d.findElement(By.xpath("//a[@href='login.php']")).click();
		 
		 d.findElement(By.xpath("//input[@name='cust_email']")).sendKeys("brainyyumlembam3@gmail.com");
		 d.findElement(By.xpath("//input[@name='cust_password']")).sendKeys("Jagu@123");
		 d.findElement(By.xpath("//input[@name='form1']")).click();
		 
		 WebElement e8= d.findElement(By.xpath("//h3[@class='text-center']"));
		 if (e8.isDisplayed())
			{
				System.out.println("Dashboard is diaplayed");
				
			}
			else
			{
				System.out.println("There is a bug in the application");
			}
		 
		 d.findElement(By.xpath("//a[@href='logout.php']")).click();
		 
		 WebElement e9= d.findElement(By.xpath("//a[@href='index.php']"));
		 if (e9.isDisplayed())
			{
				System.out.println("Home page is diaplayed");
				
			}
			else
			{
				System.out.println("There is a bug in the application");
			}
		 
		
				
				       
			    
			
	}
	

	
}



