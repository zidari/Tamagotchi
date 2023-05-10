package tamagochi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class AniDAO {
	private Connection conn; // DB와 연결된 객체
	private PreparedStatement pst; // SQL문을 담는 객체
	private ResultSet rs; // SQL문 결과를 담는 객체

	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@121.147.0.238:1521:xe";
			String user = "c##service";
			String password = "12345";

			conn = DriverManager.getConnection(url, user, password);

			if (conn == null) {
				System.out.println("연결실패..ㅜㅜ");
			} else {
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// connect

	// 아이디 중복검사
	public boolean checkId(String id) {
		connect();
		String sql = "SELECT id FROM userinfo WHERE ID = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			rs.next(); // 행
			if (id.equals(rs.getString(1))) {
				return true;
			}

		} catch (SQLException e) {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	// 회원가입 시 userinfo테이블에 아이디 생성
	public int join(String id, String password) {
		connect();
		String sql = "INSERT INTO userinfo(id, password,predate) VALUES(?, ?, sysdate)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, password);

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (SQLException e) {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return 0;

	}// join

    // 회원가입 시 stat테이블에 아이디 생성
    public int statTable(String id) {
    	connect();
    	String sql = "insert into stat values (?, 1,0,100,0,1)";
    	
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (SQLException e) {
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return 0;
    	
    }
	
	// 로그인
	public boolean login(String id, String pw) {
		connect();
		String sql = "select id,password from userinfo where id=? and password =?";
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.setString(2, pw);
			rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;

		} catch (SQLException e) {
			System.out.println("login sql문 오류");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pst != null) {
					pst.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		return false;
	}

	// 타입 보내주기
	public String type(int type) {

		connect();
		String typeName = null;

		String sql = "select * from anitype where type = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, type);

			rs = pst.executeQuery();

			while (rs.next()) {

				typeName = rs.getString(2);
			}

			return typeName;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// 동물 타입,이름 저장
    public int save(int type, String name, String id) {
       connect();
       String sql = "update userinfo set type = ?,name = ? where id=?";
         try {
          pst =conn.prepareStatement(sql);
          pst.setInt(1 ,type);
          pst.setString(2,name);
          pst.setString(3, id);
          int cnt = pst.executeUpdate();
          return cnt;
          
          
       } catch (SQLException e) {
          e.printStackTrace();
       }finally {
          try {
             pst.close();
             conn.close();
          } catch (SQLException e) {
             e.printStackTrace();
          }
       }
       return 0;
       
       
    }
    
    

    
    
    
    
	// 타입 값이 있는지 없는지
    public int selecttype(String id) {
        connect();

        String sql = "select type from userinfo where id=?";
        try {
           pst = conn.prepareStatement(sql);
           pst.setString(1, id);
           ResultSet rs = pst.executeQuery();

           rs.next();

           

           return rs.getInt(1);

        } catch (SQLException e) {
           e.printStackTrace();
        }
        
        return -1; // 뭔가 문제가 발생함
     }
	
	// 키우기
	public int[] raise(String id, int energy, int exp, int stress, int num) {
		connect(); // act: 활동 횟수(최고 5회)
		PreparedStatement pst = null;
		String sql = null;
		int[] info = new int[4];
		sql = "update stat set energy = ?, exp = ?, stress = ? where id = ?"; // 에너지, 경험치, 스트레스 업데이트

		if (num == 1) { // 밥먹기
			energy -= 20;
			exp += 10;
			stress -= 10;
		} else if (num == 2) { // 운동하기
			energy -= 20;
			exp += 10;
			stress += 20;
		} else if (num == 3) { // 놀아주기
			energy -= 20;
			exp += 10;
			stress -= 15;
		} else if (num == 4) { // 청소
			energy -= 20;
			exp += 35;
			stress += 30;
		} else if (num == 5) { // 칭찬하기
			energy -= 20;
			exp += 5;
			stress -= 10;
		} else if (num == 6) { // 잠자기
			energy = 100;
		}
		
		if(stress < 0) {
			stress = 0;
		}

		info[0] = energy;
		info[1] = exp;
		info[2] = stress;

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, energy);
			pst.setInt(2, exp);
			pst.setInt(3, stress);
			pst.setString(4, id);

			int cnt = pst.executeUpdate();
			info[3] = cnt;
			return info;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return info;
	}// raise

	//게임 시작시 데이터 가져오기!
	   public ArrayList<StatVo> gamestat(String id) {
	      connect();
	      ArrayList<StatVo> allstat = new ArrayList<StatVo>();
	      String sql = "select lv,exp,energy,stress,day from stat where id=?";
	      try {
	         pst =conn.prepareStatement(sql);
	         pst.setString(1, id);
	         rs =pst.executeQuery();
	         
	         rs.next();
	         int lv=rs.getInt(1);
	         int exp =rs.getInt(2);
	         int energy =rs.getInt(3);
	         int stress =rs.getInt(4);
	         int day = rs.getInt(5);
	         
	         StatVo stat =new StatVo(lv,exp,energy,stress,day);
	         allstat.add(stat);
	         return allstat;
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	       return null;
	      
	   }
	
	
	
	// 상태확인
	   public ArrayList<ConditionVo> condition(String id) {
	      connect();
	      ArrayList<ConditionVo> allcon = new ArrayList<ConditionVo>();
	      String sql = "select (select name from userinfo where id=a.id)as name,a.lv,a.exp,a.energy,a.stress,a.day from stat a where id = ?";
	      try {
	         pst = conn.prepareStatement(sql);
	         pst.setNString(1, id);
	         rs = pst.executeQuery();

	         while (rs.next()) {
	            String name = rs.getNString(1);
	            int lv = rs.getInt(2);
	            int exp =rs.getInt(3);
	            int energy = rs.getInt(4);
	            int stress = rs.getInt(5);
	            int day = rs.getInt(6);

	            ConditionVo con = new ConditionVo(name, lv,exp, energy, stress, day);
	            allcon.add(con);
	         }
	         return allcon;
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return null;
	   }
	
	
	
	// top3 랭킹확인
	public ArrayList<RankVo> top3rank() {
		connect();
		ArrayList<RankVo> allrank = new ArrayList<RankVo>();
		String sql = "SELECT ROWNUM AS RANK , A.* FROM (SELECT * FROM STAT ORDER BY LV DESC, EXP DESC, DAY DESC) A WHERE ROWNUM<=3";
		try {
			pst = conn.prepareStatement(sql);
	
			rs = pst.executeQuery();

			while (rs.next()) {
				int ra = rs.getInt(1);
				String allId = rs.getString(2);
				int lv = rs.getInt(3);

				RankVo rank = new RankVo(ra, allId, lv);
				allrank.add(rank);

			}
			return allrank;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 나의 랭킹확인
	public ArrayList<RankVo> myrank(String id) {
		connect();
		ArrayList<RankVo> myrank = new ArrayList<RankVo>();
		String sql = "SELECT RANK, ID, LV FROM(SELECT ROWNUM AS RANK, A.* FROM (SELECT * FROM STAT ORDER BY LV DESC, EXP DESC, DAY DESC ) A ) WHERE ID = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			while(rs.next()) {
				int ra = rs.getInt(1);
				String allId = rs.getString(2);
				int lv = rs.getInt(3);

				RankVo rank = new RankVo(ra, allId, lv);
				myrank.add(rank);
			}
			
			return myrank;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	// 동물 사망 or 삭제(탈퇴는 아님)
	public int deleteName(String id) {
		connect();
		String sql = "update userinfo set type = null, name = null where id = ?";
		PreparedStatement pst = null;

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, id);

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return 0;

	}// deleteName

	// id와 연결되어있는 stat 인스턴스 삭제
	public int deleteStat(String id) {
		connect();
		String sql = "delete from stat where id = ?";
		PreparedStatement pst = null;

		try {
			pst = conn.prepareStatement(sql);

			pst.setString(1, id);

			int cnt = pst.executeUpdate();
			return cnt;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return 0;
	}// deleteStat
	
	// 누적일 업데이트
	public int day(int day, String id) {
		connect(); // id = 사용자 id, day = 누적일
		PreparedStatement pst = null;
		String sql = null;

		sql = "update stat set day = ? where id = ?"; // 누적일 업데이트

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, day); // 누적일
			pst.setString(2, id); // id

			int cnt = pst.executeUpdate(); // 업데이트 된 행의 수
			return cnt;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return 0;
	}// day

	public int levelUp(int lv, String id) {
		connect(); // id = 사용자 id
		PreparedStatement pst = null;
		String sql = null;

		sql = "update stat set lv = ? where id = ?"; // 레벨 업!
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, lv); // 레벨
			pst.setString(2, id); // id

			int cnt = pst.executeUpdate(); // 업데이트 된 행의 수
			return cnt;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}//levelUp	
		
		return 0;
	}


}// class
