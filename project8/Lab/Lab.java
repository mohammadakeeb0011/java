import java.util.Scanner;
class Student{
	private	String name;
	private	String rollNo;
	
	public Student(String n,String r)
		{
			name = n;
			rollNo = r;
		}
	public void DisplayStd(){
			System.out.println("Name 	 : " + name);
			System.out.println("Roll No. : " + rollNo);
		}
	public void setStd(){
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter name of student: ");
			name = scan.nextLine();
			System.out.print("Enter roll no. of student: ");
			rollNo = scan.nextLine();
		}
}

class Chair{
	private boolean status;
	private Student studentObj;
	public Chair(boolean s, Student obj)
		{
			status = s;
			studentObj = obj;
		}
	public boolean checkStatus()
		{
			return status;
		}
	public void DisplayChair(){
			String a;
			if(status)
				a = "Occupied";
			else
				a = "Unoccupied";
			System.out.println("Status 	 : " + a);
			if(status){
			 System.out.println("Student Details :");
			 obj.DisplayStd();
			}
			 return;
		}
}

class Lab{
	public static void main(String args[]){
		/*Chair[] chairs = new Chair[5];
		
		for(int i=0; i<5; i++)
		{
			Student temp;
			temp.setStd();
			chairs[i].studentObj = temp;
			chairs[i].SetStatus();
		}
		
		int a=1;
		while(1){
			System.out.println("Enter chair no.: ");
			i = scan.nextInt();
			chairs[i].DisplayChair();
			System.out.println("Do you want to continue y/n: ");
			i = scan.nextLine();
			if (i == "n")
				break;
			else
				continue;
		}*/
		
		byte option;
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("\n\n---------------Menu---------------\n");
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Search");
			System.out.println("4. Update");
			System.out.println("5. Display");
			System.out.println("6. Exit");
			
			System.out.print("Enter your choise : ");
			option = scan.nextByte();
			scan.nextLine();
			switch(option){
				case 1:
					System.out.println("1");
					break;
				case 2:
					System.out.println("2");
					break;
				case 3:
					System.out.println("3");
					break;
				case 4:
					System.out.println("4");
					break;
				case 5:
				
					System.out.println("4");
					break;
			}
		}
		while(option != 6);
		
	}
}