package com.company;

import java.util.Random;

public class Main {

    public static int boosHealth = 700;
    public  static int boosDamage = 50;
    public static String bossDefenceType = " ";
    public static int[] heroesHealth = {250,250,250};
    public static int[] heroesDamage = {25,25,25};
    public static  String [] heroesAttackType ={"physical","magical","mental"};
    public static int doctorHealth = 100;
    public static int doctorHeal = 20;




    public static void main(String[] args) {
        fightInfo();

        while (!isFinished()){
            round();

        }


    }

    public static void round(){
        changeBossDefence();
        bossHit();
        doctorHealhero();
        heroesHit();
        fightInfo();

    }

    public static void changeBossDefence(){
        Random random = new Random();
        int randomIndex = random.nextInt(heroesAttackType.length);
        bossDefenceType = heroesAttackType[randomIndex];
    }

    public static boolean isFinished() {
        if (boosHealth <= 0) {
            System.out.println("Heroes won");
            return true;
        }
        if(heroesHealth[0]<=0 && heroesHealth[1] <=0 && heroesHealth[2] <=0){
            System.out.println("Boss won!!!");
            return true;
        }
        return false;

    }

    public static void bossHit() {
        for (int i = 0; i < heroesHealth.length; i++) {    //i равно нулю , если здоровье героя больше i , то i становиться больше
            if(heroesHealth[i] >0 && boosHealth >0) {   //если
                if (heroesHealth[i] - boosDamage < 0) {     //Босс атакует , если :
                    // если здоровье Босса и героя больше 0
                    //если после атаки Боса , здоровье героя  мешьше 0 ,выводит надпись здовоье героя = 0
                    //

                    heroesHealth[i] = 0;
                } else {                    //иначе
                    // здоровье героя равняется здоровье героя минус атака Бооса

                    heroesHealth[i] = heroesHealth[i] - boosDamage;
                }
            }
        }
      }
    public static void heroesHit() {                                 //шерои атакуют если
        for (int i = 0; i < heroesDamage.length; i++) {              // атака героев больше 0 , то 0 увеличивается
            if (heroesHealth[i] > 0 && boosHealth > 0) {            //если здоровьегероя  и Босса больше 0


                if (bossDefenceType.equals(heroesAttackType[i])) {     //тогда,если типзашитыбосса равна типу атаки героя
                    Random random = new Random();                       //то вызыввется метод рандом
                    int coefficient = random.nextInt(9) + 2;
                    if (boosHealth - heroesDamage[i] * coefficient < 0) {  // если после атаки героя,здоровье босса меньше 0

                        boosHealth = 0; //выводится эта надпись
                    } else {              //иначе здоровье босса равно здоровьебосса минус атаке героя
                        boosHealth = boosHealth - heroesDamage[i] * coefficient;
                    }
                    System.out.println(heroesAttackType[i] + "critical hit" + heroesDamage[i] * coefficient);
                } else {
                    if (boosHealth - heroesDamage[i] < 0) {
                        boosHealth = 0;
                    } else {
                        boosHealth = boosHealth - heroesDamage[i];
                    }
                }

            }
        }
    }
    public static void doctorHealhero() {
        for (int i = 0; i <heroesHealth[i] ; i++) {
            if (heroesHealth[i] > 0 && doctorHealth > 0) {

                heroesHealth[i] = heroesHealth[i] + doctorHeal;

            }

        }
    }

            public static void fightInfo(){
        System.out.println("____________________________");
        System.out.println("Boss health:" + boosHealth+""+bossDefenceType);
        System.out.println("Warrior Health:" +heroesHealth[0]);
        System.out.println("Magic Health:" +heroesHealth[1]);
        System.out.println("Kinetic Health:" +heroesHealth[2]);
                System.out.println("Doctor health:"+doctorHealth);
        System.out.println("____________________________");
    }
}



