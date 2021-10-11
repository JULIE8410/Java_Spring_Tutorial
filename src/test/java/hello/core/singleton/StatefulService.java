package hello.core.singleton;

public class StatefulService {
    
    private int price;
    

    public int order(String name, int price){
//    public void order(String name, int price){
        System.out.println("name = " + name + " price = "  + price);
//        this.price = price;  // It has a problem here
        return price;
    }

    public int getPrice(){
        return price;
    }
    
}
