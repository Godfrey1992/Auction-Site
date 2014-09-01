package come.myEbay;

public class MyEbayException extends Exception {

	private static final long serialVersionUID = 1L;

	public MyEbayException() {
		this("Exception");
	}

	public MyEbayException(String msg) {
		super(msg);
	}
}
