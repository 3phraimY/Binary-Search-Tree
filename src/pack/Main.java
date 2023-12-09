package pack;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		int[] randomInt = new int[10];
		Random r = new Random();
		for(int i =0; i<10; i++)
		{
			randomInt[i] = i;			
		}
		for(int i =0; i<10; i++)
		{
			int randomPos = Math.abs(r.nextInt()%10);
			int originalValue = randomInt[i];
			randomInt[i] = randomInt[randomPos];
			randomInt[randomPos] = originalValue;			
		}
		for(int i =0; i<10; i++)
		{			
			tree.Insert(randomInt[i]);
		}
		tree.PrintStructure();
		System.out.println();
		
		int[] numbers = threeRandomNumbers();
		for(int i = 0; i<numbers.length; i++)
		{
			tree.Remove(numbers[i]);
		}
		tree.PrintStructure();
		System.out.println();
		
		numbers = threeRandomNumbers();
		for(int i = 0; i<numbers.length; i++)
		{
			System.out.println(tree.Search(numbers[i]));
		}
		
	}
	public static int[] threeRandomNumbers()
	{
		Random r = new Random();
		int[] threeRandomNumbers = new int[3];
		threeRandomNumbers[0] = Math.abs(r.nextInt()%10);
		threeRandomNumbers[1] = Math.abs(r.nextInt()%10);
		threeRandomNumbers[2] = Math.abs(r.nextInt()%10);
		while(threeRandomNumbers[0] == (threeRandomNumbers[1] | threeRandomNumbers[2]))
		{
			while(threeRandomNumbers[1] == threeRandomNumbers[2])
			{
				threeRandomNumbers[1] = Math.abs(r.nextInt()%10);
			}
			threeRandomNumbers[0] = Math.abs(r.nextInt()%10);			
		}
		return threeRandomNumbers;
	}

}
