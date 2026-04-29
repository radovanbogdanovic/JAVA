package moon;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;

import emergency.LowCapacity;

public class MoonBaseAlpha {
	private ArrayList<Eagle> eaglovi;

	public MoonBaseAlpha() {
		this.eaglovi = new ArrayList<Eagle>();
	}

	public void ulaz(Eagle eagle) {
		eaglovi.add(eagle);
		System.out.println(eagle + " je dodat u bazu.");
	}

	public void uzbuna() throws LowCapacity, IOException {

		if (eaglovi.isEmpty()) {
			throw new LowCapacity("U bazi nema Eaglova.");
		}

		System.out.println("Sortiram Eaglove po kargo kapacitetu.");
		eaglovi.sort(Comparator.reverseOrder());

		Eagle najprostraniji = eaglovi.get(0);
		System.out.println("Najveci kapacitet ima Eagle: " + najprostraniji + ".");

		if (najprostraniji.getKargoKapacitet() < 100) {
			throw new LowCapacity("Eagle sa najvecim kargo kapacitetom ima manje od 100 tona.");
		}

		System.out.println("Upisujem do 3 Eagla sa najvecim kapacitetom u eagle.bin.");
		try (DataOutputStream izlaz = new DataOutputStream(
				Files.newOutputStream(Path.of("eagle.bin")))) {

			int brojZaUpis = Math.min(3, eaglovi.size());

			for (int i = 0; i < brojZaUpis; i++) {
				System.out.println("Upisujem redni broj: " + eaglovi.get(i).getRedniBroj());
				izlaz.writeInt(eaglovi.get(i).getRedniBroj());
			}
		}
		System.out.println("Upis u eagle.bin je zavrsen.");
	}
}
