package random;

public class leetcode {
	int bigParking;
	int mediumParking;
	int smallParking;

	public leetcode(int big, int medium, int small) {
		bigParking = big;
		mediumParking = medium;
		smallParking = small;

	}

	public boolean addCar(int carType) {
		
		if ( carType == 1 ) {
			if ( bigParking > 0 ) {
				bigParking = bigParking -1;
				return true;
			}else {
				return false;
			}
		}
		
		if ( carType == 2 ) {
			if ( mediumParking > 0 ) {
				mediumParking = mediumParking -1;
				return true;
			}else {
				return false;
			}
		}
		
		if ( carType == 3 ) {
			if ( smallParking > 0 ) {
				smallParking = smallParking -1;
				return true;
			}else {
				return false;
			}
		}
		return false;

	}

	public static void main(String[] args) {
		leetcode parking = new leetcode(1, 1, 0);
		System.out.println(parking.addCar(1));
		System.out.println(parking.addCar(2));
		System.out.println(parking.addCar(3));
		System.out.println(parking.addCar(1));

	}

}
