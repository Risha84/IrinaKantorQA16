package com.tran16.tests;

import com.tran16.model.GroupData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() throws InterruptedException {

        app.getGroupHelper().goToGroupsPage();
        List<GroupData> groupsListBefore=app.getGroupHelper().getGroupsList();
      // int before= app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().initGroupCreation();
        final GroupData group = new GroupData()
                .withName("testGroupName1")
                .withHeader("testGroupHeader1")
                .withFooter("testGroupFooter1");
        app.getGroupHelper().fillGroupsForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
        List<GroupData> groupsListAfter=app.getGroupHelper().getGroupsList();
        Assert.assertEquals(groupsListAfter.size(),groupsListBefore.size()+1);

        // int after = app.getGroupHelper().getGroupsCount();
      //  Assert.assertEquals(after,before+1);
    }

    @Test
    public void testGroupCreationWithEmptyFields() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        int before= app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().initGroupCreation();
        final GroupData group = new GroupData()
                .withName("")
                .withFooter("")
                .withHeader("");
        app.getGroupHelper().fillGroupsForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
       int after = app.getGroupHelper().getGroupsCount();
       Assert.assertEquals(after,before+1);

    }
@Test
    public void testGroupCreationWithLongName() throws InterruptedException {
        app.getGroupHelper().goToGroupsPage();
        int before= app.getGroupHelper().getGroupsCount();
        app.getGroupHelper().initGroupCreation();
    final GroupData group = new GroupData()
            .withName("testGroupName10000000000000000000000000")
            .withHeader("testGroupHeader1")
            .withFooter("testGroupFooter1");
    app.getGroupHelper().fillGroupsForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnToTheGroupsPage();
        int after = app.getGroupHelper().getGroupsCount();
    Assert.assertEquals(after,before+1);
}
@Test
    public void testGetGroupsList(){
        app.getGroupHelper().goToGroupsPage();
        app.getGroupHelper().getGroupsList();
}


}