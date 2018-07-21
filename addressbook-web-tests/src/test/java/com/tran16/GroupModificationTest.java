package com.tran16;

import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {


    @Test
    public void testGroupModification() {
        goToGroupsPage();
        selectGroup();
        initGroupModification();
        fillGroupsForm(new GroupData().withName("")
        .withHeader("")
        .withFooter(""));
        submitGroupModification();
        returnToTheGroupsPage();

    }

}