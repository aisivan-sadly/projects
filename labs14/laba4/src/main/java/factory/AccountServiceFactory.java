package factory;

import service.AccountService;
import service.FileAccountService;

import java.io.IOException;

public class AccountServiceFactory {
    public static AccountService getAccService() throws IOException {
        return new FileAccountService();
    }
}
