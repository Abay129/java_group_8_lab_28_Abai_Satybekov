package com.company;

import java.util.*;

public class Cart {
    static ArrayList<Products> producty = new ArrayList<>();
    static public double baseMoney;
    static private Integer liftingCapacity = 150;
    static Random random = new Random();
    static public double money = random.nextInt(500)+500;
    public Integer speed =  random.nextInt(5);

    public Cart() {
        Zakupka();
        for (int i = 0; i < producty.size();i++){
           System.out.println(producty.get(i).toString());
        }
    }

    public void Isportilsa(){

        Integer k = random.nextInt(producty.size());
        Quality.Isportilsa(producty.get(k).getQuality());
    }
    public void Uhudshenie(){

        Integer k = random.nextInt(producty.size());
        Quality.Uhudshenie(producty.get(k).getQuality());
    }

    public static void Zakupka(){
        baseMoney = money;
        while(producty.size() <= liftingCapacity || money <= 0){
            System.out.println(String.format("Вы торговец у вас %f денег выберете что купить", money));
            System.out.println("1- мясо ( стоит 40 денег)");
            System.out.println("2- сухофрукты ( стоит 10 денег)");
            System.out.println("3- зерно ( стоит 5 денег)");
            System.out.println("4- мука ( стоит 15 денег)");
            System.out.println("5- ткани ( стоит 30 денег)");
            System.out.println("6- краска ( стоит 70 денег)");
            System.out.println("7 - чтобы закончить покупки");
            Scanner scanner = new Scanner(System.in);
            Integer i = scanner.nextInt();
            if (i == 1) {
                producty.add(new Products(5, TypeProduct.MEAT, Quality.NORMAL));
                money = money - 40;
                liftingCapacity = liftingCapacity - 5;
            }else if(i == 2){
                producty.add(new Products(2, TypeProduct.DRIEDFRUITS, Quality.NORMAL));
                money = money - 10;
                liftingCapacity = liftingCapacity - 2;
            }else if(i == 3){
                producty.add(new Products(1, TypeProduct.GRAIN, Quality.NORMAL));
                money = money - 5;
                liftingCapacity = liftingCapacity - 1;
            }else if(i == 4){
                producty.add(new Products(3, TypeProduct.FLOUR, Quality.NORMAL));
                money = money - 15;
                liftingCapacity = liftingCapacity - 3;
            }else if(i == 5){
                producty.add(new Products(4, TypeProduct.FABRICS, Quality.NORMAL));
                money = money - 30;
                liftingCapacity = liftingCapacity - 4;
            }else if(i == 6){
                producty.add(new Products(7, TypeProduct.PAINT, Quality.NORMAL));
                money = money - 70;
                liftingCapacity = liftingCapacity - 7;
            }else if(i == 7){
                break;
            }
        }

    }

    public static void Brawl(){
        while(producty.size() <= liftingCapacity || money <= 0){
            System.out.println(String.format("Вы торговец у вас %f денег выберете что купить", money));
            System.out.println("1- мясо ( стоит 40 денег)");
            System.out.println("2- сухофрукты ( стоит 10 денег)");
            System.out.println("3- зерно ( стоит 5 денег)");
            System.out.println("4- мука ( стоит 15 денег)");
            System.out.println("5- ткани ( стоит 30 денег)");
            System.out.println("6- краска ( стоит 70 денег)");
            System.out.println("7 - чтобы закончить покупки");
            Scanner scanner = new Scanner(System.in);
            Integer i = scanner.nextInt();
            if (i == 1) {
                producty.add(new Products(5, TypeProduct.MEAT, Quality.NORMAL));
                money = money - 40;
                liftingCapacity = liftingCapacity - 5;
            }else if(i == 2){
                producty.add(new Products(2, TypeProduct.DRIEDFRUITS, Quality.NORMAL));
                money = money - 10;
                liftingCapacity = liftingCapacity - 2;
            }else if(i == 3){
                producty.add(new Products(1, TypeProduct.GRAIN, Quality.NORMAL));
                money = money - 5;
                liftingCapacity = liftingCapacity - 1;
            }else if(i == 4){
                producty.add(new Products(3, TypeProduct.FLOUR, Quality.NORMAL));
                money = money - 15;
                liftingCapacity = liftingCapacity - 3;
            }else if(i == 5){
                producty.add(new Products(4, TypeProduct.FABRICS, Quality.NORMAL));
                money = money - 30;
                liftingCapacity = liftingCapacity - 4;
            }else if(i == 6){
                producty.add(new Products(7, TypeProduct.PAINT, Quality.NORMAL));
                money = money - 70;
                liftingCapacity = liftingCapacity - 7;
            }else if(i == 7){
                break;
            }
        }
    }

    public static  void Prodazha(){
        double vyruchka = 0;
        while(producty.size() > 0)
            if (producty.get(0).getQuality().equals(Quality.NORMAL)){
                vyruchka = vyruchka + producty.get(0).getPrice() * 1.2;
                money = money + vyruchka;
                producty.remove(0);
            }else if (producty.get(0).getQuality().equals(Quality.SLIGHTLYSPOILED)) {
                vyruchka = vyruchka + producty.get(0).getPrice() * 0.95;
                money = money + vyruchka;
                producty.remove(0);
            }else if (producty.get(0).getQuality().equals(Quality.HALFWENTBAD)) {
                vyruchka = vyruchka + producty.get(0).getPrice() * 0.55;
                money = money + vyruchka;
                producty.remove(0);
            }else if (producty.get(0).getQuality().equals(Quality.ALMOSTALLDISAPPEARED)) {
                vyruchka = vyruchka + producty.get(0).getPrice() * 0.25;
                money = money + vyruchka;
                producty.remove(0);
            }else if (producty.get(0).getQuality().equals(Quality.SPOILEDINTOTRASH)) {
                vyruchka = vyruchka + producty.get(0).getPrice() * 0.1;
                money = money + vyruchka;
                producty.remove(0);
            }
        System.out.println(String.format("Всего вы заработали %f", vyruchka));
        if (vyruchka + money > baseMoney){
            System.out.println("Вы в плюсе ");

        }else{
            System.out.println("Вы в минусе");
        }
    }


}
