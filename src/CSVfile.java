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

public class CSVfile {
	Scanner sc = new Scanner(System.in);
	Calculation cal;
	CSVfile(Calculation cal) {
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

		// �м� ����Ʈ
		String analysis = ticket + "," + time + "," + ageCategory + "," + cal.input.data.getNumberOfTickets() + ","
				+ cal.input.data.getPriceSum() + "," + prefer + "\n";
		analysisList.add(analysis);

		// �� ���Ÿ��� ����*������ ����Ʈ��
		price.add(cal.input.data.getPriceSum());
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
		int totalPriceSum = 0;
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
			String tableName = "Ƽ������,�̿�ð�,����,����,����,���γ���";
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
}