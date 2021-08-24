import org.testng.annotations.Test;

public class robot {
  @Test
  public void f() {
	  driver.get("https://www.amazon.in/"); // sample url
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.findElement(By.linkText("See all deals")).click();
      Robot robot = new Robot(); // Robot class throws AWT Exception
      Thread.sleep(2000); 
      robot.keyPress(KeyEvent.VK_DOWN); // press arrow down key of keyboard 
      Thread.sleep(2000); 
      robot.mouseMove(200, 200); //mouse method
      Thread.sleep(2000); 
  }
}
