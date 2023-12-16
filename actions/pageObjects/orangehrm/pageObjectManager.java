package pageObjects.orangehrm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;

public class pageObjectManager {
	public static AddEmployeePageObject getEmployeePage(WebDriver driver) {
		return new AddEmployeePageObject(driver);
	}
	
	public static ContactDetailsPageObject getContactDetailsPage(WebDriver driver) {
		return new ContactDetailsPageObject(driver);
	}
	
	public static DashboardPageObject getDashboardPage(WebDriver driver) {
		return new DashboardPageObject(driver);
	}
	
	public static DependencePageObject getDependencePage(WebDriver driver) {
		return new DependencePageObject(driver);
	}
	
	public static EmergencyContactPageObject getEmergencyContactPage(WebDriver driver) {
		return new EmergencyContactPageObject(driver);
	}
	
	public static EmpJobPageObject getEmpJobPage(WebDriver driver) {
		return new EmpJobPageObject(driver);
	}
	
	public static EmployeeListPageObject getEmployeeListPage(WebDriver driver) {
		return new EmployeeListPageObject(driver);
	}
	
	public static ImmigrationPageObject getImmigrationPage(WebDriver driver) {
		return new ImmigrationPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	
	public static PersonalDetailsPageObject getPersonalDetailsPage(WebDriver driver) {
		return new PersonalDetailsPageObject(driver);
	}
	
	public static QualificationPageObject getQualificationPage(WebDriver driver) {
		return new QualificationPageObject(driver);
	}
	
	public static ReportPageObject getReportPage(WebDriver driver) {
		return new ReportPageObject(driver);
	}
	
	public static SalaryPageObject getSalaryPage(WebDriver driver) {
		return new SalaryPageObject(driver);
	}

}
