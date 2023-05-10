package tamagochi;


public class ConditionVo {
	   String name;
	   int lv;
	   int exp;
	   int energy;
	   int stress;
	   int day;

	   public ConditionVo(String name, int lv,int exp, int energy, int stress, int day) {
	      super();
	      this.name = name;
	      this.lv = lv;
	      this.exp =exp;
	      this.energy = energy;
	      this.stress = stress;
	      this.day = day;
	   }

	   public String getName() {
	      return name;
	   }

	   public int getLv() {
	      return lv;
	   }

	   public int getEnergy() {
	      return energy;
	   }

	   public int getStress() {
	      return stress;
	   }

	   public int getDay() {
	      return day;
	   }

	   public int getExp() {
	      return exp;
	   }
	}