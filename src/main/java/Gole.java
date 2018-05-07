
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Gole extends WczytywanieDanychZPliku {

	public static void main(String[] args) throws Exception {

		Gole gole = new Gole();

		String[][] plik = gole.wczytajPlik();
		// String[][] plik = gole.wczytajPlikFootball();

		int[] roznicaGoli = gole.obliczRozniceGoli(plik);
		int druzynaONajmniejszejRoznicyGoli = gole.znajdzIndeksDruzynyONajmniejszejRoznicyGoli(roznicaGoli);
		String nazwaDruzyny = plik[druzynaONajmniejszejRoznicyGoli][0];

		System.out.println("Dru¿yna, dla której ró¿nica pomiêdzy golami strzelonymi a straconymi jest najmniejsza, to "
				+ nazwaDruzyny + " . ");

	}

	public Gole() {
		super();
		nazwaPliku = "football.dat";
		pasujaceLinijkiRegEx = "[\\s]*[0-9]+[\\.][\\s]*[A-Za-z_]+[[\\s]+[0-9]+]{5}[\\s]*.*";
		kolumnyInteresujace = new int[] { 2, 7, 9 };
		minimalnaDlugoscTablicy = 10;
		liczbaWierszy=20;
		liczbaKolumn=3;
	}

	/**
	 * 
	 * @return String zawartoœæ pliku "weather.dat" wczytanego przez metodê lub
	 *         null kiedy nie uda³o siê wczytaæ pliku
	 * @throws Exception
	 */
	public String[][] wczytajPlikFootball() throws Exception {

		String[][] wynik = new String[20][3];

		BufferedReader br = new BufferedReader(new FileReader("football.dat"));

		try {

			String line = br.readLine();

			for (int i = 0; line != null;) {
				// boolean pasuje =
				// line.matches("[\\s]*[0-9]+[\\.][\\s]*[A-Za-z_]+[[\\s]*[0-9]+]{5}[\\s]*[\\-]+[[\\s]*[0-9]]{2}[\\s]*.*");
				boolean pasuje = line.matches("[\\s]*[0-9]+[\\.][\\s]*[A-Za-z_]+[[\\s]+[0-9]+]{5}[\\s]*.*");
				if (pasuje) {

					String[] plikBezBialychZnakow = line.split("[\\s]+");
					// String[] plikBezBialychZnakow = line.split("\\s+");

					if (plikBezBialychZnakow.length >= 10) {

						wynik[i][0] = plikBezBialychZnakow[2];
						wynik[i][1] = plikBezBialychZnakow[7];
						wynik[i][2] = plikBezBialychZnakow[9];

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

	public int[] obliczRozniceGoli(String[][] tablicaDanych) {
		int roznicaGoli = 0;
		int[] tablicaRoznicGoli = new int[tablicaDanych.length];

		for (int i = 0; i < tablicaDanych.length; i++) {
			roznicaGoli = Integer.parseInt(tablicaDanych[i][1]) - Integer.parseInt(tablicaDanych[i][2]);
			if (roznicaGoli < 0) {
				roznicaGoli = roznicaGoli * (-1);
			}
			tablicaRoznicGoli[i] = roznicaGoli;
		}

		return tablicaRoznicGoli;
	}

	public int znajdzIndeksDruzynyONajmniejszejRoznicyGoli(int[] tablicaRoznicGoli) {
		int roznicaGoliMinimalna = tablicaRoznicGoli[0];
		int indeksMinimalnejRoznicyGoli = 0;
		for (int i = 0; i < tablicaRoznicGoli.length; i++) {
			if (tablicaRoznicGoli[i] < roznicaGoliMinimalna) {
				roznicaGoliMinimalna = tablicaRoznicGoli[i]; 
				indeksMinimalnejRoznicyGoli = i;
			}
		}

		return indeksMinimalnejRoznicyGoli;
	}

}
