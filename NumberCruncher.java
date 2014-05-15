public class NumberCruncher{
	private int singleOne = 0;

	public NumberCruncher(int in){
		this.singleOne = in;
	}

	public int getIt(){

		return this.singleOne;

	}

	public int doubleIt(){

		return this.singleOne *= 2;

	}

	public int tripleIt(){

		return this.singleOne *= 3;

	}

	public int squareIt(){

		return this.singleOne *= this.singleOne;

	}

	public int cubeIt(){

		return this.singleOne *= this.singleOne * this.singleOne;

	}

	public static void main(String[] args) {
		NumberCruncher numbercruncher = new NumberCruncher(5);
		numbercruncher.getIt();
		numbercruncher.doubleIt();
		numbercruncher.tripleIt();
		numbercruncher.squareIt();
		numbercruncher.cubeIt();
	}
}
