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
				
				// �Է� ���� ���ڸ� ���������� ���� ���� ���ڷ� ��ȯ
				receipt.ReadyPrintReceipt();
				
			} while (input.data.getWhetherToBuy() == 1);
			
			// ������ ���
			receipt.printReceipt();
			
			// ������ ������ Ȯ���ϰ�, ��� �������� �����ϰ� ������� ���ùޱ�.
			input.ExitOrNot();
			
		} while (input.data.getWhetherToBuy() == 1);
		System.out.println("\nƼ�� �߱����α׷��� �����մϴ�. �̿����ּż� �����մϴ�.");
		
		receipt.writeCsv(receipt.analysisList); // ���ų��� CSV���Ϸ� ����
		
		receipt.readCSVFile(); // CSV ������ �о�´�.
		
		
	}
}
