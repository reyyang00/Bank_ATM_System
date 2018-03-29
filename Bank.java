import java.util.ArrayList;
import java.util.Date;

/** HW1 solution
 * Represents a bank
 * @author Rui Yang
 * @version 1.0
 * @copyright Rui Yang
 */

public class Bank {
    private String id;
    private ArrayList<ATM> atms;
    private ArrayList<Account> accounts;
    private Account currentAccount;
    private ATM currentATM;

    public ATM getCurrentATM() {
        return currentATM;
    }
    public Account getCurrentAccount() {
        return currentAccount;
    }
    public void setCurrentAccount(Account currentAccount) {
        this.currentAccount = currentAccount;
    }
    public Bank(String id){
        this.id = id;
        this.accounts = new ArrayList<Account>();
        this.atms = new ArrayList<ATM>();
    }
    public void addAccount(Account acc){

        accounts.add(acc);
    }
    public void addATM(ATM atm){
        atms.add(atm);
    }
    public ArrayList<ATM> getAtms() {
        return atms;
    }
    public void setAtms(ArrayList<ATM> atms) {
        this.atms = atms;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public ArrayList<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }


    /** Check do we have the ATM when use input.
     * @param inputATMame user's input.
     * @param theBank user's input bank.
     */
    public boolean isCurrentATM(String inputATMame,Bank theBank) {
        boolean found = false;
        for(int i=0;i<theBank.getAccounts().size();i++){
            if(inputATMame.equals(theBank.getAtms().get(i).getName())){
                this.currentATM = theBank.getAtms().get(i);
                found = true;
            }
        }
        return found;

    }
    /** Check user's input of cardnumber.
     * @param cardNumber user's input of cashcard.
     */
    public boolean isValided(String cardNumber) {
        Date currentTime = new Date();
        boolean valid = false;
        boolean isBefore= false;
        String bankCashCard = "";
        int i=0;
        while(i<currentATM.getBank().getAccounts().size()){
            bankCashCard = currentATM.getBank().getId() + currentATM.getBank().getAccounts().get(i).getAccountId();
            if(bankCashCard.equals(cardNumber)){
                currentATM.getBank().setCurrentAccount(currentATM.getBank().getAccounts().get(i));
                i= currentATM.getBank().getAccounts().size();
            }else {
                i++;
            }
        }
        if(currentAccount==null||(currentATM.getBank().id.equals(cardNumber.charAt(0)))){
            System.out.println("This card is not supported by this ATM");
        }
        if(currentAccount!=null){
            isBefore = currentTime.before(currentAccount.getCard().getExpiredDate());
            if(isBefore){
                valid = true;
            }else{
                System.out.println("This card is expired and returned to you.  ");
            }

        }
        return valid;
    }

    /** Check user's input if it matches the current cashcard.
     * @param inputPassword user's input.
     */
    public boolean authorizePssword(int inputPassword){
        boolean matches = false;
        if(this.currentAccount.getPassword()==inputPassword){
            matches = true;
        }
        return matches;
    }

    /** check user's input of amount wanted to withdraw..
     * @param input user's input of withdraw..
     */
    public boolean withDrawMoney(double input){
        boolean notPassLimit = false;
        if(input<=currentAccount.getBalance()&&input<=currentATM.getTransactions()){

            currentATM.setTransactions(currentATM.getTransactions()-input);
            currentAccount.setBalance(currentAccount.getBalance()-input);
            System.out.println(input+"is withdrawn from  your account. The remaining balance of this account is" +
                    currentAccount.getBalance()+"$. " +
                    " If you have more transactions, enter the amount or quit. ");
            if(currentAccount.getBalance()==0){
                notPassLimit = true;
            }
        }else if(input>currentATM.getTransactions()){
            System.out.println("This amount exceeds the maximum amount you " +
                    "can withdraw per transaction. Please enter the amount or quit.");
        }else if(input>currentAccount.getBalance()){
            System.out.println("The amount exceeds the current balance. " +
                    "Enter another amount or quit.  ");
        }
     return notPassLimit;
    }
}
