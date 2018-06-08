package test.registration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;




public class RegistrationPageTest {

	static WebDriver driver;
    private RegistrationPage registrationpage;
		
	
	
	@BeforeClass
	public static void setUpDriverEnv(){
		System.setProperty("webdriver.chrome.driver", "D:\\madhav\\seleTesting\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Before
	public void setUpTestEnv() {
		driver.get("https://github.com/join");
		registrationpage= new RegistrationPage();
		PageFactory.initElements(driver, registrationpage);
	}
	
	@Test
	public void testForBlankUserNameAndPassword(){	
		
		registrationpage.setUsername("");
		registrationpage.setEmail("");
		registrationpage.setPassword("");
		registrationpage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div")).getText();	
		System.out.println("error Message :- "+actualErrorMessage);
		String expectedErrorMessage="Incorrect username or password.";
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	@Test
	public void testForInValidUserName(){
		
		registrationpage.setUsername(getInvalidUserName());
		registrationpage.setEmail(getvalidEmail());
		registrationpage.setPassword(getValidPassword());
		registrationpage.clickSubmitButton();
		String expectedErrorMessage="Incorrect username or password.";
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div")).getText();	
		System.out.println("error Message :- "+actualErrorMessage);
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	
	@Test
	public void testForInValidPassword(){
		registrationpage.setUsername(getValidUserName());
		registrationpage.setEmail(getvalidEmail());
		registrationpage.setPassword(getInvalidPassword());
		registrationpage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div")).getText();	
		System.out.println("error Message :- "+actualErrorMessage);
		String expectedErrorMessage="Incorrect username or password.";
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	
	
	
	@Test
	public void testForInValidUserNameAndPasswordAndEmail(){
		registrationpage.setUsername(getInvalidUserName());
		registrationpage.setEmail(getInvalidEmail());
		registrationpage.setPassword(getInvalidPassword());
		registrationpage.clickSubmitButton();
		String actualErrorMessage=driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div")).getText();	
		
		String expectedErrorMessage="Incorrect username or password.";
		Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
	}
	
	@Test
	public void testForValidUserNameAndEmailAndPassword(){
		registrationpage.setUsername(getValidUserName());
		registrationpage.setEmail(getvalidEmail());
		registrationpage.setPassword(getValidPassword());
		registrationpage.clickSubmitButton();
		//String actualHostName =driver.findElement(By.xpath("//meta[@name='hostname']")).getAttribute("content");	
		String actualUserName=driver.findElement(By.xpath("//*[@id=\"user_login\"]")).getAttribute("content");
		
		String expectedUserName="qazwsxedcrfv";
		
		/*HostAndUserDetails expectedUserDetails = new HostAndUserDetails("github.com", "satishmahajan11");
		HostAndUserDetails actualUserDetails = new HostAndUserDetails(actualHostName, actualUserName);*/
		Assert.assertEquals(expectedUserName, actualUserName);
	}
	@After
	public void tearDownTestEnv(){
		registrationpage= null;
	}
	@AfterClass
	public static void tearDownDriverEnv(){
		driver.close();
		driver=null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private String getvalidEmail() {
			return "abcd@gamil.com";
	}
	private String getInvalidEmail() {
		return "abcd";
}
	private String getInvalidUserName() {
		return "";
	}
	
	private String getValidUserName() {
		return "qazwsxedcrfv";
	}
	
	private String getInvalidPassword() {
		return "";
	}
	
	private String getValidPassword() {
		return "Madhav@9876";
	}
	
	
	
	
	
	
	
	
}
