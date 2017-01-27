public class Pair{
		public int x;
		public int y;
		
		
	public Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public Pair getPair(){
		return this.getPair();//incorrect function
	}
	
	public void setX(int x){
		this.x = x ;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
}

// Java point class