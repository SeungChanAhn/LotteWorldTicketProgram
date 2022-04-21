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
		input.data.setToday(Integer.parseInt(sdt.format(calendar.getTime()))); // ��¥ ���� �ֹι�ȣ�� ����� ���� '220420'ó�� ���������� ��ȯ

		input.data.setYear(Integer.parseInt(input.data.getIDNumber().substring(0, 2)));
		input.data.setMonth(Integer.parseInt(input.data.getIDNumber().substring(2, 4)));
		input.data.setDay(Integer.parseInt(input.data.getIDNumber().substring(4, 6)));
		input.data.setIDNumber_Front(Integer.parseInt(input.data.getIDNumber().substring(0, 6)));
		input.data.setGender(Integer.parseInt(input.data.getIDNumber().substring(7, 8)));

		if (input.data.getGender() == StaticValue.MAN_1900 || input.data.getGender() == StaticValue.WOMAN_1900) { // 1900����
			input.data.setAge(
					(int) (input.data.getToday() * 0.0001) + 100 - (int) (input.data.getIDNumber_Front() * 0.0001) + 1);
			if (input.data.getToday() - (int) (input.data.getToday() * 0.0001) * 10000 < input.data.getIDNumber_Front()
					- (int) (input.data.getIDNumber_Front() * 0.0001) * 10000) {
				input.data.setRealAge(input.data.getAge() - 2);
			} else {
				input.data.setRealAge(input.data.getAge() - 1);
			}
		} else if (input.data.getGender() == StaticValue.MAN_2000 || input.data.getGender() == StaticValue.WOMAN_2000) { // 2000����
			input.data.setAge((int) (input.data.getToday() * 0.0001) + 100
					- (int) (input.data.getIDNumber_Front() * 0.0001) + 1 - 100);
			if (input.data.getToday() - (int) (input.data.getToday() * 0.0001) * 10000 < input.data.getIDNumber_Front()
					- (int) (input.data.getIDNumber_Front() * 0.0001) * 10000) {
				input.data.setRealAge(input.data.getAge() - 2);
			} else {
				input.data.setRealAge(input.data.getAge() - 1);
			}
		} else {
		}
	}

	// ���� ī�װ� ������
	public void AgeCategory() {
		if (input.data.getRealAge() >= StaticValue.ADULT_MAX_AGE) {
			input.data.setPersonTypeByAge(StaticValue.OLDPERSON); // ����
		} else if (input.data.getRealAge() >= StaticValue.ADULT_MIN_AGE) {
			input.data.setPersonTypeByAge(StaticValue.ADULT); // �
		} else if (input.data.getRealAge() >= StaticValue.TEEN_MIN_AGE
				&& input.data.getRealAge() < StaticValue.ADULT_MIN_AGE) {
			input.data.setPersonTypeByAge(StaticValue.TEEN); // û�ҳ�
		} else if (input.data.getRealAge() >= StaticValue.KID_MIN_AGE
				&& input.data.getRealAge() < StaticValue.KID_MAX_AGE) {
			input.data.setPersonTypeByAge(StaticValue.KID); // ���
		} else if (input.data.getRealAge() > StaticValue.BABY_AGE_0
				&& input.data.getRealAge() < StaticValue.KID_MAX_AGE) {
			input.data.setPersonTypeByAge(StaticValue.BABY); // ���̺�
		}
	}

	// ���̷� �ݾ� �����ϱ�
	public void PriceByAge() {
		if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.ADULT) {
			input.data.setPrice(input.data.getPrice() + StaticValue.ALL_1DAY_ADULT);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.TEEN) {
			input.data.setPrice(input.data.getPrice() + StaticValue.ALL_1DAY_TEEN);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.KID) {
			input.data.setPrice(input.data.getPrice() + StaticValue.ALL_1DAY_KID);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.BABY) {
			input.data.setPrice(input.data.getPrice() + StaticValue.BABY);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.ADULT) {
			input.data.setPrice(input.data.getPrice() + StaticValue.ALL_AFTER4_ADULT);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.TEEN) {
			input.data.setPrice(input.data.getPrice() + StaticValue.ALL_AFTER4_TEEN);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.KID) {
			input.data.setPrice(input.data.getPrice() + StaticValue.ALL_AFTER4_KID);
		} else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.BABY) {
			input.data.setPrice(input.data.getPrice() + StaticValue.BABY);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.ADULT) {
			input.data.setPrice(input.data.getPrice() + StaticValue.PARK_1DAY_ADULT);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.TEEN) {
			input.data.setPrice(input.data.getPrice() + StaticValue.PARK_1DAY_TEEN);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.KID) {
			input.data.setPrice(input.data.getPrice() + StaticValue.PARK_1DAY_KID);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.BABY) {
			input.data.setPrice(input.data.getPrice() + StaticValue.BABY);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.ADULT) {
			input.data.setPrice(input.data.getPrice() + StaticValue.PARK_AFTER4_ADULT);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.TEEN) {
			input.data.setPrice(input.data.getPrice() + StaticValue.PARK_AFTER4_TEEN);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.KID) {
			input.data.setPrice(input.data.getPrice() + StaticValue.PARK_AFTER4_KID);
		} else if (input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getPersonTypeByAge() == StaticValue.BABY) {
			input.data.setPrice(input.data.getPrice() + StaticValue.BABY);
		} else {
		}
	}

	// ���Ƴ��̽ü� �̿뿡 ���� �ݾ� ����
	public void UseKidplayroom() {
		if (input.data.getRealAge() > StaticValue.BABY_AGE_0 && input.data.getRealAge() < StaticValue.BABY_AGE_1) {
			input.data.setPrice(StaticValue.PRICE_FREE);
		} else if (input.data.getRealAge() >= StaticValue.BABY_AGE_1
				&& input.data.getRealAge() < StaticValue.KID_MIN_AGE) {
			System.out.printf("\n\n�� 1������ 3������ ���� ���̽ü��� ����� �̿� �����մϴ�. �̿��Ͻðڽ��ϱ�?\n");

			do {
				System.out.printf("1. �̿�O\n2. �̿�X (��ũ���� ����)\n���� : ");
				input.data.setKidsPlayroom(sc.nextInt());
				if (!(input.data.getKidsPlayroom() == StaticValue.KIDPLAYROOM_O
						|| input.data.getKidsPlayroom() == StaticValue.KIDPLAYROOM_X)) {
					System.out.printf("�߸��� �Է��Դϴ�. 1 �Ǵ� 2�� �Է��ϼ���.\n\n");
				}
			} while (!(input.data.getKidsPlayroom() == StaticValue.KIDPLAYROOM_O
					|| input.data.getKidsPlayroom() == StaticValue.KIDPLAYROOM_X));

			if (input.data.getKidsPlayroom() == StaticValue.KIDPLAYROOM_O) {
				input.data.setPrice(StaticValue.PRICE_BABY);
			} else if (input.data.getKidsPlayroom() == StaticValue.KIDPLAYROOM_X) {
				input.data.setPrice(StaticValue.PRICE_FREE);
			}
		} else {
		}
	}

	// �����׺� �ݾ� ����
	public void PriceByPrefer() {
		
		// ����� 50% ���ο��
		if (input.data.getAlwaysPrefer() == StaticValue.DISABLED) {
			input.data.setPrice(input.data.getPrice() * StaticValue.DISABLED_RATE);
			System.out.printf("\n������� �� �������� ���� �� + ���� 1��\n�����̿��/��ũ�̿�� 50%% ���\n");
		}
		
		// ���������� 50% ���ο��
		else if (input.data.getAlwaysPrefer() == StaticValue.NATIONAL_MERIT) { 
			input.data.setPrice(input.data.getPrice() * StaticValue.NATIONAL_MERIT_RATE);
			System.out.printf("\n������������ �� �������� ���� �� + ����1��\n�����̿��/��ũ�̿�� 50%% ���\n");
		} 
		
		// �ް��庴�� ���� �̿�Ǹ� 49%����
		else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getAlwaysPrefer() == StaticValue.SODIER_ON_VACATION) {
			input.data.setPrice(input.data.getPrice() * StaticValue.SODIER_ON_VACATION_RATE);
			System.out.printf("\n�ް��庴(�ǰ�, �ǹ��ҹ��, ������ ����) �������� ���� �� + ������ 1��\n�����̿�� 49%% ���\n");
		} 
		
		// �ӻ�δ� �����̿�Ǹ� 50%����
		else if (input.data.getTicketChoice() == StaticValue.ALL_PASS && input.data.getAlwaysPrefer() == StaticValue.PREGNANT) { 
			if (input.data.getGender() == StaticValue.WOMAN_1900 || input.data.getGender() == StaticValue.WOMAN_2000) {
				input.data.setPrice(input.data.getPrice() * StaticValue.PREGNANT_RATE);
				System.out.printf("\n���ڼ�ø �� �������� ���� �ӻ�� ����\n�����̿�� 50%% ���\n");
			} else {
				input.data.setAlwaysPrefer(StaticValue.NONE);
				System.out.printf("\n�ӻ�� ������ �̿��Ͻ� �� �����ϴ�.\n");
			}
		} 
		
		// �ٵ��̰����� �����̿�Ǹ� 30%����
		else if (input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getAlwaysPrefer() == StaticValue.MULTIPLE_KIDS) { 
			input.data.setPrice(input.data.getPrice() * StaticValue.MULTIPLE_KIDS_RATE);
			System.out.printf("\n�ٵ��� �ູī�� ȸ�� ���� ����(ī�忡 ���� ������ ����)\n�����̿�� 30%% ���\n");
		} 
		
		// �ش���׾����� ���ݺ�������.
		else if (input.data.getAlwaysPrefer() == StaticValue.NONE) {
			input.data.setPrice(input.data.getPrice());
		}
	}

	// ������ �ش���� ���ΰ��ݼ���
	public void PriceByNoPreferOld() {
		if (input.data.getRealAge() >= StaticValue.ADULT_MAX_AGE && input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getAlwaysPrefer() == StaticValue.NONE) {
			input.data.setPrice(StaticValue.ALL_1DAY_KID);
			input.data.setPersonTypeByAge(StaticValue.OLDPERSON); // ������ personType�� 0 ����
			input.data.setAlwaysPrefer(StaticValue.OLD); // ��ο�� ��� ��� ����, alwaysPrefer�� 0 ����
		} else if (input.data.getRealAge() >= StaticValue.ADULT_MAX_AGE
				&& input.data.getTicketChoice() == StaticValue.ALL_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getAlwaysPrefer() == StaticValue.NONE) {
			input.data.setPrice(StaticValue.ALL_AFTER4_KID);
			input.data.setPersonTypeByAge(StaticValue.OLDPERSON);
			input.data.setAlwaysPrefer(StaticValue.OLD);
		} else if (input.data.getRealAge() >= StaticValue.ADULT_MAX_AGE
				&& input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.ALLDAY_PASS
				&& input.data.getAlwaysPrefer() == StaticValue.NONE) {
			input.data.setPrice(StaticValue.PARK_1DAY_KID);
			input.data.setPersonTypeByAge(StaticValue.OLDPERSON);
			input.data.setAlwaysPrefer(StaticValue.OLD);
		} else if (input.data.getRealAge() >= StaticValue.ADULT_MAX_AGE
				&& input.data.getTicketChoice() == StaticValue.PARK_PASS
				&& input.data.getTimeChoice() == StaticValue.AFTER4_PASS
				&& input.data.getAlwaysPrefer() == StaticValue.NONE) {
			input.data.setPrice(StaticValue.PARK_AFTER4_KID);
			input.data.setPersonTypeByAge(StaticValue.OLDPERSON);
			input.data.setAlwaysPrefer(StaticValue.OLD);
		} else {
		}
	}

	// ���� ���� ���ϱ�
	// ���� �ֹ��ϴ� Ƽ�ϵ��� ������
	public void AddPrice() {
		input.data.setPriceSum(input.data.getPrice() * input.data.getNumberOfTickets());
	}
}