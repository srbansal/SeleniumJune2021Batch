import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class A12_frames {
  @Test
  // Get all frames on the Page, created with <frame> tag
  List<WebElement> frames = driver.findElements(By.tagName("frame"));
  // In this example frame in the middle is activated by checking the contents
  // Activate frame and check if it has the desired content. If found perform the
  // operations
  // if not, then switch back to the Page and continue checking next frame
  for (WebElement frame : frames) {
      // switchTo().frame() also accepts frame elements apart from id, name or index
      driver.switchTo().frame(frame);
      if (driver.getPageSource().contains("This Frame doesn't have id or name")) {
          assertTrue(true);
          // Take necessary action here 
          break;
      } else
          driver.switchTo().defaultContent();
  }
  // Activate the Page, this will move context from frame back to the Page
  driver.switchTo().defaultContent();


}
