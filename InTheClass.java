public class InTheClass {
	
	public static double sqrt(String nStr) {
		double n = 0;

		try {
			n = Double.parseDouble(nStr);
		} catch(NumberFormatException e){
			e.printStackTrace();
			System.out.println("Illegal Input");
		}

		return Math.sqrt(n);
	}

	public static void main(String[] args) {
		System.out.println(InTheClass.sqrt("abc"));
	}
}
