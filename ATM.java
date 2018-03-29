public class ATM {
    private String name;
    private double transactions;
    private Bank bank;


    public ATM(String name) {
        this.name = name;
        this.transactions = 50;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTransactions() {
        return transactions;
    }

    public void setTransactions(double transactions) {
        this.transactions = transactions;
    }
    public void addBank(Bank thebank){
        this.bank = thebank;
    }
}
