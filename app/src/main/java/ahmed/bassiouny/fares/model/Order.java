package ahmed.bassiouny.fares.model;

/**
 * Created by bassiouny on 17/01/18.
 */

public class Order {

    private String date;
    private int number;
    private int status;

    public Order(String date, int number, int status) {
        this.date = date;
        this.number = number;
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
