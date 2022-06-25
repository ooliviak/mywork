import java.util.*;

public class AddingMachine {

	public static void main (String[] args) {

		Scanner scanner = new Scanner(System.in);
		boolean isPreviousZero = false;
		int total = 0;
		int subtotal = 0;
		int input;
		int MAXIMUM_NUMBER_OF_INPUTS = 100;
        int[] listOfInputs = new int[MAXIMUM_NUMBER_OF_INPUTS];
        int index = 0;

        // TODO Add code anywhere below to complete AddingMachine
		while (true) {
			input = scanner.nextInt();
//			for (index = 0; index < MAXIMUM_NUMBER_OF_INPUTS; index++) {
//				listOfInputs[index] = input;
//			}
			listOfInputs[index] = input;
			index ++;
			if (input == 0) {
				if (isPreviousZero) {
					System.out.println("total " + total);
					for (index = 0; index < listOfInputs.length; index++) {
						if (listOfInputs[index] != 0) {
							System.out.println(listOfInputs[index]);
						}
					}
					return;
				} else {
					System.out.println("subtotal " + subtotal);
					total += subtotal;
					subtotal = 0;
					isPreviousZero = true;
				}
			}
			subtotal += input;
			if (input != 0) {
				isPreviousZero = false;
			}


		}
	}

}