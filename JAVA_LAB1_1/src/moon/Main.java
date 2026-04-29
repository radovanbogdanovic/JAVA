package moon;

import java.io.IOException;

import emergency.LowCapacity;

public class Main {
	public static void main(String[] args) throws IOException, LowCapacity {
		System.out.println("Program je pokrenut.");

		MoonBaseAlpha baza = new MoonBaseAlpha();

		System.out.println("Dodajem Eaglove u bazu.");
		baza.ulaz(new Eagle(101));
		baza.ulaz(new Eagle(102));
		baza.ulaz(new Eagle(103));
		baza.ulaz(new Eagle(104));

		System.out.println("Svi Eaglovi su dodati. Pozivam uzbunu.");
		baza.uzbuna();

		System.out.println("Program je zavrsen.");
	}
}
