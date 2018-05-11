# Käyttöohje

Lataa tiedosto [cargame.jar](https://github.com/leevileh/otm-harjoitustyo/releases/tag/0.1)
Lataa tietokanta [cargame.db](https://github.com/leevileh/otm-harjoitustyo/blob/master/CarGame/db/cargame.db) 

## Konfigurointi
Pidä huolta siitä että cargame.jar -tiedoston sijainnissa on kansio db, joka sisältää tietokannan cargame.db, muuten sovellus ei toimi.

Ohjelma käynnistetään komennolla:

java -jar cargame.jar

## Nimen syöttäminen
Syötä nimesi aloitusnäkymään ja aloita pelaaminen painamalla "Start!" -nappia. Nimen on oltava 1-20 merkkiä pitkä.
<img src="https://github.com/leevileh/hello-world/blob/master/Aloitusn%C3%A4kym%C3%A4.PNG">

## Pelaaminen
Peliä pelataan nuolinäppäimiä hyödyntäen. Tarkoitus on ajaa mustalla rajattu rata mahdollisimman nopeasti ympäri. Punaisella alueella ajastin nollautuu. Mikäli kierros on ajettu kokonaisuudessaan, tallentuu kierrosaika pelin välimuistiin punaiselle alueelle saavuttaessa. Kerralla voi ajaa useamman kierroksen, jotka kaikki tallentuvat välimuistiin. Pelaamisen voi lopettaa painamalla "End Game" -nappia.
<img src="https://github.com/leevileh/hello-world/blob/master/Pelin%C3%A4kym%C3%A4.PNG">

## Parhaat kierrosajat
"End Game" -nappi tallentaa välimuistissa olevat kierrosajat pysyvään tietokantaan, ja tuo näkyviin tietokannasta löytyvät parhaat kierrosajat. Pelin voi aloittaa alusta sulkemalla pelin ja käynnistämällä uudelleen. 
<img src="https://github.com/leevileh/hello-world/blob/master/Loppun%C3%A4kym%C3%A4.PNG">
