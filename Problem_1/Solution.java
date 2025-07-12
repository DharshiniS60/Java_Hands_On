public class Grain {
    private int grainId;
    private String grainName;
    private String state;
    private int qtyInQuintal;

    // Parameterized Constructor
    public Grain(int grainId, String grainName, String state, int qtyInQuintal) {
        this.grainId = grainId;
        this.grainName = grainName;
        this.state = state;
        this.qtyInQuintal = qtyInQuintal;
    }

    // Getters
    public int getGrainId() {
        return grainId;
    }

    public String getGrainName() {
        return grainName;
    }

    public String getState() {
        return state;
    }

    public int getQtyInQuintal() {
        return qtyInQuintal;
    }

    // Setters
    public void setGrainId(int grainId) {
        this.grainId = grainId;
    }

    public void setGrainName(String grainName) {
        this.grainName = grainName;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setQtyInQuintal(int qtyInQuintal) {
        this.qtyInQuintal = qtyInQuintal;
    }
}import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Grain[] grains = new Grain[n];

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            sc.nextLine(); // consume newline
            String name = sc.nextLine();
            String state = sc.nextLine();
            int qty = sc.nextInt();
            sc.nextLine(); // consume newline

            grains[i] = new Grain(id, name, state, qty);
        }

        String searchName = sc.nextLine();

        // Call countGrainByGivenName
        int count = countGrainByGivenName(grains, searchName);
        if (count > 0) {
            System.out.println(count);
        } else {
            System.out.println("No Grains with matching names are found");
        }

        // Call getMinGrainFromMaharashtra
        Grain result = getMinGrainFromMaharashtra(grains);
        if (result != null) {
            System.out.println(result.getGrainId());
            System.out.println(result.getGrainName());
            System.out.println(result.getState());
            System.out.println(result.getQtyInQuintal());
        } else {
            System.out.println("No Grains with matching names are found");
        }
    }

    public static int countGrainByGivenName(Grain[] grains, String name) {
        int count = 0;
        for (Grain g : grains) {
            if (g.getGrainName().equalsIgnoreCase(name)) {
                count++;
            }
        }
        return count;
    }

    public static Grain getMinGrainFromMaharashtra(Grain[] grains) {
        Grain minGrain = null;
        for (Grain g : grains) {
            if (g.getState().equalsIgnoreCase("Maharashtra")) {
                if (minGrain == null || g.getQtyInQuintal() < minGrain.getQtyInQuintal()) {
                    minGrain = g;
                }
            }
        }
        return minGrain;
    }
}


