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
		int price = 0; // Ƽ�ϱݾ� 
		int ticketCount = 0; // Ƽ�� ���� ����
		int totalprice = 0; // �� �����ݾ� 
		int ticketChoice; // �����̿�ǰ� ��ũ�̿�� ���� 
		int timeChoice; // �ð� �̿�� ����
		int today; // ���ó�¥ ���� 
		int age; // �⺻ ���� 
		int realAge; // �� ���� 
		int residentRegistrationNumber_Front; // �ֹι�ȣ ���ڸ� 6�ڸ� 
		int residentRegistrationNumber_Back; // �ֹι�ȣ �� 1�ڸ� 
		int personType = 0; // �, û�ҳ�, ���, ���̺� 
		int kidsPlayroom; // ���� ���̹� �������� ������ 
		int alwaysPrefer; // ��ÿ�� ���� 
		int whetherToBuy; // �� �������� ������ 
		int orderCount = 0;  // �迭 ��
		
		ArrayList orderList = new ArrayList(); // ������ �迭 
	}

}
