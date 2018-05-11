# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen on tarkoitus olla yksinkertainen kaksiulotteinen autopeli. Pelissä käyttäjä eli pelaaja ohjaa nuolinäppäimiä käyttäen 
autoa radalla, jolla on reunat. Radan reunojen läpi ei ole mahdollista ajaa. Peli mittaa aikaa jossa käyttäjä kykenee ajamaan 
yhden kierroksen radalla. Parhaita kierrosaikoja voi tarkastella "high-score" -listalta.

## Käyttäjät

Sovelluksella on ainoastaan yksi käyttäjärooli eli pelaaja. 

## Perusversion tarjoama toiminnallisuus

### Ennen pelaamisen aloittamista
- käyttäjä voi antaa nimen jolla parhaat kierrosajat tallennetaan
  - nimen ei tarvitse olla uniikki
  - nimellä on maksimipituus jotta se mahtuu kokonaisuudessaan "high-score" -listalle

### Pelaaminen
#### Ajo-ominaisuudet
- autolla voi kiihdyttää, kääntyä ja peruuttaa/jarruttaa
- auto ei voi kiihtyä loputtomiin, eli sillä on maksiminopeus
- kun autoa ei kiihdytetä, hidastuu sen vauhti automaattisesti
- reunaan törmääminen aiheuttaa kimpoamisefektin  

#### Muut ominaisuudet
- auto ei voi mennä kentän reunojen läpi
- ajan mittaaminen alkaa kun auto ylittää lähtö/maaliviivan
  - kierrosaika tallennetaan kun auto ylittää uudestaan lähtö/maaliviivan
    - tämä nollaa ajanoton
  - peliä ei voi huijata ylittämällä lähtöviivaa, peruuttamalla ja ylittämällä se heti uudestaan  
  
### Pelaamisen jälkeen
- käyttäjä voi tarkastella parhaita kierrosaikoja "high-score" -listalta

### Jatkokehitysideoita    

- realistisemmat ajo-ominaisuudet
  - auto ei voi kiihtyä loputtomiin
  - kun autoa ei kiihdytetä, hidastuu sen vauhti automaattisesti
  - jonkinlainen kitkankaltainen ominaisuus renkaisiin, jotta suunta vaihtuisi pelkästä renkaiden kääntämisestä (eikä kiihdyttämällä kuten avaruuspeleissä)
- mahdollisuus nähdä paras ajettu kierros "haamuna" radalla
- mahdollisuus kaksinpeliin
- pelimusiikki ja äänitehosteita
- mahdollisuus piirtää omia ratoja (Iso osa toiminnallisuudesta jo toteutettu)
