package NEW;

public class StatVo {
	 int lv;
	 int exp;
	 int energy;
	 int stress;
	 int day;
	public StatVo(int lv, int exp, int energy, int stress, int day) {
	   super();
	   this.lv = lv;
	   this.exp = exp;
	   this.energy = energy;
	   this.stress = stress;
	   this.day = day;
	}
	public int getLv() {
	   return lv;
	}
	public void setLv(int lv) {
	   this.lv = lv;
	}
	public int getExp() {
	   return exp;
	}
	public void setExp(int exp) {
	   this.exp = exp;
	}
	public int getEnergy() {
	   return energy;
	}
	public void setEnergy(int energy) {
	   this.energy = energy;
	}
	public int getStress() {
	   return stress;
	}
	public void setStress(int stress) {
	   this.stress = stress;
	}
	public int getDay() {
	   return day;
	}
	public void setDay(int day) {
	   this.day = day;
	}
	 
	 
	}
