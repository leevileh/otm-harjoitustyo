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
- käyttäjä voi tarkastella "high-score" -listaa

### Pelaaminen
- autolla voi kiihdyttää, kääntyä ja peruuttaa/jarruttaa
- auto ei voi mennä kentän reunojen läpi
- ajan mittaaminen alkaa kun auto ylittää lähtö/maaliviivan
  - ajan mittaaminen päättyy kun auto ylittää uudestaan lähtö/maaliviivan
  - peliä ei voi huijata ylittämällä lähtöviivaa, peruuttamalla ja ylittämällä sen heti uudestaan
  
### Pelaamisen jälkeen
- käyttäjä voi tallentaa parhaan kierrosaikansa "high-score" -listalle
