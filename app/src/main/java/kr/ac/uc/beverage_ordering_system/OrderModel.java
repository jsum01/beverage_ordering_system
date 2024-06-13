package kr.ac.uc.beverage_ordering_system;

public class OrderModel {
    String name, juice;
    int num;

    public OrderModel(String name, String juice, int num){
        this.name = name;
        this.juice = juice;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public String getJuice() {
        return juice;
    }

    public int getNum() {
        return num;
    }
}
