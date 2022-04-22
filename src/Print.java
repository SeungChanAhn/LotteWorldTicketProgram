package Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Print {
	Calculation cal;

	Print(Calculation cal) {
		this.cal = cal;
	}

	ArrayList orderList = new ArrayList(); // 영수증 출력 리스트
	ArrayList price = new ArrayList(); // 가격 저장 리스트
	ArrayList analysisList = new ArrayList(); // CSV파일 리스트
	String[][] readList = new String[100][6]; // CSV파일 읽어와서 배열에 저장

	public void ReadyPrintReceipt() {
		String ticket = null;
		String time = null;
		String ageCategory = null;
		String ticketCount = null;
		String prefer = null;

		switch (cal.input.data.getTicketChoice()) {
		case 1:
			ticket = "종합이용권";
			break;
		case 2:
			ticket = "파크이용권";
			break;
		}

		switch (cal.input.data.getTimeChoice()) {
		case 1:
			time = "종일권";
			break;
		case 2:
			time = "After4";
			break;
		}

		switch (cal.input.data.getPersonTypeByAge()) {
		case 0:
			ageCategory = "노인";
			break;
		case 1:
			ageCategory = "어른";
			break;
		case 2:
			ageCategory = "청소년";
			break;
		case 3:
			ageCategory = "어린이";
			break;
		case 4:
			ageCategory = "베이비";
			break;
		}

		switch (cal.input.data.getAlwaysPrefer()) {
		case 0:
			prefer = "해당없음";
			break;
		case 1:
			prefer = "장애인";
			break;
		case 2:
			prefer = "국가유공자";
			break;
		case 3:
			prefer = "휴가군인";
			break;
		case 4:
			prefer = "임산부";
			break;
		case 5:
			prefer = "다둥이가족";
			break;
		case 6:
			prefer = "경로우대";
			break;
		}

		// 영수증 출력 리스트
		String all = null;
		if (cal.input.data.getPriceSum() >= 100000) { // 10만원 넘어가면 영수증 줄 맞춤..
			all = ticket + "\t\t" + time + "\t\t\t" + ageCategory + "\t\t" + cal.input.data.getNumberOfTickets() + "장"
					+ "\t\t" + cal.input.data.getPriceSum() + "원" + "\t" + prefer + "\n";
		} else {
			all = ticket + "\t\t" + time + "\t\t\t" + ageCategory + "\t\t" + cal.input.data.getNumberOfTickets() + "장"
					+ "\t\t" + cal.input.data.getPriceSum() + "원" + "\t\t" + prefer + "\n";
		}

		orderList.add(all);

		// 매 구매마다 가격*수량을 리스트로 만들기 (총 금액 계산)
		price.add(cal.input.data.getPriceSum());

		// CSV파일로 저장할 분석 리스트
		String analysis = ticket + "," + time + "," + ageCategory + "," + cal.input.data.getNumberOfTickets() + ","
				+ cal.input.data.getPriceSum() + "," + prefer + "\n";
		analysisList.add(analysis);

	}

	public void printReceipt() {
		Calendar calendar = Calendar.getInstance(); // 현재 날짜 가져오기
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");

		System.out.printf(
				"=============================================================================================================\n");
		System.out.printf("\n\n                                                롯 데 월 드\n\n");
		System.out.printf("\t\t\t\t\t\t\t\t\t\t\t%s\n", sdt.format(calendar.getTime()));
		System.out.printf(
				"=============================================================================================================\n");
		System.out.printf("티켓종류\t\t이용시간\t\t구분\t\t수량\t\t가격\t\t할인내역\n");
		System.out.printf(
				"-------------------------------------------------------------------------------------------------------------\n");
		for (int index = 0; index < orderList.size(); index++) {
			System.out.println(orderList.get(index));
		}
		System.out.printf(
				"-------------------------------------------------------------------------------------------------------------\n");
		int totalPriceSum = 0; // 결제금액 계산
		for (int index = 0; index < price.size(); index++) {
			totalPriceSum += (int) price.get(index);
		}
		System.out.printf("결제금액\t\t\t\t\t\t\t\t\t\t%19d원", totalPriceSum);
		System.out.printf(
				"\n=============================================================================================================\n");
	}

	// analysisList를 CSV파일로 내보내기
	public void writeCsv(ArrayList<String> list) {
		String fileName = "C:\\ticketing\\test1.csv";
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName);
			for (String analysisList : list) {
				out.write(analysisList.getBytes());
			}
			System.out.println("\n▶ 파일이 C드라이브 ticketing 폴더에 저장되었습니다.\n");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				out.close();
			} catch (IOException e) {
			}
		}
	}

	// CSV파일 읽어오기
	public void readCSVFile() {
		System.out.println("▶ CSV파일 불러오기\n");
		System.out.println("티켓종류 이용시간 구분 수량 가격 우대사항");
		try {
			File csv = new File("C:\\ticketing\\test1.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String line = "";
			int row = 0;

			while ((line = br.readLine()) != null) {
				String[] token = line.split(",");

				// 배열에 넣기
				for (int index = 0; index < 6; index++) {
					readList[row][index] = token[index];
				}

				// CSV에서 읽어 배열에 옮긴 자료 확인하기 위해 전체 출력
				for (int index = 0; index < 6; index++) {
					System.out.print(readList[row][index] + " ");
				}
				System.out.println("");
				row++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 권종별 매출 분석
	public void TicketTypeAnalysis() {
		int allPass_Sales = 0;
		int allPass_Count = 0;
		int allPass_Count_Baby = 0;
		int allPass_Count_Kid = 0;
		int allPass_Count_Teen = 0;
		int allPass_Count_Adult = 0;
		int allPass_Count_Old = 0;

		int parkPass_Sales = 0;
		int parkPass_Count = 0;
		int parkPass_Count_Baby = 0;
		int parkPass_Count_Kid = 0;
		int parkPass_Count_Teen = 0;
		int parkPass_Count_Adult = 0;
		int parkPass_Count_Old = 0;

		try {
			File csv = new File("C:\\ticketing\\test1.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String line = "";

			while ((line = br.readLine()) != null) {
				String token[] = line.split(",");

				if (line.contains("종합이용권")) {
					allPass_Count += Integer.parseInt(token[3]);
					allPass_Sales += Integer.parseInt(token[4]);
					if (line.contains("베이비")) {
						allPass_Count_Baby += Integer.parseInt(token[3]);
					} else if (line.contains("어린이")) {
						allPass_Count_Kid += Integer.parseInt(token[3]);
					} else if (line.contains("청소년")) {
						allPass_Count_Teen += Integer.parseInt(token[3]);
					} else if (line.contains("어른")) {
						allPass_Count_Adult += Integer.parseInt(token[3]);
					} else if (line.contains("노인")) {
						allPass_Count_Old += Integer.parseInt(token[3]);
					} else {
					}
				}

				if (line.contains("파크이용권")) {
					parkPass_Count += Integer.parseInt(token[3]);
					parkPass_Sales += Integer.parseInt(token[4]);
					if (line.contains("베이비")) {
						parkPass_Count_Baby += Integer.parseInt(token[3]);
					} else if (line.contains("어린이")) {
						parkPass_Count_Kid += Integer.parseInt(token[3]);
					} else if (line.contains("청소년")) {
						parkPass_Count_Teen += Integer.parseInt(token[3]);
					} else if (line.contains("어른")) {
						parkPass_Count_Adult += Integer.parseInt(token[3]);
					} else if (line.contains("노인")) {
						parkPass_Count_Old += Integer.parseInt(token[3]);
					} else {
					}
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("\n\n===================== 권종별 매출 =====================\n");
		System.out.printf("종합이용권 총 %d매\n", allPass_Count);
		System.out.printf("베이비 %d매 어린이 %d매 청소년 %d매 어른 %d매 노인 %d매\n", allPass_Count_Baby, allPass_Count_Kid,
				allPass_Count_Teen, allPass_Count_Adult, allPass_Count_Old);
		System.out.printf("종합이용권 매출 %d원\n\n", allPass_Sales);
		System.out.printf("파크이용권 총 %d매\n", parkPass_Count);
		System.out.printf("베이비 %d매 어린이 %d매 청소년 %d매 어른 %d매 노인 %d매\n", parkPass_Count_Baby, parkPass_Count_Kid,
				parkPass_Count_Teen, parkPass_Count_Adult, parkPass_Count_Old);
		System.out.printf("파크이용권 매출 %d원\n", parkPass_Sales);
		System.out.printf("=======================================================");
	}
	
	public void TicketTimeAnalysis() {
		int allday_Sales = 0;
		int allday_Count = 0;
		int allday_Count_Baby = 0;
		int allday_Count_Kid = 0;
		int allday_Count_Teen = 0;
		int allday_Count_Adult = 0;
		int allday_Count_Old = 0;

		int after4_Sales = 0;
		int after4_Count = 0;
		int after4_Count_Baby = 0;
		int after4_Count_Kid = 0;
		int after4_Count_Teen = 0;
		int after4_Count_Adult = 0;
		int after4_Count_Old = 0;

		try {
			File csv = new File("C:\\ticketing\\test1.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String line = "";

			while ((line = br.readLine()) != null) {
				String token[] = line.split(",");

				if (line.contains("종일권")) {
					allday_Count += Integer.parseInt(token[3]);
					allday_Sales += Integer.parseInt(token[4]);
					if (line.contains("베이비")) {
						allday_Count_Baby += Integer.parseInt(token[3]);
					} else if (line.contains("어린이")) {
						allday_Count_Kid += Integer.parseInt(token[3]);
					} else if (line.contains("청소년")) {
						allday_Count_Teen += Integer.parseInt(token[3]);
					} else if (line.contains("어른")) {
						allday_Count_Adult += Integer.parseInt(token[3]);
					} else if (line.contains("노인")) {
						allday_Count_Old += Integer.parseInt(token[3]);
					} else {
					}
				}

				if (line.contains("After4")) {
					after4_Count += Integer.parseInt(token[3]);
					after4_Sales += Integer.parseInt(token[4]);
					if (line.contains("베이비")) {
						after4_Count_Baby += Integer.parseInt(token[3]);
					} else if (line.contains("어린이")) {
						after4_Count_Kid += Integer.parseInt(token[3]);
					} else if (line.contains("청소년")) {
						after4_Count_Teen += Integer.parseInt(token[3]);
					} else if (line.contains("어른")) {
						after4_Count_Adult += Integer.parseInt(token[3]);
					} else if (line.contains("노인")) {
						after4_Count_Old += Integer.parseInt(token[3]);
					} else {
					}
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("\n\n=================== 이용시간별 매출 ===================\n");
		System.out.printf("종일권 총 %d매\n", allday_Count);
		System.out.printf("베이비 %d매 어린이 %d매 청소년 %d매 어른 %d매 노인 %d매\n", allday_Count_Baby, allday_Count_Kid,
				allday_Count_Teen, allday_Count_Adult, allday_Count_Old);
		System.out.printf("종일권 매출 %d원\n\n", allday_Sales);
		System.out.printf("After4 이용권 총 %d매\n", after4_Count);
		System.out.printf("베이비 %d매 어린이 %d매 청소년 %d매 어른 %d매 노인 %d매\n", after4_Count_Baby, after4_Count_Kid,
				after4_Count_Teen, after4_Count_Adult, after4_Count_Old);
		System.out.printf("After4 이용권 매출 %d원\n", after4_Sales);
		System.out.printf("=======================================================");
	}

	public void preferAnalysis() {
		int preferTicket_Count = 0; // 우대권만 카운트
		int prefer_Count_Disabled = 0;
		int prefer_Count_NationalMerit = 0;
		int prefer_Count_Sordier = 0;
		int prefer_Count_Pregnant = 0;
		int prefer_Count_MultipleKids = 0;
		int prefer_Count_Old = 0;

		try {
			File csv = new File("C:\\ticketing\\test1.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String line = "";

			while ((line = br.readLine()) != null) {
				String token[] = line.split(",");

				if (line.contains("장애인")) {
					prefer_Count_Disabled += Integer.parseInt(token[3]);
					preferTicket_Count += Integer.parseInt(token[3]);
				} else if (line.contains("국가유공자")) {
					prefer_Count_NationalMerit += Integer.parseInt(token[3]);
					preferTicket_Count += Integer.parseInt(token[3]);
				} else if (line.contains("휴가군인")) {
					prefer_Count_Sordier += Integer.parseInt(token[3]);
					preferTicket_Count += Integer.parseInt(token[3]);
				} else if (line.contains("임산부")) {
					prefer_Count_Pregnant += Integer.parseInt(token[3]);
					preferTicket_Count += Integer.parseInt(token[3]);
				} else if (line.contains("다둥이가족")) {
					prefer_Count_MultipleKids += Integer.parseInt(token[3]);
					preferTicket_Count += Integer.parseInt(token[3]);
				} else if (line.contains("경로우대")) {
					prefer_Count_Old += Integer.parseInt(token[3]);
					preferTicket_Count += Integer.parseInt(token[3]);
				} else {
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("\n\n=================== 우대권 판매 현황 ==================\n");
		System.out.printf("총 판매 티켓수 : %d매\n", preferTicket_Count);
		System.out.printf("장애인 : %d매\n", prefer_Count_Disabled);
		System.out.printf("국가유공자 : %d매\n", prefer_Count_NationalMerit);
		System.out.printf("휴가군인 : %d매\n", prefer_Count_Sordier);
		System.out.printf("임산부 : %d매\n", prefer_Count_Pregnant);
		System.out.printf("다둥이가족 : %d매\n", prefer_Count_MultipleKids);
		System.out.printf("경로우대 : %d매\n", prefer_Count_Old);
		System.out.printf("=======================================================");
	}
}
