package com.tran16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {


    @Test
    public void testGroupModification() {
        goToGroupsPage();
        if(!isGroupPresent()){
            createGroup();
        }
        int before = getGroupsCount();
        selectGroup();
        initGroupModification();
        fillGroupsForm(new GroupData()

                .withName("modifiedTestGroupName1")
                .withHeader("modifiedTestGroupHeader1")
                .withFooter("modifiedTestGroupFooter1"));
        submitGroupModification();
        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after, before);

    }

}