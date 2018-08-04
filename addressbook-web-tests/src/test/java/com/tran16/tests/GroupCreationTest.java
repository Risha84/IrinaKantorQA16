package com.tran16.tests;

import com.tran16.manager.TestBase;
import com.tran16.model.GroupData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        app.getGroupHelper().goToGroupsPage();
       int before= app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().initGroupCreation();
        final GroupData groupData = new GroupData()
                .withName("testGroupName1")
                .withHeader("testGroupHeader1")
                .withFooter("testGroupFooter1");
        app.getGroupHelper().fillGroupsForm(groupData, groupData.getFooter());
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
       int after = app.getGroupHelper().getGroupsCount();
        Assert.assertEquals(after,before+1);
    }

    @Test
    public void testGroupCreationWithEmptyFields() {
        app.getGroupHelper().goToGroupsPage();
        int before= app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().initGroupCreation();
        final GroupData groupData = new GroupData()
                .withName("")
                .withFooter("")
                .withHeader("");
        app.getGroupHelper().fillGroupsForm(groupData, groupData.getFooter());
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
       int after = app.getGroupHelper().getGroupsCount();
       Assert.assertEquals(after,before+1);

    }
@Test
    public void testGroupCreationWithLongName(){
        app.getGroupHelper().goToGroupsPage();
        int before= app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().initGroupCreation();
    final GroupData groupData = new GroupData()
            .withName("testGroupName10000000000000000000000000")
            .withHeader("testGroupHeader1")
            .withFooter("testGroupFooter1");
    app.getGroupHelper().fillGroupsForm(groupData, groupData.getFooter());
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();
    Assert.assertEquals(after,before+1);
}

}