package Practice;

public class TicketingSystem {

	public void TicketingSystem() {
		Input input;
		input = new Input();

		Calculation cal;
		cal = new Calculation(input);

		ReceiptPrint receipt;
		receipt = new ReceiptPrint(cal);
		
		do {
			do {
				// �Է�
				input.TicketChoice();
				input.TimeChoice();
				input.IDNumber();
				input.NumberOfTickets();
				input.AlwaysPrefer();
				// ���
				cal.InternationalAge();
				cal.AgeCategory();
				cal.PriceByAge();
				cal.UseKidplayroom();
				cal.PriceByPrefer();
				cal.PriceByNoPreferOld();
				cal.AddPrice();
				// ��� ����
				input.WhetherToBuy();
				// �Է��� ���ڸ� ���ڷ� ����ϱ� ���� ����
				receipt.changeST();				
			} while (input.data.WhetherToBuy == 1);
			// ���
			receipt.printReceipt();
			// ��� ����
			input.WhetherToBuy();
		} while (input.data.WhetherToBuy == 1);
		System.out.println("�����մϴ�.");
	}
}
