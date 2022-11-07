import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try
        {
            File f = new File("backup");
            if(f.exists())
            {
                FileInputStream fin = new FileInputStream(f);
                ObjectInputStream ois = new ObjectInputStream(fin);
                Hotel.hotel_ob = (holder)ois.readObject();
            }
            Scanner sc = new Scanner(System.in);
            int ch, ch2;
            char wish;
            x:
            do{
                System.out.println("****************************************");
                System.out.println("*           THE IKTARA HOTEL           *");
                System.out.println("*       HOTEL TO CELEBRATE LIFE        *");
                System.out.println("*     NAMASTE FROM IKTARA FAMILY       *");
                System.out.println("****************************************");
                System.out.println("\nEnter Your Choice :\n1.Room Info \n2.Room Availabilities \n3.Book your Room \n4.Order food \n5.Checkout \n6.Exit \n");
                ch = sc.nextInt();
                switch(ch){
                    case 1: System.out.println("\nChoose Room Type :\n1.Standard Room \n2.Deluxe Room(NON-AC) \n3.Deluxe Room(AC) \n4.Luxury Room\n");
                        ch2 = sc.nextInt();
                        Hotel.features(ch2);
                        break;
                    case 2: System.out.println("\nChoose Room Type :\n1.Standard Room \n2.Deluxe Room(NON-AC) \n3.Deluxe Room(AC) \n4.Luxury Room\n");
                        ch2 = sc.nextInt();
                        Hotel.availability(ch2);
                        break;
                    case 3:System.out.println("\nChoose Room Type :\n1.Standard Room \n2.Deluxe Room(NON-AC) \n3.Deluxe Room(AC) \n4.Luxury Room\n");
                        ch2 = sc.nextInt();
                        Hotel.bookroom(ch2);
                        break;
                    case 4:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if(ch2 > 60)
                            System.out.println("Room doesn't exist");
                        else if(ch2 > 50)
                            Hotel.order(ch2-51,4);
                        else if(ch2 > 40)
                            Hotel.order(ch2-41,3);
                        else if(ch2 > 25)
                            Hotel.order(ch2-26,2);
                        else if(ch2 > 0)
                            Hotel.order(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 5:
                        System.out.print("Room Number -");
                        ch2 = sc.nextInt();
                        if(ch2 > 60)
                            System.out.println("Room doesn't exist");
                        else if(ch2 > 50)
                            Hotel.deallocate(ch2-51,4);
                        else if(ch2 > 40)
                            Hotel.deallocate(ch2-41,3);
                        else if(ch2 > 25)
                            Hotel.deallocate(ch2-26,2);
                        else if(ch2 > 0)
                            Hotel.deallocate(ch2-1,1);
                        else
                            System.out.println("Room doesn't exist");
                        break;
                    case 6:
                        break x;

                }

                System.out.println("\nContinue : (y/n)");
                wish = sc.next().charAt(0);
                if(!(wish == 'y'|| wish == 'Y' || wish == 'n' || wish == 'N'))
                {
                    System.out.println("Invalid Option");
                    System.out.println("\nContinue : (y/n)");
                    wish = sc.next().charAt(0);
                }

            }while(wish == 'y'|| wish == 'Y');

            Thread t = new Thread(new write(Hotel.hotel_ob));
            t.start();
        }
        catch(Exception e)
        {
            System.out.println("Not a valid input");
        }
    }
}