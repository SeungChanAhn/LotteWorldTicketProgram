package Practice;

import java.util.ArrayList;

public class ReceiptPrint {	
	Calculation cal;
	ReceiptPrint(Calculation cal) {
		this.cal = cal;
	}

	ArrayList orderList = new ArrayList();
	ArrayList price = new ArrayList();
	
	public void changeST() {	
		String ticket = null;
		String time = null;
		String ageCategory = null;
		String ticketCount = null;
		String prefer = null;

		switch (cal.input.data.ticketChoice) {
		case 1:
			ticket = "종합이용권";
			break;
		case 2:
			ticket = "파크이용권";
			break;
		}

		switch (cal.input.data.timeChoice) {
		case 1:
			time = "종일권";
			break;
		case 2:
			time = "After4";
			break;
		}
		
		switch (cal.input.data.personTypeByAge) {
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
		
		switch (cal.input.data.alwaysPrefer) {
		case 0:
			prefer = "경로 우대";
			break;
		case 1:
			prefer = "장애인 우대";
			break;
		case 2:
			prefer = "국가유공자 우대";
			break;
		case 3:
			prefer = "휴가군인 우대";
			break;
		case 4:
			prefer = "임산부 우대";
			break;
		case 5:
			prefer = "다둥이가족 우대";
			break;
		case 6:
			prefer = "해당사항 없음";
			break;
		}

		String all = ticket + "\t\t" + time + "\t\t\t" + ageCategory + "\t\t" + cal.input.data.numberOfTickets + "장" + "\t\t" + cal.input.data.priceSum + "원" + "\t\t" + prefer + "\n";
		orderList.add(all);
		price.add(cal.input.data.priceSum);
		

	}

	public void printReceipt() {
		int sum = 0;
		for (int i = 0; i < price.size(); i++) {
			sum += (int) price.get(i);
		}
		System.out.printf(
				"=============================================================================================================\n");
		System.out.printf("\n\n                                                롯 데 월 드\n");
		System.out.printf("\n                                                     \n");
		System.out.printf(
				"=============================================================================================================\n");
		System.out.printf("티켓종류\t\t이용시간\t\t구분\t\t수량\t\t가격\t\t할인내역\n");
		System.out.printf(
				"-------------------------------------------------------------------------------------------------------------\n");
		for (int i = 0; i < orderList.size(); i++) {
			System.out.println(orderList.get(i));
		}
		System.out.printf(
				"\n-------------------------------------------------------------------------------------------------------------\n");
		System.out.printf("결제금액\t\t\t\t\t\t\t\t\t\t%19d원", sum);
		System.out.printf(
				"\n=============================================================================================================\n");
	}
}