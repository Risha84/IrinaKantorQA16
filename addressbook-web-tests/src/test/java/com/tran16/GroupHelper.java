package com.tran16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase{


    public GroupHelper(WebDriver wd) {
       super(wd);
    }

    public void goToGroupsPage() {
        //wd.findElement(By.linkText("groups")).click();
        //wd.findElement(By.xpath("//*[@href='group.php']")).click();
         wd.findElement(By.cssSelector("[href='group.php']")).click();
    }

    public void submitGroupCreation() {
        //wd.findElement(By.name("submit")).click();
       wd.findElement(By.xpath("//*[@value='Enter information']")).click();


    }

    public void fillGroupsForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());

        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());

        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public void initGroupCreation() {

         // wd.findElement(By.name("new")).click();
       // wd.findElement(By.xpath("//*[@value='New group'][1]")).click();
        wd.findElement(By.xpath("//*[@name='new'][1]")).click();
    }

    public void groupDeletion() {
        wd.findElement(By.name("delete")).click();
    }

    public void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    public void selectGroupByIndex(int ind) {
        wd.findElements(By.name("selected[]")).get(ind).click();
    }

    public void returnToTheGroupsPage() {
        click(By.linkText("group page"));
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void submitGroupModification() {
        wd.findElement(By.name("update")).click();
    }

    public void initGroupModification() {

       // wd.findElement(By.cssSelector("//*[@name='edit'][1]")).click();
        wd.findElement(By.xpath("//*[@name='edit'][1]")).click();
        wd.findElement(By.xpath("//*[@name='new'][2]")).click();
    }

    public int getGroupsCount() {
        return wd.findElements((By.name("selected[]"))).size();
    }



    public void createGroup(){
    initGroupCreation();
    fillGroupsForm(new GroupData()
            .withName("testGroupName1")
            .withHeader("testGroupHeader1")
            .withFooter("testGroupFooter1"));
    submitGroupCreation();
    returnToTheGroupsPage();
}
    public boolean isGroupPresent(){
        return isElementPresent(By.name("selected[]"));
    }
}
