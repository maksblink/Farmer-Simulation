# Farmer-Simulation

Projektujemy prostą symulację agentową, w której będziemy symulować interakcje farmera z
marchewkami oraz z rynkiem i interakcje marchewki ze szkodnikami oraz pogodą.
Dla uproszczenia przyjmujemy, że farmer posiada 1 pole z 100 grządkami (10 kolumn oraz
10 wierszy). W każdej z grządek może znajdować się sadzonka marchewki, niedojrzała
marchewka, marchewka gotowa do zbioru albo szkodnik.

▶ Możliwe stany nasłonecznienia:
▶ złe
▶ średnie
▶ dobre
▶ bardzo dobre

▶ Możliwe stany wilgotności:
▶ bardzo mała
▶ mała
▶średnia
▶duża
▶bardzo duża

▶ Zachowanie się marchewek:
▶ Na początku marchewka jest w postaci nasiona, które kupuje się na rynku:

▶Cena startowa to 0,2 USD.

▶ Cykl wzrostu marchewek rozpoczyna się od sadzonki (trwa 72 h)

▶ Na tym etapie marchewka reaguje na otoczenie mocno:

▶ Nasłonecznienie:

▶ złe: -10% do wzrostu
▶ średnie: -4% do wzrostu
▶ dobre: +15% do wzrostu
▶ bardzo dobre: +25% do wzrostu

▶ Wilgotność:
▶ bardzo mała: -20% do wzrostu
▶ mała: -7% do wzrostu
▶ średnia: +3% do wzrostu
▶duża: +21% do wzrostu
▶ bardzo duża: -20% do wzrostu

▶ Następnie marchewka jest w fazie niedojrzałości (trwa 240 h)

▶ Na tym etapie marchewka reaguje na otoczenie mocno:

▶ Nasłonecznienie:

▶ złe: -5% do wzrostu
▶ średnie: -2% do wzrostu
▶ dobre: +6% do wzrostu
▶ bardzo dobre: +16% do wzrostu

▶ Wilgotność:
▶ bardzo mała: -10% do wzrostu
▶ mała: -3% do wzrostu
▶ średnia: +1% do wzrostu
▶duża: +10% do wzrostu
▶ bardzo duża: -10% do wzrostu

▶ Po tym czasie marchewka jest gotowa do zbioru.

▶ Po zebraniu marchewek farmer sprzedaje je na rynku.

▶ Pole na którym nic nie rośnie ma 0,25% szans na pojawienie się szkodnika na nim chyba
że takie pole sąsiaduje z innym polem na którym jest szkodnik wtedy szansa ta wzrasta do
1,5%. Koszt usunięcia szkodnika to 2 USD.

▶ Parametry symulacji:

▶Parametry farmera:

▶Ilość marchewek.

▶Ilość nasion marchwi.

▶Ilość pieniędzy.

▶Parametry pola:

▶ Możliwe stany nasłonecznienia:

▶ złe
▶ średnie
▶ dobre
▶ bardzo dobre

▶ Możliwe stany wilgotności:

▶ bardzo mała
▶ mała
▶średnia
▶duża
▶bardzo duża

▶Parametry grządki:

▶Czy jest marchewka w stanie sadzonka.
▶Czy jest marchewka w stanie niedojrzałym.
▶Czy jest marchewka w stanie gotowym.
▶Czy jest szkodnik.

▶Parametry rynku:

▶Cena zakupu nasion
▶Cena sprzedaży marchewek


