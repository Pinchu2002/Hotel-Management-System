import java.io.Serializable;

class Food implements Serializable
{
    int itemno;
    int quantity;
    float price;
    int ft;

    Food(int ft,int itemno,int quantity)
    {
        this.ft = ft;
        this.itemno = itemno;
        this.quantity = quantity;
        switch(ft)
        {
            case 1://breakfast & snacks;
                switch (itemno) {
                    case 1 -> price = quantity * 49;//sandwich
                    case 2 -> price = quantity * 59;//burger
                    case 3 -> price = quantity * 129;//pasta
                    case 4 -> price = quantity * 99; //idli
                    case 5 -> price = quantity * 129;//dosa
                    case 6 -> price = quantity * 49; //tari_poha
                    case 7 -> price = quantity * 49;//poori bhaji
                    case 8 -> price = quantity * 49;//(aloo/gobi/masala/paneer)
                    case 9 -> price = quantity * 89;//pancake stack
                    case 10 -> price = quantity * 59;//boiled eggs/poached/scrambled/omelette
                }
                break;
            case 2://lunch time & Dinner;
                switch (itemno) {
                    case 1 -> price = quantity * 299;    //basic lunch pack
                    case 2 -> price = quantity * 199;    // veg blast
                    case 3 -> price = quantity * 399;    // veg thali normal
                    case 4 -> price = quantity * 599;    // seafood thali normal
                    case 5 -> price = quantity * 499;    // chicken thali normal
                    case 6 -> price = quantity * 549;    // mutton thali normal
                    case 7 -> price = quantity * 749;    // iktara special veg thali
                    case 8 -> price = quantity * 899;    // iktara special non-veg thali
                    case 9 -> price = quantity * 1099;   // iktara autograph collection
                    case 10 -> price = quantity * 1199;  // Chef's signature collection
                }
                break;
        }
    }
}