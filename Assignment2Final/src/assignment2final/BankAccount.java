package assignment2final;

public class BankAccount {

    private String accountNumber;
    private String ownerName;
    private double balance;

    public BankAccount(String accountNumber,
                       String ownerName,
                       double balance) {

        this.accountNumber = accountNumber;
        this.ownerName = ownerName;

        if (balance < 0) {
            System.out.println("Số dư không hợp lệ! Gán = 0");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    // Getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter
    public void setOwnerName(String name) {
        if(name != null && !name.trim().isEmpty()){
            ownerName = name;
        }
        else{
            System.out.println("Tên không hợp lệ!");
        }
    }

    // Nạp tiền
    public void deposit(double amount){

        if(amount > 0){

            balance += amount;

            System.out.println(
                    "Đã nạp "
                            + amount +
                            " | Số dư: "
                            + balance
            );
        }
        else{
            System.out.println(
                    "Số tiền nạp không hợp lệ!"
            );
        }
    }

    // Rút tiền
    public void withdraw(double amount){

        if(amount > 0 && amount <= balance){

            balance -= amount;

            System.out.println(
                    "Đã rút "
                            + amount +
                            " | Số dư: "
                            + balance
            );
        }
        else{
            System.out.println(
                    "Rút tiền thất bại!"
            );
        }
    }

    // Chuyển tiền
    public void transfer(BankAccount other,
                         double amount){

        if(amount > 0 && amount <= balance){

            balance -= amount;
            other.balance += amount;

            System.out.println(
                    "Đã chuyển "
                            + amount +
                            " sang "
                            + other.ownerName
            );
        }
        else{
            System.out.println(
                    "Chuyển tiền thất bại!"
            );
        }
    }

    // Hiển thị
    public void displayInfo(){

        String maskedNumber =
                "****" +
                        accountNumber.substring(
                                accountNumber.length()-4
                        );

        System.out.println(
                "Tài khoản: "
                        + maskedNumber +
                        " | Chủ TK: "
                        + ownerName +
                        " | Số dư: "
                        + balance
        );
    }
}