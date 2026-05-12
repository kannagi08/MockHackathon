package com.krce.tests;

import com.krce.pages.FramePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    public void nestedFrameTest() {

        FramePage frame = new FramePage(driver);

        // Open page
        frame.openPage();

        // Switch to parent iframe
        frame.switchToParentFrame();

        // Verify parent frame text
        String parentText = frame.getParentFrameText();

        System.out.println("Parent Frame Text: " + parentText);

        Assert.assertTrue(parentText.contains("Parent frame"));

        // Switch to child iframe
        frame.switchToChildFrame();

        // Verify child frame text
        String childText = frame.getChildFrameText();

        System.out.println("Child Frame Text: " + childText);

        Assert.assertEquals(childText, "Child Iframe");

        // Switch back to main page
        frame.switchToMainPage();

        // Verify main page still accessible
        Assert.assertTrue(frame.isMainPageAccessible());

        System.out.println("MAIN PAGE ACCESSIBLE");

        System.out.println("IFRAME TEST PASSED");
    }
}