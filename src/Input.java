package Practice;

import java.util.Scanner;

public class Input {
	OrderData data;
	Scanner sc = new Scanner(System.in);

	// Ƽ�� ���� �����ϱ� (�����̿��, ��ũ�̿��)
	public void TicketChoice() {
		data = new OrderData();
		System.out.printf("\n\n�� �̿���� �������ּ���. (�����̿���� �μӹڹ������� ���������մϴ�.)\n\n");
		do {
			System.out.printf("�� �����̿��  �� ��ũ�̿��\n���� : ");
			data.setTicketChoice(sc.nextInt());
			if (!(data.getTicketChoice() == StaticValue.ALL_PASS || data.getTicketChoice() == StaticValue.PARK_PASS)) {
				System.out.printf("�߸��� �Է��Դϴ�. 1 �Ǵ� 2�� �Է��ϼ���.\n\n");
			}
		} while (!(data.getTicketChoice() == StaticValue.ALL_PASS || data.getTicketChoice() == StaticValue.PARK_PASS));
	}

	// ���̰��� �̿�ð� �����ϱ� (���ϱ�, After4 �̿��)
	public void TimeChoice() {
		System.out.printf("\n\n�� �̿�ð��� �������ּ���. (After4 �̿���� 4�� ���ĺ��� �̿밡���մϴ�.)\n\n");
		do {
			System.out.printf("�� 1Day  �� After4\n���� : ");
			data.setTimeChoice(sc.nextInt());
			if (!(data.getTimeChoice() == StaticValue.ALLDAY_PASS || data.getTimeChoice() == StaticValue.AFTER4_PASS)) {
				System.out.printf("�߸��� �Է��Դϴ�. 1 �Ǵ� 2�� �Է��ϼ���.\n\n");
			}
		} while (!(data.getTimeChoice() == StaticValue.ALLDAY_PASS || data.getTimeChoice() == StaticValue.AFTER4_PASS));
	}

	// �ֹε�Ϲ�ȣ �Է�
	public void IDNumber() {
		System.out.printf("\n\n�� �ֹε�Ϲ�ȣ�� �Է��� �ּ���. (���� : 123456-7)\n�Է� : ");
		data.setIDNumber(sc.next());
	}

	// Ƽ�� �� �Է�
	public void NumberOfTickets() {
		System.out.printf("\n\n�� �� ���� �����Ͻó���? (�ִ� 10��)\n");
		do {
			System.out.printf("�Է� : ");
		data.setNumberOfTickets(sc.nextInt());
		if (!(data.getNumberOfTickets() < 10)) {
			System.out.printf("�߸��� �Է��Դϴ�. 1 ���� 10������ �Է��ϼ���.\n\n");
		}
	} while (!(data.getNumberOfTickets() < 10));
	}

	// ������� ����
	public void AlwaysPrefer() {
		System.out.printf("\n\n******************************* �� �� �� ��  *******************************");
		System.out.printf("\n\n�� �ش������ �����ø� �Է��� �ּ���. ���ٸ� 0���� �Է��� �ּ���. (�ߺ� �Ұ�)\n\n");
		if (data.getTicketChoice() == 1) {
			do {
				System.out.printf("�� �ش����  �� �����  �豹��������  ���ް��庴  ���ӻ��  ��ٵ��̰���\n���� : ");
				data.setAlwaysPrefer(sc.nextInt());
				if (!(data.getAlwaysPrefer() == StaticValue.DISABLED || data.getAlwaysPrefer() == StaticValue.NATIONAL_MERIT
						|| data.getAlwaysPrefer() == StaticValue.SODIER_ON_VACATION || data.getAlwaysPrefer() == StaticValue.PREGNANT
						|| data.getAlwaysPrefer() == StaticValue.MULTIPLE_KIDS || data.getAlwaysPrefer() == StaticValue.NONE)) {
					System.out.printf("�߸��� �Է��Դϴ�. 0���� 5������ ���ڸ� �Է��ϼ���.\n\n");
				}
			} while (!(data.getAlwaysPrefer() == StaticValue.DISABLED || data.getAlwaysPrefer() == StaticValue.NATIONAL_MERIT
					|| data.getAlwaysPrefer() == StaticValue.SODIER_ON_VACATION || data.getAlwaysPrefer() == StaticValue.PREGNANT
					|| data.getAlwaysPrefer() == StaticValue.MULTIPLE_KIDS || data.getAlwaysPrefer() == StaticValue.NONE));
		} 
		
		else if (data.getTicketChoice() == 2) {
			do {
				System.out.printf("�� �ش����  �� �����  �豹��������\n���� : ");
				data.setAlwaysPrefer(sc.nextInt());
				if (!(data.getAlwaysPrefer() == StaticValue.DISABLED || data.getAlwaysPrefer() == StaticValue.NATIONAL_MERIT || data.getAlwaysPrefer() == StaticValue.NONE)) {
					System.out.printf("�߸��� �Է��Դϴ�. 0���� 2������ ���ڸ� �Է��ϼ���.\n\n");
				}
			} while (!(data.getAlwaysPrefer() == StaticValue.DISABLED || data.getAlwaysPrefer() == StaticValue.NATIONAL_MERIT || data.getAlwaysPrefer() == StaticValue.NONE));
		}
	}
	
	// ���ų��� Ȯ������ ���� (��ӱ���, ���� �� ���)
	public void WhetherToBuy() {
		System.out.printf("\n\n�� �̾ �����Ͻðڽ��ϱ�? ���ų����� Ȯ���Ͻðڽ��ϱ�?\n\n");
		do {
			System.out.printf("�� ��� ����  �� ���ų���Ȯ��\n���� : ");
			data.setWhetherToBuy(sc.nextInt());
			if (!(data.getWhetherToBuy() == StaticValue.KEEP_BUYING || data.getWhetherToBuy() == StaticValue.PRICE_CHECK)) {
				System.out.printf("�߸��� �Է��Դϴ�. 1 �Ǵ� 2�� �Է��ϼ���.\n\n");
			}
		} while (!(data.getWhetherToBuy() == StaticValue.KEEP_BUYING || data.getWhetherToBuy() == StaticValue.PRICE_CHECK));
	}
	
	// �߰��� �������� ���� (��ӱ���, ���� �� ���)
	public void ExitOrNot() {
		System.out.printf("\n\n�� �̾ �����Ͻðڽ��ϱ�? ���� �� �����Ͻðڽ��ϱ�?\n\n");
		do {
			System.out.printf("�� ��� ����  �� ���� �� ����\n���� : ");
			data.setWhetherToBuy(sc.nextInt());
			if (!(data.getWhetherToBuy() == StaticValue.KEEP_BUYING || data.getWhetherToBuy() == StaticValue.EXIT)) {
				System.out.printf("�߸��� �Է��Դϴ�. 1 �Ǵ� 2�� �Է��ϼ���.\n\n");
			}
		} while (!(data.getWhetherToBuy() == StaticValue.KEEP_BUYING || data.getWhetherToBuy() == StaticValue.EXIT));
	}
}