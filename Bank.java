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
		System.out.println("어서오세요^^");
		Scanner keyboard = new Scanner(System.in);
		System.out.println("통장이 있으면 1을 없으시면 2번을 입력해 주세요. ");
		int accountInfo = keyboard.nextInt();
		CheckAccount checkAccount = null;
		if (accountInfo == 1) {
			System.out.println("통장 번호를 입력하세요.");
			String accountNumber = keyboard.next();
			checkAccount = getCheckAccount(accountNumber);
		} else {
			checkAccount = createCheckAccount(keyboard);
		}

		if (checkAccount == null) {
			System.out.println("없는 계좌입니다. ");
			checkAccount = createCheckAccount(keyboard);
		}

		a: while (true) {
			System.out.println("원하는 업무를 선택하세요.  입금은 1, 출금은 2, 업무를 종료하시려면 3 을 입력하세요.");
			int flag = keyboard.nextInt();
			switch (flag) {
			case 1:
				System.out.println("입금하려는 금액을 입력하세요.");
				int money = keyboard.nextInt();
				checkAccount.deposit(money);
				System.out.println("입금이 완료되었습니다. 현재 잔액은 :" + checkAccount.getBalance());
				break;
			case 2:
				System.out.println("출금하려는 금액을 입력하세요.");
				int money2 = keyboard.nextInt();
				try {
					checkAccount.withdraw(money2);
					System.out.println("출금이 완료되었습니다. 현재 잔액은 :" + checkAccount.getBalance());

				} catch (BankException e) {
					System.out.println(e);
					System.out.println("출금은 잔액보다 많이 할 수 없습니다. 다시 업무를 수행하세요.");
				}
				break;
			case 3:
				System.out.println("업무를 종료합니다. 안녕히 가세요.");
				endJob();
				break a;
			default:
				System.out.println("잘못입력하셨습니다. 다시 입력해 주세요.");
				break;
			}
		}
	}

	// 은행이 문을닫을때 수행되는 메소드
	public void endJob() {
		// 종료될때 은행이 가지고 있는 모든 계좌정보를 출력해 주세요.
		printCheckAccounts();
		// 은행업무가 끝날때 파일에 계좌 정보를 저장한다.
		saveFile();
	}
}
