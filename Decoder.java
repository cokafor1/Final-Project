
public enum Decoder {
		OPEN (0), WALL (1), START (2), END (3);
	
	private int value;
	
	private Decoder(int value){
		this.value = value;
	}
	
	public int getDecoder(){
		return value;
	}
}