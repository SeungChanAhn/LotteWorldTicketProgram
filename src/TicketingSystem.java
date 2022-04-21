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
				
				// 계속 구매할지 영수증 가격을 확인할지 선택받기.
				input.WhetherToBuy();
				
				// 입력 받은 숫자를 영수증에서 보기 쉽게 문자로 변환
				print.ReadyPrintReceipt();
				
			} while (input.data.getWhetherToBuy() == 1);
			
			// 영수증 출력
			print.printReceipt();
			
			// 영수증 가격을 확인하고, 계속 구매할지 종료하고 계산할지 선택받기.
			input.ExitOrNot();
			
		} while (input.data.getWhetherToBuy() == 1);
		System.out.println("\n티켓 발권프로그램을 종료합니다. 이용해주셔서 감사합니다.");
		
		
		print.writeCsv(print.analysisList); // 구매내역을 CSV파일로 저장
		
		print.readCSVFile(); // CSV 파일을 배열에 저장하고 출력한다.
		
		print.TicketTypeAnalysis(); // 권종별 매출표
		
		print.TicketTimeAnalysis(); // 이용시간별 매출표
		
		print.preferAnalysis(); // 우대권 판매현황표
	}
}
