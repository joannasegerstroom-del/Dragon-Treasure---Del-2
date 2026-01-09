#  Dragon Treasure — Del 2


*Författare: Joanna Segerström, Oscar Dahl, Valentino Markouch*  
*Datum: 2026-01-08*  
*Version: 2.0*  
*Språk: Java*  

##  Om spelet


Dragon Treasure är ett äventyrsspel skrivet i java, där spelaren utforskar en grotta ***Dungeon*** genom olika dörrar och rum samt är ett turbaserade fightingspel med vapen, potions och skatt.
Det är ett textbaserat spel med fokus på objektorienterad programmering (OOP).
Spelet hanterar navigering mellan rum via olika dörrar samt håller koll på spelarens position i grottan. Spelaren bekämpar monster och hittar skatter samt andra föremål i de olika rumen.  spelet navigerar man mellan olika rum genom att använda väderstrecken (n, v, ö, s).

## ⚙️ Funktioner

- **Navigering**  
  Genom att välja olika väderstreck (**N / S / V / O**) kan spelaren förflytta sig från ett rum till ett annat.  
  Vi valde att byta ut bokstaven **Ö (öster)** mot **O**, på grund av problem som uppstod vid användning av tecknet **Ö**.

- **doNarrative**  
  Varje rum har en unik beskrivning som skrivs ut när spelaren anländer till rummet.  
  Det skrivs även ut vilka dörrar som finns kopplade till rummet för vidare navigering.

- **Låsta dörrar**  
  Samtliga dörrar har ett lås som antingen kan vara:
  - `false` – dörren är upplåst  
  - `true` – dörren är låst  

  Denna funktion är tillagd eftersom en av dörrarna är låst och kräver en nyckel för att öppnas.  
  I nuläget finns ingen nyckel, och därmed inget sätt att öppna den låsta dörren, eftersom detta inte var nödvändigt enligt uppgiftsbeskrivningen.

- **Items**
    Det finns olika items att hitta i de olika rummen. Dessa items är:
    - `Potion` - Potions används för att vårda spelaren.
    - `Weapon` - Weapons används för att öka skada mot fiender.
    - `Treasure` - Treasure ger guld till spelare.
    - `Key` - Key används för att öppna låsta dörrar.

- **Objektorienterad design**  
  Tydlig uppdelning mellan spellogik, kart-setup och entiteter.



Du styr en spelare genom olika rum i en dungeon. Målet är att hitta skatten innan du dör!  
På vägen kan du:
-  Strida mot monster
-  Hitta nycklar för att öppna låsta dörrar
-  Plocka upp potioner för att återställa liv
-  Samla skatter

##  Projektstruktur

Projektet är skrivet i **Java** och innehåller flera klasser som bygger spelets logik:

| Fil | Beskrivning |
|-----|-------------|
| `Main.java` | Startar spelet |
| `Player.java` | Spelarens egenskaper och handlingar |
| `Monster.java` | Monster som spelaren möter |
| `Dungeon.java` | Dungeon-logik och rumshantering |
| `Room.java` | Individuella rum |
| `Item.java` | Basobjekt för föremål |
| `Weapon.java` | Vapen som kan användas |
| `Potion.java` | Hälsopotioner |
| `Key.java` | Nycklar |
| `Door.java`| Dörrar |
| `Treasure.java` | Skatt att hitta |
| `Dragon.java` | Dragon-logik |

##  Kom igång med spelet

### Förutsättningar

- Installation av **Java Development Kit (JDK)** krävs.
- Ladda ned källkoden till en mapp på datorn.
- Öppna en terminal och navigera till mappen.
- Kompilera alla Java-filer:

```bash
javac *.java
```

- Starta spelet:

```bash
java Main
```

---

### 🎮 Kontroller

När spelet startar skriver du in ditt namn och trycker på **[Enter]** för att komma till det första rummet.  
Därefter navigerar du igenom grottan genom att skriva in bokstaven för det väderstreck du vill gå mot, följt av **[Enter]**.

- **`N`** – Gå norrut  
- **`S`** – Gå söderut  
- **`V`** – Gå västerut  
- **`O`** – Gå österut  
- **`Q`** – Avsluta spelet  
- **`P`** - Plocka upp item
