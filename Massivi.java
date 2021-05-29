import java.util.Scanner;
import java.util.ArrayList;

public class Massivi {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList <Integer> array = new ArrayList<>();
		int number;
		System.out.println("¬ведите массив");
		while (scan.hasNextInt()) {
			array.add(scan.nextInt()); 
		}
		boolean isSorted = false;
        int buf;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.size()-1; i++) {
                if(array.get(i) > array.get(i+1)){
                    isSorted = false; 
                    buf = array.get(i);
                    array.set(i, i+1);
                    array.set(i+1, buf);
                }
            }
        }
        int[] arr = new int[array.size()];
        int j=1;
        arr[0] = array.get(0);
        for (int i = 1; i < array.size(); i++) {
        	if(array.get(i) != array.get(i-1))
        	{
        		arr[j]=array.get(i);
        		j++;
        	}	
        }
        for (int i=0; i<j; i++) {
            System.out.print(arr[i]+" ");
            }
	}
}
