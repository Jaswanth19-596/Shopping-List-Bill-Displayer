
class Item{

    private double price;
    private int quantity;
    static final double GST = 0.18;

    Item(String name,Double double1,int quantity){
        this.price = double1;
        this.quantity = quantity;
    }

    public double getPrice(){
        return this.price * this.quantity;
    }
}