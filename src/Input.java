package Practice;

import java.util.Scanner;

public class Input {
	OrderData data;
	Scanner sc = new Scanner(System.in);

	// 티켓 종류 선택하기 (종합이용권, 파크이용권)
	public void TicketChoice() {
		data = new OrderData();
		System.out.printf("\n\n⊙ 이용권을 선택해주세요. (종합이용권은 민속박물관까지 관람가능합니다.)\n\n");
		do {
			System.out.printf("① 종합이용권  ② 파크이용권\n선택 : ");
			data.setTicketChoice(sc.nextInt());
			if (!(data.getTicketChoice() == StaticValue.ALL_PASS || data.getTicketChoice() == StaticValue.PARK_PASS)) {
				System.out.printf("잘못된 입력입니다. 1 또는 2를 입력하세요.\n\n");
			}
		} while (!(data.getTicketChoice() == StaticValue.ALL_PASS || data.getTicketChoice() == StaticValue.PARK_PASS));
	}

	// 놀이공원 이용시간 선택하기 (종일권, After4 이용권)
	public void TimeChoice() {
		System.out.printf("\n\n⊙ 이용시간을 선택해주세요. (After4 이용권은 4시 이후부터 이용가능합니다.)\n\n");
		do {
			System.out.printf("① 1Day  ② After4\n선택 : ");
			data.setTimeChoice(sc.nextInt());
			if (!(data.getTimeChoice() == StaticValue.ALLDAY_PASS || data.getTimeChoice() == StaticValue.AFTER4_PASS)) {
				System.out.printf("잘못된 입력입니다. 1 또는 2를 입력하세요.\n\n");
			}
		} while (!(data.getTimeChoice() == StaticValue.ALLDAY_PASS || data.getTimeChoice() == StaticValue.AFTER4_PASS));
	}

	// 주민등록번호 입력
	public void IDNumber() {
		System.out.printf("\n\n⊙ 주민등록번호를 입력해 주세요. (예시 : 123456-7)\n입력 : ");
		data.setIDNumber(sc.next());
	}

	// 티켓 수 입력
	public void NumberOfTickets() {
		System.out.printf("\n\n⊙ 몇 장을 구매하시나요? (최대 10장)\n");
		do {
			System.out.printf("입력 : ");
		data.setNumberOfTickets(sc.nextInt());
		if (!(data.getNumberOfTickets() < 10)) {
			System.out.printf("잘못된 입력입니다. 1 부터 10까지만 입력하세요.\n\n");
		}
	} while (!(data.getNumberOfTickets() < 10));
	}

	// 우대혜택 선택
	public void AlwaysPrefer() {
		System.out.printf("\n\n******************************* 우 대 할 인  *******************************");
		System.out.printf("\n\n⊙ 해당사항이 있으시면 입력해 주세요. 없다면 0번을 입력해 주세요. (중복 불가)\n\n");
		if (data.getTicketChoice() == 1) {
			do {
				System.out.printf("ⓞ 해당없음  ① 장애인  ②국가유공자  ③휴가장병  ④임산부  ⑤다둥이가족\n선택 : ");
				data.setAlwaysPrefer(sc.nextInt());
				if (!(data.getAlwaysPrefer() == StaticValue.DISABLED || data.getAlwaysPrefer() == StaticValue.NATIONAL_MERIT
						|| data.getAlwaysPrefer() == StaticValue.SODIER_ON_VACATION || data.getAlwaysPrefer() == StaticValue.PREGNANT
						|| data.getAlwaysPrefer() == StaticValue.MULTIPLE_KIDS || data.getAlwaysPrefer() == StaticValue.NONE)) {
					System.out.printf("잘못된 입력입니다. 0부터 5까지의 숫자만 입력하세요.\n\n");
				}
			} while (!(data.getAlwaysPrefer() == StaticValue.DISABLED || data.getAlwaysPrefer() == StaticValue.NATIONAL_MERIT
					|| data.getAlwaysPrefer() == StaticValue.SODIER_ON_VACATION || data.getAlwaysPrefer() == StaticValue.PREGNANT
					|| data.getAlwaysPrefer() == StaticValue.MULTIPLE_KIDS || data.getAlwaysPrefer() == StaticValue.NONE));
		} 
		
		else if (data.getTicketChoice() == 2) {
			do {
				System.out.printf("ⓞ 해당없음  ① 장애인  ②국가유공자\n선택 : ");
				data.setAlwaysPrefer(sc.nextInt());
				if (!(data.getAlwaysPrefer() == StaticValue.DISABLED || data.getAlwaysPrefer() == StaticValue.NATIONAL_MERIT || data.getAlwaysPrefer() == StaticValue.NONE)) {
					System.out.printf("잘못된 입력입니다. 0부터 2까지의 숫자만 입력하세요.\n\n");
				}
			} while (!(data.getAlwaysPrefer() == StaticValue.DISABLED || data.getAlwaysPrefer() == StaticValue.NATIONAL_MERIT || data.getAlwaysPrefer() == StaticValue.NONE));
		}
	}
	
	// 구매내역 확인할지 질문 (계속구매, 종료 후 계산)
	public void WhetherToBuy() {
		System.out.printf("\n\n⊙ 이어서 구매하시겠습니까? 구매내역을 확인하시겠습니까?\n\n");
		do {
			System.out.printf("① 계속 구매  ② 구매내역확인\n선택 : ");
			data.setWhetherToBuy(sc.nextInt());
			if (!(data.getWhetherToBuy() == StaticValue.KEEP_BUYING || data.getWhetherToBuy() == StaticValue.PRICE_CHECK)) {
				System.out.printf("잘못된 입력입니다. 1 또는 2를 입력하세요.\n\n");
			}
		} while (!(data.getWhetherToBuy() == StaticValue.KEEP_BUYING || data.getWhetherToBuy() == StaticValue.PRICE_CHECK));
	}
	
	// 추가로 구매할지 질문 (계속구매, 종료 후 계산)
	public void ExitOrNot() {
		System.out.printf("\n\n⊙ 이어서 구매하시겠습니까? 종료 후 결제하시겠습니까?\n\n");
		do {
			System.out.printf("① 계속 구매  ② 종료 후 결제\n선택 : ");
			data.setWhetherToBuy(sc.nextInt());
			if (!(data.getWhetherToBuy() == StaticValue.KEEP_BUYING || data.getWhetherToBuy() == StaticValue.EXIT)) {
				System.out.printf("잘못된 입력입니다. 1 또는 2를 입력하세요.\n\n");
			}
		} while (!(data.getWhetherToBuy() == StaticValue.KEEP_BUYING || data.getWhetherToBuy() == StaticValue.EXIT));
	}
}