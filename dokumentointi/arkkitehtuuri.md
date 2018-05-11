# Arkkitehtuurikuvaus

## Rakenne
Ohjelman rakenne on kolmikerroksinen, ja koodin pakkausrakenne on seuraava:

<img src="https://github.com/leevileh/hello-world/blob/master/Pakkauskaavio.png">

Pakkaus cargame.ui sisältää käyttöliittymän, cargame.domain sovelluslogiikan ja cargame.dao tietokantaan tallentamisesta vastaavan koodin.

## Käyttöliittymä
Käyttöliittymä sisältää kolme erillistä näkymää
- Aloitusnäkymä
- Pelinäkymä
- Parhaat kierrosajat -näkymä

Nämä on toteutettu Scene-olioina, joista näkyvillä eli sovelluksen stageen sijoitettuna on kerralla vain yksi. Käyttöliittymä löytyy luokasta cargame.ui.CarGameUi.

## Sovelluslogiikka
Sovelluksen loogisen datamallin muodostavat luokat Car, Track, Timer ja Player. Ne kuvaavat autoja, ratoja joilla autot sijaitsevat, pelaajaa joka pelaa, sekä pelaajan autolla ajamia kierrosaikoja. Jokaisella autolla on vain yksi rata, mutta sama rata voisi olla käytössä useammallakin autolla.  

## Tietojen pysyväistallennus
Pakkauksen cargame.dao luokat Database.java, DbPlayerDao.java ja DbTrackDao.java huolehtivat tietojen tallettamisesta sql-tietokantoihin. Luokkia ei ole eristetty rajapintojen taakse.

### Tietokannat
Tietokanta cargame.db sisältää radan nimen, materiaalit ja koordinaatit joissa mitäkin materiaalia on. Ohjelma hyödyntää tietokantaa DbTrackDao.java -luokasta käsin. 
Tietokanta player.db sisältää rivejä joissa on pelaajan nimi, kierrosaika int-muodossa ja kierrosaika String-muodossa. Ohjelma hyödyntää tietokantaa DbPlayerDao.java -luokasta käsin. Mikäli ohjelma ei löydä tietokantaa, luodaan se Database.java -luokassa. 

## Ohjelman rakenteeseen jääneet heikkoudet

Autopelin rata on tallennettuna koordinaatteina tietokantaan cargame.db . Ongelmaksi muodostui, että kun projektista tehdään jar-tiedosto, ei tämä tietokanta päädy mukaan, enkä keksinyt ongelmaan ratkaisua. Peli toimii jar-tiedostosta, mikäli sijaintiin jossa jar-tiedosto on, luodaan kansio db, johon kopioidaan tietokanta cargame polusta otm-harjoitustyo/CarGame/db . DbTrackDao -luokan CREATE TABLE -lausekkeita ei löydy ohjelmasta, koska mikäli koordinaatteja sisältävää tietokantaa ei ole käytössä, on koko ohjelma melkoisen turha. 

Tietokantaa muokkaavia luokkia DbPlayerDao.java ja DbTrackDao.java ei ole eristetty rajapintojen taakse.
