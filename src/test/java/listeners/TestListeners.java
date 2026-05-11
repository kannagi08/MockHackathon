package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.FormTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

class TestListener implements ITestListener {

    public void onTestFailure(ITestResult result) {

        Object testClass = result.getInstance();

        WebDriver driver =
                ((FormTest) testClass).driver;

        File src =
                ((TakesScreenshot)driver)
                        .getScreenshotAs(OutputType.FILE);

        String time =
                new SimpleDateFormat("yyyyMMddHHmmss")
                        .format(new Date());

        try {

            FileUtils.copyFile(src,
                    new File("screenshots/" +
                            result.getName() +
                            time + ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}