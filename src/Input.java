package Practice;

import java.util.Scanner;

public class Input {
	OrderData data;
	Scanner sc = new Scanner(System.in);

	// 티켓 종류 선택하기 (종합이용권, 파크이용권)
	public void TicketChoice() {
		data = new OrderData();
		data.price = 0;
		do {
			System.out.printf("1. 종합이용권 (이용범위 : 롯데월드 + 민속박물관)\n2. 파크이용권 (이용범위 : 롯데월드)\n선택 : ");
			data.ticketChoice = sc.nextInt();
			if (!(data.ticketChoice == StaticValue.ALL_PASS || data.ticketChoice == StaticValue.PARK_PASS)) {
				System.out.printf("잘못된 입력입니다. 1 또는 2를 입력하세요.\n\n");
			}
		} while (!(data.ticketChoice == StaticValue.ALL_PASS || data.ticketChoice == StaticValue.PARK_PASS));
	}

	// 놀이공원 이용시간 선택하기 (종일권, After4 이용권)
	public void TimeChoice() {
		do {
			System.out.printf("\n1. 1Day 이용권\n2. After4 이용권(이용시간 : 오후 4시부터 입장)\n선택 : ");
			data.timeChoice = sc.nextInt();
			if (!(data.timeChoice == StaticValue.ALLDAY_PASS || data.timeChoice == StaticValue.AFTER4_PASS)) {
				System.out.printf("잘못된 입력입니다. 1 또는 2를 입력하세요.\n\n");
			}
		} while (!(data.timeChoice == StaticValue.ALLDAY_PASS || data.timeChoice == StaticValue.AFTER4_PASS));
	}

	// 추가로 구매할지 질문 (계속구매, 종료 후 계산)
	public void WhetherToBuy() {
		do {
			System.out.printf("\n1. 계속 구매\n2. 종료 후 계산\n선택 : ");
			data.WhetherToBuy = sc.nextInt();
			if (!(data.WhetherToBuy == StaticValue.KEEP_BUYING || data.WhetherToBuy == StaticValue.EXIT)) {
				System.out.printf("잘못된 입력입니다. 1 또는 2를 입력하세요.\n\n");
			}
		} while (!(data.WhetherToBuy == StaticValue.KEEP_BUYING || data.WhetherToBuy == StaticValue.EXIT));
	}

	// 주민등록번호 입력
	public void IDNumber() {
		System.out.printf("\n주민등록번호 를 입력해 주세요. (예 : 123456-7)\n입력 : ");
		data.IDNumber = sc.next();
	}

	// 티켓 수 입력
	public void NumberOfTickets() {
		System.out.printf("\n\n몇장을 구매하시겠습니까?\n");
		data.numberOfTickets = sc.nextInt();
	}

	// 우대혜택 선택
	public void AlwaysPrefer() {
		System.out.printf("***************************** 우 대 할 인  *****************************");
		System.out.printf("\n\n해당사항이 있으시면 입력해 주세요. 없다면 6번을 입력해 주세요. (중복 불가)\n");
		do {
			System.out.printf("1. 장애인\n2. 국가유공자\n3. 휴가장병\n4. 임산부\n5. 다둥이 행복카드\n6. 해당사항 없음\n선택 : ");
			data.alwaysPrefer = sc.nextInt();
			if (!(data.alwaysPrefer == StaticValue.DISABLED || data.alwaysPrefer == StaticValue.NATIONAL_MERIT
					|| data.alwaysPrefer == StaticValue.SODIER_ON_VACATION || data.alwaysPrefer == StaticValue.PREGNANT
					|| data.alwaysPrefer == StaticValue.MULTIPLE_KIDS || data.alwaysPrefer == StaticValue.NONE)) {
				System.out.printf("잘못된 입력입니다. 1부터 6까지의 숫자만 입력하세요.\n\n");
			}
		} while (!(data.alwaysPrefer == StaticValue.DISABLED || data.alwaysPrefer == StaticValue.NATIONAL_MERIT
				|| data.alwaysPrefer == StaticValue.SODIER_ON_VACATION || data.alwaysPrefer == StaticValue.PREGNANT
				|| data.alwaysPrefer == StaticValue.MULTIPLE_KIDS || data.alwaysPrefer == StaticValue.NONE));
	}
}
