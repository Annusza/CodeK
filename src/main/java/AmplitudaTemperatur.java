
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AmplitudaTemperatur extends WczytywanieDanychZPliku {

	public static void main(String[] args) throws Exception {

		AmplitudaTemperatur amplitudaTemperatur = new AmplitudaTemperatur();

		String[][] plik = amplitudaTemperatur.wczytajPlik();
		// String[][] plik = amplitudaTemperatur.wczytajPlikPogody(); 

		int[] amplitudaDzienna = amplitudaTemperatur.obliczRoznice(plik);
		int najmniejszaAmplituda = amplitudaTemperatur.znajdzIndeks(amplitudaDzienna);
		System.out.println("Dzieñ w miesi¹cu, w którym wyst¹pi³a najmniejsza amplituda " + najmniejszaAmplituda
				+ " (na podstawie danych pobranych z pliku). ");

	}

	public AmplitudaTemperatur() {
		super();
		nazwaPliku = "weather.dat";
		pasujaceLinijkiRegEx = "[\\s]*[0-9]+.*";
		kolumnyInteresujace = new int[] { 1, 2, 3 };
		minimalnaDlugoscTablicy = 4;
		liczbaWierszy = 30;
		liczbaKolumn = 3;

	}

	/**
	 * 
	 * @return String zawartoœæ pliku "weather.dat" wczytanego przez metodê lub
	 *         null kiedy nie uda³o siê wczytaæ pliku
	 * @throws Exception
	 */
	public String[][] wczytajPlikPogody() throws Exception {

		String[][] wynik = new String[30][3];

		BufferedReader br = new BufferedReader(new FileReader("weather.dat"));

		try {

			String line = br.readLine();

			for (int i = 0; line != null;) {
				boolean pasuje = line.matches("[\\s]*[0-9]+.*");
				if (pasuje) {

					String[] plikBezBialychZnakow = line.split("\\s+");

					if (plikBezBialychZnakow.length >= 4) {

						for (int j = 0; j <= 2; j++) {

							wynik[i][j] = (plikBezBialychZnakow[j + 1].replaceAll("\\*", ""));

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

	public int[] obliczRoznice(String[][] plik) {
		int amplitudaDzienna = 0;
		int[] tablicaAmpitud = new int[plik.length];
		int indeksTablicyAmplitud;

		for (int i = 0; i < plik.length; i++) {
			amplitudaDzienna = Integer.parseInt(plik[i][1]) - Integer.parseInt(plik[i][2]);
			indeksTablicyAmplitud = Integer.parseInt(plik[i][0]) - 1;
			tablicaAmpitud[indeksTablicyAmplitud] = amplitudaDzienna;
		}

		return tablicaAmpitud;
	}

	public int znajdzIndeks(int[] tablicaAmplitud) {
		int amplitudaMinimalna = tablicaAmplitud[0];
		int indeksMinimalnejAmplitudy = 0;
		for (int i = 0; i < tablicaAmplitud.length; i++) {
			if (tablicaAmplitud[i] < amplitudaMinimalna) {
				amplitudaMinimalna = tablicaAmplitud[i]; 
				indeksMinimalnejAmplitudy = i;
			}
		}

		return indeksMinimalnejAmplitudy + 1;
	}

}
