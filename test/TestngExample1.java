/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.testng.annotations.*;

/**
 *
 * @author asun
 */
public class TestngExample1 {
    
//    @BeforeClass
//    public void setUp(){
//        System.out.println("Before start the test case!");
//    }
//    
//    @Test(groups = {"first"})
//    public void firstMethod(){
//        System.out.println("Running the first method!");
//    }
//    
//    @Test(groups = {"second"})
//    public void secondMethod(){
//        System.out.println("Running the second method!");
//    }

  @Test(dataProvider="user")
  public void verifyUser(String userName) {
	  System.out.println("Username: " + userName);
  }
  
  @DataProvider(name="user")
  public Object[][] Users() {
	  return new Object[][] {
			  {"root","password"},
			  {"tank","xiao"}
	  };
  }    
}
