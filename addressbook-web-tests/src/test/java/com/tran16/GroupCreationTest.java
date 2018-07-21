package com.tran16;

import org.testng.annotations.Test;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {
        goToGroupsPage();
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .withName("testGroupName1")
                .withHeader("testGroupHeader1")
                .withFooter("testGroupFooter1"));
        submitGroupCreation();
        returnToTheGroupsPage();
    }

    @Test
    public void testGroupCreationWithEmptyFields() {
        goToGroupsPage();
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .withName("")
                .withFooter("")
                .withHeader(""));
        submitGroupCreation();
        returnToTheGroupsPage();


    }
@Test
    public void testGroupCreationWithLongName(){
        goToGroupsPage();
        initGroupCreation();
        fillGroupsForm(new GroupData()
                .withName("testGroupName10000000000000000000000000")
                .withHeader("testGroupHeader1")
                .withFooter("testGroupHeader1"));
        submitGroupCreation();
        returnToTheGroupsPage();
}

}