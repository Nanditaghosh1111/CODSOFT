import java.util.Scanner;
public class Marks_calculator {


		public static String CalculateGrade(double percentage)
		{
			if(percentage>=90)
			{
				return "A+";
			}
			else if(percentage>=80)
			{
				return "A";
			}
			else if(percentage>=70)
			{
				return "B";
			}
			else if(percentage>=60)
			{
				return "C";
			}
			else if(percentage>=50)
			{
				return "D";
			}
			else
			{
				return "F";
			}
		}

	    public static void main(String[] args) {
	       Scanner sc=new Scanner(System.in);
	       System.out.print("Enter number of subjects : ");
	       int n=sc.nextInt();
	       double marks[]=new double[n];
	       double totalMarks=0;
	       for(int i=0;i<n;i++)
	       {
	    	   System.out.print("Enter marks for subject"+(i+1)+"(out of 100) : ");
	    	   double mark=sc.nextDouble();
	    	   while(mark<0 || mark>100)
	    	   {
	    		   System.out.println("Invalid marks please enter a value between 0 and 100. ");
	    		   System.out.print("Enter marks for subject"+(i+1)+"(out of 100) : ");
	    		   mark=sc.nextDouble();
	    	   }
	    	   marks[i]=mark;
	    	   totalMarks+=mark;
	       }
	       double averagePercentage=totalMarks/n;
	       String grade=CalculateGrade(averagePercentage);
	       System.out.println("\n -----Result-----");
	       System.out.println();
	       System.out.printf("Total Marks         : %.2f / %.0f%n",totalMarks,100.0*n);
	       System.out.printf("Average Percentage  : %.2f%%%n",averagePercentage);
	       System.out.println("Grade               : "+grade);
	       sc.close();
	}
}

