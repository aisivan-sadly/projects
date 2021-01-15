package service;

import exception.NotEnoughMoneyException;
import exception.UnknownAccountException;

import java.io.IOException;

public interface AccountService {
    void withdraw(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, IOException;
    void balance(int accountId) throws IOException, UnknownAccountException;
    void deposit(int accountId, int amount) throws UnknownAccountException, IOException;
    void transfer(int from, int to, int amount) throws NotEnoughMoneyException, UnknownAccountException, IOException;
}
