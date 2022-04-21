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
				// 입력
				input.TicketChoice();
				input.TimeChoice();
				input.IDNumber();
				input.NumberOfTickets();
				input.AlwaysPrefer();
				// 계산
				cal.InternationalAge();
				cal.AgeCategory();
				cal.PriceByAge();
				cal.UseKidplayroom();
				cal.PriceByPrefer();
				cal.PriceByNoPreferOld();
				cal.AddPrice();
				// 계속 구매
				input.WhetherToBuy();
				// 입력한 숫자를 문자로 출력하기 위해 변경
				receipt.changeST();				
			} while (input.data.WhetherToBuy == 1);
			// 출력
			receipt.printReceipt();
			// 계속 구매
			input.WhetherToBuy();
		} while (input.data.WhetherToBuy == 1);
		System.out.println("종료합니다.");
	}
}
