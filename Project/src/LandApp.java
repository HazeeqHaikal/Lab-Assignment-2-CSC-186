import java.util.*;
import java.text.*;

public class LandApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // 2 decimal places and comma between thousands
        DecimalFormat df = new DecimalFormat("#,##0.00");

        String ID, ownerName;
        char houseType;
        double area, totalTaxation = 0;
        int count = 0;


        System.out.print("Enter the amount of customers: ");
        count = input.nextInt();
        input.nextLine();

        System.out.println();

        // 2 dimensional array to store the data
        String[][] data = new String[count][5];

        for(int i = 0; i < count; i++){
            System.out.print("Enter ID: ");
            ID = input.nextLine();

            System.out.print("Enter owner name: ");
            ownerName = input.nextLine();
             // split the string by spaces but the spaces are removed and the amount of
            // spaces does not matter
            String ownerNameArray[] = ownerName.split("\\s+");

            // capitalize the first letter of each word and lowercase the rest
            // except for "bin" and "binti"
            for (int j = 0; j < ownerNameArray.length; j++) {
                if (ownerNameArray[j].toLowerCase().equals("bin") || ownerNameArray[j].toLowerCase().equals("binti")) {
                    ownerNameArray[j] = ownerNameArray[j].toLowerCase();
                } else {
                    ownerNameArray[j] = ownerNameArray[j].substring(0, 1).toUpperCase()
                            + ownerNameArray[j].substring(1).toLowerCase();
                }
            }

            // combine the array into a string with spaces
            ownerName = String.join(" ", ownerNameArray);

            System.out.print("\nTerrace (T)\nSemi-Detached (S)\nBungalow (B)\nCondominium (C)\nEnter house type: ");
            houseType = input.nextLine().charAt(0);
            houseType = Character.toUpperCase(houseType);

            System.out.print("Enter area: ");
            area = input.nextDouble();
            input.nextLine();

            Land land = new Land(ID, ownerName, houseType, area);

            System.out.println();

            switch (houseType) {
                case 'T':
                    land.setDescription("Terrace");
                    break;
                case 'S':
                    land.setDescription("Semi-Detached");
                    break;
                case 'B':
                    land.setDescription("Bungalow");
                    break;
                case 'C':
                    land.setDescription("Condominium");
                    break;
                default:
                    land.setDescription("Invalid");
                    break;
            }

            System.out.println(land);

            // store data into 2 dimensional array
            data[i][0] = ID;
            data[i][1] = ownerName;
            data[i][2] = Character.toString(houseType);
            data[i][3] = Double.toString(area);
            data[i][4] = Double.toString(land.calculateTax());
            totalTaxation += land.calculateTax();

            System.out.println();


        }


        // display data that has the highest taxation
        int maxTaxCustomer = 0;
        
        for(int i = 0; i < count; i++){
            if(Double.parseDouble(data[i][4]) > maxTaxCustomer){
                maxTaxCustomer = i;
            }
        }

        System.out.println("Customer with the highest taxation:\n");
        System.out.println("ID: " + data[maxTaxCustomer][0]);
        System.out.println("Owner Name: " + data[maxTaxCustomer][1]);
        System.out.println("House Type: " + data[maxTaxCustomer][2]);
        System.out.println("Area: " + data[maxTaxCustomer][3]);
        // 2 decimal places
        double taxRate = Double.parseDouble(data[maxTaxCustomer][4]);
        System.out.println("Highest Taxation: RM" + df.format(taxRate));

        System.out.println();

        // calculate total tax
        for(int i = 0; i < count; i++){
            totalTaxation += Double.parseDouble(data[i][4]);
        }

        System.out.println("Total Taxation: RM" + df.format(totalTaxation));

        input.close();
    }
}