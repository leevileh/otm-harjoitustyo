# Arkkitehtuurikuvaus

## Rakenne
Ohjelman rakenne on tällä hetkellä kaksikerroksinen, ja koodin pakkausrakenne on seuraava:

<img src="https://github.com/leevileh/hello-world/blob/master/17042018pakkauskaavio.png">

Pakkaus cargame.ui sisältää käyttöliittymän ja cargame.domain sovelluslogiikan. cargame.dao tulee sisältämään tietokantaan tallentamisesta vastaavan koodin.

## Käyttöliittymä
Käyttöliittymä sisältää tällä hetkellä kaksi näkymää.
- Aloitusnäkymä
- Pelinäkymä

Nämä ovat toteutettu Scene-olioina, joista näkyvillä eli sovelluksen stageen sijoitettuna on kerralla vain yksi. Käyttöliittymä löytyy luokasta cargame.ui.CarGameUi.

## Sovelluslogiikka
Sovelluksen loogisen datamallin muodostavat luokat Car ja Track, jotka kuvaavat autoja ja ratoja joilla autot sijaitsevat. Jokaisella autolla on vain yksi rata, mutta sama rata voisi olla käytössä useammallakin autolla. Toiminnallisista kokonaisuuksista vastaavaa luokkaa ei vielä ole. 

<img src="https://github.com/leevileh/hello-world/blob/master/17042018luokkakaavio.png">


