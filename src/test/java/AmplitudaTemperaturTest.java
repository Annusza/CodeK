import static org.junit.Assert.*;

import org.junit.Test;

public class AmplitudaTemperaturTest {

	@Test
	public void testZnajdzIndeks() {

		AmplitudaTemperatur amplitudaTemperatur = new AmplitudaTemperatur();

		int[] tablicaAmplitud1 = { 1, 2, 5, 6 };
		int[] tablicaAmplitud2 = { 12, 19, 13, 4 };

		int wynikOtrzymany1 = amplitudaTemperatur.znajdzIndeks(tablicaAmplitud1);
		int wynikOtrzymany2 = amplitudaTemperatur.znajdzIndeks(tablicaAmplitud2);
		
		String komunikat = "Metoda znajdzIndeks(int[] tablicaAmplitud) powinna wyliczaæ indeks minimalnej ró¿nicy ";
		
		int wynikSpodziewany1 = 1;
		int wynikSpodziewany2 = 4;

		assertEquals(komunikat, wynikSpodziewany1, wynikOtrzymany1);
		assertEquals(komunikat, wynikSpodziewany2, wynikOtrzymany2);

	}

	@Test
	public void testObliczRoznice() {

		AmplitudaTemperatur amplitudaTemperatur = new AmplitudaTemperatur();

		String[][] plik1 = { { "1", "2", "5" }, { "2", "7", "8" }, { "3", "10", "11" } };
		String[][] plik2 = { { "1", "20", "50" }, { "2", "17", "8" }, { "3", "1", "0" } };

		int[] wynikOtrzymany1 = amplitudaTemperatur.obliczRoznice(plik1);
		int[] wynikOtrzymany2 = amplitudaTemperatur.obliczRoznice(plik2);

		String komunikat = "Metoda obliczRoznice(String[][] plik) powinna wyliczaæ tablicê ró¿nic ";

		int[] wynikSpodziewany1 = { 2 - 5, 7 - 8, 10 - 11 };
		int[] wynikSpodziewany2 = { 20 - 50, 17 - 8, 1 - 0 };
		
		assertArrayEquals(komunikat, wynikSpodziewany1, wynikOtrzymany1);
		assertArrayEquals(komunikat, wynikSpodziewany2, wynikOtrzymany2);

	}

	@Test
	public void testWczytywaniaPlikuPogody() throws Exception {

		AmplitudaTemperatur amplitudaTemperatur = new AmplitudaTemperatur();

		String[][] wynikOtrzymany = amplitudaTemperatur.wczytajPlikPogody();

		String komunikat = "Metoda wczytajPlikPogody() powinna wyliczaæ tablicê temperatur ";
		
		String[][] wynikSpodziewany = { { "1", "88", "59" }, { "2", "79", "63" }, { "3", "77", "55" },
				{ "4", "77", "59" }, { "5", "90", "66" }, { "6", "81", "61" }, { "7", "73", "57" }, { "8", "75", "54" },
				{ "9", "86", "32" }, { "10", "84", "64" }, { "11", "91", "59" }, { "12", "88", "73" },
				{ "13", "70", "59" }, { "14", "61", "59" }, { "15", "64", "55" }, { "16", "79", "59" },
				{ "17", "81", "57" }, { "18", "82", "52" }, { "19", "81", "61" }, { "20", "84", "57" },
				{ "21", "86", "59" }, { "22", "90", "64" }, { "23", "90", "68" }, { "24", "90", "77" },
				{ "25", "90", "72" }, { "26", "97", "64" }, { "27", "91", "72" }, { "28", "84", "68" },
				{ "29", "88", "66" }, { "30", "90", "45" } };
		
		assertArrayEquals(komunikat, wynikSpodziewany, wynikOtrzymany);

	}
	
	@Test
	public void testWczytywaniaPliku() throws Exception {
		
		AmplitudaTemperatur amplitudaTemperatur = new AmplitudaTemperatur();
		
		String[][] wynik1 = amplitudaTemperatur.wczytajPlikPogody();
		
		String komunikat = "Metoda wczytajPlik() powinna zwracaæ to samo co metoda wczytajPlikPogody() ";
		
		String[][] wynik2 = amplitudaTemperatur.wczytajPlik();
		
		assertArrayEquals(komunikat, wynik2, wynik1);
		
	}

}
