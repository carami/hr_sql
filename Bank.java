package bankTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Bank {

	public void startJob() {
		System.out.println("�������^^");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("������ ������ 1�� �����ø� 2���� �Է��� �ּ���. ");
		int accountInfo = keyboard.nextInt();
		CheckAccount checkAccount = null;
		if (accountInfo == 1) {
			System.out.println("���� ��ȣ�� �Է��ϼ���.");
			String accountNumber = keyboard.next();
			checkAccount = getCheckAccount(accountNumber);
		} else {
			checkAccount = createCheckAccount(keyboard);
		}

		if (checkAccount == null) {
			System.out.println("���� �����Դϴ�. ");
			checkAccount = createCheckAccount(keyboard);
		}

		a: while (true) {
			System.out.println("���ϴ� ������ �����ϼ���.  �Ա��� 1, ����� 2, ������ �����Ͻ÷��� 3 �� �Է��ϼ���.");
			int flag = keyboard.nextInt();
			switch (flag) {
			case 1:
				System.out.println("�Ա��Ϸ��� �ݾ��� �Է��ϼ���.");
				int money = keyboard.nextInt();
				checkAccount.deposit(money);
				System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�. ���� �ܾ��� :" + checkAccount.getBalance());
				break;
			case 2:
				System.out.println("����Ϸ��� �ݾ��� �Է��ϼ���.");
				int money2 = keyboard.nextInt();
				try {
					checkAccount.withdraw(money2);
					System.out.println("����� �Ϸ�Ǿ����ϴ�. ���� �ܾ��� :" + checkAccount.getBalance());

				} catch (BankException e) {
					System.out.println(e);
					System.out.println("����� �ܾ׺��� ���� �� �� �����ϴ�. �ٽ� ������ �����ϼ���.");
				}
				break;
			case 3:
				System.out.println("������ �����մϴ�. �ȳ��� ������.");
				endJob();
				break a;
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է��� �ּ���.");
				break;
			}
		}
	}

	// ������ ���������� ����Ǵ� �޼ҵ�
	public void endJob() {
		// ����ɶ� ������ ������ �ִ� ��� ���������� ����� �ּ���.
		printCheckAccounts();
		// ��������� ������ ���Ͽ� ���� ������ �����Ѵ�.
		saveFile();
	}
}
