package NEW;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import oracle.jdbc.internal.StateSignatures;

public class NewView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		ArrayList<String> idList = new ArrayList<String>();
		AniDAO dao = new AniDAO();

		int acc = 100; // 누적치
		int act = 0; // 활동


		System.out.println("====================================================");
		System.out.println("   ##     ##  ##    ####    ##   ##    ##     ##      ");
		System.out.println("  ####    ### ##     ##     ### ###   ####    ##      ");
		System.out.println(" ##  ##   ######     ##     #######  ##  ##   ##      ");
		System.out.println(" ######   ######     ##     ## # ##  ######   ##      ");
		System.out.println(" ##  ##   ## ###     ##     ##   ##  ##  ##   ##      ");
		System.out.println(" ##  ##   ##  ##     ##     ##   ##  ##  ##   ##      ");
		System.out.println(" ##  ##   ##  ##    ####    ##   ##  ##  ##   ######  ");
		System.out.println("====================================================");
		System.out.println("어서오세요 랜덤!동물키우기입니다");

		while (true) {
			System.out.println("[1]게임start [2]게임종료");
			System.out.print(">> ");
			int menu = sc.nextInt();

			if (menu == 1) {

				while (true) {
					System.out.println("====================게임 start!====================");
					System.out.println();
					System.out.println("[1]로그인  [2]회원가입  [3]메인페이지");
					System.out.print(">> ");
					int menu2 = sc.nextInt();
					if (menu2 == 1) { // 로그인
						System.out.println();
						System.out.print("ID를 입력하세요 >> ");
						String ID = sc.next();

						System.out.print("PW를 입력하세요 >> ");
						String PASSWORD = sc.next();

						boolean sucess = dao.login(ID, PASSWORD);
						if (sucess) {
							System.out.println("로그인 성공!");
							System.out.println("");
							System.out.println("");

//                     if(동물타입에 null 아니면) 넘어가고
//                     null이면 랜덤동물뽑기인데 그거 확인을 dao에서 해줘야된다!
							if (dao.selecttype(ID) == 0) {
								System.out.println();
			                     System.out.println("★★★★랜덤 동물 뽑기를 시작합니다 ★★★★");
			                     System.out.println("--------- 뽑힌 동물 --------- ");
			                     System.out.println();
			                     System.out.println();

								int type = rd.nextInt(10) + 1;
								if (type == 1) {
									System.out.println();
									System.out.println(" 난 강아지! 잘 키워주라멍!");
									System.out.println();
									 System.out.println("      ▼ 'ェ' ▼");
									 System.out.println();
								} else if (type == 2) {
									System.out.println();
									System.out.println(" 난 고양이! 잘 키워주라냥!");
									System.out.println();
			                        System.out.println("       ^ㅡㅡ^");
			                        System.out.println("      (='ω'=)");
			                        System.out.println("       (っ■♥〓┳═");
			                        System.out.println("         /　　 )");
			                        System.out.println("        ( /￣∪");
			                        System.out.println();

								} else if (type == 3) {
									System.out.println();
									System.out.println(" 난 앵무새! 잘 키워주라짹!");
									System.out.println();
									System.out.println("     =(＠’Θ’＠)=");
									System.out.println();
								} else if (type == 4) {
									System.out.println();
									System.out.println(" 난 호랑이! 잘 키워주어흥!");
									 System.out.println();
				                        System.out.println("   ^ㅡㅡㅡ^  ");
				                        System.out.println("ㄴ(=@ . @=)ㄱ");
				                        System.out.println();
								} else if (type == 5) {
									System.out.println("난 햄스터! 잘 키워주라찍!");
			                        System.out.println();
			                        System.out.println("<{ ̳ㅇ · ㅇ ̳}\r\n"
			                              + "/ づ♡ =♡\r\n"
			                              + "");
			                        System.out.println();


								} else if (type == 6) {
									System.out.println();
									System.out.println("난 알파카! 잘 키워주라음메!");
									System.out.println();
			                        System.out.println("     Δ~~~Δ");
			                        System.out.println("    ξ 'ェ' ξ");
			                        System.out.println("     ξ　~　ξ");
			                        System.out.println("     ξ　　 ξ");
			                        System.out.println("     ξ　　 “~～~～O");
			                        System.out.println("     ξ　　　　　　 ξ");
			                        System.out.println("     ξ ξ ξ~～~ξ ξ　");
			                        System.out.println("     ξ_ξ_ξ　ξ_ξ_ξ");
			                        System.out.println();
								} else if (type == 7) {
									System.out.println();
									System.out.println("난 소! 잘 키워주라음머!");
									System.out.println();
									System.out.println(" \r\n"
								            + "                   (__)\r\n"
								            + "                   (o|o)\r\n"
								            + "            /-------\\슷/\r\n"
								            + "           / |     ||\r\n"
								            + "          *  ||----||");
									System.out.println();
								} else if (type == 8) {
									System.out.println();
									System.out.println("난 토끼!잘 키워주라깡총!");
									System.out.println();
									System.out.println("(＼(＼");
									System.out.println("(  -.- )~♥");
									System.out.println("  O_(\")(\")    ");
									System.out.println();
								} else if (type == 9) {
									System.out.println("난 뱀! 잘 키워주랏스스슥");
									System.out.println();
									System.out.println("     ～>'）～～～～");
									System.out.println();

								} else if (type == 10) {
			                        System.out.println("난 가재다! 키워주라집게 Vv");
			                        System.out.println("(V)(ㅇ～ㅇ)(V)");
			                        System.out.println();

			                     
								}
								System.out.println("");
								System.out.println("");
								System.out.println("뽑은 동물의 이름을 지어주세요 ( > ω <)*   ");
								System.out.print(">> ");
								String name = sc.next();
								int make = dao.save(type, name, ID);
								int cnt2 = dao.statTable(ID);
								if (cnt2 > 0) {
									System.out.println("나의 동물의 이름은 " + name + " 이(가) 되었습니다 죽이지 말고 잘 키워주세요~~");
									System.out.println();
								}

							} else {
								ArrayList<ConditionVo> allcon2 = dao.condition(ID);
								int type = dao.selecttype(ID);
								String typeName = dao.type(type);
								String name = allcon2.get(0).getName();
								System.out.println("현재 "+typeName+ "-" +name+ " 을(를) 키우고 있습니다.");
								System.out.println();
								
							}
							
							
							ArrayList<ConditionVo> allcon2 = dao.condition(ID);
							String name = allcon2.get(0).getName();
							
							
							while (true) {
								if (dao.selecttype(ID) == 0) {
									System.out.println("로그아웃");
									System.out.println();
									break;
								}
								System.out.println();
								System.out.println("=================메인 메뉴==================");
								System.out.println("[1]동물키우기  [2]상태확인  [3]랭킹   [4]로그아웃");
								System.out.print("번호 >>");
								int choice = sc.nextInt();

								if (choice == 1) {
									ArrayList<ConditionVo> na = dao.condition(ID);
									/// stat정보 호출
									ArrayList<StatVo> data = dao.gamestat(ID);
									int lv = data.get(0).getLv();
									int exp = data.get(0).getExp();
									int stress = data.get(0).getStress();
									int energy = data.get(0).getEnergy();
									int day = data.get(0).getDay();

									while (true) {
										System.out.println("============================동물 키우기 ============================");
										System.out.println();
										System.out.println("[1]밥먹기   [2]운동하기   [3]놀아주기   [4]청소");
										System.out.println("[5]칭찬하기  [6]잠자기    [7]종료");
										System.out.print("번호 >> ");

										int num = sc.nextInt();
										System.out.println();
										int[] arr = dao.raise(ID, energy, exp, stress, num);
										int lastexp = (exp/100)*100;


										if (num == 1) {
											System.out.println();
											System.out.println("냠냠 "+ name+ "이 맛있어합니다!");
			                                 System.out.println(".　                ∧   ∧　　　　　　\r\n"
			                                       + "             \" 　( ´^ω^)　배불러\r\n"
			                                       + "             \" 　/　　⌒ヽ　　　\r\n"
			                                       + "             \" （人＿__つ_つ\r\n"
			                                       + "             \"\");");
			                                 System.out.println();

	                                 System.out.println();

											System.out.println(day + "일차 " + ++act + "회 활동");
											System.out.println();
										} else if (num == 2) {
											System.out.println();
			                                 System.out.println("헥헥 헛둘헛둘❕");
			                                 System.out.println();
			                                 System.out.println(".　 _＿\r\n"
			                                       + "　 / )))　　　 ＿\r\n"
			                                       + "`／ イ~　　　(((ヽ\r\n"
			                                       + "(　 ﾉ　　　　 ￣Ｙ＼\r\n"
			                                       + "|　(＼　∧＿∧　｜　)\r\n"
			                                       + "ヽ　ヽ`(　`o´　)／ノ/\r\n"
			                                       + "　＼ |　⌒Ｙ⌒　/ /\r\n"
			                                       + "　 ｜ヽ　 ｜　 ﾉ／\r\n"
			                                       + "　　＼トー仝ーイ\r\n"
			                                       + "　　 ｜ ミ土彡/\r\n"
			                                       + "");

	                                 System.out.println();

											System.out.println(day + "일차 " + ++act + "회 활동");
											System.out.println();

										} else if (num == 3) {
											System.out.println();
											System.out.println("♪♬ "+name+ " 이(가) 놀이를 재밌어합니다.");
			                                 System.out.println();
			                                 System.out.println("♡   ∧＿∧　♪\r\n"
			                                       + "　　(*^,^*)　　♪\r\n"
			                                       + "　　( つ　つ\r\n"
			                                       + "((　 (⌒ __)　))\r\n"
			                                       + "　　し' っ\r\n"
			                                       + "♪　　　　　♡\r\n"
			                                       + "　♪　 ∧＿∧\r\n"
			                                       + "　　∩(*^~^*)\r\n"
			                                       + "　　ヽ　 ⊂ノ\r\n"
			                                       + "　(( 　(　 ⌒)　　))\r\n"
			                                       + "　　 　c し'\r\n"
			                                       + "");

			                                 System.out.println();
											System.out.println(day + "일차 " + ++act + "회 활동");
											System.out.println();

										} else if (num == 4) {
											System.out.println();
			                                 System.out.println("쓱싹쓱싹 청소~ ♪♬");
			                                 System.out.println();
			                                 System.out.println("　　               ∧_∧\r\n"
			                                       + "             \"　　(*ω*`)\r\n"
			                                       + "             \"　 _o⌒|⌒c)_\r\n"
			                                       + "             \".／　⌒⌒⌒⌒／||\r\n"
			                                       + "             \"||￣￣￣￣||||\r\n"
			                                       + "             \"||　　　　||\r\n"
			                                       + "             \"\");");

			                                 System.out.println();
											System.out.println(day + "일차 " + ++act + "회 활동");
											System.out.println();

										} else if (num == 5) {
											System.out.println();
											System.out.println(".  ( |__/)");
			                                 System.out.println("  （｀'.' )づ__/)  쓰담");
			                                 System.out.println("  （つ　 /( '.'   )");
			                                 System.out.println("   しーＪ   (nnノ)");
			                                 System.out.println();
			                                 System.out.println(name+"에게 칭찬해주었습니다");
			                                 System.out.println();


											System.out.println(day + "일차 " + ++act + "회 활동");
											System.out.println();

										} else if (num == 6) {
											System.out.println();
			                                 System.out.println("∩――――――――――――∩\r\n"
			                                          + "|| ∧    ∧   ||\r\n"
			                                          + "||(* ' ㅅ')   ||\r\n"
			                                          + "|/^⌒⌒づ`  ￣＼\r\n"
			                                          + "(　ノ　　⌒    ＼\r\n"
			                                          + "　＼　　||￣￣￣￣￣||\r\n"
			                                          + " 　　 ＼,/||―――――||\r\n"
			                                          + "");
			                                 System.out.println();
	                                  System.out.println(name+" 은(는) 잠에 들었습니다 쿠울쿠울");
	                                  System.out.println();
	                                 System.out.println("");

											act = 0;
											System.out.println(day++ + "일차 활동이 종료되었습니다!");
											System.out.println();
											int plusDay = dao.day(day, ID);

										} else if (num == 7) {
			                                 System.out.println("메인메뉴로 갑니다.");
			                                 System.out.println();

											break;
										} else {
											System.out.println("다시 선택해 주세요");
											System.out.println();
										}

										energy = arr[0];
										exp = arr[1];
										stress = arr[2];

										System.out.println("에너지:" + energy + ", 경험치:" + exp + ", 스트레스:" + stress);
										System.out.println();

//										if (exp >= acc) {
//											lv++;
//											acc += 100;
//											System.out.println("레벨 " + lv + " 달성!");
//											dao.levelUp(lv, ID);
//										}
										

										
										if (exp >= lastexp+100) {
											lv++;
											System.out.println("레벨 " + lv + " 달성!");
											System.out.println();
											dao.levelUp(lv, ID);
										}
										
										
										
										
										

										if (act == 5) {
											act = 0;
											System.out.println(day++ + "차 활동이 종료되었습니다!");
											System.out.println();
										}
										if (stress >= 70) {
											System.out.println();
											System.out.println("=============================================================");
											System.out.println();
											System.out.println("※경고!! 스트레스가 70이상 입니다! 스트레스 관리를 해주세요!!");
											System.out.println();
											System.out.println("=============================================================");
											System.out.println();
										}
										if (energy <= 20) {
											System.out.println();
											System.out.println("=============================================================");
											System.out.println();
											System.out.println("※경고!! 에너지가 20이하 입니다! 에너지 관리를 해주세요!!");
											System.out.println();
											System.out.println("=============================================================");
											System.out.println();
										}

										if (stress >= 100) {
			                                 System.out.println("====================================================");
			                                 System.out.println();
			                                 System.out.println("  #####      ##########    #########               ");
			                                 System.out.println("  ##   ##        ##        ##                         ");
			                                 System.out.println("  ##    ##       ##        ##                      ");
			                                 System.out.println("  ##    ##       ##        #########                        ");
			                                 System.out.println("  ##    ##       ##        ##                         ");
			                                 System.out.println("  ##   ##        ##        ##                    ");
			                                 System.out.println("  #####      ##########    #########   # #  #  #  #        ");
			                                 System.out.println();
			                                 System.out.println("====================================================");

                                System.out.println();
                                System.out.println("당신의 펫이 죽었습니다.... 더 잘 보살펴주시지...");
											dao.deleteName(ID);
											dao.deleteStat(ID);

											break;

										}
										if (energy <= 0) {
			                                 System.out.println("====================================================");
			                                 System.out.println();
			                                 System.out.println("  #####      ##########    #########               ");
			                                 System.out.println("  ##   ##        ##        ##                         ");
			                                 System.out.println("  ##    ##       ##        ##                      ");
			                                 System.out.println("  ##    ##       ##        #########                        ");
			                                 System.out.println("  ##    ##       ##        ##                         ");
			                                 System.out.println("  ##   ##        ##        ##                    ");
			                                 System.out.println("  #####      ##########    #########   # #  #  #  #        ");
			                                 System.out.println();
			                                 System.out.println("====================================================");
                                System.out.println();
                                System.out.println("당신의 펫이 죽었습니다.... 더 잘 보살펴주시지...");
											dao.deleteName(ID);
											dao.deleteStat(ID);
											break;
										}

									} // while

								} else if (choice == 2) { // 상태확인
									// id, lv, exp, energy, stress ,day

									System.out.println("================== "+name + " 의 상태입니다. ==================");
									ArrayList<ConditionVo> allcon = dao.condition(ID);
									int type = dao.selecttype(ID);
									String typeName = dao.type(type);
									for (int i = 0; i < allcon.size(); i++) {
										System.out.println("▶ 닉네임 : " + allcon.get(0).getName());
										System.out.println("▶ 동물타입 : " + typeName);
										System.out.println("▶ 레벨 : " + allcon.get(0).getLv());
										System.out.println("▶ 경험치 : " + allcon.get(0).getExp());
										System.out.println("▶ 에너지 : " + allcon.get(0).getEnergy());
										System.out.println("▶ 스트레스 : " + allcon.get(0).getStress());
										System.out.println("▶ 태어난지 +" + allcon.get(0).getDay() + "일 째");
									}

								} else if (choice == 3) { // 랭킹확인

									System.out.println("==================현재 랭킹을 공개합니다!==================");

									ArrayList<RankVo> allrank = dao.top3rank();
									for (int i = 0; i < allrank.size(); i++) {
										System.out.println();
										System.out.print(allrank.get(i).getRa() + "위. ");
										System.out.print("아이디: " + allrank.get(i).getId() + "   ");
										System.out.println("레벨: " + allrank.get(i).getLv() + " ");
										System.out.println();

									}
									ArrayList<RankVo> myrank = dao.myrank(ID);
									System.out.println();
									System.out.println("=================나의 랭킹==================");

									if (myrank.size() == 1) {
										System.out.print(myrank.get(0).getRa() + "위. ");
										System.out.print("아이디: " + myrank.get(0).getId() + "   ");
										System.out.println("레벨: " + myrank.get(0).getLv() + " ");
										System.out.println();
									}

								}

								else if (choice == 4) {
									System.out.println("로그아웃 되었습니다.");
									break;

								}
							}
						} else {
							System.out.println("※    ID, PASSWORD를 다시 확인해주세요.    ※ ");
						}

					} else if (menu2 == 2) { // 회원가입
						String ID = null;
						String PASSWORD = null;

						while (true) {
							System.out.print("생성할 ID를 입력하세요 >> ");
							ID = sc.next();
							System.out.print("패스워드를 입력하세요 >>");
							PASSWORD = sc.next();
							boolean check = dao.checkId(ID); // 중복이면 true 아니면 false dao에서 받아옴
							if (check) {
								System.out.println("※    중복된 ID 입니다.   ※ ");
							} else {
								break;
							}
						} // while

						int cnt = dao.join(ID, PASSWORD);

						if (cnt > 0) {
							System.out.println("성공적으로 회원가입이 되었습니다.");

						} else {
							System.out.println("다시 입력해주세요.");
						}
					} else if (menu2 == 3) {
						System.out.println("메인페이지로 이동합니다.");
						break;
					} else {
						System.out.println("번호를 잘못입력하셨습니다.");
					}
				}

			} else if (menu == 2) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			} else {
				System.out.println("잘못된 번호입니다.");
			}
		}
	}

}