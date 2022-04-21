package Practice;

public class StaticValue {
	// 티켓 권종 선택
	static final int ALL_PASS = 1;
	static final int PARK_PASS = 2;
	
	// 이용 시간 선택
	static final int ALLDAY_PASS = 1;
	static final int AFTER4_PASS = 2;
	
	// 주민등록번호 뒷자리로 구분하는 1900년대생과 2000년대생 남자, 여자
	static final int MAN_1900 = 1;
	static final int WOMAN_1900 = 2;
	static final int MAN_2000 = 3;
	static final int WOMAN_2000 = 4;
	
	// 나이 구분
	static final int ADULT_MAX_AGE = 65;
	static final int ADULT_MIN_AGE = 18;
	static final int TEEN_MIN_AGE = 13;
	static final int KID_MAX_AGE = 12;
	static final int KID_MIN_AGE = 3;
	static final int BABY_AGE_0 = 0;
	static final int BABY_AGE_1 = 1;
	
	// 나이로 사람 구분
	static final int OLDPERSON = 0;
	static final int ADULT = 1;
	static final int TEEN = 2;
	static final int KID = 3;
	static final int BABY = 4;
	
	// 만 나이로 구분하는 가격
	static final int ALL_1DAY_ADULT = 62000;
	static final int ALL_1DAY_TEEN = 54000;
	static final int ALL_1DAY_KID = 47000;
	static final int ALL_AFTER4_ADULT = 50000;
	static final int ALL_AFTER4_TEEN = 43000;
	static final int ALL_AFTER4_KID = 36000;
	static final int PARK_1DAY_ADULT = 59000;
	static final int PARK_1DAY_TEEN = 52000;
	static final int PARK_1DAY_KID = 46000;
	static final int PARK_AFTER4_ADULT = 47000;
	static final int PARK_AFTER4_TEEN = 41000;
	static final int PARK_AFTER4_KID = 35000;
	static final int PRICE_BABY = 15000;
	static final int PRICE_FREE = 0;
	
	// 어린이놀이시설 이용 유무
	static final int KIDPLAYROOM_O = 1;
	static final int KIDPLAYROOM_X = 2;
	
	// 우대혜택선택
	static final int NONE = 0;
	static final int DISABLED = 1;
	static final int NATIONAL_MERIT = 2;
	static final int SODIER_ON_VACATION = 3;
	static final int PREGNANT = 4;
	static final int MULTIPLE_KIDS = 5;
	static final int OLD = 6; // 경로우대
	
	
	// 우대혜택 할인율
	static final double DISABLED_RATE = 0.5;
	static final double NATIONAL_MERIT_RATE = 0.5;
	static final double SODIER_ON_VACATION_RATE = 0.49;
	static final double PREGNANT_RATE = 0.5;
	static final double MULTIPLE_KIDS_RATE = 0.3;
	
	// 더 구매할지 안할지 선택
	static final int KEEP_BUYING = 1;
	static final int PRICE_CHECK = 2;
	static final int EXIT = 2;
}
