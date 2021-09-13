package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static Towns goal = Towns.getRandomTown();
    public static Integer put = goal.distance;
    public static void main(String[] args) {

        State state = State.AT_HOME;
        Random random = new Random();
        Cart cart = new Cart();
        state = State.IN_WAY;
        System.out.println(String.format("Вы стартовали до города ехать %s км", put));
        while(true){
            Events day = Events.getRandomEvent();
            if (day.equals(Events.TypicalDay)){
                System.out.println("Обычный день ничего не случилось");
                put = put - cart.speed;
                System.out.println(String.format("Вам осталось ехать %s км", put));
            }else if (day.equals(Events.Rain)){
                put = put - cart.speed + 2;
                Integer p = random.nextInt(100);
                if (p<=30) {
                    System.out.println("Дождливый день едем медленее и у вас испортился один товар");
                    cart.Uhudshenie();
                    System.out.println(String.format("Вам осталось ехать %s км", put));
                }else if (p > 30){
                    System.out.println("Дождливый день едем медленее");
                    System.out.println(String.format("Вам осталось ехать %s км", put));
                }
            }else if (day.equals(Events.GoodRoad)){
                System.out.println("Ровная дорога вы едете на максимальной скорости");
                if (cart.speed + 2 <= 5){
                    put = put - cart.speed - 2;
                    System.out.println(String.format("Вам осталось ехать %s км", put));
                }else if (cart.speed + 2 > 5){
                    put = put - 5;
                    System.out.println(String.format("Вам осталось ехать %s км", put));
                }
            }else if (day.equals(Events.BreakWheel)){
                System.out.println("Сломалось колесо вы не сдвинулись с места");
                System.out.println(String.format("Вам осталось ехать %s км", put));
            }else if (day.equals(Events.River)){
                System.out.println("Попали в реку потратили день чтоб выбраться");
                System.out.println(String.format("Вам осталось ехать %s км", put));
            }else if (day.equals(Events.MeetTheStranger)){
                System.out.println("Вам повезло вы встретили местного он показал короткий путь вы срезали дорогу");
                Integer i = random.nextInt(3) + 3;
                put = put - cart.speed - i;
                System.out.println(String.format("Вам осталось ехать %s км", put));
            }else if (day.equals(Events.ThiefOnTheRoad)){
                System.out.println("На вас напали разбойники выберите отдать часть денег - 1 или часть товара -2");
                Scanner scanner = new Scanner(System.in);
                 Integer otvet = scanner.nextInt();
                 if (otvet == 1 && cart.money > 1){
                     cart.money = cart.money / 2;
                     put = put - cart.speed;
                     System.out.println(String.format("Вы откупились деньгами их осталось %f", cart.money));
                     System.out.println(String.format("Вам осталось ехать %s км", put));
                 }else if (otvet == 2){
                     Integer k = cart.producty.size();
                     Integer l = cart.producty.size() / 2;
                     cart.producty.subList(l,k).clear();
                     System.out.println("Вы откупились товаром");
                     put = put - cart.speed;
                     System.out.println(String.format("Вам осталось ехать %s км", put));
                 }
            }else if (day.equals(Events.Brawl)){
                Scanner scanner = new Scanner(System.in);
                System.out.println("Вы встретили таверну выберите 1 - зайти и купить товара ( придётся потратить денег), 2 - продолжить путь");
                Integer otvet = scanner.nextInt();
                if (cart.money > 0 && otvet ==1){
                    Cart.Brawl();
                }else if (otvet == 2){
                    put = put - cart.speed;
                    System.out.println(String.format("Вам осталось ехать %s км", put));
                }
            }else if (day.equals(Events.BadNews)){
                System.out.println("Ва не повезло у вас испортился товар");
                cart.Isportilsa();
                put = put - cart.speed;
                System.out.println(String.format("Вам осталось ехать %s км", put));
            }

            if (put <= 0){
                state = State.IN_TOWN;
                System.out.println("Вы прибыли в город");
                Cart.Prodazha();
            }


            if (state.equals(State.IN_TOWN)){
                break;
            }
        }


    }


}
