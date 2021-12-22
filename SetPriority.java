package basicInTestNG;

import org.testng.annotations.Test;

public class PriorityCheck {

	//Driving The Car
	
	@Test(priority = 0)
	public void startTheCar(){
		System.out.println("Start The Car");
	}
	
	@Test(priority = 1)
	public void putTheFirstGear(){
		System.out.println("Put The First Gear");
	}
	
	@Test(priority = 2)
	public void putTheSecondGear(){
		System.out.println("Put The Second Gear");
	}
	
	@Test(priority = 3)
	public void putTheThirdGear(){
		System.out.println("Put The Third Gear");
	}
}
