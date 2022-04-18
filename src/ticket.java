import java.util.*;

public class ticket {

	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
		    int ALL_1DAY_ADULT = 62000, ALL_1DAY_TEEN = 54000, ALL_1DAY_KID = 47000;
		    int ALL_AFTER4_ADULT = 50000, ALL_AFTER4_TEEN = 43000, ALL_AFTER4_KID = 36000;
		    int PARK_1DAY_ADULT = 59000, PARK_1DAY_TEEN = 52000, PARK_1DAY_KID = 46000;
		    int PARK_AFTER4_ADULT = 47000, PARK_AFTER4_TEEN = 41000, PARK_AFTER4_KID = 35000;
		    int BABY = 15000;
		    int FREE = 0;
		    int ADULT_MAX_AGE = 65, ADULT_MIN_AGE = 18, TEEN_MIN_AGE = 13, KID_MAX_AGE = 12, KID_MIN_AGE = 3;
		    int BABY_AGE_0 = 0, BABY_AGE_1 = 1;
		    double DISABLED = 0.5, NATIONAL_MERIT = 0.5, SODIER_ON_VACATION = 0.49, PREGNANT = 0.5, MULTIPLE_KIDS = 0.3;
		    int totalprice = 0; // �� �����ݾ� 
		    int ticketChoice; // �����̿�ǰ� ��ũ�̿�� ���� 
		    int timeChoice; // �ð� �̿�� ����
		    int today = 220415; // ���ó�¥ 
		    int age; // �⺻ ���� 
		    int realAge = 0; // �� ���� 
		    int personNumberFront; // �ֹι�ȣ ���ڸ� 6�ڸ� 
		    int personNumberBack; // �ֹι�ȣ �� 1�ڸ� 
		    int personType = 0; // �, û�ҳ�, ���, ���̺� 
		    int kidsPlayroom; // ���� ���̹� �������� ������ 
		    int alwaysPrefer; // ��ÿ�� ���� 
		    int whetherToBuy; // �� �������� ������ 
		    int orderCount = 0; 
		    int ticketCount = 1;
		   
		    ArrayList list = new ArrayList();
		    do {
		        do {
		            int price = 0;
		            System.out.printf("******************** Ƽ �� �� �� ********************\n\n");
		            // ���� ���� �⺻ �ݾ�. 
		            System.out.printf("1. �����̿�� (�̿���� : �Ե����� + �μӹڹ���)\n2. ��ũ�̿�� (�̿���� : �Ե�����)\n���� : ");
		            ticketChoice = sc.nextInt();
		            System.out.printf("\n1. 1Day �̿��\n2. After4 �̿��(�̿�ð� : ���� 4�ú��� ����)\n���� : ");
		            timeChoice= sc.nextInt();
		            System.out.printf("\n�ֹε�Ϲ�ȣ �� 6�ڸ��� �Է��� �ּ���.\n�Է� : ");
		            personNumberFront= sc.nextInt();
		            System.out.printf("\n�ֹε�Ϲ�ȣ ���ڸ� ù ��° ���ڸ� �Է��� �ּ���.\n�Է� : ");
		            personNumberBack= sc.nextInt();
		            System.out.printf("***************************** �� �� �� ��  *****************************");
		            System.out.printf("\n\n�ش������ �����ø� �Է��� �ּ���. ���ٸ� 6���� �Է��� �ּ���. (�ߺ� �Ұ�)\n");
		            System.out.printf("1. �����\n2. ����������\n3. �ް��庴\n4. �ӻ��\n5. �ٵ��� �ູī��\n6. �ش���� ����\n���� : ");
		            alwaysPrefer= sc.nextInt();

		            // �� ���̰�� 
		            if (personNumberBack == 1 || personNumberBack == 2) { // 1900����  
		                age = (int)(today * 0.0001) + 100 - (int)(personNumberFront * 0.0001) + 1;
		                if (today - (int)(today * 0.0001) * 10000 < personNumberFront - (int)(personNumberFront * 0.0001) * 10000) {
		                    realAge = age - 2;
		                } else {
		                    realAge = age - 1;
		                }
		            } else if (personNumberBack == 3 || personNumberBack == 4) { // 2000���� 
		                age = (int)(today * 0.0001) + 100 - (int)(personNumberFront * 0.0001) + 1 - 100;
		                if (today - (int)(today * 0.0001) * 10000 < personNumberFront - (int)(personNumberFront * 0.0001) * 10000) {
		                    realAge = age - 2;
		                } else {
		                    realAge = age - 1;
		                }
		            } else {}

		            // �, û�ҳ�, ���, ���̺� 
		            if (realAge >= ADULT_MIN_AGE) {
		                personType = 1; // � 
		            } else if (realAge >= TEEN_MIN_AGE && realAge < ADULT_MIN_AGE) {
		                personType = 2; // û�ҳ� 
		            } else if (realAge >= KID_MIN_AGE && realAge < KID_MAX_AGE) {
		                personType = 3; // ��� 
		            } else if (realAge > BABY_AGE_0 && realAge < KID_MAX_AGE) {
		                personType = 4; // ���̺� 
		            }

		            // ������ Ƽ���� ���� ���� 
		            if (ticketChoice == 1 && timeChoice == 1 && personType == 1) {
		                price += ALL_1DAY_ADULT;
		            } else if (ticketChoice == 1 && timeChoice == 1 && personType == 2) {
		                price += ALL_1DAY_TEEN;
		            } else if (ticketChoice == 1 && timeChoice == 1 && personType == 3) {
		                price += ALL_1DAY_KID;
		            } else if (ticketChoice == 1 && timeChoice == 1 && personType == 4) {
		                price += BABY;
		            } else if (ticketChoice == 1 && timeChoice == 2 && personType == 1) {
		                price += ALL_AFTER4_ADULT;
		            } else if (ticketChoice == 1 && timeChoice == 2 && personType == 2) {
		                price += ALL_AFTER4_TEEN;
		            } else if (ticketChoice == 1 && timeChoice == 2 && personType == 3) {
		                price += ALL_AFTER4_KID;
		            } else if (ticketChoice == 1 && timeChoice == 2 && personType == 4) {
		                price += BABY;
		            } else if (ticketChoice == 2 && timeChoice == 1 && personType == 1) {
		                price += PARK_1DAY_ADULT;
		            } else if (ticketChoice == 2 && timeChoice == 1 && personType == 2) {
		                price += PARK_1DAY_TEEN;
		            } else if (ticketChoice == 2 && timeChoice == 1 && personType == 3) {
		                price += PARK_1DAY_KID;
		            } else if (ticketChoice == 2 && timeChoice == 1 && personType == 4) {
		                price += BABY;
		            } else if (ticketChoice == 2 && timeChoice == 2 && personType == 1) {
		                price += PARK_AFTER4_ADULT;
		            } else if (ticketChoice == 2 && timeChoice == 2 && personType == 2) {
		                price += PARK_AFTER4_TEEN;
		            } else if (ticketChoice == 2 && timeChoice == 2 && personType == 3) {
		                price += PARK_AFTER4_KID;
		            } else if (ticketChoice == 2 && timeChoice == 2 && personType == 4) {
		                price += BABY;
		            } else {}

		            // ���̺� �� �ݾ�. ���Ƴ��̽ü� �̿� ���� Ȯ��. 
		            if (realAge > 0 && realAge < 1) {
		                price = FREE;
		            } else if (realAge >= 1 && realAge < 3) {
		                System.out.printf("\n\n�� 1������ 3������ ���� ���̽ü��� ����� �̿� �����մϴ�. �̿��Ͻðڽ��ϱ�?\n");
		                System.out.printf("1. �̿�O\n2. �̿�X (��ũ���� ����)\n���� : ");
		                kidsPlayroom = sc.nextInt();
		                if (kidsPlayroom == 1) {
		                    price = BABY;
		                } else if (kidsPlayroom == 2) {
		                    price = FREE;
		                }
		            } else {}

		            // ��� ��� ���� 
		            if (alwaysPrefer == 1) { // ����� 
		                price *= DISABLED;
		                System.out.printf("\n������� �� �������� ���� �� + ���� 1��\n�����̿��/��ũ�̿�� 50%% ���\n");
		            } else if (alwaysPrefer == 2) { // ���������� 
		                price *= NATIONAL_MERIT;
		                System.out.printf("\n������������ �� �������� ���� �� + ����1��\n�����̿��/��ũ�̿�� 50%% ���\n");
		            } else if (ticketChoice == 1 && alwaysPrefer == 3) { // �ް��庴�� ���� �̿�Ǹ� ����
		                price *= SODIER_ON_VACATION;
		                System.out.printf("\n�ް��庴(�ǰ�, �ǹ��ҹ��, ������ ����) �������� ���� �� + ������ 1��\n�����̿�� 49%% ���\n");
		            } else if (ticketChoice == 1 && alwaysPrefer == 4) { // �ӻ�δ� ���� �̿�Ǹ� ����
		                if (personNumberBack == 2 || personNumberBack == 4) {
		                    price *= PREGNANT;
		                    System.out.printf("\n���ڼ�ø �� �������� ���� �ӻ�� ����\n�����̿�� 50%% ���\n");
		                } else {
		                    System.out.printf("\n�ӻ�� ������ �̿��Ͻ� �� �����ϴ�.\n");
		                }
		            } else if (ticketChoice == 1 && alwaysPrefer == 5) { // �ٵ��� �ູī��� ���� �̿�Ǹ� ����
		                price *= MULTIPLE_KIDS;
		                System.out.printf("\n�ٵ��� �ູī�� ȸ�� ���� ����(ī�忡 ���� ������ ����)\n�����̿�� 30%% ���\n");
		            } else if (alwaysPrefer == 6) {
		                price = price;
		            } else {}

		            // �� 65�� �̻� ��� ��, ��� ��� ���ÿ��� �ش������ ���� ���. ��� ��� ���� 
		            if (realAge >= ADULT_MAX_AGE && ticketChoice == 1 && timeChoice == 1 && alwaysPrefer == 6) {
		                price = ALL_1DAY_KID;
		                personType = 0; // �(��ο��)
		            } else if (realAge >= ADULT_MAX_AGE && ticketChoice == 1 && timeChoice == 2 && alwaysPrefer == 6) {
		                price = ALL_AFTER4_KID;
		                personType = 0;
		            } else if (realAge >= ADULT_MAX_AGE && ticketChoice == 2 && timeChoice == 1 && alwaysPrefer == 6) {
		                price = PARK_1DAY_KID;
		                personType = 0;
		            } else if (realAge >= ADULT_MAX_AGE && ticketChoice == 2 && timeChoice == 2 && alwaysPrefer == 6) {
		                price = PARK_AFTER4_KID;
		                personType = 0;
		            } else {}
		            System.out.printf("\nƼ�� �����ݾ��� %d�� �Դϴ�.", price);

		            // �Ѿ� �ջ� 
		            totalprice += price;

		            // �迭�� ����  
		            String all = ticketChoice + "\t" + timeChoice + "\t" + personType + "\t" + ticketCount + "\t" + price + "\t" + alwaysPrefer + "\n";
					list.add(all);
		            

		            // ��ӱ��� Ȥ�� ���� 
		            System.out.printf("\n\n��� �����Ͻðڽ��ϱ�?\n");
		            System.out.printf("1. ��� ����\n2. ���� �� ���\n���� : ");
		            whetherToBuy= sc.nextInt();

		        } while (whetherToBuy == 1);

		        System.out.printf("\n\n************************* ���� ���� *************************\n");
		        System.out.printf("Ƽ������ �̿�ð�\t����\t����\t����\t���γ���\n");
		        System.out.println(list);
		       

		        System.out.printf("\n\n��� �����Ͻðڽ��ϱ�?\n");
		        System.out.printf("1. ��� ����\n2. ���� �� ���\n���� : ");
		        whetherToBuy= sc.nextInt();

		    } while (whetherToBuy == 1);
		    if (whetherToBuy == 2) {
		       System.out.printf("\n�����ϰڽ��ϴ�."); 
		   }
		}
}