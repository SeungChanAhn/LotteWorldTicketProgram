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
import java.util.Scanner;

public class CSVfile {
	Scanner sc = new Scanner(System.in);
	Calculation cal;
	CSVfile(Calculation cal) {
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

		// 분석 리스트
		String analysis = ticket + "," + time + "," + ageCategory + "," + cal.input.data.getNumberOfTickets() + ","
				+ cal.input.data.getPriceSum() + "," + prefer + "\n";
		analysisList.add(analysis);

		// 매 구매마다 가격*수량을 리스트로
		price.add(cal.input.data.getPriceSum());
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
		int totalPriceSum = 0;
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
			String tableName = "티켓종류,이용시간,구분,수량,가격,할인내역";
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
}