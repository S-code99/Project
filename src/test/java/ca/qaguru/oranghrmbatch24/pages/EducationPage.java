package ca.qaguru.oranghrmbatch24.pages;

import ca.qaguru.oranghrmbatch24.library.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EducationPage extends PageBase {
    private final String idEduAddBtn = "oxd-button.oxd-button--medium.oxd-button--secondary";
    private final String idEduTxtLevel="oxd-input.oxd-input--active";
    private final String idEduSaveBtn="oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space";
    private final String getIdEduCancelBtn= "oxd-button.oxd-button--medium oxd-button--ghost";

    public EducationPage(WebDriver driver) {
        super(driver);
    }

    public void saveNewEducation(String level1) {
        click(By.className(idEduAddBtn));
        setText(By.className(idEduTxtLevel), level1);
        click(By.className(idEduSaveBtn));
    }
}
