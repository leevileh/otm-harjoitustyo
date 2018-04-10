# CarGame
Sovellus on erittäin yksinkertainen autopeli. Tällä hetkellä sovellus on tilassa, jossa avautuvaan peliruutuun voi piirtää radan seinää, ja autolla voi ajaa. Auton ja seinän kohtaaminen ei vielä toimi kovin toivotusti. Lisäksi kentän luominen ja ajaminen on tarkoitus eriyttää myöhemmin.

## Dokumentaatio
[Vaatimusmäärittely](https://github.com/leevileh/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/leevileh/otm-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

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

Tällä hetkellä sovelluksella on ainoastaan yksi testi. Se toimii.
