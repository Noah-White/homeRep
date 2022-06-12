package kr.or.ddit.practice.game;

public class Character {
	   String name;
	   int maxHp, maxMp, hp,mp, att, def, level, exp, nextExp;
	   Item []items;
	   
	      Character(String name, int maxHp, int maxMp, int att, int def){
	         this.name = name;
	         this.maxHp = maxHp;
	         this.maxMp = maxMp;
	         this.hp=maxHp;      //now hp
	         this.mp=maxMp;
	         this.att = att;
	         this.def = def;
	         this.level=1;
	         this.exp=0;
	         this.nextExp=this.level*100;
	         this.items=new Item[50];
	      }
	      
	      void showInfo(){
	         System.out.println("-------상태--------");
	         System.out.println("이름 : "+name);
	         System.out.println("레벨 : "+level +" ("+exp+"/"+nextExp+")" );
	         System.out.println("체력 : " + hp + "/"+maxHp);
	         System.out.println("마나 : " + mp + "/"+maxMp);
	         System.out.println("공격 : "+att);
	         System.out.println("방어 : "+def);
	         System.out.println("--------------------");
	         System.out.println("------아이템-------");
	         for(int i=0; i<this.items.length; i++){
	            if(items[i] !=null)
	               System.out.println(items[i].itemInfo());
	         }
	         System.out.println("--------------------");
	         System.out.println();
	         
	      }
	      
	      void attack(Monster m){
	         int damage=this.att - m.def;
	         damage = (damage <= 0) ? (1) : (damage);   //삼항연산자 '(A) ? (B) : (C)' => A가 참이면, B를 출력하고,거짓이면 C를 출력
	         m.hp = m.hp < damage ? 0 : m.hp - damage;
	         System.out.println(name + "(이)가 공격으로 " +m.name+"에게 "+damage + "만큼 데미지를 주었습니다.");
	         System.out.println(m.name+"의 남은 체력 : "+m.hp);
	         System.out.println();
	      }
	      
	      void getExp (int exp){
	         System.out.println(exp + "의 경험치를 획득했습니다.");
	         this.exp+=exp;
	         while(nextExp <=this.exp){
	            this.exp-=nextExp;
	            levelUp();
	         }
	      }
	         
	      void levelUp(){
	         this.level++;
	         this.maxHp +=10;
	         this.maxMp+=5;
	         this.att+=2;
	         this.def+=2;
	         this.hp=this.maxHp;
	         this.mp=this.maxMp;
	         this.nextExp=level*100;
	         System.out.println("LEVEL UP !!");   
	      }
	      
	      void getItem(Item item){
	         System.out.println(item.name+" 을(를) 획득하였습니다.");
	         //System.err.println(item.name+" 을(를) 획득하였습니다."); //색 바꿀때, 근데 속도가 다름
	         for(int i=0;i<items.length; i++){
	            if(items[i] == null){
	               this.items[i] = item; //내 인벤토리 제일 끝에 넣어줌
	               break;
	            }
	         }
	         this.maxHp += item.maxHp;
	         this.maxMp += item.maxMp;
	         this.att+=item.att;
	         this.def+=item.def;
	      }
	}