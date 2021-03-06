package com.tran16.manager;

import com.tran16.model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {


    public GroupHelper(WebDriver wd) {

        super(wd);
    }


    public void submitGroupCreation() {
        click(By.xpath("//*[@value='Enter information']"));


    }

    public void fillGroupsForm(GroupData group) {
        type(By.name("group_name"), group.getName());

        type(By.name("group_header"), group.getHeader());

        type(By.name("group_footer"), group.getFooter());
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

    public void returnToTheGroupsPage() throws InterruptedException {
        click(By.linkText("group page"));
        Thread.sleep(2000);
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


    public void createGroup() throws InterruptedException {
        initGroupCreation();
        final GroupData group = new GroupData()
                .withName("testGroupName1")
                .withHeader("testGroupHeader1")
                .withFooter("testGroupFooter1");
        fillGroupsForm(group);
        submitGroupCreation();
        returnToTheGroupsPage();
    }

    public boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isGroupPresent() {
        return isElementPresent(By.name("selected[]"));
    }

    public void goToGroupsPage() {
        if (!isElementPresent(By.xpath("//h1[contains(text(),'Groups')]"))
                && !isElementPresent(By.name("new"))) {
            wd.findElement(By.cssSelector("[href='group.php']")).click();
        }
    }

    public List<GroupData> getGroupsList() {
        List<GroupData> groups = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for(WebElement element:elements){
            String name = element.getText();
            int id = Integer.parseInt(
            element.findElement(By.tagName("input")).getAttribute("value"));
            GroupData group = new GroupData().withName(name);
            groups.add(group);
        }
        System.out.println(groups);
        return groups;
    }
}

