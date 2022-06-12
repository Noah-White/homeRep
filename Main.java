package kr.or.ddit.practice.game;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
   Character c;
   Item[] items;
   Monster[] monsters;
   Scanner sc = new Scanner(System.in);
   
   Main(){ //메인 메서드도 생성자를 지정해 줄 수 있음. 
      c= new Character("가렌",100,50,20,10);
      
      items = new Item[12]; //여기서 총 사용할 아이템 수는 12개.
      items[0] =new Item("나무검",0,0,10,0);
      items[1] =new Item("천 갑옷",0,0,0,10);
      items[2] =new Item("체력 구슬",10,0,0,0);
      items[3] =new Item("마나 구슬",0,10,0,0);
      
      items[4] =new Item("강철검",0,0,30,0);
      items[5] =new Item("가죽 갑옷",0,0,0,30);
      items[6] =new Item("체력 주머니",50,0,0,0);
      items[7] =new Item("마나 주머니",0,50,0,0);
      
      items[8] =new Item("무한의 대검",0,0,100,0);
      items[9] =new Item("가시 갑옷",0,0,0,100);
      items[10] =new Item("체력의 샘",100,0,0,0);
      items[11] =new Item("마나의 샘",0,100,0,0);
      
      monsters = new Monster[3];
      monsters[0] = new Monster("바위게",20,20,10,10,50, new Item[]{items[0], items[1], items[2], items[3]}); 
      monsters[1] = new Monster("협곡의 전령",100,20,50,50,100, new Item[]{items[4], items[5], items[6], items[7]}); 
      monsters[2] = new Monster("바론",5000,2000,200,200,400, new Item[]{items[8], items[9], items[10], items[11]}); 
      
      }
      
   
   public static void main(String[] args) {
      //Item i1 = new Item("나무검", 0, 0, 10, 0);
      
      //System.out.println(i1.itemInfo());
      //Character c1 = new Character("가렌",100,50,10,10);
      //c1.showInfo();
         new Main().start();
      
   }
      private void start(){
         int input =0;
         System.out.println("=======================게임시작=======================");
         while(true){
            if(c.hp <= 0){
               System.out.println("플레이어의 체력이 없습니다. ");
               System.out.println("게임을 종료합니다. ");
               break;
               }
            System.out.println("----------------메인메뉴----------------");
            System.out.println("1. 내 정보         2.사냥        0. 종료");
            System.out.println("------------------------------------------");
            System.out.println("메뉴를 입력해 주세요 >>");
            input = Integer.parseInt(sc.nextLine());
            switch(input){
               case 1:
                  c.showInfo();
               break;
            case 2:
               hunt();
               break;
            case 0:
               System.out.println("종료되었습니다");
               System.exit(0);
               break;
            }
         }
      }
         private void hunt(){
            Monster originM = monsters[(int)(Math.random() * monsters.length)];
            Monster m= new Monster(originM.name, originM.maxHp, originM.maxMp, originM.att, originM.def, originM.exp, originM.items);
            System.out.println("--------------전투화면----------------");
            System.out.println(m.name + "을(를) 만났습니다. 전투를 시작합니다. ");
            
            int input = 0;
            battle:while(true){
               System.out.println("1. 공격   2.도망 >>");
               input = Integer.parseInt(sc.nextLine());
               switch(input){
               case 1:
                  c.attack(m);
                  if(m.hp<=0){
                     System.out.println(m.name +"을(를) 처치하였습니다.");
                     System.out.println("-----------------전투 종료-----------------");
                     c.getExp(m.exp);
                     c.getItem(m.itemDrop());
                     System.out.println();
                     break battle;   //while문 종료가 아니라, battle이 종료됨. 
                  }
                  m.attack(c);
                  if(c.hp <= 0){
                     System.out.println(c.name +"이(가) 죽었습니다.");
                     System.out.println("-----------------전투 종료-----------------");
                     System.out.println();
                     break battle;
                  }
                  break;
               case 2:
                  System.out.println(m.name+"으로부터 도망갔습니다.");
                  break battle;
               }
            }
            
}
}