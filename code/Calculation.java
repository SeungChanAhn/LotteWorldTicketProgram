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
		input.data.setToday(Integer.parseInt(sdt.format(calendar.getTime()))); // 날짜 형식 주민번호와 계산을 위해 '220420'처럼 정수형으로 변환

		input.data.setYear(Integer.parseInt(input.data.getIDNumber().substring(0, 2)));
		input.data.setMonth(Integer.parseInt(input.data.getIDNumber().substring(2, 4)));
		input.data.setDay(Integer.parseInt(input.data.getIDNumber().substring(4, 6)));
		input.data.setIDNumber_Front(Integer.parseInt(input.data.getIDNumber().substring(0, 6)));
		input.data.setGender(Integer.parseInt(input.data.getIDNumber().substring(7, 8)));

		if (input.data.getGender() == StaticValue.MAN_1900 || input.data.getGender() == StaticValue.WOMAN_1900) { // 1900년대생
			input.data.setAge(
					(int) (input.data.getToday() * 0.0001) + 100 - (int) (input.data.getIDNumber_Front() * 0.0001) + 1);
			if (input.data.getToday() - (int) (input.data.getToday() * 0.0001) * 10000 < input.data.getIDNumber_Front()
					- (int) (input.data.getIDNumber_Front() * 0.0001) * 10000) {
				input.data.setRealAge(input.data.getAge() - 2);
			} else {
				input.data.setRealAge(input.data.getAge() - 1);
			}
		} else if (input.data.getGender() == StaticValue.MAN_2000 || input.data.getGender() == StaticValue.WOMAN_2000) { // 2000년대생
			input.data.setAge((int) (input.data.getToday() * 0.0001) + 100
					- (int) (input.data.getIDNumber_Front() * 0.0001) + 1 - 100);
			if (input.data.getToday() - (int) (input.data.getToday() * 0.0001) * 10000 < input.data.getIDNumber_Front()
					- (int) (input.data.getIDNumber_Front() * 0.0001) * 10000) {
				input.data.setRealAge(input.data.getAge() - 2);
			} else {
				input.data.setRealAge(input.data.getAge() - 1);
			}
		} else {
		}
	}

	// 나이 카테고리 나누기
	public void AgeCategory() {
		if (input.data.getRealAge() >= StaticValue.ADULT_MAX_AGE) {
			input.data.setPersonTypeByAge(StaticValue.OLDPERSON); // 노인
		} else if (input.data.getRealAge() >= StaticValue.ADULT_MIN_AGE) {
			input.data.setPersonTypeByAge(StaticValue.ADULT); // 어른
		} else if (input.data.getRealAge() >= StaticValue.TEEN_MIN_AGE
				&& input.data.getRealAge() < StaticValue.ADULT_MIN_AGE) {
			input.data.setPersonTypeByAge(StaticValue.TEEN); // 청소년
		} else if (input.data.getRealAge() >= StaticValue.KID_MIN_AGE
				&& input.data.getRealAge() < StaticValue.KID_MAX_AGE) {
			input.data.setPersonTypeByAge(StaticValue.KID); // 어린이
		} else if (input.data.getRealAge() > StaticValue.BABY_AGE_0
				&& input.data.getRealAge() < StaticValue.KID_MAX_AGE) {
			input.data.setPersonTypeByAge(StaticValue.BABY); // 베이비
		}
	}

	// 나이로 금액 구분하기
	public void PriceByAge() {
		if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.ADULT) {
			input.data.setPrice(input.data.getPrice() + StaticValue.ALL_1DAY_ADULT);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.TEEN) {
			input.data.setPrice(input.data.getPrice() + StaticValue.ALL_1DAY_TEEN);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.KID) {
			input.data.setPrice(input.data.getPrice() + StaticValue.ALL_1DAY_KID);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.BABY) {
			input.data.setPrice(input.data.getPrice() + StaticValue.BABY);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.ADULT) {
			input.data.setPrice(input.data.getPrice() + StaticValue.ALL_AFTER4_ADULT);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.TEEN) {
			input.data.setPrice(input.data.getPrice() + StaticValue.ALL_AFTER4_TEEN);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.KID) {
			input.data.setPrice(input.data.getPrice() + StaticValue.ALL_AFTER4_KID);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.BABY) {
			input.data.setPrice(input.data.getPrice() + StaticValue.BABY);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.ADULT) {
			input.data.setPrice(input.data.getPrice() + StaticValue.PARK_1DAY_ADULT);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.TEEN) {
			input.data.setPrice(input.data.getPrice() + StaticValue.PARK_1DAY_TEEN);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.KID) {
			input.data.setPrice(input.data.getPrice() + StaticValue.PARK_1DAY_KID);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.BABY) {
			input.data.setPrice(input.data.getPrice() + StaticValue.BABY);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.ADULT) {
			input.data.setPrice(input.data.getPrice() + StaticValue.PARK_AFTER4_ADULT);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.TEEN) {
			input.data.setPrice(input.data.getPrice() + StaticValue.PARK_AFTER4_TEEN);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.KID) {
			input.data.setPrice(input.data.getPrice() + StaticValue.PARK_AFTER4_KID);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.BABY) {
			input.data.setPrice(input.data.getPrice() + StaticValue.BABY);
		} else {
		}
	}

	// 유아놀이시설 이용에 따른 금액 변경
	public void UseKidplayroom() {
		if (input.data.getRealAge() > StaticValue.BABY_AGE_0 && input.data.getRealAge() < StaticValue.BABY_AGE_1) {
			input.data.setPrice(StaticValue.PRICE_FREE);
		} else if (input.data.getRealAge() >= StaticValue.BABY_AGE_1
				&& input.data.getRealAge() < StaticValue.KID_MIN_AGE) {
			System.out.printf("\n\n만 1세에서 3세까지 유아 놀이시설은 유료로 이용 가능합니다. 이용하시겠습니까?\n");

			do {
				System.out.printf("1. 이용O\n2. 이용X (파크입장 무료)\n선택 : ");
				input.data.setKidsPlayroom(sc.nextInt());
				if (!(input.data.getKidsPlayroom() == StaticValue.KIDPLAYROOM_O
						|| input.data.getKidsPlayroom() == StaticValue.KIDPLAYROOM_X)) {
					System.out.printf("잘못된 입력입니다. 1 또는 2를 입력하세요.\n\n");
				}
			} while (!(input.data.getKidsPlayroom() == StaticValue.KIDPLAYROOM_O
					|| input.data.getKidsPlayroom() == StaticValue.KIDPLAYROOM_X));

			if (input.data.getKidsPlayroom() == StaticValue.KIDPLAYROOM_O) {
				input.data.setPrice(StaticValue.PRICE_BABY);
			} else if (input.data.getKidsPlayroom() == StaticValue.KIDPLAYROOM_X) {
				input.data.setPrice(StaticValue.PRICE_FREE);
			}
		} else {
		}
	}

	// 우대사항별 금액 설정
	public void PriceByPrefer() {
		
		// 장애인 50% 할인우대
		if (input.data.getAlwaysPrefer() == StaticValue.DISABLED) {
			input.data.setPrice(input.data.getPrice() * StaticValue.DISABLED_RATE);
			System.out.printf("\n장애인증 등 공식증빙 지참 고객 + 동반 1인\n종합이용권/파크이용권 50%% 우대\n");
		}
		
		// 국가유공자 50% 할인우대
		else if (input.data.getAlwaysPrefer() == StaticValue.NATIONAL_MERIT) { 
			input.data.setPrice(input.data.getPrice() * StaticValue.NATIONAL_MERIT_RATE);
			System.out.printf("\n국가유공자증 등 공식증빙 지참 고객 + 동반1인\n종합이용권/파크이용권 50%% 우대\n");
		} 
		
		// 휴가장병은 종합 이용권만 49%할인
		else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getAlwaysPrefer() == StaticValue.SODIER_ON_VACATION) {
			input.data.setPrice(input.data.getPrice() * StaticValue.SODIER_ON_VACATION_RATE);
			System.out.printf("\n휴가장병(의경, 의무소방관, 군무원 포함) 공식증빙 지참 고객 + 동반인 1인\n종합이용권 49%% 우대\n");
		} 
		
		// 임산부는 종합이용권만 50%할인
		else if (input.data.getTicketChoice() == StaticValue.ALL_PASS && input.data.getAlwaysPrefer() == StaticValue.PREGNANT) { 
			if (input.data.getGender() == StaticValue.WOMAN_1900 || input.data.getGender() == StaticValue.WOMAN_2000) {
				input.data.setPrice(input.data.getPrice() * StaticValue.PREGNANT_RATE);
				System.out.printf("\n모자수첩 등 공식증빙 지참 임산부 본인\n종합이용권 50%% 우대\n");
			} else {
				input.data.setAlwaysPrefer(StaticValue.NONE);
				System.out.printf("\n임산부 혜택을 이용하실 수 없습니다.\n");
			}
		} 
		
		// 다둥이가족은 종합이용권만 30%할인
		else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getAlwaysPrefer() == StaticValue.MULTIPLE_KIDS) { 
			input.data.setPrice(input.data.getPrice() * StaticValue.MULTIPLE_KIDS_RATE);
			System.out.printf("\n다둥이 행복카드 회원 가족 본인(카드에 명기된 가족에 한함)\n종합이용권 30%% 우대\n");
		} 
		
		// 해당사항없음은 가격변동없음.
		else if (input.data.getAlwaysPrefer() == StaticValue.NONE) {
			input.data.setPrice(input.data.getPrice());
		}
	}

	// 우대사항 해당없는 노인가격설정
	public void PriceByNoPreferOld() {
		if (input.data.getRealAge() >= StaticValue.ADULT_MAX_AGE && input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getAlwaysPrefer() == StaticValue.NONE) {
			input.data.setPrice(StaticValue.ALL_1DAY_KID);
			input.data.setPersonTypeByAge(StaticValue.OLDPERSON); // 노인은 personType에 0 저장
			input.data.setAlwaysPrefer(StaticValue.OLD); // 경로우대 어린이 요금 적용, alwaysPrefer에 0 저장
		} else if (input.data.getRealAge() >= StaticValue.ADULT_MAX_AGE
				&& input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getAlwaysPrefer() == StaticValue.NONE) {
			input.data.setPrice(StaticValue.ALL_AFTER4_KID);
			input.data.setPersonTypeByAge(StaticValue.OLDPERSON);
			input.data.setAlwaysPrefer(StaticValue.OLD);
		} else if (input.data.getRealAge() >= StaticValue.ADULT_MAX_AGE
				&& input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getAlwaysPrefer() == StaticValue.NONE) {
			input.data.setPrice(StaticValue.PARK_1DAY_KID);
			input.data.setPersonTypeByAge(StaticValue.OLDPERSON);
			input.data.setAlwaysPrefer(StaticValue.OLD);
		} else if (input.data.getRealAge() >= StaticValue.ADULT_MAX_AGE
				&& input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getAlwaysPrefer() == StaticValue.NONE) {
			input.data.setPrice(StaticValue.PARK_AFTER4_KID);
			input.data.setPersonTypeByAge(StaticValue.OLDPERSON);
			input.data.setAlwaysPrefer(StaticValue.OLD);
		} else {
		}
	}

	// 가격 수량 곱하기
	// 현재 주문하는 티켓들의 가격합
	public void AddPrice() {
		input.data.setPriceSum(input.data.getPrice() * input.data.getNumberOfTickets());
	}
}