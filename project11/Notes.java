import java.util.Scanner;
class Notes{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the amount : ");
		int amount = scan.nextInt();
		scan.nextLine();
		int twoThousand,oneThousand,fiveHundred,twoHundred,hundred,fifty,twenty,ten,five,two,one;
		int r = amount;
		System.out.println("The given amount "+amount+" contains:");
		if(r >= 2000){
			twoThousand = (int)(r/2000);
			r = r - 2000*twoThousand;
			System.out.println("Two Thousand notes = "+twoThousand);
		}
		if(r >= 1000){
			oneThousand = (int)(r/1000);
			r = r - 1000*oneThousand;
			System.out.println("One Thousand notes = "+oneThousand);
		}
		if(r >= 500){
			fiveHundred = (int)(r/500);
			r = r - 500*fiveHundred;
			System.out.println("Five Hundred notes = "+fiveHundred);
		}
		if(r >= 200){
			twoHundred = (int)(r/200);
			r = r - 200*twoHundred;
			System.out.println("Two Hundred notes = "+twoHundred);
		}
		if(r >= 100){
			hundred = (int)(r/100);
			r = r - 100*hundred;
			System.out.println("One Hundred notes = "+hundred);
		}
		if(r >= 50){
			fifty = (int)(r/50);
			r = r - 50*fifty;
			System.out.println("Fifty Rs notes = "+fifty);
		}
		if(r >= 20){
			twenty = (int)(r/20);
			r = r - 20*twenty;
			System.out.println("Twenty Rs notes = "+twenty);
		}
		if(r >= 10){
			ten = (int)(r/10);
			r = r - 10*ten;
			System.out.println("Ten Rs notes = "+ten);
		}
		if(r >= 5){
			five = (int)(r/5);
			r = r - 5*five;
			System.out.println("Five Rs coins = "+five);
		}
		if(r >= 2){
			two = (int)(r/2);
			r = r - 2*two;
			System.out.println("Two Rs coins = "+two);
		}
		if(r >= 1){
			one = (int)(r/1);
			r = r - 1*one;
			System.out.println("One Rs coins = "+one);
		}
				
	}
}