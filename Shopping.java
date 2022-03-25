import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Shopping {
    
   static Scanner sc = new Scanner(System.in);
   static double GST = 0.18;


   static void printBill(Map<String,Integer> quantityMap,Map<String,Double> itemPriceMap){

        double totalPrice = 0;
        double gstCost = 0;;

        for(Map.Entry<String,Double> e : itemPriceMap.entrySet()){
            totalPrice += itemPriceMap.get(e.getKey());
            gstCost += (totalPrice * GST)/100;
        }

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter obj = DateTimeFormatter.ofPattern("dd-MM-yyyy hh.mm");

        System.out.println("******************************************");
        System.out.println(String.format("\t\tReceipt"));
        System.out.println("******************************************");
        System.out.println("Terminal #1 \t\t"+dateTime.format(obj));
        System.out.println("------------------------------------------");
        
        for(Map.Entry<String,Double> e : itemPriceMap.entrySet()){
            String key = e.getKey();
            int quantity = quantityMap.get(key);
            double price = itemPriceMap.get(key);
            System.out.println(quantity + " x "+key+"\t\t"+price);
        }
        System.out.println("------------------------------------------");
        System.out.println("------------------------------------------");
        
        System.out.println("AMOUNT \t\t\t "+totalPrice);
        System.out.println(String.format("GST \t\t\t %.2f ",gstCost));
        System.out.println(String.format("TOTAL AMOUNT \t\t %.2f", totalPrice+gstCost));
        System.out.println("\n************  THANK YOU  ******************");
        
    }


    public static void fillPrice(Map<String, Double> priceMap){
        priceMap.put("Choclates",35d);
        priceMap.put("Wallet",499d);
        priceMap.put("IceCream",30d);
        priceMap.put("VenchiCiocollato",1500d);
    }

    public static void getItemsFromUser(Map<String,Double> itemPriceMap,Map<String,Integer> quantityMap,Map<String,Double> priceMap,String item){

        System.out.print(String.format("Enter no of %s : ",item));

        // Gets the quantity of the item
        int quantity = sc.nextInt();

        // fills the quantity
        quantityMap.put(item,quantityMap.getOrDefault(item, 0)+quantity);

        Item item1 = new Item(item, priceMap.get(item), quantity);

        double choclatesPrice = item1.getPrice();

        itemPriceMap.put(item,itemPriceMap.getOrDefault(item, 0d)+choclatesPrice);
    }

    public static void main(String[] args) {
    
        
        Map<String,Integer> quantityMap = new HashMap<>();
        Map<String,Double> priceMap = new HashMap<>();
        Map<String,Double> itemPriceMap = new HashMap<>();

        // fills the map with items along with its prices
        fillPrice(priceMap);


        // for choosing the required item
        int choice;
        System.out.println("************ Welcome to the mart  **************");
        do{
            try{
                System.out.println("\t1.Choclates\n\t2.Wallet \n\t3.IceCream \n\t4.Venchi_ciocollato\n\t5.Print Bill \n\t6.Exit \n\nBuy something : )");

            // if the user enters a character instead of number
                choice = sc.nextInt();
                switch(choice){

                    case 1 : {
                        getItemsFromUser(itemPriceMap,quantityMap,priceMap,"Choclates");
                        break;
                    } 
                    case 2 : {
                        getItemsFromUser(itemPriceMap,quantityMap,priceMap,"Wallet");
                        break;
                    }
                    case 3 : {
                        getItemsFromUser(itemPriceMap,quantityMap,priceMap,"IceCream");                       
                        break;
                    }
                    case 4 : {
                        getItemsFromUser(itemPriceMap,quantityMap,priceMap,"VenchiCiocollato");
                        break;
                    }
                    case 5 : printBill(quantityMap,itemPriceMap);
                                System.exit(0);
                                 break;
                    case 6 : System.exit(0);
                    default : System.out.println("Come on man !!!! Enter from the options that are displayed");                        
                }

            }
            catch(Exception e){
                System.out.println("Enter a valid input");
                System.exit(1);
            }
        }while(true);


    }
    
}
