package kr.or.ddit.practice.game;

public class Monster {
	   String name;
	   int maxHp, maxMp, hp,mp, att, def, exp;
	   Item []items;
	   
	      Monster(String name, int maxHp, int maxMp, int att, int def, int exp, Item[] items){
	         this.name = name;
	         this.maxHp = maxHp;
	         this.maxMp = maxMp;
	         this.hp=maxHp;
	         this.mp=maxMp;         
	         this.att = att;
	         this.def = def;
	         this.exp=exp;
	         this.items=items;
	      }
	      
	      void attack(Character c){
	         int damage=this.att - c.def;
	         damage = (damage <= 0) ? (1) : (damage);   //삼항연산자 '(A) ? (B) : (C)' => A가 참이면, B를 출력하고,거짓이면 C를 출력
	         c.hp = c.hp < damage ? 0 : c.hp - damage;
	         System.out.println(name + "(이)가 공격으로 " +c.name+"에게 "+damage + "만큼 데미지를 주었습니다.");
	         System.out.println(c.name+"의 남은 체력 : "+c.hp);
	         System.out.println();
	      }
	      
	      Item itemDrop(){
	         return items[(int)(Math.random()*items.length)];
	            //Math.random()은 Double을 반환하기에 cast 해주어야 함.
	      }
	}