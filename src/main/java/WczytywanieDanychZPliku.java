
import java.io.BufferedReader;
import java.io.FileReader;

public class WczytywanieDanychZPliku {

	protected String nazwaPliku;
	protected String pasujaceLinijkiRegEx;
	int kolumnaInteresujaca1;
	int kolumnaInteresujaca2;
	int kolumnaInteresujaca3;
	int[] kolumnyInteresujace;
	int minimalnaDlugoscTablicy;
	int liczbaWierszy;
	int liczbaKolumn;

	public String[][] wczytajPlik() throws Exception {

		String[][] wynik = new String[liczbaWierszy][liczbaKolumn];

		BufferedReader br = new BufferedReader(new FileReader(nazwaPliku));

		try {

			String line = br.readLine();

			for (int i = 0; line != null;) {
				boolean pasuje = line.matches(pasujaceLinijkiRegEx);
				if (pasuje) {

					String[] plikBezBialychZnakow = line.split("[\\s\\*]+");

					if (plikBezBialychZnakow.length >= minimalnaDlugoscTablicy) {
						for (int j = 0; j <= 2; j++) {

							wynik[i][j] = plikBezBialychZnakow[kolumnyInteresujace[j]];
						}
					

						i++;
					}

				}

				line = br.readLine();
			}

			return wynik;

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			br.close();
		}

		return null;
	}

}
