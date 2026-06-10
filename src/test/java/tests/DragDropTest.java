package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DragDropPage;


public class DragDropTest extends BaseTest {

    @Test(priority=1,
    		description="Verify Drag and Drop Functionality Between Source and Target Elements",
    		groups = {"smoke", "regression"})
    public void testDragAndDrop() {

    	logger.info("Drag and Drop Test Started");
    	
        DragDropPage dragDropPage = new DragDropPage(getDriver());

        dragDropPage.performDragAndDrop();

        Assert.assertTrue(dragDropPage.isDroppedSuccessfully(),"Drag and Drop failed!"
        );

        logger.info("Drag and Drop Test Passed");
        logger.info("Drop Result: " + dragDropPage.getDropMessage());
    }
}