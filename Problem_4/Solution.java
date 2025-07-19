import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Bike[] bikes = new Bike[n];

        for (int i = 0; i < n; i++) {
            int id = Integer.parseInt(sc.nextLine());
            int quantity = Integer.parseInt(sc.nextLine());
            String name = sc.nextLine();
            int price = Integer.parseInt(sc.nextLine());

            bikes[i] = new Bike(id, quantity, name, price);
        }

        String searchName = sc.nextLine();

        Bike maxPriceBike = findMaxPriceOfBike(bikes);
        if (maxPriceBike != null) {
            printBikeDetails(maxPriceBike);
        } else {
            System.out.println("No Bike found with mentioned attribute");
        }

        Bike foundByName = searchBikeByName(bikes, searchName);
        if (foundByName != null) {
            printBikeDetails(foundByName);
        } else {
            System.out.println("No Bike found with mentioned attribute");
        }
    }

    public static Bike findMaxPriceOfBike(Bike[] bikes) {
        if (bikes == null || bikes.length == 0) return null;

        Bike maxBike = null;
        int maxPrice = Integer.MIN_VALUE;

        for (Bike b : bikes) {
            if (b.getPrice() > maxPrice) {
                maxPrice = b.getPrice();
                maxBike = b;
            }
        }

        return maxBike;
    }

    public static Bike searchBikeByName(Bike[] bikes, String name) {
        for (Bike b : bikes) {
            if (b.getName().equalsIgnoreCase(name)) {
                return b;
            }
        }
        return null;
    }

    public static void printBikeDetails(Bike b) {
        System.out.println("id-" + b.getId());
        System.out.println("quantity-" + b.getQuantity());
        System.out.println("name-" + b.getName());
        System.out.println("price-" + b.getPrice());
    }
}
public class Bike {
    private int id;
    private int quantity;
    private String name;
    private int price;

    public Bike(int id, int quantity, String name, int price) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }  public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}



