package com.mattsobek;

import java.util.Scanner;

class ShopItems {
    int totalCount;

    class NonVegan {
        int iceCreamCount;
        int shakeCount;
        int totalCount;

        public void increaseCount(int type, int count) {
            if (type == 1) {
                iceCreamCount = iceCreamCount + count;
            }
            if (type == 2) {
                shakeCount = shakeCount + count;
            }
            totalCount = totalCount + count;
            ShopItems.this.totalCount = ShopItems.this.totalCount + count;
        }
    }

    class Vegan {
        int smoothieCount;
        int slushieCount;
        int totalCount;

        public void increaseCount(int type, int count) {
            if (type == 3) {
                smoothieCount = smoothieCount + count;
            }
            if (type == 4) {
                slushieCount = slushieCount + count;
            }
            totalCount = totalCount + count;
            ShopItems.this.totalCount = ShopItems.this.totalCount + count;
        }
    }
}

public class IceCreamShop {

    public static void main(String[] args) {
        int orderType;
        Scanner input = new Scanner(System.in);
        int itemCount;
        String itemName;

        ShopItems shopItems = new ShopItems();
        ShopItems.NonVegan nonVegan = shopItems.new NonVegan();
        ShopItems.Vegan vegan = shopItems.new Vegan();

        System.out.println("Hello! Welcome to the ice cream shop. We are ready to take your order. " +
                "For ice-cream type 1, for shakes type 2, for smoothies type 3, and for slushies type 4. " +
                "If you are done ordering type 0.");
        orderType = input.nextInt();

        while(orderType != 0) {
            System.out.println("How many items of this item would you like to order?");
            itemCount = input.nextInt();
            if(orderType == 1){
                itemName = "ice cream";
                nonVegan.increaseCount(orderType, itemCount);
            } else if(orderType == 2) {
                itemName = "shake";
                nonVegan.increaseCount(orderType, itemCount);
            } else if(orderType == 3) {
                itemName = "smoothie";
                vegan.increaseCount(orderType, itemCount);
            } else if(orderType == 4) {
                itemName = "slushie";
                vegan.increaseCount(orderType, itemCount);
            } else {
                break;
            }

            System.out.println("Thank you for your order! Today we have sold " + shopItems.totalCount + " orders of sweetness!");
            System.out.println(nonVegan.totalCount + " items have been ice Cream and shakes.");
            System.out.println(vegan.totalCount + " items have been smoothies and slushies.");

            System.out.println("Adding " + itemCount + " of the item "+ itemName + " to your order!");

            System.out.println("Type a number for the next item in your order:\n1: Ice cream\n2: Shake\n3: Smoothie\n4: Slushie\n");
            orderType = input.nextInt();
        }
    }
}
