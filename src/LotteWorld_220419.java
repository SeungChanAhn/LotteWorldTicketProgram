import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class LotteWorld_220419 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		OrderData orderItem;
		orderItem = new OrderData();
		ArrayList orderList = new ArrayList();

		Calendar cal = Calendar.getInstance(); // 현재 날짜 가져오기
		SimpleDateFormat sdt = new SimpleDateFormat("YYMMdd");
		int today = Integer.parseInt(sdt.format(cal.getTime())); // 날짜 형식 주민번호와 계산을 위해 '220418'처럼 정수형으로 변환
		int age; // 기본 나이
		int realAge = 0; // 만 나이
		int orderCount = 0; // 배열의 행 (주문수)

		do {
			do {
				orderItem.price = 0; // 가격 초기화

				System.out.printf("***************************** 티 켓 구 매 *****************************\n\n");
				System.out.printf("1. 종합이용권 (이용범위 : 롯데월드 + 민속박물관)\n2. 파크이용권 (이용범위 : 롯데월드)\n선택 : ");
				orderItem.ticketChoice = sc.nextInt();

				System.out.printf("\n1. 1Day 이용권\n2. After4 이용권(이용시간 : 오후 4시부터 입장)\n선택 : ");
				orderItem.timeChoice = sc.nextInt();

				System.out.printf("\n주민등록번호 를 입력해 주세요. (예 : 123456-7)\n입력 : ");
				orderItem.IDNumber = sc.next();

				System.out.printf("***************************** 우 대 할 인  *****************************");
				System.out.printf("\n\n해당사항이 있으시면 입력해 주세요. 없다면 6번을 입력해 주세요. (중복 불가)\n");
				System.out.printf("1. 장애인\n2. 국가유공자\n3. 휴가장병\n4. 임산부\n5. 다둥이 행복카드\n6. 해당사항 없음\n선택 : ");
				orderItem.alwaysPrefer = sc.nextInt();

				// 만 나이계산
				orderItem.year = Integer.parseInt(orderItem.IDNumber.substring(0, 2));
				orderItem.month = Integer.parseInt(orderItem.IDNumber.substring(2, 4));
				orderItem.day = Integer.parseInt(orderItem.IDNumber.substring(4, 6));
				orderItem.IDNumber_Front = Integer.parseInt(orderItem.IDNumber.substring(0, 6));
				orderItem.gender = Integer.parseInt(orderItem.IDNumber.substring(7, 8));

				if (orderItem.gender == 1 || orderItem.gender == 2) { // 1900년대생
					age = (int) (today * 0.0001) + 100 - (int) (orderItem.IDNumber_Front * 0.0001) + 1;
					if (today - (int) (today * 0.0001) * 10000 < orderItem.IDNumber_Front
							- (int) (orderItem.IDNumber_Front * 0.0001) * 10000) {
						realAge = age - 2;
					} else {
						realAge = age - 1;
					}
				} else if (orderItem.gender == 3 || orderItem.gender == 4) { // 2000년대생
					age = (int) (today * 0.0001) + 100 - (int) (orderItem.IDNumber_Front * 0.0001) + 1 - 100;
					if (today - (int) (today * 0.0001) * 10000 < orderItem.IDNumber_Front
							- (int) (orderItem.IDNumber_Front * 0.0001) * 10000) {
						realAge = age - 2;
					} else {
						realAge = age - 1;
					}
				} else {
				}

				// 어른, 청소년, 어린이, 베이비
				if (realAge >= StaticValue.ADULT_MIN_AGE) {
					orderItem.personType = 1; // 어른
				} else if (realAge >= StaticValue.TEEN_MIN_AGE && realAge < StaticValue.ADULT_MIN_AGE) {
					orderItem.personType = 2; // 청소년
				} else if (realAge >= StaticValue.KID_MIN_AGE && realAge < StaticValue.KID_MAX_AGE) {
					orderItem.personType = 3; // 어린이
				} else if (realAge > StaticValue.BABY_AGE_0 && realAge < StaticValue.KID_MAX_AGE) {
					orderItem.personType = 4; // 베이비
				}

				// 선택한 티켓의 가격 저장
				if (orderItem.ticketChoice == 1 && orderItem.timeChoice == 1 && orderItem.personType == 1) {
					orderItem.price += StaticValue.ALL_1DAY_ADULT;
				} else if (orderItem.ticketChoice == 1 && orderItem.timeChoice == 1 && orderItem.personType == 2) {
					orderItem.price += StaticValue.ALL_1DAY_TEEN;
				} else if (orderItem.ticketChoice == 1 && orderItem.timeChoice == 1 && orderItem.personType == 3) {
					orderItem.price += StaticValue.ALL_1DAY_KID;
				} else if (orderItem.ticketChoice == 1 && orderItem.timeChoice == 1 && orderItem.personType == 4) {
					orderItem.price += StaticValue.BABY;
				} else if (orderItem.ticketChoice == 1 && orderItem.timeChoice == 2 && orderItem.personType == 1) {
					orderItem.price += StaticValue.ALL_AFTER4_ADULT;
				} else if (orderItem.ticketChoice == 1 && orderItem.timeChoice == 2 && orderItem.personType == 2) {
					orderItem.price += StaticValue.ALL_AFTER4_TEEN;
				} else if (orderItem.ticketChoice == 1 && orderItem.timeChoice == 2 && orderItem.personType == 3) {
					orderItem.price += StaticValue.ALL_AFTER4_KID;
				} else if (orderItem.ticketChoice == 1 && orderItem.timeChoice == 2 && orderItem.personType == 4) {
					orderItem.price += StaticValue.BABY;
				} else if (orderItem.ticketChoice == 2 && orderItem.timeChoice == 1 && orderItem.personType == 1) {
					orderItem.price += StaticValue.PARK_1DAY_ADULT;
				} else if (orderItem.ticketChoice == 2 && orderItem.timeChoice == 1 && orderItem.personType == 2) {
					orderItem.price += StaticValue.PARK_1DAY_TEEN;
				} else if (orderItem.ticketChoice == 2 && orderItem.timeChoice == 1 && orderItem.personType == 3) {
					orderItem.price += StaticValue.PARK_1DAY_KID;
				} else if (orderItem.ticketChoice == 2 && orderItem.timeChoice == 1 && orderItem.personType == 4) {
					orderItem.price += StaticValue.BABY;
				} else if (orderItem.ticketChoice == 2 && orderItem.timeChoice == 2 && orderItem.personType == 1) {
					orderItem.price += StaticValue.PARK_AFTER4_ADULT;
				} else if (orderItem.ticketChoice == 2 && orderItem.timeChoice == 2 && orderItem.personType == 2) {
					orderItem.price += StaticValue.PARK_AFTER4_TEEN;
				} else if (orderItem.ticketChoice == 2 && orderItem.timeChoice == 2 && orderItem.personType == 3) {
					orderItem.price += StaticValue.PARK_AFTER4_KID;
				} else if (orderItem.ticketChoice == 2 && orderItem.timeChoice == 2 && orderItem.personType == 4) {
					orderItem.price += StaticValue.BABY;
				} else {
				}

				// 베이비 상세 금액. 유아놀이시설 이용 유무 확인.
				if (realAge > 0 && realAge < 1) {
					orderItem.price = StaticValue.FREE;
				} else if (realAge >= 1 && realAge < 3) {
					System.out.printf("\n\n만 1세에서 3세까지 유아 놀이시설은 유료로 이용 가능합니다. 이용하시겠습니까?\n");
					System.out.printf("1. 이용O\n2. 이용X (파크입장 무료)\n선택 : ");
					orderItem.kidsPlayroom = sc.nextInt();
					if (orderItem.kidsPlayroom == 1) {
						orderItem.price = StaticValue.BABY;
					} else if (orderItem.kidsPlayroom == 2) {
						orderItem.price = StaticValue.FREE;
					}
				} else {
				}

				// 상시 우대 혜택
				if (orderItem.alwaysPrefer == 1) { // 장애인
					orderItem.price *= StaticValue.DISABLED;
					System.out.printf("\n장애인증 등 공식증빙 지참 고객 + 동반 1인\n종합이용권/파크이용권 50%% 우대\n");
				} else if (orderItem.alwaysPrefer == 2) { // 국가유공자
					orderItem.price *= StaticValue.NATIONAL_MERIT;
					System.out.printf("\n국가유공자증 등 공식증빙 지참 고객 + 동반1인\n종합이용권/파크이용권 50%% 우대\n");
				} else if (orderItem.ticketChoice == 1 && orderItem.alwaysPrefer == 3) { // 휴가장병은 종합 이용권만 할인
					orderItem.price *= StaticValue.SODIER_ON_VACATION;
					System.out.printf("\n휴가장병(의경, 의무소방관, 군무원 포함) 공식증빙 지참 고객 + 동반인 1인\n종합이용권 49%% 우대\n");
				} else if (orderItem.ticketChoice == 1 && orderItem.alwaysPrefer == 4) { // 임산부는 종합 이용권만 할인
					if (orderItem.gender == 2 || orderItem.gender == 4) {
						orderItem.price *= StaticValue.PREGNANT;
						System.out.printf("\n모자수첩 등 공식증빙 지참 임산부 본인\n종합이용권 50%% 우대\n");
					} else {
						orderItem.alwaysPrefer = 6;
						System.out.printf("\n임산부 혜택을 이용하실 수 없습니다.\n");
					}
				} else if (orderItem.ticketChoice == 1 && orderItem.alwaysPrefer == 5) { // 다둥이 행복카드는 종합 이용권만 할인
					orderItem.price *= StaticValue.MULTIPLE_KIDS;
					System.out.printf("\n다둥이 행복카드 회원 가족 본인(카드에 명기된 가족에 한함)\n종합이용권 30%% 우대\n");
				} else if (orderItem.alwaysPrefer == 6) { // 해당사항 없음
					orderItem.price = orderItem.price;
				} else {
				}

				// 만 65세 이상 어른일 때, 상시 우대 혜택에서 해당사항이 없는 경우. 어린이 요금 적용
				if (realAge >= StaticValue.ADULT_MAX_AGE && orderItem.ticketChoice == 1 && orderItem.timeChoice == 1
						&& orderItem.alwaysPrefer == 6) {
					orderItem.price = StaticValue.ALL_1DAY_KID;
					orderItem.personType = 0; // 노인은 personType에 0 저장
					orderItem.alwaysPrefer = 0; // 경로우대 어린이 요금 적용, alwaysPrefer에 0 저장
				} else if (realAge >= StaticValue.ADULT_MAX_AGE && orderItem.ticketChoice == 1
						&& orderItem.timeChoice == 2 && orderItem.alwaysPrefer == 6) {
					orderItem.price = StaticValue.ALL_AFTER4_KID;
					orderItem.personType = 0;
					orderItem.alwaysPrefer = 0;
				} else if (realAge >= StaticValue.ADULT_MAX_AGE && orderItem.ticketChoice == 2
						&& orderItem.timeChoice == 1 && orderItem.alwaysPrefer == 6) {
					orderItem.price = StaticValue.PARK_1DAY_KID;
					orderItem.personType = 0;
					orderItem.alwaysPrefer = 0;
				} else if (realAge >= StaticValue.ADULT_MAX_AGE && orderItem.ticketChoice == 2
						&& orderItem.timeChoice == 2 && orderItem.alwaysPrefer == 6) {
					orderItem.price = StaticValue.PARK_AFTER4_KID;
					orderItem.personType = 0;
					orderItem.alwaysPrefer = 0;
				} else {
				}

				// 티켓 수
				System.out.printf("\n\n몇장을 구매하시겠습니까?\n");
				orderItem.ticketCount = sc.nextInt();

				// 총액 합산
				orderItem.sumPrice = orderItem.ticketCount * orderItem.price; // 현재 주문하는 티켓들의 가격합
				orderItem.totalprice += orderItem.sumPrice; // 주문한 모든 티켓가격

				// 배열에 숫자 대신 문자로
				////////////////////////////////////////
				String ticketChoice_ST = null;
				String timeChoice_ST = null;
				String personType_ST = null;
				String alwaysPrefer_ST = null;

				switch (orderItem.ticketChoice) {
				case 1:
					ticketChoice_ST = "종합이용권";
					break;
				case 2:
					ticketChoice_ST = "파크이용권";
					break;
				}
				////////////////////////////////////////
				switch (orderItem.timeChoice) {
				case 1:
					timeChoice_ST = "Allday";
					break;
				case 2:
					timeChoice_ST = "After4";
					break;
				}
				////////////////////////////////////////
				switch (orderItem.personType) {
				case 0:
					personType_ST = "노인";
					break;
				case 1:
					personType_ST = "어른";
					break;
				case 2:
					personType_ST = "청소년";
					break;
				case 3:
					personType_ST = "어린이";
					break;
				case 4:
					personType_ST = "베이비";
					break;
				}
				////////////////////////////////////////
				switch (orderItem.alwaysPrefer) {
				case 0:
					alwaysPrefer_ST = "경로 우대";
					break;
				case 1:
					alwaysPrefer_ST = "장애인 우대";
					break;
				case 2:
					alwaysPrefer_ST = "국가유공자 우대";
					break;
				case 3:
					alwaysPrefer_ST = "휴가군인 우대";
					break;
				case 4:
					alwaysPrefer_ST = "임산부 우대";
					break;
				case 5:
					alwaysPrefer_ST = "다둥이가족 우대";
					break;
				case 6:
					alwaysPrefer_ST = "해당사항 없음";
					break;
				}
				////////////////////////////////////////
				// 한줄 씩 출력하기 위해서 String 형 all 변수생성
				String all = ticketChoice_ST + "\t\t" + timeChoice_ST + "\t\t\t" + personType_ST + "\t\t"
						+ orderItem.ticketCount + "장" + "\t\t" + orderItem.sumPrice + "원" + "\t" + alwaysPrefer_ST
						+ "\n";

				// arraylist에 추가
				orderList.add(all);
				orderCount++;
				// 계속구매 혹은 종료
				System.out.printf("\n\n계속 구매하시겠습니까?\n");
				System.out.printf("1. 계속 구매\n2. 종료 후 계산\n선택 : ");
				orderItem.whetherToBuy = sc.nextInt();

			} while (orderItem.whetherToBuy == 1);

			System.out.printf(
					"=============================================================================================================\n");
			System.out.printf("\n\n                                                롯 데 월 드\n");
			System.out.printf("\n                                                     \n");
			System.out.printf(
					"=============================================================================================================\n");
			System.out.printf("%s%12s%14s%5s%9s%12s\n", "티켓종류", "이용시간", "구분", "수량", "가격", "할인내역");
			System.out.printf(
					"-------------------------------------------------------------------------------------------------------------\n");
			for (int i = 0; i < orderCount; i++) {
				System.out.println(orderList.get(i));
			}
			System.out.printf(
					"\n-------------------------------------------------------------------------------------------------------------\n");
			System.out.printf("결제금액\t\t\t\t\t\t\t\t\t\t%19d원", orderItem.totalprice);
			System.out.printf(
					"\n=============================================================================================================\n");

			System.out.printf("\n\n계속 구매하시겠습니까?\n");
			System.out.printf("1. 계속 구매\n2. 종료 후 계산\n선택 : ");
			orderItem.whetherToBuy = sc.nextInt();

		} while (orderItem.whetherToBuy == 1);
		System.out.printf("\n종료하겠습니다. 감사합니다.");
	}
}
