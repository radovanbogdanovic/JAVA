package moon;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Eagle implements Comparable<Eagle> {
	private int redniBroj;
	private double kargoKapacitet;

	public Eagle(int redniBroj) throws IOException {
		System.out.println("Kreiram Eagle " + redniBroj + ".");
		this.redniBroj = redniBroj;
		this.kargoKapacitet = ucitajKargoKapacitet(redniBroj);
		System.out.println("Eagle " + redniBroj + " je ucitan sa kargo kapacitetom " + kargoKapacitet + " t.");
	}

	private double ucitajKargoKapacitet(int redniBroj) throws IOException {
		Path putanja = Path.of(redniBroj + ".txt");
		String tekst = Files.readString(putanja).trim();

		return Double.parseDouble(tekst);
	}

	public int getRedniBroj() {
		return redniBroj;
	}

	public double getKargoKapacitet() {
		return kargoKapacitet;
	}

	@Override
	public int compareTo(Eagle drugi) {
		return Double.compare(this.kargoKapacitet, drugi.kargoKapacitet);
	}

	@Override
	public String toString() {
		return "Eagle " + redniBroj + " (" + kargoKapacitet + " t)";
	}
}
