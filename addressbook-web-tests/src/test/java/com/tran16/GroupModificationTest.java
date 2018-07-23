package com.tran16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {


    @Test
    public void testGroupModification() {
        goToGroupsPage();
        int before = getGroupsCount();
        selectGroup();
        initGroupModification();
        fillGroupsForm(new GroupData().withName("")
        .withHeader("")
        .withFooter(""));
        submitGroupModification();
        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after,before);

    }

}