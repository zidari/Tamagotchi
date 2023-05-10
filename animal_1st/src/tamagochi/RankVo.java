package tamagochi;

public class RankVo {
	private String id;
	private int lv;
	private int ra;


	public RankVo(int ra, String id, int lv) {
	   this.id = id;
	   this.lv = lv;
	   this.ra = ra;
	   
	}
	
	

	public int getRa() {
		return ra;
	}


	public void setRa(int ra) {
		this.ra = ra;
	}



	public String getId() {
	   return id;
	}

	public void setId(String id) {
	   this.id = id;
	}

	public int getLv() {
	   return lv;
	}

	public void setLv(int lv) {
	   this.lv = lv;
	}


}
