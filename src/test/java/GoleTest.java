import static org.junit.Assert.*;

import org.junit.Test;

public class GoleTest {

	@Test
	public void testZnajdzIndeks() {

		Gole gole = new Gole();

		int[] tablicaRoznicGoli1 = { 1, 2, 5, 6 };
		int[] tablicaRoznicGoli2 = { 12, 19, 13, 4 };

		int wynikOtrzymany1 = gole.znajdzIndeksDruzynyONajmniejszejRoznicyGoli(tablicaRoznicGoli1);
		int wynikOtrzymany2 = gole.znajdzIndeksDruzynyONajmniejszejRoznicyGoli(tablicaRoznicGoli2);

		String komunikat = "Metoda znajdzIndeksDruzynyONajmniejszejRoznicyGoli(int[] tablicaRoznicGoli) powinna wyliczaæ indeks minimalnej ró¿nicy";

		int wynikSpodziewany1 = 0;
		int wynikSpodziewany2 = 3;

		assertEquals(komunikat, wynikSpodziewany1, wynikOtrzymany1);
		assertEquals(komunikat, wynikSpodziewany2, wynikOtrzymany2);

	}

	@Test
	public void testObliczRozniceGoli() {

		Gole gole = new Gole();

		String[][] plik1 = { { "1", "21", "5" }, { "3", "17", "8" }, { "7", "11", "11" } };
		String[][] plik2 = { { "1", "31", "10" }, { "7", "10", "1" }, { "9", "11", "0" } };

		int[] wynikOtrzymany1 = gole.obliczRozniceGoli(plik1);
		int[] wynikOtrzymany2 = gole.obliczRozniceGoli(plik2);

		String komunikat = "Metoda obliczRozniceGoli(String[][] plik) powinna wyliczaæ tablicê ró¿nic ";

		int[] wynikSpodziewany1 = { 21 - 5, 17 - 8, 11 - 11 };
		int[] wynikSpodziewany2 = { 31 - 10, 10 - 1, 11 - 0 };

		assertArrayEquals(komunikat, wynikSpodziewany1, wynikOtrzymany1);
		assertArrayEquals(komunikat, wynikSpodziewany2, wynikOtrzymany2);

	}

	@Test
	public void testWczytywaniaPlikuFootball() throws Exception {

		Gole gole = new Gole();

		String[][] wynikOtrzymany = gole.wczytajPlikFootball();

		String komunikat = "Metoda wczytajPlikFootball() powinna wyliczaæ tablicê goli ";

		String[][] wynikSpodziewany = { { "Arsenal", "79", "36" }, { "Liverpool", "67", "30" },
				{ "Manchester_U", "87", "45" }, { "Newcastle", "74", "52" }, { "Leeds", "53", "37" },
				{ "Chelsea", "66", "38" }, { "West_Ham", "48", "57" }, { "Aston_Villa", "46", "47" },
				{ "Tottenham", "49", "53" }, { "Blackburn", "55", "51" }, { "Southampton", "46", "54" },
				{ "Middlesbrough", "35", "47" }, { "Fulham", "36", "44" }, { "Charlton", "38", "49" },
				{ "Everton", "45", "57" }, { "Bolton", "44", "62" }, { "Sunderland", "29", "51" },
				{ "Ipswich", "41", "64" }, { "Derby", "33", "63" }, { "Leicester", "30", "64" } };
		
		assertArrayEquals(komunikat, wynikSpodziewany, wynikOtrzymany);

	}
	
	@Test
	public void testWczytywaniaPliku() throws Exception {
		
		Gole gole = new Gole();
		
		String[][] wynik1 = gole.wczytajPlikFootball();
		
		String komunikat = "Metoda wczytajPlik() powinna zwracaæ to samo co metoda wczytajPlikFootball() ";
		
		String[][] wynik2 = gole.wczytajPlik();
		
		assertArrayEquals(komunikat, wynik2, wynik1);
		
	}

}
