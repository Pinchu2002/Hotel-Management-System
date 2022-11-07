import java.util.Scanner;

class Hotel
{
    static holder hotel_ob = new holder();
    static Scanner sc = new Scanner(System.in);
    static void CustDetails(int i,int rn)
    {
        String name, contact, gender, email, aadhar,temp;
        temp = sc.nextLine();
        System.out.print("\nEnter Customer Name: ");
        name = sc.nextLine();
        System.out.print("Enter Contact Number: ");
        contact=sc.next();
        System.out.print("Enter Email Address: ");
        email = sc.next();
        System.out.print("Enter Gender: ");
        gender = sc.next();
        System.out.print("Enter Aadhar No.: ");
        aadhar = sc.next();

        switch (i) {
            case 1 -> hotel_ob.standard_room[rn] = new Room(name, contact, email, gender, aadhar);
            case 2 -> hotel_ob.deluxe_nonac[rn] = new Room(name, contact, email, gender, aadhar);
            case 3 -> hotel_ob.deluxe_ac[rn] = new Room(name, contact, email, gender, aadhar);
            case 4 -> hotel_ob.luxury_room[rn] = new Room(name, contact, email, gender, aadhar);
            default -> System.out.println("Wrong option");
        }
    }

    static void bookroom(int i)
    {
        int j;
        int rn;
        System.out.println("\nChoose room number from : ");
        switch (i) {
            case 1 -> {
                for (j = 0; j < hotel_ob.standard_room.length; j++) {
                    if (hotel_ob.standard_room[j] == null) {
                        System.out.print(j + 1 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn--;
                    if (hotel_ob.standard_room[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
            }
            case 2 -> {
                for (j = 0; j < hotel_ob.deluxe_nonac.length; j++) {
                    if (hotel_ob.deluxe_nonac[j] == null) {
                        System.out.print(j + 26 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 26;
                    if (hotel_ob.deluxe_nonac[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
            }
            case 3 -> {
                for (j = 0; j < hotel_ob.deluxe_ac.length; j++) {
                    if (hotel_ob.deluxe_ac[j] == null) {
                        System.out.print(j + 41 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 41;
                    if (hotel_ob.deluxe_ac[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
            }
            case 4 -> {
                for (j = 0; j < hotel_ob.luxury_room.length; j++) {
                    if (hotel_ob.luxury_room[j] == null) {
                        System.out.print(j + 51 + ",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn = rn - 51;
                    if (hotel_ob.luxury_room[rn] != null)
                        throw new NotAvailable();
                    CustDetails(i, rn);
                } catch (Exception e) {
                    System.out.println("Invalid Option");
                    return;
                }
            }
            default -> System.out.println("Enter valid option");
        }
        System.out.println("Room Booked");
    }

    static void features(int i)
    {
        switch (i) {
            case 1 -> {
                System.out.println("_____Standard Room Details_____");
                System.out.println("* NON-AC");
                System.out.println("* FREE WIFI");
                System.out.println("* Rs.1500 per night + 18% GST");
            }
            case 2 -> {
                System.out.println("_____DELUXE Room (NON-AC) Details_____");
                System.out.println("* FREE BREAKFAST");
                System.out.println("* FAST SERVICES");
                System.out.println("* FREE WIFI");
                System.out.println("* Rs.2500 per night + 18% GST");
            }
            case 3 -> {
                System.out.println("_____DELUXE Room (AC) Details_____");
                System.out.println("* FREE BREAKFAST");
                System.out.println("* FAST SERVICES");
                System.out.println("* FREE WIFI");
                System.out.println("* Rs.3000 per night + 18% GST");
            }
            case 4 -> {
                System.out.println("_____LUXURY Room Details_____");
                System.out.println("* FREE FOOD");
                System.out.println("* 24/7 INSTANT SERVICES");
                System.out.println("* FREE WIFI");
                System.out.println("* LUXURIOUS BED AND COUCHES");
                System.out.println("* CITY VIEW");
                System.out.println("* Rs.4000 per night + 18% GST");
            }
            default -> System.out.println("Oops! Wrong option \nEnter Valid number");
        }
    }

    static void availability(int i)
    {
        int count = 0;
        switch (i) {
            case 1:
                for(int j = 0; j < hotel_ob.standard_room.length; j++)
                {
                    if(hotel_ob.standard_room[j] == null)
                        count++;
                }
                break;
            case 2:
                for(int j = 0; j < hotel_ob.deluxe_nonac.length; j++)
                {
                    if(hotel_ob.deluxe_nonac[j]==null)
                        count++;
                }
                break;
            case 3:
                for(int j = 0; j < hotel_ob.deluxe_ac.length; j++)
                {
                    if(hotel_ob.deluxe_ac[j]==null)
                        count++;
                }
                break;
            case 4:
                for(int j = 0; j < hotel_ob.luxury_room.length; j++)
                {
                    if(hotel_ob.luxury_room[j]==null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available : " + count);
    }

    static void bill(int rn,int rtype)
    {
        double amount = 0;
        String[][] list ={{"Sandwich","Burger","Pasta","Idli","Dosa",
                "Tari Poha","Poori Bhaji","Paratha","Pancake","Eggs"},
                {"Basic Lunch Pack","Veg Blast","Veg Thali","Seafood Thali","Chicken Thali",
                        "Mutton Thali","Iktara Special Veg Thali","Iktara Special Non-Veg Thali"
                        ,"Iktara Autograph Collection", "Chef's Signature Collection"}};
        System.out.println("****************************************");
        System.out.println("*           THE IKTARA HOTEL           *");
        System.out.println("*        HOTEL TO CELEBRATE LIFE       *");
        System.out.println("*      NAMASTE FROM IKTARA FAMILY      *");
        System.out.println("*             HOTEL INVOICE            *");
        System.out.println("****************************************");
        switch (rtype) {
            case 1 -> {
                amount += 1770;
                System.out.println("\nRoom Charge - Rs." + 1770);
                System.out.println("\n===================================================================================");
                System.out.println("Food Charges:- ");
                System.out.println("====================================================================================");
                System.out.println("Item                                    Quantity                              Price");
                System.out.println("------------------------------------------------------------------------------------");

                for (Food obb : hotel_ob.standard_room[rn].food) {
                    amount += obb.price;
                    String format = "%s%20s%20s%n";
                    System.out.printf(format, list[obb.ft-1][obb.itemno - 1], obb.quantity, obb.price);
                }
            }
            case 2 -> {
                amount += 2950;
                System.out.println("Room Charge - Rs." + 2950);
                System.out.println("\n===================================================================================");
                System.out.println("Food Charges:- ");
                System.out.println("====================================================================================");
                System.out.println("Item                                    Quantity                              Price");
                System.out.println("------------------------------------------------------------------------------------");
                for (Food obb : hotel_ob.deluxe_nonac[rn].food) {
                    amount += obb.price;
                    String format = "%s%20s%20s%n";
                    System.out.printf(format, list[obb.ft-1][obb.itemno - 1], obb.quantity, obb.price);
                }
            }
            case 3 -> {
                amount += 3540;
                System.out.println("Room Charge - Rs." + 3540);
                System.out.println("\n===================================================================================");
                System.out.println("Food Charges:- ");
                System.out.println("====================================================================================");
                System.out.println("Item                                    Quantity                              Price");
                System.out.println("------------------------------------------------------------------------------------");

                for (Food obb : hotel_ob.deluxe_ac[rn].food) {
                    amount += obb.price;
                    String format = "%s%20s%20s%n";
                    System.out.printf(format, list[obb.ft-1][obb.itemno - 1], obb.quantity, obb.price);
                }
            }
            case 4 -> {
                amount += 4720;
                System.out.println("Room Charge - Rs." + 4720);
                System.out.println("\n===================================================================================");
                System.out.println("Food Charges:- ");
                System.out.println("====================================================================================");
                System.out.println("Item                                    Quantity                              Price");
                System.out.println("------------------------------------------------------------------------------------");

                for (Food obb : hotel_ob.luxury_room[rn].food) {
                    amount += obb.price;
                    String format = "%s%20s%20s%n";
                    System.out.printf(format, list[obb.ft-1][obb.itemno - 1], obb.quantity, obb.price);
                }
            }
            default -> System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- "+amount);
    }

    static void deallocate(int rn,int rtype)
    {
        int j;
        char w;
        switch (rtype) {
            case 1 -> {
                if (hotel_ob.standard_room[rn] != null) {
                    System.out.println("Room used by " + hotel_ob.standard_room[rn].name);
                    System.out.println("Contact No. " + hotel_ob.standard_room[rn].contact);
                } else {
                    System.out.println("Room Already Empty");
                    return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.standard_room[rn] = null;
                    System.out.println("""
                            Checkout Successful\s
                            Thanks for choosing Our Hotel!\s
                            Pleas Visit Again""");
                }
            }
            case 2 -> {
                if (hotel_ob.deluxe_nonac[rn] != null) {
                    System.out.println("Room used by " + hotel_ob.deluxe_nonac[rn].name);
                    System.out.println("Contact No. " + hotel_ob.deluxe_nonac[rn].contact);
                } else {
                    System.out.println("Room Already Empty");
                    return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.deluxe_nonac[rn] = null;
                    System.out.println("""
                            Checkout Successful\s
                            Thanks for choosing Our Hotel!\s
                            Pleas Visit Again""");
                }
            }
            case 3 -> {
                if (hotel_ob.deluxe_ac[rn] != null) {
                    System.out.println("Room used by " + hotel_ob.deluxe_ac[rn].name);
                    System.out.println("Contact No. " + hotel_ob.deluxe_ac[rn].contact);
                } else {
                    System.out.println("Room Already Empty");
                    return;
                }
                System.out.println("Do you want to checkout ? (y/n)");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.deluxe_ac[rn] = null;
                    System.out.println("""
                            Checkout Successful\s
                            Thanks for choosing Our Hotel!\s
                            Pleas Visit Again""");
                }
            }
            case 4 -> {
                if (hotel_ob.luxury_room[rn] != null) {
                    System.out.println("Room used by " + hotel_ob.luxury_room[rn].name);
                    System.out.println("Contact No. " + hotel_ob.luxury_room[rn].contact);
                } else {
                    System.out.println("Room Already Empty");
                    return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w = sc.next().charAt(0);
                if (w == 'y' || w == 'Y') {
                    bill(rn, rtype);
                    hotel_ob.luxury_room[rn] = null;
                    System.out.println("""
                            Checkout Successful\s
                            Thanks for choosing Our Hotel!\s
                            Pleas Visit Again""");
                }
            }
            default -> System.out.println("\nEnter valid option : ");
        }
    }

    static void order(int rn,int rtype)
    {
        int i,q,ft;
        char wish;
        try{
            System.out.println("*****************************************************");
            System.out.println("*               THE IKTARA HOTEL                    *");
            System.out.println("*            HOTEL TO CELEBRATE LIFE                *");
            System.out.println("*           NAMASTE FROM IKTARA FAMILY              *");
            System.out.println("*            IKTARA RESTAURANT MENU                 *");
            System.out.println("*             1.BREAKFAST/SNACKS                    *");
            System.out.println("*                 1.Sandwich                - Rs49  *");
            System.out.println("*                 2.Burger                  - Rs59  *");
            System.out.println("*                 3.Pasta                   - Rs129 *");
            System.out.println("*                 4.Idli                    - Rs99  *");
            System.out.println("*                 5.Dosa                    - Rs129 *");
            System.out.println("*                 6.Tari Poha               - Rs49  *");
            System.out.println("*                 7.Poori Bhaji             - Rs49  *");
            System.out.println("*                 8.Aloo/Gobi/                      *\n"+
                               "*                  Masala/Panner Paratha    - Rs49  *");
            System.out.println("*                 9.Pancake Stack           - Rs89  *");
            System.out.println("*                 10.Boiled Eggs/Poached    -       *\n"+
                               "*                    /Scrambled/Omelette    - Rs59  *");
            System.out.println("*               2.LUNCH/DINNER                      *");
            System.out.println("*                 1.Basic Lunck Pack        - Rs299 *");
            System.out.println("*                 2.Veg Blast               - Rs199 *");
            System.out.println("*                 3.Veg Thali               - Rs399 *");
            System.out.println("*                 4.Seafood Thali           - Rs599 *");
            System.out.println("*                 5.Chicken Thali           - Rs499 *");
            System.out.println("*                 6.Mutton Thali            - Rs549 *");
            System.out.println("*                 7.Iktara Specail Veg Thali- Rs749 *");
            System.out.println("*                 8.Iktara Specail                  *\n"+
                               "*                   Non-Veg Thali           - Rs899 *");
            System.out.println("*                 9.Iktara Autograph                *\n"+
                               "*                   Collection             - Rs1099 *");
            System.out.println("*                 10.Chef Signature                 *\n"+
                               "*                   Collection             - Rs1199 *");
            System.out.println("*****************************************************");
            do
            {
                System.out.println("Enter Food Category No. ");
                ft = sc.nextInt();
                System.out.println("Enter Food Item No. ");
                i = sc.nextInt();
                System.out.print("Quantity- ");
                q = sc.nextInt();
                switch (rtype) {
                    case 1 -> hotel_ob.standard_room[rn].food.add(new Food(ft, i, q));
                    case 2 -> hotel_ob.deluxe_nonac[rn].food.add(new Food(ft, i, q));
                    case 3 -> hotel_ob.deluxe_ac[rn].food.add(new Food(ft, i, q));
                    case 4 -> hotel_ob.luxury_room[rn].food.add(new Food(ft, i, q));
                }
                System.out.println("Do you want to order anything else ? (y/n)");
                wish = sc.next().charAt(0);
            }while(wish == 'y'|| wish == 'Y');
        }
        catch(NullPointerException e)
        {
            System.out.println("\nRoom not booked");
        }
        catch(Exception e)
        {
            System.out.println("Can't Order Food");
        }
    }
}