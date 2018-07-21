package com.tran16;

import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void test1() {
        goToGroupsPage();
        selectGroup();
        groupDeletion();
        returnToTheGroupsPage();
    }
}

