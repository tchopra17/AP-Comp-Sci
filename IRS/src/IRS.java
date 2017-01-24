import chn.util.ConsoleIO;

public class IRS {

	public static void main(String[] args) {
		String filingStat;
		boolean sOrM = false;
		double income;
		
		ConsoleIO input = new ConsoleIO();
		
		// First Run
		System.out.print("Filing Status (Single or Married): ");
		filingStat = input.readToken();
		char stat = filingStat.charAt(0);
		System.out.print("Taxable Income: ");
		income = input.readDouble();
		
		if (stat == 's' || stat == 'S') {
			sOrM = true;
		} else if (stat == 'm' || stat == 'M') {
			sOrM = false;
		}
		
		TaxPayer tax = new TaxPayer(sOrM, income);
		System.out.println("FedralTax: "+tax.calculateTax());
		
		//First Run
		System.out.print("Filing Status (Single or Married): ");
		filingStat = input.readToken();
		stat = filingStat.charAt(0);
		System.out.print("Taxable Income: ");
		income = input.readDouble();
		
		if (stat == 's' || stat == 'S') {
			sOrM = true;
		} else if (stat == 'm' || stat == 'M') {
			sOrM = false;
		}
		
		TaxPayer tax1 = new TaxPayer(sOrM, income);
		System.out.println("FedralTax: "+tax1.calculateTax());
	}
	
}

