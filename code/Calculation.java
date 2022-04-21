package Practice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Calculation {
	Scanner sc = new Scanner(System.in);
	Input input;

	Calculation(Input input) {
		this.input = input;
	}

	// �Է¹��� �ֹε�Ϲ�ȣ�� �������� ������ ����ϱ�
	public void InternationalAge() {
		Calendar calendar = Calendar.getInstance(); // ���� ��¥ ��������
		SimpleDateFormat sdt = new SimpleDateFormat("YYMMdd");
		input.data.today = Integer.parseInt(sdt.format(calendar.getTime())); // ��¥ ���� �ֹι�ȣ�� ����� ���� '220420'ó�� ���������� ��ȯ

		input.data.year = Integer.parseInt(input.data.IDNumber.substring(0, 2));
		input.data.month = Integer.parseInt(input.data.IDNumber.substring(2, 4));
		input.data.day = Integer.parseInt(input.data.IDNumber.substring(4, 6));
		input.data.IDNumber_Front = Integer.parseInt(input.data.IDNumber.substring(0, 6));
		input.data.gender = Integer.parseInt(input.data.IDNumber.substring(7, 8));

		if (input.data.gender == StaticValue.MAN_1900 || input.data.gender == StaticValue.WOMAN_1900) { // 1900����
			input.data.age = (int) (input.data.today * 0.0001) + 100 - (int) (input.data.IDNumber_Front * 0.0001) + 1;
			if (input.data.today - (int) (input.data.today * 0.0001) * 10000 < input.data.IDNumber_Front
					- (int) (input.data.IDNumber_Front * 0.0001) * 10000) {
				input.data.realAge = input.data.age - 2;
			} else {
				input.data.realAge = input.data.age - 1;
			}
		} else if (input.data.gender == StaticValue.MAN_2000 || input.data.gender == StaticValue.WOMAN_2000) { // 2000����
			input.data.age = (int) (input.data.today * 0.0001) + 100 - (int) (input.data.IDNumber_Front * 0.0001) + 1
					- 100;
			if (input.data.today - (int) (input.data.today * 0.0001) * 10000 < input.data.IDNumber_Front
					- (int) (input.data.IDNumber_Front * 0.0001) * 10000) {
				input.data.realAge = input.data.age - 2;
			} else {
				input.data.realAge = input.data.age - 1;
			}
		} else {
		}
	}

	// ���� ī�װ� ������
	public void AgeCategory() {
		if (input.data.realAge > StaticValue.ADULT_MAX_AGE) {
			input.data.personTypeByAge = StaticValue.OLDPERSON; // ����
		} else if (input.data.realAge >= StaticValue.ADULT_MIN_AGE) {
			input.data.personTypeByAge = StaticValue.ADULT; // �
		} else if (input.data.realAge >= StaticValue.TEEN_MIN_AGE && input.data.realAge < StaticValue.ADULT_MIN_AGE) {
			input.data.personTypeByAge = StaticValue.TEEN; // û�ҳ�
		} else if (input.data.realAge >= StaticValue.KID_MIN_AGE && input.data.realAge < StaticValue.KID_MAX_AGE) {
			input.data.personTypeByAge = StaticValue.KID; // ���
		} else if (input.data.realAge > StaticValue.BABY_AGE_0 && input.data.realAge < StaticValue.KID_MAX_AGE) {
			input.data.personTypeByAge = StaticValue.BABY; // ���̺�
		}
	}

	// ���̷� �ݾ� �����ϱ�
	public void PriceByAge() {
		if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.ADULT) {
			input.data.price += StaticValue.ALL_1DAY_ADULT;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.TEEN) {
			input.data.price += StaticValue.ALL_1DAY_TEEN;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.KID) {
			input.data.price += StaticValue.ALL_1DAY_KID;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.BABY) {
			input.data.price += StaticValue.BABY;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.ADULT) {
			input.data.price += StaticValue.ALL_AFTER4_ADULT;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.TEEN) {
			input.data.price += StaticValue.ALL_AFTER4_TEEN;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.KID) {
			input.data.price += StaticValue.ALL_AFTER4_KID;
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.BABY) {
			input.data.price += StaticValue.BABY;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.ADULT) {
			input.data.price += StaticValue.PARK_1DAY_ADULT;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.TEEN) {
			input.data.price += StaticValue.PARK_1DAY_TEEN;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.KID) {
			input.data.price += StaticValue.PARK_1DAY_KID;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.ALLDAY_PASS
				&& input.data.personTypeByAge == StaticValue.BABY) {
			input.data.price += StaticValue.BABY;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.ADULT) {
			input.data.price += StaticValue.PARK_AFTER4_ADULT;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.TEEN) {
			input.data.price += StaticValue.PARK_AFTER4_TEEN;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.KID) {
			input.data.price += StaticValue.PARK_AFTER4_KID;
		} else if (input.data.ticketChoice == StaticValue.PARK_PASS && input.data.timeChoice == StaticValue.AFTER4_PASS
				&& input.data.personTypeByAge == StaticValue.BABY) {
			input.data.price += StaticValue.BABY;
		} else {
		}
	}

	// ���Ƴ��̽ü� �̿뿡 ���� �ݾ� ����
	public void UseKidplayroom() {
		if (input.data.realAge > StaticValue.BABY_AGE_0 && input.data.realAge < StaticValue.BABY_AGE_1) {
			input.data.price = StaticValue.PRICE_FREE;
		} else if (input.data.realAge >= StaticValue.BABY_AGE_1 && input.data.realAge < StaticValue.KID_MIN_AGE) {
			System.out.printf("\n\n�� 1������ 3������ ���� ���̽ü��� ����� �̿� �����մϴ�. �̿��Ͻðڽ��ϱ�?\n");

			do {
				System.out.printf("1. �̿�O\n2. �̿�X (��ũ���� ����)\n���� : ");
				input.data.kidsPlayroom = sc.nextInt();
				if (!(input.data.kidsPlayroom == StaticValue.KIDPLAYROOM_O
						|| input.data.kidsPlayroom == StaticValue.KIDPLAYROOM_X)) {
					System.out.printf("�߸��� �Է��Դϴ�. 1 �Ǵ� 2�� �Է��ϼ���.\n\n");
				}
			} while (!(input.data.kidsPlayroom == StaticValue.KIDPLAYROOM_O
					|| input.data.kidsPlayroom == StaticValue.KIDPLAYROOM_X));

			if (input.data.kidsPlayroom == StaticValue.KIDPLAYROOM_O) {
				input.data.price = StaticValue.PRICE_BABY;
			} else if (input.data.kidsPlayroom == StaticValue.KIDPLAYROOM_X) {
				input.data.price = StaticValue.PRICE_FREE;
			}
		} else {
		}
	}

	// �����׺� �ݾ� ����
	public void PriceByPrefer() {
		if (input.data.alwaysPrefer == StaticValue.DISABLED) { // �����
			input.data.price *= StaticValue.DISABLED_RATE;
			System.out.printf("\n������� �� �������� ���� �� + ���� 1��\n�����̿��/��ũ�̿�� 50%% ���\n");
		} else if (input.data.alwaysPrefer == StaticValue.NATIONAL_MERIT) { // ����������
			input.data.price *= StaticValue.NATIONAL_MERIT_RATE;
			System.out.printf("\n������������ �� �������� ���� �� + ����1��\n�����̿��/��ũ�̿�� 50%% ���\n");
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS
				&& input.data.alwaysPrefer == StaticValue.SODIER_ON_VACATION) { // �ް��庴�� ���� �̿�Ǹ� ����
			input.data.price *= StaticValue.SODIER_ON_VACATION_RATE;
			System.out.printf("\n�ް��庴(�ǰ�, �ǹ��ҹ��, ������ ����) �������� ���� �� + ������ 1��\n�����̿�� 49%% ���\n");
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS && input.data.alwaysPrefer == StaticValue.PREGNANT) { // �ӻ�δ�
																															// ����
																															// �̿�Ǹ�
																															// ����
			if (input.data.gender == StaticValue.WOMAN_1900 || input.data.gender == StaticValue.WOMAN_2000) {
				input.data.price *= StaticValue.PREGNANT_RATE;
				System.out.printf("\n���ڼ�ø �� �������� ���� �ӻ�� ����\n�����̿�� 50%% ���\n");
			} else {
				input.data.alwaysPrefer = StaticValue.NONE;
				System.out.printf("\n�ӻ�� ������ �̿��Ͻ� �� �����ϴ�.\n");
			}
		} else if (input.data.ticketChoice == StaticValue.ALL_PASS
				&& input.data.alwaysPrefer == StaticValue.MULTIPLE_KIDS) { // �ٵ��� �ູī��� ���� �̿�Ǹ� ����
			input.data.price *= StaticValue.MULTIPLE_KIDS_RATE;
			System.out.printf("\n�ٵ��� �ູī�� ȸ�� ���� ����(ī�忡 ���� ������ ����)\n�����̿�� 30%% ���\n");
		} else if (input.data.alwaysPrefer == StaticValue.NONE) { // �ش���� ����
			input.data.price = input.data.price;
		} else {
		}
	}

	// ������ �ش���� ���ΰ��ݼ���
	public void PriceByNoPreferOld() {
		if (input.data.realAge >= StaticValue.ADULT_MAX_AGE && input.data.ticketChoice == StaticValue.ALL_PASS
				&& input.data.timeChoice == StaticValue.ALLDAY_PASS && input.data.alwaysPrefer == StaticValue.NONE) {
			input.data.price = StaticValue.ALL_1DAY_KID;
			input.data.personTypeByAge = StaticValue.OLDPERSON; // ������ personType�� 0 ����
			input.data.alwaysPrefer = StaticValue.OLD; // ��ο�� ��� ��� ����, alwaysPrefer�� 0 ����
		} else if (input.data.realAge >= StaticValue.ADULT_MAX_AGE && input.data.ticketChoice == StaticValue.ALL_PASS
				&& input.data.timeChoice == StaticValue.AFTER4_PASS && input.data.alwaysPrefer == StaticValue.NONE) {
			input.data.price = StaticValue.ALL_AFTER4_KID;
			input.data.personTypeByAge = StaticValue.OLDPERSON;
			input.data.alwaysPrefer = StaticValue.OLD;
		} else if (input.data.realAge >= StaticValue.ADULT_MAX_AGE && input.data.ticketChoice == StaticValue.PARK_PASS
				&& input.data.timeChoice == StaticValue.ALLDAY_PASS && input.data.alwaysPrefer == StaticValue.NONE) {
			input.data.price = StaticValue.PARK_1DAY_KID;
			input.data.personTypeByAge = StaticValue.OLDPERSON;
			input.data.alwaysPrefer = StaticValue.OLD;
		} else if (input.data.realAge >= StaticValue.ADULT_MAX_AGE && input.data.ticketChoice == StaticValue.PARK_PASS
				&& input.data.timeChoice == StaticValue.AFTER4_PASS && input.data.alwaysPrefer == StaticValue.NONE) {
			input.data.price = StaticValue.PARK_AFTER4_KID;
			input.data.personTypeByAge = StaticValue.OLDPERSON;
			input.data.alwaysPrefer = StaticValue.OLD;
		} else {
		}
	}
	
	// ���� ���� ���ϱ�, �Ѿ� �����ϱ�
	public void AddPrice() {
		input.data.priceSum = input.data.price * input.data.numberOfTickets; // ���� �ֹ��ϴ� Ƽ�ϵ��� ������
		input.data.totalPrice += input.data.priceSum;
	}
}