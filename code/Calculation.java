package Practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Calculation {
	Scanner sc = new Scanner(System.in);
	Input input;

	Calculation(Input input) {
		this.input = input;
	}

	// 입력받은 주민등록번호를 바탕으로 만나이 계산하기
	public void InternationalAge() {
		Calendar calendar = Calendar.getInstance(); // 현재 날짜 가져오기
		SimpleDateFormat sdt = new SimpleDateFormat("YYMMdd");
		input.data.today = Integer.parseInt(sdt.format(calendar.getTime())); // 날짜 형식 주민번호와 계산을 위해 '220420'처럼 정수형으로 변환

		input.data.year = Integer.parseInt(input.data.IDNumber.substring(0, 2));
		input.data.month = Integer.parseInt(input.data.IDNumber.substring(2, 4));
		input.data.day = Integer.parseInt(input.data.IDNumber.substring(4, 6));
		input.data.IDNumber_Front = Integer.parseInt(input.data.IDNumber.substring(0, 6));
		input.data.gender = Integer.parseInt(input.data.IDNumber.substring(7, 8));

		if (input.data.gender == StaticValue.MAN_1900 || input.data.gender == StaticValue.WOMAN_1900) { // 1900년대생
			input.data.age = (int) (input.data.today * 0.0001) + 100 - (int) (input.data.IDNumber_Front * 0.0001) + 1;
			if (input.data.today - (int) (input.data.today * 0.0001) * 10000 < input.data.IDNumber_Front
					- (int) (input.data.IDNumber_Front * 0.0001) * 10000) {
				input.data.realAge = input.data.age - 2;
			} else {
				input.data.realAge = input.data.age - 1;
			}
		} else if (input.data.gender == StaticValue.MAN_2000 || input.data.gender == StaticValue.WOMAN_2000) { // 2000년대생
			input.data.age = (int) (input.data.today * 0.0001) + 100 - (int) (input.data.IDNumber_Front * 0.0001) + 1
					- 100;
			if (input.data.today - (int) (input.data.today * 0.0001) * 10000 < input.data.IDNumber_Front
					- (int) (input.data.IDNumber_Front * 0.0001) * 10000) {
				input.data.realAge = input.data.age - 2;
			} else {
				input.data.realAge = input.data.age - 1;
			}
		} else {
		}
	}

	// 나이 카테고리 나누기
	public void AgeCategory() {
		if (input.data.realAge > StaticValue.ADULT_MAX_AGE) {
			input.data.personTypeByAge = StaticValue.OLDPERSON; // 노인
		} else if (input.data.realAge >= StaticValue.ADULT_MIN_AGE) {
			input.data.personTypeByAge = StaticValue.ADULT; // 어른
		} else if (input.data.realAge >= StaticValue.TEEN_MIN_AGE && input.data.realAge < StaticValue.ADULT_MIN_AGE) {
			input.data.personTypeByAge = StaticValue.TEEN; // 청소년
		} else if (input.data.realAge >= StaticValue.KID_MIN_AGE && input.data.realAge < StaticValue.KID_MAX_AGE) {
			input.data.personTypeByAge = StaticValue.KID; // 어린이
		} else if (input.data.realAge > StaticValue.BABY_AGE_0 && input.data.realAge < StaticValue.KID_MAX_AGE) {
			input.data.personTypeByAge = StaticValue.BABY; // 베이비
		}
	}

	// 나이로 금액 구분하기
	public void PriceByAge() {
		if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.ADULT) {
			input.data.price += StaticValue.ALL_1DAY_ADULT;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.TEEN) {
			input.data.price += StaticValue.ALL_1DAY_TEEN;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.KID) {
			input.data.price += StaticValue.ALL_1DAY_KID;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.BABY) {
			input.data.price += StaticValue.BABY;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.ADULT) {
			input.data.price += StaticValue.ALL_AFTER4_ADULT;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.TEEN) {
			input.data.price += StaticValue.ALL_AFTER4_TEEN;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.KID) {
			input.data.price += StaticValue.ALL_AFTER4_KID;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.BABY) {
			input.data.price += StaticValue.BABY;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.ADULT) {
			input.data.price += StaticValue.PARK_1DAY_ADULT;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.TEEN) {
			input.data.price += StaticValue.PARK_1DAY_TEEN;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.KID) {
			input.data.price += StaticValue.PARK_1DAY_KID;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.BABY) {
			input.data.price += StaticValue.BABY;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.ADULT) {
			input.data.price += StaticValue.PARK_AFTER4_ADULT;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.TEEN) {
			input.data.price += StaticValue.PARK_AFTER4_TEEN;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.KID) {
			input.data.price += StaticValue.PARK_AFTER4_KID;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.BABY) {
			input.data.price += StaticValue.BABY;
		} else {
		}
	}

	// 유아놀이시설 이용에 따른 금액 변경
	public void UseKidplayroom() {
		if (input.data.realAge > StaticValue.BABY_AGE_0 && input.data.realAge < StaticValue.BABY_AGE_1) {
			input.data.price = StaticValue.PRICE_FREE;
		} else if (input.data.realAge >= StaticValue.BABY_AGE_1 && input.data.realAge < StaticValue.KID_MIN_AGE) {
			System.out.printf("\n\n만 1세에서 3세까지 유아 놀이시설은 유료로 이용 가능합니다. 이용하시겠습니까?\n");

			do {
				System.out.printf("1. 이용O\n2. 이용X (파크입장 무료)\n선택 : ");
				input.data.kidsPlayroom = sc.nextInt();
				if (!(input.data.kidsPlayroom == StaticValue.KIDPLAYROOM_O
						|| input.data.kidsPlayroom == StaticValue.KIDPLAYROOM_X)) {
					System.out.printf("잘못된 입력입니다. 1 또는 2를 입력하세요.\n\n");
				}
			} while (!(input.data.kidsPlayroom == StaticValue.KIDPLAYROOM_O
					|| input.data.kidsPlayroom == StaticValue.KIDPLAYROOM_X));

			if (input.data.kidsPlayroom == StaticValue.KIDPLAYROOM_O) {
				input.data.price = StaticValue.PRICE_BABY;
			} else if (input.data.kidsPlayroom == StaticValue.KIDPLAYROOM_X) {
				input.data.price = StaticValue.PRICE_FREE;
			}
		} else {
		}
	}

	// 우대사항별 금액 설정
	public void PriceByPrefer() {
		if (input.data.alwaysPrefer == StaticValue.DISABLED) { // 장애인
			input.data.price *= StaticValue.DISABLED_RATE;
			System.out.printf("\n장애인증 등 공식증빙 지참 고객 + 동반 1인\n종합이용권/파크이용권 50%% 우대\n");
		} else if (input.data.alwaysPrefer == StaticValue.NATIONAL_MERIT) { // 국가유공자
			input.data.price *= StaticValue.NATIONAL_MERIT_RATE;
			System.out.printf("\n국가유공자증 등 공식증빙 지참 고객 + 동반1인\n종합이용권/파크이용권 50%% 우대\n");
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS
				&& input.data.alwaysPrefer == StaticValue.SODIER_ON_VACATION) { // 휴가장병은 종합 이용권만 할인
			input.data.price *= StaticValue.SODIER_ON_VACATION_RATE;
			System.out.printf("\n휴가장병(의경, 의무소방관, 군무원 포함) 공식증빙 지참 고객 + 동반인 1인\n종합이용권 49%% 우대\n");
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.alwaysPrefer == StaticValue.PREGNANT) { // 임산부는
																															// 종합
																															// 이용권만
																															// 할인
			if (input.data.gender == StaticValue.WOMAN_1900 || input.data.gender == StaticValue.WOMAN_2000) {
				input.data.price *= StaticValue.PREGNANT_RATE;
				System.out.printf("\n모자수첩 등 공식증빙 지참 임산부 본인\n종합이용권 50%% 우대\n");
			} else {
				input.data.alwaysPrefer = StaticValue.NONE;
				System.out.printf("\n임산부 혜택을 이용하실 수 없습니다.\n");
			}
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS
				&& input.data.alwaysPrefer == StaticValue.MULTIPLE_KIDS) { // 다둥이 행복카드는 종합 이용권만 할인
			input.data.price *= StaticValue.MULTIPLE_KIDS_RATE;
			System.out.printf("\n다둥이 행복카드 회원 가족 본인(카드에 명기된 가족에 한함)\n종합이용권 30%% 우대\n");
		} else if (input.data.alwaysPrefer == StaticValue.NONE) { // 해당사항 없음
			input.data.price = input.data.price;
		} else {
		}
	}

	// 우대사항 해당없는 노인가격설정
	public void PriceByNoPreferOld() {
		if (input.data.realAge >= StaticValue.ADULT_MAX_AGE && input.data.ticketChoice == StaticValue.ALL_PASS
				&& input.data.timeChoice == StaticValue.ALLDAY_PASS && input.data.alwaysPrefer == StaticValue.NONE) {
			input.data.price = StaticValue.ALL_1DAY_KID;
			input.data.personTypeByAge = StaticValue.OLDPERSON; // 노인은 personType에 0 저장
			input.data.alwaysPrefer = StaticValue.OLD; // 경로우대 어린이 요금 적용, alwaysPrefer에 0 저장
		} else if (input.data.realAge >= StaticValue.ADULT_MAX_AGE && input.data.ticketChoice == StaticValue.ALL_PASS
				&& input.data.timeChoice == StaticValue.AFTER4_PASS && input.data.alwaysPrefer == StaticValue.NONE) {
			input.data.price = StaticValue.ALL_AFTER4_KID;
			input.data.personTypeByAge = StaticValue.OLDPERSON;
			input.data.alwaysPrefer = StaticValue.OLD;
		} else if (input.data.realAge >= StaticValue.ADULT_MAX_AGE && input.data.ticketChoice == StaticValue.PARK_PASS
				&& input.data.timeChoice == StaticValue.ALLDAY_PASS && input.data.alwaysPrefer == StaticValue.NONE) {
			input.data.price = StaticValue.PARK_1DAY_KID;
			input.data.personTypeByAge = StaticValue.OLDPERSON;
			input.data.alwaysPrefer = StaticValue.OLD;
		} else if (input.data.realAge >= StaticValue.ADULT_MAX_AGE && input.data.ticketChoice == StaticValue.PARK_PASS
				&& input.data.timeChoice == StaticValue.AFTER4_PASS && input.data.alwaysPrefer == StaticValue.NONE) {
			input.data.price = StaticValue.PARK_AFTER4_KID;
			input.data.personTypeByAge = StaticValue.OLDPERSON;
			input.data.alwaysPrefer = StaticValue.OLD;
		} else {
		}
	}
	
	// 가격 수량 곱하기, 총액 누적하기
	public void AddPrice() {
		input.data.priceSum = input.data.price * input.data.numberOfTickets; // 현재 주문하는 티켓들의 가격합
		input.data.totalPrice += input.data.priceSum;
	}
}