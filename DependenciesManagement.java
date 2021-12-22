package basicInTestNG;

import org.testng.annotations.Test;

public class DependenciesManagement {

	@Test(enabled = true)
	public void XSTD() {
		System.out.println("Tenth Standard Pass");
	}
	
	@Test(dependsOnMethods = "XSTD")
	public void XIISTD() {
		System.out.println("Twelth Standard Pass");
	}
	
	@Test(dependsOnMethods = "XIISTD")
	public void College() {
		System.out.println("Engineering Degree");
	}
}
