package Practice;

public class TicketingSystem {

	public void TicketingSystem() {
		Input input;
		input = new Input();

		Calculation cal;
		cal = new Calculation(input);

		Print print;
		print = new Print(cal);
		
		CSVfile cf  = new CSVfile (cal);
		
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
				
				// ��� �������� ������ ������ Ȯ������ ���ùޱ�.
				input.WhetherToBuy();
				
				// �Է� ���� ���ڸ� ���������� ���� ���� ���ڷ� ��ȯ
				print.ReadyPrintReceipt();
				
			} while (input.data.getWhetherToBuy() == 1);
			
			// ������ ���
			print.printReceipt();
			
			// ������ ������ Ȯ���ϰ�, ��� �������� �����ϰ� ������� ���ùޱ�.
			input.ExitOrNot();
			
		} while (input.data.getWhetherToBuy() == 1);
		System.out.println("\nƼ�� �߱����α׷��� �����մϴ�. �̿����ּż� �����մϴ�.");
		
		
		print.writeCsv(print.analysisList); // ���ų����� CSV���Ϸ� ����
		
		print.readCSVFile(); // CSV ������ �迭�� �����ϰ� ����Ѵ�.
		
		print.TicketTypeAnalysis(); // ������ ����ǥ
		
		print.TicketTimeAnalysis(); // �̿�ð��� ����ǥ
		
		print.preferAnalysis(); // ���� �Ǹ���Ȳǥ
	}
}
