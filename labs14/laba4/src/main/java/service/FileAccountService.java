package service;

import account.Account;
import exception.NotEnoughMoneyException;
import exception.UnknownAccountException;

import java.io.*;
import java.util.Random;

class Pair<K, V> {
    public K first;
    public V second;
    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }


}

public class FileAccountService implements AccountService {
    private static final String DB_FILENAME = "accounts.db";
    private static final String[] NAMES = {"A. Smith", "T. Armstrong", "A. Lee", "J. Edison",
            "T. Ericson", "M. Tetcher", "B. Stohalski", "S. Valeska", "J. Carry", "M. Watson"};
    private static final int DB_BASEUSERS = 10;
    private static final int RECORD_SIZE = 48;
    public FileAccountService() throws IOException{
        checkDB();
    }



    private void checkDB() throws IOException {
        File db = new File(DB_FILENAME);
        if (!db.exists()){
            createDBFile();
        }
    }

    private Account readAccount(RandomAccessFile file, int record) throws IOException {
        file.seek(record*RECORD_SIZE);
        String s = file.readLine();
        s = s.substring(2);
        String[] params = s.split("\\|");
        return new Account(Integer.parseInt(params[0].trim()), params[1].trim(), Integer.parseInt(params[2].trim()));

    }

    private void writeAccount(RandomAccessFile file, Account account) throws IOException {
        writeAccount(file, account, 0);
    }

    private void writeAccount(RandomAccessFile file, Account account, int seek)  throws IOException{
        file.seek(seek*RECORD_SIZE);
        file.writeUTF(String.format("%-3d|%-30s|%-10d\n", account.getId(), account.getHolder(), account.getAmount()));
    }

    private void createDBFile() throws IOException {
        File db = new File(DB_FILENAME);
        db.createNewFile();
        Random r = new Random();
        RandomAccessFile file_out = new RandomAccessFile(DB_FILENAME, "rw");
        for (int i = 0; i < DB_BASEUSERS; i++) {
            int amount = r.nextInt(50)+50;
            Account acc = new Account(i, NAMES[i], amount*1000);
            writeAccount(file_out, acc, i);
        }
        file_out.close();
    }

    private Pair<Integer, Account>  find(int accountId) throws IOException, UnknownAccountException {
        RandomAccessFile file = new RandomAccessFile(DB_FILENAME, "r");
        int records = (int)file.length()/RECORD_SIZE;
        for (int i = 0; i<records; i++){
            Account acc = readAccount(file, i);
            if (acc.getId() == accountId) {
                return new Pair<>(i, acc);
            }
        }
        throw new UnknownAccountException("Нет такого клиента");
    }
    @Override
    public void withdraw(int accountId, int amount) throws NotEnoughMoneyException, UnknownAccountException, IOException{
        Pair<Integer, Account> result = find(accountId);
        Account acc = result.second;
        if (acc.getAmount() < amount) throw new NotEnoughMoneyException();
        int record = result.first;
        acc.withdraw(amount);
        RandomAccessFile raf = new RandomAccessFile(DB_FILENAME, "rw");
        writeAccount(raf, acc, record);
    }
    @Override
    public void balance(int accountId) throws IOException, UnknownAccountException {
        Account acc = find(accountId).second;
        System.out.println(acc.getAmount());
    }
    @Override
    public void deposit(int accountId, int amount) throws UnknownAccountException, IOException {
        Pair<Integer, Account> result = find(accountId);
        Account acc = result.second;
        int record = result.first;
        acc.deposit(amount);
        RandomAccessFile raf = new RandomAccessFile(DB_FILENAME, "rw");
        writeAccount(raf, acc, record);
    }
    @Override
    public void transfer(int from, int to, int amount) throws NotEnoughMoneyException, UnknownAccountException, IOException {
        Pair<Integer, Account> from_info = find(from);
        Pair<Integer, Account> to_info = find(to);
        Account from_acc = from_info.second;
        Account to_acc = to_info.second;
        if (from_acc.getAmount() < amount) throw new NotEnoughMoneyException();
        int from_record = from_info.first;
        int to_record = to_info.first;
        from_acc.withdraw(amount);
        to_acc.deposit(amount);
        RandomAccessFile raf = new RandomAccessFile(DB_FILENAME, "rw");
        writeAccount(raf, from_acc, from_record);
        writeAccount(raf, to_acc, to_record);
    }

}
