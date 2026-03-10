package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String testName) {

        try {

            File src = ((TakesScreenshot)driver)
                    .getScreenshotAs(OutputType.FILE);

            String path = "screenshots/" + testName + ".png";

            File dest = new File(path);

            FileUtils.copyFile(src, dest);

        } catch (Exception ignored) {
        }
    }
}