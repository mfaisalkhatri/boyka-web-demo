package io.github.mfaisalkhatri.web.testdata;

import io.github.boykaframework.actions.data.TestDataAction;
import io.github.boykaframework.actions.interfaces.data.ITestDataAction;
import org.testng.annotations.DataProvider;

import java.util.Iterator;


public class LoginDataProvider {

    private static final ITestDataAction DATA;

    static {
        DATA = TestDataAction.withData("LoginTestData").inBlock("login_credentials");
    }

    @DataProvider
    public static Iterator<Object[]> getLoginDataObject() {
        var rows = DATA.rows();
        return rows.stream()
                .map(d -> new Object[] { LoginData.builder().username(d.cell("Username")).password(d.cell("Password"))
                        .isValid(d.cell("isValid").toString().equalsIgnoreCase("true")).
                        isEnabled(d.cell("isEnabled").toString().equalsIgnoreCase("Y")).
                        build() })
                .filter(d -> ((LoginData) d[0]).isEnabled())
                .toList()
                .iterator();
    }
}
