package Practice;

public class TicketingSystem {

	public void TicketingSystem() {
		Input input;
		input = new Input();

		Calculation cal;
		cal = new Calculation(input);

		Receipt receipt;
		receipt = new Receipt(cal);
		
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
				System.out.println(input.data.price);
				System.out.println(input.data.priceSum);
				System.out.println(input.data.totalPrice);
				
				// 계속 구매
				input.WhetherToBuy();
				receipt.changeST();				
			} while (input.data.WhetherToBuy == 1);
			// 출력
			receipt.printReceipt();
			input.WhetherToBuy();
		} while (input.data.WhetherToBuy == 1);
		System.out.println("종료합니다.");
	}
}
