# CarGame
Sovellus on erittäin yksinkertainen autopeli. Peliin annetaan oma nimi, jonka jälkeen ajetaan kierroksia radalla. Pelin lopuksi kierrosajat tallentuvat tietokantaan ja pelaaja voi tarkastella tietokannasta löytyviä kierrosaikoja paremmuusjärjestyksessä.

## Releaset
[Loppupalautus](https://github.com/leevileh/otm-harjoitustyo/releases/tag/0.1)
  
[Release 1](https://github.com/leevileh/otm-harjoitustyo/releases/tag/viikko5)

## Dokumentaatio
[Vaatimusmäärittely](https://github.com/leevileh/otm-harjoitustyo/blob/master/dokumentointi/vaatimusmaarittely.md)

[Työaikakirjanpito](https://github.com/leevileh/otm-harjoitustyo/blob/master/dokumentointi/tuntikirjanpito.md)

[Arkkitehtuuri](https://github.com/leevileh/otm-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)

[Käyttöohje](https://github.com/leevileh/otm-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)

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

### Suoritettavan jar -tiedoston generointi
Jar tiedosto generoidaan komennolla
```
mvn package
```

### JavaDoc
JavaDoc generoidaan komennolla
```
mvn javadoc:javadoc
```
JavaDocia voi tarkastella avaamalla selaimella tiedosto _target\site\apidocs\index.html_

