import java.util.Scanner;

class FirstLetterPrinter{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(firstLetterPrinter(input));

	}

	static String firstLetterPrinter(String input){
		char[] array = input.toCharArray();
		String output = array[0] + "";
		for(int i=0;i<array.length;i++){
			if(array[i] == ' '){
				output += array[i+1] + "";
			}
		}
		return output;

	}

}