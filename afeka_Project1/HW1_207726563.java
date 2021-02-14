package afeka_Project1;
/*Name:Shay Gabison
 *ID:207726563 
 *HomeWorkNumber:1
 *
 *Menu of 9 option representing by switch. 
 *every case have a Detailed documentation.
 *Enjoy.
 *
 */

import java.util.Scanner;
public class HW1_207726563 {

public static void main(String[] args) { 
	  int menuChoice;
	  int NUM4=0;
	  int NUMber,diviSor,divdiv,counter,rev,reVers,rev2,temp2,rev1,Odd,Carpet;
      int NUM2=0;
      int NUM3=0;
      int a,b = 0;
      int c=1;
      int  mate1 = 0, mate2, checkMate1, lastMate = 0;
      final char Aster='*';
      final char Hashtag='#';
	  Scanner input= new Scanner(System.in);
	  do {
	  System.out.println("Please select an option:\r\n"
		  		+ "1 - Training program (3.6)\r\n"
		  		+ "2 - Final grade calculation (3.7)\r\n"
		  		+ "3 - Flip each 2 digits of a number (4.5)\r\n"
		  		+ "4 - Reverse a number by parts (4.10)\r\n"
		  		+ "5 - Print rectangle (4.11)\r\n"
		  		+ "6 - Print sand watch (4.13)\r\n"
		  		+ "7 - Print carpet (4.14)\r\n"
		  		+ "8 – Mates numbers (4.16)\r\n"
		  		+ "9 - Exit\r\n"
		  		+ "\r\n"
		  		+ " ");
	  System.out.println("enter one number : ");
	  menuChoice = input.nextInt();
	  
	  switch(menuChoice ){
	  case (1):
	  /*A training offer for a person who wants to get into running fitness.
	   *The proposal is based on the person's fitness, based on the resting heart rate, and the number of weeks he has already trained.
	   * The variables in this case are:
	   * Pulse = User heart Pulse at rest.
	   * Week = User current week of training.
	   */
		System.out.println("enter your Pulse at rest: ");
	    int Pulse= input.nextInt();
	  
	  	System.out.println("enter your current week of training: ");
	  	int Week = input.nextInt();
	  
	  	if   (Week==1 || Week==2){
	  		System.out.println("next training you shoulde ran 3 km ");
	  	}
	  
	  	if   (Week==3 || Week==4){
		  if (Pulse>70) {
			  System.out.println("next training you shoulde ran 3 km ");}
		  else {System.out.println("next training you shoulde ran 5 km ");}

		  }
	    if   (Week==3 || Week==4){
		  if (Pulse>70) {
			  System.out.println("next training you shoulde ran 3 km ");}
		  
		  else {System.out.println("next training you shoulde ran 5 km ");}

	    }
	    if   (Week>=5){
	    	if (Pulse>70) {
	    		System.out.println("next training you shoulde ran 3 km ");}
	    	else	if (Pulse>60 && Pulse<70) {
	    		System.out.println("next training you shoulde ran 8 km ");}
	    	else  if (Pulse<60) {
	    		System.out.println("next training you shoulde ran 10 km ");}
	  }
	  break;   	  
      case (2):
       /*In this case the program receives from the user 3 integers representing: 
        * Exam score (score out of one hundred), average Homework (score from one hundred ) and number of exercises submitted) to 8 exercises. 
        *The program will calculate the final score on- According to a formula.
	   * The variables in this case are:
	   * Exam_Grade=User exam grade  (0-100).
	   * Number_Of_Homework=User number of homework's you have submit (0-8).
	   * Average=User average homework's grades(0-100). 
	   */
 
    	System.out.println("enter your exam grade  (0-100): ");
      	System.out.println("enter your average homework's grades(0-100): ");
      	System.out.println("enter the number of homework's you have submit (0-8): ");

      	int Exam_Grade= input.nextInt();
      	int Average= input.nextInt();
      	int Number_Of_Homework= input.nextInt();
      	if (Number_Of_Homework<=4){
      		System.out.println("your final grade is: 0 (Fail) ");

      	}
        if (Number_Of_Homework==5 || Number_Of_Homework==6){
        	if (Exam_Grade>55) {
        		System.out.println("your final grade is: "+ ((Exam_Grade*0.8)+(Average*0.2)));
        	}
        	else
        		System.out.println("your final grade is: "+ Exam_Grade);
	

        }
        if (Number_Of_Homework==7 || Number_Of_Homework==8){
        	if (Exam_Grade>55) {
        		System.out.println("your final grade is: "+ ((Exam_Grade*0.8)+(Average*0.2)));
			  	}
			else
				System.out.println("your final grade is: "+ Exam_Grade);
		
	 
        }
	  break;
	  
      case (3):
    	  /*
    	   *In this case The program picks up a positive integer from the user and produces a new number so that each pair of digits will be replaced as follows: 
    	   *The unity digit will become the decimal digit and the decimal digit will become the unity digit .
    	   *The hundred digit will become the thousands  and the thousands  digit will become the hundred, etc.
    	   *If the number of digits is odd, the left digit will remain in place.
	       *The variables in this case are:
    	   *NUMber=An integer number that the user enter.
    	   *NUM2=NUM unity and decimal digit.
    	   *a=NUM2 unity digit.
    	   *b=(NUM2 - NUM2 unity digit.)/10.(For example :if NUM2 is 42 . b is 42 -2 = 40/10 =4).
    	   *c=The Multiplier of a and b every loop iteration.
    	   *NUM3=Collecting the values of a and b and transform them every loop iteration.
    	   */
    	  System.out.println( "please enter an integer number : ");

          NUMber= input.nextInt();
	      while(NUMber>10) {
	    	  NUM2=NUMber%100;
	    	  a=(NUM2%10);
	    	  b=(NUM2-a)/10;
	    	  NUM3+=(b*c)+(a*10*c);
	    	  NUMber=NUMber/100;
	    	  c*=100;	  
	      }
	      System.out.println(NUMber*c+NUM3);	  
		  break;
      case (4):
    	  /*In this case The program receives from the user a positive integer and a number.
    	   *The program will divide the number into parts (right) To the left (so that the length of each section is equal to the value of the digit absorbed). 
    	   *If the last section does not have enough digits, Will remain the remaining length.
    	   *For example: For the number 123456 and the number 2 divide the number into the following parts: 56 | 34 | 12.
    	   *For the number 1234567 and the digit 3 divide the number into the following parts: 567 | 234 | 1.
    	   *The program will produce a new number so that the order of the digits in each part is reversed.
    	   *Example:Enter a number and a digit:
    	   *123456 2
    	   *res = 214365
	       *The variables in this case are:
    	   *NUMber=An integer number.
    	   *diviSor=An integer number between 1 to 9 that divides NUMber into parts. 
    	   *divdiv=10 power diviSor.
    	   *rev1 and rev2= responsible for the reverse action.
    	   *counter= gets every loop iteration the diviSor value and than by powered rev1(variable).
    	   *reVers= gets every loop iteration the reversed number and his section by rev1 power counter(variable).
    	   *
    	   */
    	  System.out.println( "please enter an integer number : ");
	      System.out.println( "please enter an integer number between 1 to 9 : ");

	      NUMber=input.nextInt();
	      diviSor=input.nextInt();
	      divdiv=(int) (Math.pow(10,diviSor));
	      counter=0;
	      rev=0;
	      reVers=0;
	      while(NUMber>10) {
	    	  temp2=NUMber%divdiv;
	    	  rev1=0;
	    	  	while (temp2!=0) {
	    	  		rev2 = temp2%10;
	    	  		rev1= rev1*10+rev2;
	    	  		temp2/=10; }
	    	  reVers += rev1*((int)Math.pow(10,counter));
	    	  counter+=diviSor;
	    	  NUMber/=(int) (Math.pow(10,diviSor));
	  }
	      System.out.println(reVers);
      break;
      case (5):
    	  /*In this case the program  receives from the user an integer number. 
    	   *The program will display a square screen as follows: the lower left triangle of the square will be with * and the upper triangle The right one will be with #.
	       *The variables in this case are:
    	   *NUMber= An integer number the user enter.
    	   * i,j and z = Local variables that allows the programs loops work smoothly by count back and forwards the the loops iteration .
    	   * Aster and Hashtag = Final chars that represent '*' and '#'. 
    	   */
    	  System.out.println( "please enter an integer number : ");
      	  NUMber=input.nextInt();

      	  for (int i=1,j=NUMber-1;i<=NUMber;j--, i++) {
      		  for (int z=0;z<i; z++) {
      			  System.out.print(Aster);}
      		  for (int z=0;z<j; z++) {
      			  System.out.print(Hashtag);
                  }
      		  System.out.println();}
       break;
      case (6):
    	  /*In this case the program receives an odd number that represents the base of a triangle (the input can be assumed to be correct) draw an hourglass by asterisks . 
    	   *Whose upper and lower bases are the width of the absorbed base.
	       *The variables in this case are:
    	   *Odd=An Odd integer number the user enter.
    	   * i,j and k = Local variables that count back and forwards the the loops iteration.
    	   */
    	  System.out.println( "please enter an Odd integer number : ");
      
      	  Odd=input.nextInt();
     
      	  for (int i=0;i<=Odd; i++) {
      		  for (int j=0;j<i;j++){
      			  	System.out.print(" ");}
      		  for(int j=Odd;j>i;j--) {
      			  	System.out.print(Aster+" ");}
    		  
      		  System.out.println();}
             
      	  for (int i=0,k=Odd-1;i<Odd; i++,k--) {
      		  for (int j=0;j<k;j++){
      			  System.out.print(" ");}
      		  for (int j=0;j<=i;j++){
      			  System.out.print(Aster+" ");}		  
      		  System.out.println();}
      break;

      case (7):
    	  /*In this case the program receives an integer number and print "carpet" of squares: 
    	   *The length and width of each square will be the value of the number typed by asterisks.
	       *The variables in this case are:
    	   *Carpet=an integer number that will represent the length and width of each square.
           * i = Represent the length and width of each square.
    	   * l = Moving k(variable) step down.
    	   * k = Moving i(variable) step down.
           * j = Moving i(variable) step aside.
    	   */
    	  System.out.println( "please enter an integer number : ");
          Carpet=input.nextInt();
          for(int l=1;l<=Carpet;l++) {
        	  for(int k=1;k<=Carpet;k++) {
        		  for(int j=1;j<=Carpet;j++) {
        			  for(int i=1;i<=Carpet;i++) {
        				  System.out.print(Aster+" ");}
        			  System.out.print(" ");}	
        		  System.out.println();}
      		  System.out.println();}
      break;

      case 8:
    	  /*Mates numbers are a pair of numbers each equal to the sum of the parts of the other number, not including The number itself but includes 1.
           *The first and smallest pair of friend numbers are the numbers 220 and 284 since:
    	   * 1 - The integers divisors numbers of 220 are :1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110. their sum is 248.
    	   * 2 - The integers divisors numbers of the number 284 are: 1, 2, 4, 71 and 142 and their sum is 220.
    	   * 
    	   *In this case the program represent the first ten Mates numbers.
	       *The variables in this case are:
    	   *counter=counts till ten Mates numbers.
    	   *mate1 and mate2= represent each mate number.
    	   *checkMate1=checking if the numbers are "mates".
    	   *lastMate= represent the last mate that found.
    	   */
	      System.out.println("You chose first 10 mate numbers");
	      System.out.println("Note that this section needs a few seconds to finish running. Please be patient until the counter reaches 10");
	      counter = 0;
	      mate1 = 0;
	      lastMate = 0;
          while (counter < 10) {
	    	  mate2 = 0;
	    	  checkMate1 = 0;
	      for(int i = 1; i < mate1; i++) {
	    	  if (mate1 % i == 0) {
	    		  mate2 += i;
	    	  }
	      	}
	      for(int i = 1; i < mate2; i++) {
	    	  if (mate2 % i == 0) {
	    		  checkMate1 += i;
	    	  }
	      	}
	      	if ((checkMate1 == mate1) && (mate2 != mate1) && (lastMate != mate1)) {
	      		lastMate = mate2;
	      		counter++;
	      		System.out.println(counter + ") " + mate1 + " and " + mate2 + " are mates");
	      	}
	      	mate1++;
	      	}
	  break;
      case (9):
    	  /*
    	   *Menu exit.
    	   */
    	  System.out.println("You chose exit");
      break;
      default:
    	  /*
    	   * The default in this switch print to the user "Invalid input".
    	   */
          System.out.println("Invalid input");
          break;
	  }}while (menuChoice!=9);
	  
	  System.out.println("Bye Bye. Hope you enjoyed and see you again ");;}}

	

