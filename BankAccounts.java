import java.io.*;

class BankAccount{
	private int sum = 0;

	public int creation(int sum){
		System.out.println("Creating.");

		return this.sum = sum;

	}

	public int balance(){
		System.out.println("Your balance.");

		return this.sum;

	}

	public int deposit(int money){
		System.out.println("Depositing.");

		return this.sum += money;

	}

	public int withdraw(int money){
		System.out.println("Withdrawing.");

		if (this.sum - money < 0) {
			System.out.println("Warning: Overdraft.");

			return this.sum;

		}else {
			this.sum -= money;

			return this.sum;

		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("order :");
		String order = stdin.readLine();
		BankAccount bank = new BankAccount();
		bank.creation(5);

		while(!order.equals("quit")){
			if (order.equals("deposit")) {
				System.out.println("Deposit Amount :");
				int deposits = Integer.parseInt(stdin.readLine());

				bank.deposit(deposits);
				System.out.println(bank.balance());

			}else if (order.equals("withdraw")) {
				System.out.println("Withdraw Amount :");
				int withdraws = Integer.parseInt(stdin.readLine());

				bank.withdraw(withdraws);
				System.out.println(bank.balance());

			}

			System.out.println("order :");
			order = stdin.readLine();

		}
	}

}
