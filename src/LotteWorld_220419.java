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

		Calendar cal = Calendar.getInstance(); // ���� ��¥ ��������
		SimpleDateFormat sdt = new SimpleDateFormat("YYMMdd");
		int today = Integer.parseInt(sdt.format(cal.getTime())); // ��¥ ���� �ֹι�ȣ�� ����� ���� '220418'ó�� ���������� ��ȯ
		int age; // �⺻ ����
		int realAge = 0; // �� ����
		int orderCount = 0; // �迭�� �� (�ֹ���)

		do {
			do {
				orderItem.price = 0; // ���� �ʱ�ȭ

				System.out.printf("***************************** Ƽ �� �� �� *****************************\n\n");
				System.out.printf("1. �����̿�� (�̿���� : �Ե����� + �μӹڹ���)\n2. ��ũ�̿�� (�̿���� : �Ե�����)\n���� : ");
				orderItem.ticketChoice = sc.nextInt();

				System.out.printf("\n1. 1Day �̿��\n2. After4 �̿��(�̿�ð� : ���� 4�ú��� ����)\n���� : ");
				orderItem.timeChoice = sc.nextInt();

				System.out.printf("\n�ֹε�Ϲ�ȣ �� �Է��� �ּ���. (�� : 123456-7)\n�Է� : ");
				orderItem.IDNumber = sc.next();

				System.out.printf("***************************** �� �� �� ��  *****************************");
				System.out.printf("\n\n�ش������ �����ø� �Է��� �ּ���. ���ٸ� 6���� �Է��� �ּ���. (�ߺ� �Ұ�)\n");
				System.out.printf("1. �����\n2. ����������\n3. �ް��庴\n4. �ӻ��\n5. �ٵ��� �ູī��\n6. �ش���� ����\n���� : ");
				orderItem.alwaysPrefer = sc.nextInt();

				// �� ���̰��
				orderItem.year = Integer.parseInt(orderItem.IDNumber.substring(0, 2));
				orderItem.month = Integer.parseInt(orderItem.IDNumber.substring(2, 4));
				orderItem.day = Integer.parseInt(orderItem.IDNumber.substring(4, 6));
				orderItem.IDNumber_Front = Integer.parseInt(orderItem.IDNumber.substring(0, 6));
				orderItem.gender = Integer.parseInt(orderItem.IDNumber.substring(7, 8));

				if (orderItem.gender == 1 || orderItem.gender == 2) { // 1900����
					age = (int) (today * 0.0001) + 100 - (int) (orderItem.IDNumber_Front * 0.0001) + 1;
					if (today - (int) (today * 0.0001) * 10000 < orderItem.IDNumber_Front
							- (int) (orderItem.IDNumber_Front * 0.0001) * 10000) {
						realAge = age - 2;
					} else {
						realAge = age - 1;
					}
				} else if (orderItem.gender == 3 || orderItem.gender == 4) { // 2000����
					age = (int) (today * 0.0001) + 100 - (int) (orderItem.IDNumber_Front * 0.0001) + 1 - 100;
					if (today - (int) (today * 0.0001) * 10000 < orderItem.IDNumber_Front
							- (int) (orderItem.IDNumber_Front * 0.0001) * 10000) {
						realAge = age - 2;
					} else {
						realAge = age - 1;
					}
				} else {
				}

				// �, û�ҳ�, ���, ���̺�
				if (realAge >= StaticValue.ADULT_MIN_AGE) {
					orderItem.personType = 1; // �
				} else if (realAge >= StaticValue.TEEN_MIN_AGE && realAge < StaticValue.ADULT_MIN_AGE) {
					orderItem.personType = 2; // û�ҳ�
				} else if (realAge >= StaticValue.KID_MIN_AGE && realAge < StaticValue.KID_MAX_AGE) {
					orderItem.personType = 3; // ���
				} else if (realAge > StaticValue.BABY_AGE_0 && realAge < StaticValue.KID_MAX_AGE) {
					orderItem.personType = 4; // ���̺�
				}

				// ������ Ƽ���� ���� ����
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

				// ���̺� �� �ݾ�. ���Ƴ��̽ü� �̿� ���� Ȯ��.
				if (realAge > 0 && realAge < 1) {
					orderItem.price = StaticValue.FREE;
				} else if (realAge >= 1 && realAge < 3) {
					System.out.printf("\n\n�� 1������ 3������ ���� ���̽ü��� ����� �̿� �����մϴ�. �̿��Ͻðڽ��ϱ�?\n");
					System.out.printf("1. �̿�O\n2. �̿�X (��ũ���� ����)\n���� : ");
					orderItem.kidsPlayroom = sc.nextInt();
					if (orderItem.kidsPlayroom == 1) {
						orderItem.price = StaticValue.BABY;
					} else if (orderItem.kidsPlayroom == 2) {
						orderItem.price = StaticValue.FREE;
					}
				} else {
				}

				// ��� ��� ����
				if (orderItem.alwaysPrefer == 1) { // �����
					orderItem.price *= StaticValue.DISABLED;
					System.out.printf("\n������� �� �������� ���� �� + ���� 1��\n�����̿��/��ũ�̿�� 50%% ���\n");
				} else if (orderItem.alwaysPrefer == 2) { // ����������
					orderItem.price *= StaticValue.NATIONAL_MERIT;
					System.out.printf("\n������������ �� �������� ���� �� + ����1��\n�����̿��/��ũ�̿�� 50%% ���\n");
				} else if (orderItem.ticketChoice == 1 && orderItem.alwaysPrefer == 3) { // �ް��庴�� ���� �̿�Ǹ� ����
					orderItem.price *= StaticValue.SODIER_ON_VACATION;
					System.out.printf("\n�ް��庴(�ǰ�, �ǹ��ҹ��, ������ ����) �������� ���� �� + ������ 1��\n�����̿�� 49%% ���\n");
				} else if (orderItem.ticketChoice == 1 && orderItem.alwaysPrefer == 4) { // �ӻ�δ� ���� �̿�Ǹ� ����
					if (orderItem.gender == 2 || orderItem.gender == 4) {
						orderItem.price *= StaticValue.PREGNANT;
						System.out.printf("\n���ڼ�ø �� �������� ���� �ӻ�� ����\n�����̿�� 50%% ���\n");
					} else {
						orderItem.alwaysPrefer = 6;
						System.out.printf("\n�ӻ�� ������ �̿��Ͻ� �� �����ϴ�.\n");
					}
				} else if (orderItem.ticketChoice == 1 && orderItem.alwaysPrefer == 5) { // �ٵ��� �ູī��� ���� �̿�Ǹ� ����
					orderItem.price *= StaticValue.MULTIPLE_KIDS;
					System.out.printf("\n�ٵ��� �ູī�� ȸ�� ���� ����(ī�忡 ���� ������ ����)\n�����̿�� 30%% ���\n");
				} else if (orderItem.alwaysPrefer == 6) { // �ش���� ����
					orderItem.price = orderItem.price;
				} else {
				}

				// �� 65�� �̻� ��� ��, ��� ��� ���ÿ��� �ش������ ���� ���. ��� ��� ����
				if (realAge >= StaticValue.ADULT_MAX_AGE && orderItem.ticketChoice == 1 && orderItem.timeChoice == 1
						&& orderItem.alwaysPrefer == 6) {
					orderItem.price = StaticValue.ALL_1DAY_KID;
					orderItem.personType = 0; // ������ personType�� 0 ����
					orderItem.alwaysPrefer = 0; // ��ο�� ��� ��� ����, alwaysPrefer�� 0 ����
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

				// Ƽ�� ��
				System.out.printf("\n\n������ �����Ͻðڽ��ϱ�?\n");
				orderItem.ticketCount = sc.nextInt();

				// �Ѿ� �ջ�
				orderItem.sumPrice = orderItem.ticketCount * orderItem.price; // ���� �ֹ��ϴ� Ƽ�ϵ��� ������
				orderItem.totalprice += orderItem.sumPrice; // �ֹ��� ��� Ƽ�ϰ���

				// �迭�� ���� ��� ���ڷ�
				////////////////////////////////////////
				String ticketChoice_ST = null;
				String timeChoice_ST = null;
				String personType_ST = null;
				String alwaysPrefer_ST = null;

				switch (orderItem.ticketChoice) {
				case 1:
					ticketChoice_ST = "�����̿��";
					break;
				case 2:
					ticketChoice_ST = "��ũ�̿��";
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
					personType_ST = "����";
					break;
				case 1:
					personType_ST = "�";
					break;
				case 2:
					personType_ST = "û�ҳ�";
					break;
				case 3:
					personType_ST = "���";
					break;
				case 4:
					personType_ST = "���̺�";
					break;
				}
				////////////////////////////////////////
				switch (orderItem.alwaysPrefer) {
				case 0:
					alwaysPrefer_ST = "��� ���";
					break;
				case 1:
					alwaysPrefer_ST = "����� ���";
					break;
				case 2:
					alwaysPrefer_ST = "���������� ���";
					break;
				case 3:
					alwaysPrefer_ST = "�ް����� ���";
					break;
				case 4:
					alwaysPrefer_ST = "�ӻ�� ���";
					break;
				case 5:
					alwaysPrefer_ST = "�ٵ��̰��� ���";
					break;
				case 6:
					alwaysPrefer_ST = "�ش���� ����";
					break;
				}
				////////////////////////////////////////
				// ���� �� ����ϱ� ���ؼ� String �� all ��������
				String all = ticketChoice_ST + "\t\t" + timeChoice_ST + "\t\t\t" + personType_ST + "\t\t"
						+ orderItem.ticketCount + "��" + "\t\t" + orderItem.sumPrice + "��" + "\t" + alwaysPrefer_ST
						+ "\n";

				// arraylist�� �߰�
				orderList.add(all);
				orderCount++;
				// ��ӱ��� Ȥ�� ����
				System.out.printf("\n\n��� �����Ͻðڽ��ϱ�?\n");
				System.out.printf("1. ��� ����\n2. ���� �� ���\n���� : ");
				orderItem.whetherToBuy = sc.nextInt();

			} while (orderItem.whetherToBuy == 1);

			System.out.printf(
					"=============================================================================================================\n");
			System.out.printf("\n\n                                                �� �� �� ��\n");
			System.out.printf("\n                                                     \n");
			System.out.printf(
					"=============================================================================================================\n");
			System.out.printf("%s%12s%14s%5s%9s%12s\n", "Ƽ������", "�̿�ð�", "����", "����", "����", "���γ���");
			System.out.printf(
					"-------------------------------------------------------------------------------------------------------------\n");
			for (int i = 0; i < orderCount; i++) {
				System.out.println(orderList.get(i));
			}
			System.out.printf(
					"\n-------------------------------------------------------------------------------------------------------------\n");
			System.out.printf("�����ݾ�\t\t\t\t\t\t\t\t\t\t%19d��", orderItem.totalprice);
			System.out.printf(
					"\n=============================================================================================================\n");

			System.out.printf("\n\n��� �����Ͻðڽ��ϱ�?\n");
			System.out.printf("1. ��� ����\n2. ���� �� ���\n���� : ");
			orderItem.whetherToBuy = sc.nextInt();

		} while (orderItem.whetherToBuy == 1);
		System.out.printf("\n�����ϰڽ��ϴ�. �����մϴ�.");
	}
}
