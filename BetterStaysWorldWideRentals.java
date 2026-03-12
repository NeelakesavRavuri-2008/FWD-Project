import java.util.*;

// Property class
class Property {

    private String propertyId;
    private String name;
    private double pricePerNight;
    private int rating;
    private String location;

    public Property(String propertyId, String name, double pricePerNight, int rating, String location) {
        this.propertyId = propertyId;
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.rating = rating;
        this.location = location;
    }

    public String getPropertyId() { return propertyId; }
    public String getName() { return name; }
    public double getPricePerNight() { return pricePerNight; }
    public int getRating() { return rating; }
    public String getLocation() { return location; }

    public String toString() {
        return propertyId + " | " + name + " | ₹" + pricePerNight +
                " per night | Rating: " + rating + " | Location: " + location;
    }
}

public class BetterStaysWorldWideRentals {

    List<Property> properties = new ArrayList<>();

    // Linear Search
    public int linearSearch(String id) {

        for (int i = 0; i < properties.size(); i++) {
            if (properties.get(i).getPropertyId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    // Bubble Sort
    public void bubbleSortByPrice() {

        for (int i = 0; i < properties.size() - 1; i++) {

            for (int j = 0; j < properties.size() - i - 1; j++) {

                if (properties.get(j).getPricePerNight() >
                        properties.get(j + 1).getPricePerNight()) {

                    Collections.swap(properties, j, j + 1);
                }
            }
        }
    }

    // Heap (Priority Queue)
    static class PropertyHeap {

        PriorityQueue<Property> heap =
                new PriorityQueue<>((a, b) -> b.getRating() - a.getRating());

        void add(Property p) {
            heap.offer(p);
        }

        Property getHighestRated() {
            return heap.poll();
        }
    }

    public static void main(String[] args) {

        BetterStaysWorldWideRentals system = new BetterStaysWorldWideRentals();
        Scanner sc = new Scanner(System.in);

        // Sample properties
        system.properties.add(new Property("P001","SeaView Villa",5000,4,"Goa"));
        system.properties.add(new Property("P002","Mountain Lodge",3000,5,"Manali"));
        system.properties.add(new Property("P003","City Apartment",2500,3,"Mumbai"));
        system.properties.add(new Property("P004","Beach Resort",4500,4,"Goa"));
        system.properties.add(new Property("P005","Hill Cottage",3500,5,"Ooty"));

        while(true) {

            System.out.println("\n===== Better Stays Worldwide Rentals =====");
            System.out.println("1. View Properties");
            System.out.println("2. Search Property");
            System.out.println("3. Sort Properties by Price");
            System.out.println("4. Show Highest Rated Property");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.println("\nAvailable Properties:");

                    for(Property p : system.properties) {
                        System.out.println(p);
                    }

                    break;

                case 2:

                    System.out.print("Enter Property ID: ");
                    String id = sc.next();

                    int index = system.linearSearch(id);

                    if(index != -1)
                        System.out.println("Property Found: " + system.properties.get(index));
                    else
                        System.out.println("Property Not Found");

                    break;

                case 3:

                    system.bubbleSortByPrice();

                    System.out.println("\nSorted Properties by Price:");

                    for(Property p : system.properties) {
                        System.out.println(p);
                    }

                    break;

                case 4:

                    PropertyHeap heap = new PropertyHeap();

                    for(Property p : system.properties) {
                        heap.add(p);
                    }

                    System.out.println("\nHighest Rated Property:");
                    System.out.println(heap.getHighestRated());

                    break;

                case 5:

                    System.out.println("Thank you for using Better Stays!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");

            }
        }
    }
}