import java.io.Serializable;

class holder implements Serializable
{
    Room[] standard_room = new Room[25]; //Standard
    Room[] deluxe_nonac = new Room[15]; //Deluxe_NON_AC
    Room[] deluxe_ac = new Room[10]; //Deluxe_AC
    Room[] luxury_room = new Room[10]; //Luxury
}