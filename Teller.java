package bank;

//import com.cg.Container;

//public class Teller {
	//bank.Bank bankRef=new bank.Bank();
//}

	
	public class Teller extends Thread
	{
		
		private Bank bankRef;
			
			public Teller(Bank  bankRef) {
				this.bankRef =bankRef;
			}

			public void run() /*throws InterruptedException*/{
				int i=0;

				while(i<=1){
					try {
							bankRef.transferAmount(1, 2, 500);
							bankRef.showTotalBalance();
						} catch (InterruptedException e) {
						e.printStackTrace();
		
					}
				i++;}
			}
	}


