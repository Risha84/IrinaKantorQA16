package com.tran16.tests;

import com.tran16.model.GroupData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupDeletionTest extends TestBase {

    @Test
    public void deletionLastGroupTest() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup();
        }
        List<GroupData> groupsListBefore = app.getGroupHelper().getGroupsList();
        // int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroupByIndex(groupsListBefore.size() - 1);//last group
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();



        List<GroupData> groupsListAfter = app.getGroupHelper().getGroupsList();
        Assert.assertEquals(groupsListAfter.size(), groupsListBefore.size() - 1);
        groupsListBefore.remove(groupsListBefore.size() - 1);
Assert.assertEquals(groupsListAfter,groupsListBefore);
        //int after = app.getGroupHelper().getGroupsCount();
        // Assert.assertEquals(after,before-1);
    }

    @Test
    public void deletionFirstGroupTest() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if (!app.getGroupHelper().isGroupPresent()) {
            app.getGroupHelper().createGroup();
        }
        List<GroupData> groupsListBefore = app.getGroupHelper().getGroupsList();
      //  int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroup();//first group
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();
        List<GroupData> groupsListAfter = app.getGroupHelper().getGroupsList();
        groupsListBefore.remove(0);
        Assert.assertEquals(groupsListBefore.size(),groupsListAfter.size());
        Assert.assertEquals(groupsListBefore,groupsListAfter);
       // int after = app.getGroupHelper().getGroupsCount();
       // Assert.assertEquals(after, before - 1);
    }

    @Test
    public void deletionGroupTest2() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        if (!app.isElementsPresent(By.name("selected[]"))) {
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().selectGroup();//first group
        app.getGroupHelper().groupDeletion();
        app.getGroupHelper().returnToTheGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after, before - 1);
    }

}

