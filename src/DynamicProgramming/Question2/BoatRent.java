package DynamicProgramming.Question2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @auther nihao
 * @create 2019-12-29 20:05
 */
public class BoatRent {

    public static int siteNum;

    public static int price = 0;

    List<Flight> flightList = new ArrayList<>();

    public static void main(String[] args){
        initData();
        computedValue();
    }

    public static void computedValue(){
        for(int i = 0; i < siteNum; i++){

        }
    }

    public static void initData(){
        Scanner input = new Scanner(System.in);
        siteNum = input.nextInt();
        for(int i = 0; i < 3; i++){
            Flight flight = new Flight();
            flight.start = input.nextInt();
            flight.end = input.nextInt();
            flight.amount = input.nextInt();
        }
    }
}