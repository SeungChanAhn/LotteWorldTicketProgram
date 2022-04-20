package Practice;

import java.util.Scanner;

public class Input {
	OrderData data;
	Scanner sc = new Scanner(System.in);

	// Ƽ�� ���� �����ϱ� (�����̿��, ��ũ�̿��)
	public void TicketChoice() {
		data = new OrderData();
		data.price = 0;
		do {
			System.out.printf("1. �����̿�� (�̿���� : �Ե����� + �μӹڹ���)\n2. ��ũ�̿�� (�̿���� : �Ե�����)\n���� : ");
			data.ticketChoice = sc.nextInt();
			if (!(data.ticketChoice == StaticValue.ALL_PASS || data.ticketChoice == StaticValue.PARK_PASS)) {
				System.out.printf("�߸��� �Է��Դϴ�. 1 �Ǵ� 2�� �Է��ϼ���.\n\n");
			}
		} while (!(data.ticketChoice == StaticValue.ALL_PASS || data.ticketChoice == StaticValue.PARK_PASS));
	}

	// ���̰��� �̿�ð� �����ϱ� (���ϱ�, After4 �̿��)
	public void TimeChoice() {
		do {
			System.out.printf("\n1. 1Day �̿��\n2. After4 �̿��(�̿�ð� : ���� 4�ú��� ����)\n���� : ");
			data.timeChoice = sc.nextInt();
			if (!(data.timeChoice == StaticValue.ALLDAY_PASS || data.timeChoice == StaticValue.AFTER4_PASS)) {
				System.out.printf("�߸��� �Է��Դϴ�. 1 �Ǵ� 2�� �Է��ϼ���.\n\n");
			}
		} while (!(data.timeChoice == StaticValue.ALLDAY_PASS || data.timeChoice == StaticValue.AFTER4_PASS));
	}

	// �߰��� �������� ���� (��ӱ���, ���� �� ���)
	public void WhetherToBuy() {
		do {
			System.out.printf("\n1. ��� ����\n2. ���� �� ���\n���� : ");
			data.WhetherToBuy = sc.nextInt();
			if (!(data.WhetherToBuy == StaticValue.KEEP_BUYING || data.WhetherToBuy == StaticValue.EXIT)) {
				System.out.printf("�߸��� �Է��Դϴ�. 1 �Ǵ� 2�� �Է��ϼ���.\n\n");
			}
		} while (!(data.WhetherToBuy == StaticValue.KEEP_BUYING || data.WhetherToBuy == StaticValue.EXIT));
	}

	// �ֹε�Ϲ�ȣ �Է�
	public void IDNumber() {
		System.out.printf("\n�ֹε�Ϲ�ȣ �� �Է��� �ּ���. (�� : 123456-7)\n�Է� : ");
		data.IDNumber = sc.next();
	}

	// Ƽ�� �� �Է�
	public void NumberOfTickets() {
		System.out.printf("\n\n������ �����Ͻðڽ��ϱ�?\n");
		data.numberOfTickets = sc.nextInt();
	}

	// ������� ����
	public void AlwaysPrefer() {
		System.out.printf("***************************** �� �� �� ��  *****************************");
		System.out.printf("\n\n�ش������ �����ø� �Է��� �ּ���. ���ٸ� 6���� �Է��� �ּ���. (�ߺ� �Ұ�)\n");
		do {
			System.out.printf("1. �����\n2. ����������\n3. �ް��庴\n4. �ӻ��\n5. �ٵ��� �ູī��\n6. �ش���� ����\n���� : ");
			data.alwaysPrefer = sc.nextInt();
			if (!(data.alwaysPrefer == StaticValue.DISABLED || data.alwaysPrefer == StaticValue.NATIONAL_MERIT
					|| data.alwaysPrefer == StaticValue.SODIER_ON_VACATION || data.alwaysPrefer == StaticValue.PREGNANT
					|| data.alwaysPrefer == StaticValue.MULTIPLE_KIDS || data.alwaysPrefer == StaticValue.NONE)) {
				System.out.printf("�߸��� �Է��Դϴ�. 1���� 6������ ���ڸ� �Է��ϼ���.\n\n");
			}
		} while (!(data.alwaysPrefer == StaticValue.DISABLED || data.alwaysPrefer == StaticValue.NATIONAL_MERIT
				|| data.alwaysPrefer == StaticValue.SODIER_ON_VACATION || data.alwaysPrefer == StaticValue.PREGNANT
				|| data.alwaysPrefer == StaticValue.MULTIPLE_KIDS || data.alwaysPrefer == StaticValue.NONE));
	}
}
