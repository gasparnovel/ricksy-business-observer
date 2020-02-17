package ricksy.business;

public class CreditCard {

    private final String owner;
    private final String number;
    private double credit = 3000d;
    private final String SYMBOL = "EZI";

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
    }

    public boolean pay(double charge) {
        if (charge <= this.credit) {
            this.credit -= charge;
            return true;
        } else {
            return false;
        }
    }

    public String number() {
        return this.number;
    }

    public double credit() {
        return this.credit;
    }

    @Override
    public String toString() {
        return "owner: " + this.owner 
                + "\nnumber: " + this.number
                + "\ncredit: " + this.credit + this.SYMBOL;
    }
}