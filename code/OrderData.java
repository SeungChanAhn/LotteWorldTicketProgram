package Practice;

public class OrderData {
	private int ticketChoice;
	private int timeChoice;
	private int price;
	private int priceSum;
	private int totalPrice;
	private int WhetherToBuy;
	private String IDNumber;
	private int numberOfTickets;
	private int alwaysPrefer;
	private int today, year, month, day;
	private int IDNumber_Front;
	private int gender;
	private int age, realAge;
	private int personTypeByAge;
	private int kidsPlayroom;
	
	
	public int getTicketChoice() {
		return ticketChoice;
	}
	public void setTicketChoice(int ticketChoice) {
		this.ticketChoice = ticketChoice;
	}
	public int getTimeChoice() {
		return timeChoice;
	}
	public void setTimeChoice(int timeChoice) {
		this.timeChoice = timeChoice;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = (int) price;
	}
	public int getPriceSum() {
		return priceSum;
	}
	public void setPriceSum(int priceSum) {
		this.priceSum = priceSum;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getWhetherToBuy() {
		return WhetherToBuy;
	}
	public void setWhetherToBuy(int whetherToBuy) {
		WhetherToBuy = whetherToBuy;
	}
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	public int getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	public int getAlwaysPrefer() {
		return alwaysPrefer;
	}
	public void setAlwaysPrefer(int alwaysPrefer) {
		this.alwaysPrefer = alwaysPrefer;
	}
	public int getToday() {
		return today;
	}
	public void setToday(int today) {
		this.today = today;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getIDNumber_Front() {
		return IDNumber_Front;
	}
	public void setIDNumber_Front(int iDNumber_Front) {
		IDNumber_Front = iDNumber_Front;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getRealAge() {
		return realAge;
	}
	public void setRealAge(int realAge) {
		this.realAge = realAge;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPersonTypeByAge() {
		return personTypeByAge;
	}
	public void setPersonTypeByAge(int personTypeByAge) {
		this.personTypeByAge = personTypeByAge;
	}
	public int getKidsPlayroom() {
		return kidsPlayroom;
	}
	public void setKidsPlayroom(int kidsPlayroom) {
		this.kidsPlayroom = kidsPlayroom;
	}
}