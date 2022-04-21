package Practice;

import java.util.ArrayList;

public class ReceiptPrint {	
	Calculation cal;
	ReceiptPrint(Calculation cal) {
		this.cal = cal;
	}

	ArrayList orderList = new ArrayList();
	ArrayList price = new ArrayList();
	
	public void changeST() {	
		String ticket = null;
		String time = null;
		String ageCategory = null;
		String ticketCount = null;
		String prefer = null;

		switch (cal.input.data.ticketChoice) {
		case 1:
			ticket = "�����̿��";
			break;
		case 2:
			ticket = "��ũ�̿��";
			break;
		}

		switch (cal.input.data.timeChoice) {
		case 1:
			time = "���ϱ�";
			break;
		case 2:
			time = "After4";
			break;
		}
		
		switch (cal.input.data.personTypeByAge) {
		case 0:
			ageCategory = "����";
			break;
		case 1:
			ageCategory = "�";
			break;
		case 2:
			ageCategory = "û�ҳ�";
			break;
		case 3:
			ageCategory = "���";
			break;
		case 4:
			ageCategory = "���̺�";
			break;
		}
		
		switch (cal.input.data.alwaysPrefer) {
		case 0:
			prefer = "��� ���";
			break;
		case 1:
			prefer = "����� ���";
			break;
		case 2:
			prefer = "���������� ���";
			break;
		case 3:
			prefer = "�ް����� ���";
			break;
		case 4:
			prefer = "�ӻ�� ���";
			break;
		case 5:
			prefer = "�ٵ��̰��� ���";
			break;
		case 6:
			prefer = "�ش���� ����";
			break;
		}

		String all = ticket + "\t\t" + time + "\t\t\t" + ageCategory + "\t\t" + cal.input.data.numberOfTickets + "��" + "\t\t" + cal.input.data.priceSum + "��" + "\t\t" + prefer + "\n";
		orderList.add(all);
		price.add(cal.input.data.priceSum);
		

	}

	public void printReceipt() {
		int sum = 0;
		for (int i = 0; i < price.size(); i++) {
			sum += (int) price.get(i);
		}
		System.out.printf(
				"=============================================================================================================\n");
		System.out.printf("\n\n                                                �� �� �� ��\n");
		System.out.printf("\n                                                     \n");
		System.out.printf(
				"=============================================================================================================\n");
		System.out.printf("Ƽ������\t\t�̿�ð�\t\t����\t\t����\t\t����\t\t���γ���\n");
		System.out.printf(
				"-------------------------------------------------------------------------------------------------------------\n");
		for (int i = 0; i < orderList.size(); i++) {
			System.out.println(orderList.get(i));
		}
		System.out.printf(
				"\n-------------------------------------------------------------------------------------------------------------\n");
		System.out.printf("�����ݾ�\t\t\t\t\t\t\t\t\t\t%19d��", sum);
		System.out.printf(
				"\n=============================================================================================================\n");
	}
}