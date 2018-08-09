package com.tran16.manager;

import com.tran16.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GroupHelper extends HelperBase {


    public GroupHelper(WebDriver wd) {

        super(wd);
    }

    public void goToGroupsPage()
    {
        if(!isElementPresent(By.xpath("//h1[contains(text(),'Groups')]"))
                &&!isElementPresent(By.name("new"))){
            click(By.cssSelector("[href='group.php']"));
        }
    }



    public void submitGroupCreation() {
              click(By.xpath("//*[@value='Enter information']"));


    }

    public void fillGroupsForm(GroupData groupData, String text) {
        type(By.name("group_name"), groupData.getName());

        type(By.name("group_header"), groupData.getHeader());

        type(By.name("group_footer"),groupData.getFooter());
    }

    public void type(By locator, String text) {
        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);

    }

    public void initGroupCreation() {
        click(By.xpath("//*[@name='new'][1]"));
    }

    public void groupDeletion() {
        click(By.name("delete"));
    }

    public void selectGroup() {
        click(By.name("selected[]"));
    }

    public void selectGroupByIndex(int ind) {
        wd.findElements(By.name("selected[]")).get(ind).click();
    }

    public void returnToTheGroupsPage() {
        click(By.linkText("group page"));
    }


    public void submitGroupModification() {
        click(By.name("update"));
    }

    public void initGroupModification() {
        click(By.xpath("//*[@name='edit'][1]"));
      //  click(By.xpath("//*[@name='new'][2]"));
    }

    public int getGroupsCount() {
        return wd.findElements((By.name("selected[]"))).size();
    }



    public void createGroup(){
    initGroupCreation();
        final GroupData groupData = new GroupData()
                .withName("testGroupName1")
                .withHeader("testGroupHeader1")
                .withFooter("testGroupFooter1");
        fillGroupsForm(groupData, groupData.getFooter());
    submitGroupCreation();
    returnToTheGroupsPage();
}

}
