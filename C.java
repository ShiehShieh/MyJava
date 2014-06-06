public class C {
	private int m;
	private int n;

	public C(int mIn, int nIn){
		m = mIn;
		n = nIn;
	}

	public int m1(){
		return m+n;
	}
 
}

class B extends C {
	private float n;
	private float m;

	public B(float mIn, float nIn) {
		this.m = mIn;
		this.n = nIn;
	}

	public float m1() {
		return m - n;
	}
}