# CarGame
Sovellus on erittäin yksinkertainen autopeli. Tällä hetkellä sovellus on tilassa, jossa avautuvaan peliruutuun voi piirtää radan seinää, ja autolla voi ajaa. Auton ja seinän kohtaaminen ei vielä toimi kovin toivotusti. Lisäksi kentän luominen ja ajaminen on tarkoitus eriyttää myöhemmin.

## Releaset
[Release 1](https://github.com/leevileh/otm-harjoitustyo/releases/tag/viikko5)

## Dokumentaatio
[Vaatimusmäärittely](https://github.com/leevileh/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/leevileh/otm-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/leevileh/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

## Komentorivitoiminnot

### Testaus

Testit suoritetaan komennolla

```
mvn test
```

Testikattavuusraportti luodaan komennolla

```
mvn jacoco:report
```

Kattavuusraporttia voi tarkastella avaamalla selaimella tiedosto _target/site/jacoco/index.html_


### Checkstyle
Tiedostossa [checkstyle.xml](https://github.com/leevileh/otm-harjoitustyo/blob/master/CarGame/checkstyle.xml) määritetyt tarkistukset suoritetaan komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
Raportti jossa näkyy mahdolliset virheet löytyy avaamalla selaimella tiedosto _target/site/checkstyle.html_
