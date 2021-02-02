public class StrategyPattern {
	public static void main(String[] args) {
		
	}
}

interface Strategy {
	double getPrice(double price);
}

class FullPrice implements Strategy {
	@Override
	public double getPrice(double price) {
		return price;
	}
	
}

class HalfPrice implements Strategy {
	@Override
	public double getPrice(double price) {
		return price * 0.5;
	}
}