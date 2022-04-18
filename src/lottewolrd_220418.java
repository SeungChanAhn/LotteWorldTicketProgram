import java.util.ArrayList;
import java.util.Scanner;

public class lottewolrd_220418 {
	static final int ALL_1DAY_ADULT = 62000, ALL_1DAY_TEEN = 54000, ALL_1DAY_KID = 47000;
	static final int ALL_AFTER4_ADULT = 50000, ALL_AFTER4_TEEN = 43000, ALL_AFTER4_KID = 36000;
	static final int PARK_1DAY_ADULT = 59000, PARK_1DAY_TEEN = 52000, PARK_1DAY_KID = 46000;
	static final int PARK_AFTER4_ADULT = 47000, PARK_AFTER4_TEEN = 41000, PARK_AFTER4_KID = 35000;
	static final int BABY = 15000, FREE = 0;
	static final int ADULT_MAX_AGE = 65, ADULT_MIN_AGE = 18, TEEN_MIN_AGE = 13, KID_MAX_AGE = 12, KID_MIN_AGE = 3, BABY_AGE_0 = 0, BABY_AGE_1 = 1;
	static final double DISABLED = 0.5, NATIONAL_MERIT = 0.5, SODIER_ON_VACATION = 0.49, PREGNANT = 0.5, MULTIPLE_KIDS = 0.3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int price = 0; // 티켓금액 
		int ticketCount = 0; // 티켓 구매 수량
		int totalprice = 0; // 총 결제금액 
		int ticketChoice; // 종합이용권과 파크이용권 선택 
		int timeChoice; // 시간 이용권 선택
		int today; // 오늘날짜 저장 
		int age; // 기본 나이 
		int realAge; // 만 나이 
		int residentRegistrationNumber_Front; // 주민번호 앞자리 6자리 
		int residentRegistrationNumber_Back; // 주민번호 뒷 1자리 
		int personType = 0; // 어른, 청소년, 어린이, 베이비 
		int kidsPlayroom; // 유아 놀이방 선택할지 안할지 
		int alwaysPrefer; // 상시우대 혜택 
		int whetherToBuy; // 더 구매할지 안할지 
		int orderCount = 0;  // 배열 행
		
		ArrayList orderList = new ArrayList(); // 영수증 배열 
	}

}
