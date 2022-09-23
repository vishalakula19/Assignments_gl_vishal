import java.util.Scanner;

class FindMissingNumber{
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int size = in.nextInt();
	int[] arr = new int[size-1];
	for(int i=0;i<size-1;i++){
		arr[i] = in.nextInt();
	}
	System.out.println(missingNumberFinder(arr, size));
}
	static int missingNumberFinder(int[] arr, int size){
		top:
		for(int i=1;i<=size;i++){
			for(int j=0;j<size-1;j++){
				if(arr[j] == i){
					continue top;
				}
			}
			// if no number found in j loop then we found the missing number
			return i;
		}
	return -1;	
	}
}