import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        ZipCodeSearch zipCodeSearch = new ZipCodeSearch();

        System.out.println("-------------------------------------------------");
        System.out.println("Type a postal code");
        String postalCode = sc.nextLine();

        try {
            Address newAddress = zipCodeSearch.zipSearch(postalCode);
            System.out.println(newAddress);
            FileGenerator fg = new FileGenerator();
            fg.generator(newAddress);
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
            System.out.println("Finishing the application");
        }



    }
}