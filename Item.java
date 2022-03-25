
class Item{

    private int price;
    private int quantity;
    private String name;
    static final double GST = 0.18;

    Item(String name,int price,int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice(){
        return this.price * this.quantity * GST;
    }

    public 

}