import java.util.Date;
import java.util.Scanner;

public class ATMSystem {

    public static void main(String arg[]) {

        ATM a = new ATM("ATM_A1");
        ATM b = new ATM("ATM_A2");
        ATM c = new ATM("ATM_B1");
        ATM d = new ATM("ATM_B2");
        ATM e = new ATM("ATM_A3");

        Date now = new Date(2019, 11, 22);
        CashCard card1 = new CashCard(new Date(2019 - 1900, 11, 22));
        CashCard card2 = new CashCard(new Date(2017 - 1900, 01, 22));
        CashCard card3 = new CashCard(new Date(2018 - 1900, 01, 22));
        CashCard card4 = new CashCard(new Date(2018 - 1900, 12, 22));
        CashCard card5 = new CashCard(new Date(2018 - 1900, 8, 22));

        Account A_ac1 = new Account(000000, 11, card1);
        Account A_ac2 = new Account(111111, 112, card2);
        Account B_ac1 = new Account(000000, 111, card3);
        Account B_ac2 = new Account(000000, 11, card4);
        Account B_ac3 = new Account(000000, 11, card5);

        Bank A = new Bank("A");
        Bank B = new Bank("B");
        A.addAccount(A_ac1);
        A.addAccount(A_ac2);
        B.addAccount(B_ac1);
        B.addAccount(B_ac2);
        B.addAccount(B_ac3);

        a.setBank(A);
        b.setBank(A);
        c.setBank(B);
        d.setBank(B);
        e.setBank(B);


        A.addATM(a);
        A.addATM(b);
        B.addATM(c);
        B.addATM(d);
        B.addATM(e);

        boolean run = true;
        while(run){
            System.out.println("Enter your choice of ATM");
            Scanner sc1= new Scanner(System.in);
            String ChoiceofATM = sc1.nextLine();
            if(A.isCurrentATM(ChoiceofATM,A)||B.isCurrentATM(ChoiceofATM,B)){
                run = false;
            }else{
                System.out.println("We do not recognize this ATM, enter another one");
            }
        }
        run = true;
        while(run){
            System.out.println("Enter your card");
            Scanner sc2= new Scanner(System.in);
            String inputCard = sc2.nextLine();
            if(A.isValided(inputCard)){
                System.out.println("The card is accepted. Please enter your password");
                run = false;
            }
        }

        run = true;
        while(run){
            Scanner sc3= new Scanner(System.in);
            int inputPassword = sc3.nextInt();
            if(A.authorizePssword(inputPassword)){
                System.out.println("Authorization is accepted. Start your transaction by entering the amount to withdraw.");
                run = false;
            }else{
                System.out.println("This is a wrong password. Enter your password");
            }
        }
        run = true;
        while(run){
            Scanner sc4= new Scanner(System.in);
            int inputAmount = sc4.nextInt();
            if(A.withDrawMoney(inputAmount)){
                run = false;
            }else{
                ;
            }
        }







    }
}






//        boolean run = true;
//            System.out.println("Chose your ATM by entering the ATM and bank" + "(" + "For example:ATM_A1" + ")" + ":");
//            Scanner sc1 = new Scanner(System.in);
//            ATM choiseOfatm = new ATM (sc1.nextLine());
//            for(int i =0;i<A.getAtms().size();i++) {
//                if (choiseOfatm.getName().equals(A.getAtms().get(i).getName())) {
//                    A.setCurrentATM(A.getAtms().get(i));
//                    System.out.println("Please enter your card number");
//                    Scanner sc2 = new Scanner(System.in);
//                    String inpuCard = sc2.nextLine();
//                    if (A.isValided(inpuCard, A)) {
//                        Scanner sc3 = new Scanner(System.in);
//                        int unserInputPassword = sc3.nextInt();
//                        if (A.authorizePssword(unserInputPassword)) {
//                            System.out.println("Please enter the amount you would like to withdraw");
//                            Scanner sc4 = new Scanner(System.in);
//                            double userInputWithdraw = sc4.nextDouble();
//                            A.withDrawMoney(userInputWithdraw);
//
//                        } else {
//                            do {
//                                System.out.println("This is a wrong password. Enter your password.");
//                                unserInputPassword = sc2.nextInt();
//                            } while (!A.authorizePssword(unserInputPassword));
//                        }
//
//                    } else {
//                        do {
//                            System.out.println("Please enter your card number");
//                            sc2 = new Scanner(System.in);
//                            inpuCard = sc2.nextLine();
//                            if (A.isValided(inpuCard, A)) {
//                                Scanner sc3 = new Scanner(System.in);
//                                int unserInputPassword = sc3.nextInt();
//                                if (A.authorizePssword(unserInputPassword)) {
//                                    System.out.println("Please enter the amount you would like to withdraw");
//                                    Scanner sc4 = new Scanner(System.in);
//                                    double userInputWithdraw = sc4.nextDouble();
//                                    A.withDrawMoney(userInputWithdraw);
//                                }
//                            }
//                        }while (!A.isValided(inpuCard, A)) ;
//                    }
//                }
//            }
