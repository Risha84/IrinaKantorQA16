package com.tran16;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void deletionLastGroupTest() {
        goToGroupsPage();
        if(!isGroupPresent()){
            createGroup();
        }
        int before = getGroupsCount();
        selectGroupByIndex(before-1);//last group
        groupDeletion();
        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after,before-1);
    }
    @Test
    public void deletionFirstGroupTest() {
        goToGroupsPage();
        if(!isGroupPresent()){
            createGroup();
        }
        int before = getGroupsCount();
        selectGroup();//first group
        groupDeletion();
        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after,before-1);
    }
    @Test
    public void deletionGroupTest2() {
        goToGroupsPage();
        if(!areEltsPresent(By.name("selected[]"))){
            createGroup();
        }
        int before = getGroupsCount();
        selectGroup();//first group
        groupDeletion();
        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after,before-1);
    }

}

