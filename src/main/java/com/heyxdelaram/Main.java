package com.heyxdelaram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        while (true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                //how many salespeople
                System.out.println("Please enter the number of sellers\n(or if you want to exit enter 0):");
                int numOfSellers = Integer.parseInt(reader.readLine());

                if (numOfSellers == 0){
                    System.out.println("Have a nice day!");
                    return;
                }

                //initiating the best sale and the shop's total sale
                double sellerTotalSale = 0;
                double shopTotalSale = 0;

                //initiating the bestseller's info
                String bestSellerName = null;
                double bestSellerAmount = 0;

                for (int sellerIndex = 0; sellerIndex < numOfSellers; sellerIndex++) {
                    System.out.println("seller's full name: ");
                    String sName = reader.readLine();

                    System.out.println(sName + "'s number of invoices: ");
                    int invCount = Integer.parseInt(reader.readLine());

                    sellerTotalSale = 0;

                    for (int invIndex = 0; invIndex < invCount; invIndex++) {
                        System.out.println((invIndex + 1) + " - invoice amount: ");
                        Double invAmount = Double.parseDouble(reader.readLine());
                        sellerTotalSale += invAmount;
                    }

                    shopTotalSale += sellerTotalSale;

                    Double avgAmount = sellerTotalSale / invCount;
                    System.out.printf(sName+ "'s total amount of sales: %f\n", sellerTotalSale);
                    System.out.printf(sName+ "'s average amount of sales: %f\n", avgAmount);

                    if (sellerTotalSale < 5_000_000) {
                        System.out.println(sName + " is a low level salesperson");
                    } else if (sellerTotalSale >= 5_000_000 && sellerTotalSale < 10_000_000) {
                        System.out.println(sName + " is a mediocre level salesperson");
                    } else if (sellerTotalSale >= 10_000_00) {
                        System.out.println(sName + " is a high level salesperson");
                    }

                    if (sellerTotalSale > bestSellerAmount) {
                        bestSellerAmount = sellerTotalSale;
                        bestSellerName = sName;
                    }

                    System.out.println((sellerIndex + 1) + " seller's status submitted and "
                            + (numOfSellers - (sellerIndex + 1)) + " left");
                }

                //end of loop - reporting the total status
                System.out.println("\n-------Shop's Status-------\n");
                System.out.printf("shop's total amount of sales: %f\n", shopTotalSale);
                System.out.printf("best seller is " + bestSellerName +  "with a total of %f sales\n", bestSellerAmount);
            } catch (NumberFormatException e) {
                System.out.println("Please enter the right format.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}