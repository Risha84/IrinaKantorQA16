package com.tran16;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {

    @Test
    public void test1() {
        goToGroupsPage();
        int before = getGroupsCount();
        selectGroup();
        groupDeletion();
        returnToTheGroupsPage();
        int after = getGroupsCount();
        Assert.assertEquals(after,before-1);
    }
}

