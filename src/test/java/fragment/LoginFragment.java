package test.java.fragment;

import static org.openqa.selenium.By.name;
import static test.java.ultil.WaitUtils.waitForElementVisible;
import static test.java.ultil.WaitUtils.waitForFragmentNotVisible;

import org.jboss.arquillian.graphene.Graphene;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.java.abstracts.AbstractFragment;

public class LoginFragment extends AbstractFragment {

    @FindBy(name = "uid")
    WebElement userIDInput;

    @FindBy(name = "password")
    WebElement passwordInput;

    @FindBy(name = "btnLogin")
    WebElement btnLogin;

    public static LoginFragment getInstance(SearchContext context) {
        return Graphene.createPageFragment(LoginFragment.class,
                    waitForElementVisible(name("frmLogin"), context));
    }

    public void login(String userID, String password) {
        waitForElementVisible(userIDInput).clear();
        userIDInput.sendKeys(userID);

        waitForElementVisible(passwordInput).clear();
        passwordInput.sendKeys(password);
        waitForElementVisible(btnLogin).click();
        waitForFragmentNotVisible(this);
    }
}
