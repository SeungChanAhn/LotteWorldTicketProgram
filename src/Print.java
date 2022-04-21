package Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Print {
	Scanner sc = new Scanner(System.in);
	Calculation cal;

	Print(Calculation cal) {
		this.cal = cal;
	}

	ArrayList orderList = new ArrayList(); // ������ ��� ����Ʈ
	ArrayList price = new ArrayList(); // ���� ���� ����Ʈ
	ArrayList analysisList = new ArrayList(); // CSV���� ����Ʈ
	String[][] readList = new String[100][6]; // CSV���� �о�ͼ� �迭�� ����

	public void ReadyPrintReceipt() {
		String ticket = null;
		String time = null;
		String ageCategory = null;
		String ticketCount = null;
		String prefer = null;

		switch (cal.input.data.getTicketChoice()) {
		case 1:
			ticket = "�����̿��";
			break;
		case 2:
			ticket = "��ũ�̿��";
			break;
		}

		switch (cal.input.data.getTimeChoice()) {
		case 1:
			time = "���ϱ�";
			break;
		case 2:
			time = "After4";
			break;
		}

		switch (cal.input.data.getPersonTypeByAge()) {
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

		switch (cal.input.data.getAlwaysPrefer()) {
		case 0:
			prefer = "�ش����";
			break;
		case 1:
			prefer = "�����";
			break;
		case 2:
			prefer = "����������";
			break;
		case 3:
			prefer = "�ް�����";
			break;
		case 4:
			prefer = "�ӻ��";
			break;
		case 5:
			prefer = "�ٵ��̰���";
			break;
		case 6:
			prefer = "��ο��";
			break;
		}

		// ������ ��� ����Ʈ
		String all = null;
		if (cal.input.data.getPriceSum() >= 100000) { // 10���� �Ѿ�� ������ �� ����..
			all = ticket + "\t\t" + time + "\t\t\t" + ageCategory + "\t\t" + cal.input.data.getNumberOfTickets() + "��"
					+ "\t\t" + cal.input.data.getPriceSum() + "��" + "\t" + prefer + "\n";
		} else {
			all = ticket + "\t\t" + time + "\t\t\t" + ageCategory + "\t\t" + cal.input.data.getNumberOfTickets() + "��"
					+ "\t\t" + cal.input.data.getPriceSum() + "��" + "\t\t" + prefer + "\n";
		}

		orderList.add(all);

		// �� ���Ÿ��� ����*������ ����Ʈ�� ����� (�� �ݾ� ���)
		price.add(cal.input.data.getPriceSum());

		// CSV���Ϸ� ������ �м� ����Ʈ
		String analysis = ticket + "," + time + "," + ageCategory + "," + cal.input.data.getNumberOfTickets() + ","
				+ cal.input.data.getPriceSum() + "," + prefer + "\n";
		analysisList.add(analysis);

	}

	public void printReceipt() {
		Calendar calendar = Calendar.getInstance(); // ���� ��¥ ��������
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");

		System.out.printf(
				"=============================================================================================================\n");
		System.out.printf("\n\n                                                �� �� �� ��\n\n");
		System.out.printf("\t\t\t\t\t\t\t\t\t\t\t%s\n", sdt.format(calendar.getTime()));
		System.out.printf(
				"=============================================================================================================\n");
		System.out.printf("Ƽ������\t\t�̿�ð�\t\t����\t\t����\t\t����\t\t���γ���\n");
		System.out.printf(
				"-------------------------------------------------------------------------------------------------------------\n");
		for (int index = 0; index < orderList.size(); index++) {
			System.out.println(orderList.get(index));
		}
		System.out.printf(
				"-------------------------------------------------------------------------------------------------------------\n");
		int totalPriceSum = 0; // �����ݾ� ���
		for (int index = 0; index < price.size(); index++) {
			totalPriceSum += (int) price.get(index);
		}
		System.out.printf("�����ݾ�\t\t\t\t\t\t\t\t\t\t%19d��", totalPriceSum);
		System.out.printf(
				"\n=============================================================================================================\n");
	}

	// analysisList�� CSV���Ϸ� ��������
	public void writeCsv(ArrayList<String> list) {
		String fileName = "C:\\ticketing\\test1.csv";
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(fileName);
			for (String analysisList : list) {
				out.write(analysisList.getBytes());
			}
			System.out.println("\n�� ������ C����̺� ticketing ������ ����Ǿ����ϴ�.\n");
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				out.close();
			} catch (IOException e) {
			}
		}
	}

	// CSV���� �о����
	public void readCSVFile() {
		System.out.println("�� CSV���� �ҷ�����\n");
		System.out.println("Ƽ������ �̿�ð� ���� ���� ���� ������");
		try {
			File csv = new File("C:\\ticketing\\test1.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String line = "";
			int row = 0;

			while ((line = br.readLine()) != null) {
				String[] token = line.split(",");

				// �迭�� �ֱ�
				for (int index = 0; index < 6; index++) {
					readList[row][index] = token[index];
				}

				// CSV���� �о� �迭�� �ű� �ڷ� Ȯ���ϱ� ���� ��ü ���
				for (int index = 0; index < 6; index++) {
					System.out.print(readList[row][index] + " ");
				}
				System.out.println("");
				row++;
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ������ ���� �м�
	public void TicketTypeAnalysis() {
		int allPass_Sales = 0;
		int allPass_Count = 0;
		int allPass_Count_Baby = 0;
		int allPass_Count_Kid = 0;
		int allPass_Count_Teen = 0;
		int allPass_Count_Adult = 0;
		int allPass_Count_Old = 0;

		int parkPass_Sales = 0;
		int parkPass_Count = 0;
		int parkPass_Count_Baby = 0;
		int parkPass_Count_Kid = 0;
		int parkPass_Count_Teen = 0;
		int parkPass_Count_Adult = 0;
		int parkPass_Count_Old = 0;

		try {
			File csv = new File("C:\\ticketing\\test1.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String line = "";

			while ((line = br.readLine()) != null) {
				String token[] = line.split(",");

				if (line.contains("�����̿��")) {
					allPass_Count += Integer.parseInt(token[3]);
					allPass_Sales += Integer.parseInt(token[4]);
					if (line.contains("���̺�")) {
						allPass_Count_Baby += Integer.parseInt(token[3]);
					} else if (line.contains("���")) {
						allPass_Count_Kid += Integer.parseInt(token[3]);
					} else if (line.contains("û�ҳ�")) {
						allPass_Count_Teen += Integer.parseInt(token[3]);
					} else if (line.contains("�")) {
						allPass_Count_Adult += Integer.parseInt(token[3]);
					} else if (line.contains("����")) {
						allPass_Count_Old += Integer.parseInt(token[3]);
					} else {
					}
				}

				if (line.contains("��ũ�̿��")) {
					parkPass_Count += Integer.parseInt(token[3]);
					parkPass_Sales += Integer.parseInt(token[4]);
					if (line.contains("���̺�")) {
						parkPass_Count_Baby += Integer.parseInt(token[3]);
					} else if (line.contains("���")) {
						parkPass_Count_Kid += Integer.parseInt(token[3]);
					} else if (line.contains("û�ҳ�")) {
						parkPass_Count_Teen += Integer.parseInt(token[3]);
					} else if (line.contains("�")) {
						parkPass_Count_Adult += Integer.parseInt(token[3]);
					} else if (line.contains("����")) {
						parkPass_Count_Old += Integer.parseInt(token[3]);
					} else {
					}
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("\n\n===================== ������ ���� =====================\n");
		System.out.printf("�����̿�� �� %d��\n", allPass_Count);
		System.out.printf("���̺� %d�� ��� %d�� û�ҳ� %d�� � %d�� ���� %d��\n", allPass_Count_Baby, allPass_Count_Kid,
				allPass_Count_Teen, allPass_Count_Adult, allPass_Count_Old);
		System.out.printf("�����̿�� ���� %d��\n\n", allPass_Sales);
		System.out.printf("��ũ�̿�� �� %d��\n", parkPass_Count);
		System.out.printf("���̺� %d�� ��� %d�� û�ҳ� %d�� � %d�� ���� %d��\n", parkPass_Count_Baby, parkPass_Count_Kid,
				parkPass_Count_Teen, parkPass_Count_Adult, parkPass_Count_Old);
		System.out.printf("��ũ�̿�� ���� %d��\n", parkPass_Sales);
		System.out.printf("=======================================================");
	}
	
	public void TicketTimeAnalysis() {
		int allday_Sales = 0;
		int allday_Count = 0;
		int allday_Count_Baby = 0;
		int allday_Count_Kid = 0;
		int allday_Count_Teen = 0;
		int allday_Count_Adult = 0;
		int allday_Count_Old = 0;

		int after4_Sales = 0;
		int after4_Count = 0;
		int after4_Count_Baby = 0;
		int after4_Count_Kid = 0;
		int after4_Count_Teen = 0;
		int after4_Count_Adult = 0;
		int after4_Count_Old = 0;

		try {
			File csv = new File("C:\\ticketing\\test1.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String line = "";

			while ((line = br.readLine()) != null) {
				String token[] = line.split(",");

				if (line.contains("���ϱ�")) {
					allday_Count += Integer.parseInt(token[3]);
					allday_Sales += Integer.parseInt(token[4]);
					if (line.contains("���̺�")) {
						allday_Count_Baby += Integer.parseInt(token[3]);
					} else if (line.contains("���")) {
						allday_Count_Kid += Integer.parseInt(token[3]);
					} else if (line.contains("û�ҳ�")) {
						allday_Count_Teen += Integer.parseInt(token[3]);
					} else if (line.contains("�")) {
						allday_Count_Adult += Integer.parseInt(token[3]);
					} else if (line.contains("����")) {
						allday_Count_Old += Integer.parseInt(token[3]);
					} else {
					}
				}

				if (line.contains("After4")) {
					after4_Count += Integer.parseInt(token[3]);
					after4_Sales += Integer.parseInt(token[4]);
					if (line.contains("���̺�")) {
						after4_Count_Baby += Integer.parseInt(token[3]);
					} else if (line.contains("���")) {
						after4_Count_Kid += Integer.parseInt(token[3]);
					} else if (line.contains("û�ҳ�")) {
						after4_Count_Teen += Integer.parseInt(token[3]);
					} else if (line.contains("�")) {
						after4_Count_Adult += Integer.parseInt(token[3]);
					} else if (line.contains("����")) {
						after4_Count_Old += Integer.parseInt(token[3]);
					} else {
					}
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("\n\n=================== �̿�ð��� ���� ===================\n");
		System.out.printf("���ϱ� �� %d��\n", allday_Count);
		System.out.printf("���̺� %d�� ��� %d�� û�ҳ� %d�� � %d�� ���� %d��\n", allday_Count_Baby, allday_Count_Kid,
				allday_Count_Teen, allday_Count_Adult, allday_Count_Old);
		System.out.printf("���ϱ� ���� %d��\n\n", allday_Sales);
		System.out.printf("After4 �̿�� �� %d��\n", after4_Count);
		System.out.printf("���̺� %d�� ��� %d�� û�ҳ� %d�� � %d�� ���� %d��\n", after4_Count_Baby, after4_Count_Kid,
				after4_Count_Teen, after4_Count_Adult, after4_Count_Old);
		System.out.printf("After4 �̿�� ���� %d��\n", after4_Sales);
		System.out.printf("=======================================================");
	}

	public void preferAnalysis() {
		int preferTicket_Count = 0; // ���Ǹ� ī��Ʈ
		int prefer_Count_Disabled = 0;
		int prefer_Count_NationalMerit = 0;
		int prefer_Count_Sordier = 0;
		int prefer_Count_Pregnant = 0;
		int prefer_Count_MultipleKids = 0;
		int prefer_Count_Old = 0;

		try {
			File csv = new File("C:\\ticketing\\test1.csv");
			BufferedReader br = new BufferedReader(new FileReader(csv));
			String line = "";

			while ((line = br.readLine()) != null) {
				String token[] = line.split(",");

				if (line.contains("�����")) {
					prefer_Count_Disabled += Integer.parseInt(token[3]);
					preferTicket_Count += Integer.parseInt(token[3]);
				} else if (line.contains("����������")) {
					prefer_Count_NationalMerit += Integer.parseInt(token[3]);
					preferTicket_Count += Integer.parseInt(token[3]);
				} else if (line.contains("�ް�����")) {
					prefer_Count_Sordier += Integer.parseInt(token[3]);
					preferTicket_Count += Integer.parseInt(token[3]);
				} else if (line.contains("�ӻ��")) {
					prefer_Count_Pregnant += Integer.parseInt(token[3]);
					preferTicket_Count += Integer.parseInt(token[3]);
				} else if (line.contains("�ٵ��̰���")) {
					prefer_Count_MultipleKids += Integer.parseInt(token[3]);
					preferTicket_Count += Integer.parseInt(token[3]);
				} else if (line.contains("��ο��")) {
					prefer_Count_Old += Integer.parseInt(token[3]);
					preferTicket_Count += Integer.parseInt(token[3]);
				} else {
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.printf("\n\n=================== ���� �Ǹ� ��Ȳ ==================\n");
		System.out.printf("�� �Ǹ� Ƽ�ϼ� : %d��\n", preferTicket_Count);
		System.out.printf("����� : %d��\n", prefer_Count_Disabled);
		System.out.printf("���������� : %d��\n", prefer_Count_NationalMerit);
		System.out.printf("�ް����� : %d��\n", prefer_Count_Sordier);
		System.out.printf("�ӻ�� : %d��\n", prefer_Count_Pregnant);
		System.out.printf("�ٵ��̰��� : %d��\n", prefer_Count_MultipleKids);
		System.out.printf("��ο�� : %d��\n", prefer_Count_Old);
		System.out.printf("=======================================================");
	}
}