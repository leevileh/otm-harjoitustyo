

package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



public class KassapaateTest {
    
    Kassapaate paate;
    Maksukortti rikasKortti;
    Maksukortti koyhaKortti;
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        rikasKortti = new Maksukortti(1000);
        koyhaKortti = new Maksukortti(200);                
    }
    
//En ollut ihan varma kuinka tarkkaan jokaista asiaa tulee testata erikseen, joten laitoin 
//konstruktorin testaamisen esimerkkimielessä niin tarkasti kuin mahdollista, ja sen jälkeen
//sellaisella tarkkuudella jonka itse näin mielekkääksi
    
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void konstruktoriAsettaaEdullisetOikein() {
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void konstruktoriAsettaaMaukkaatOikein() {
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullinenKateisOstoToimiiJosMaksuOnRiittava() {
        assertEquals(10, paate.syoEdullisesti(250));
        assertEquals(1, paate.edullisiaLounaitaMyyty());
        assertEquals(100240, paate.kassassaRahaa());
        
    }
    
    @Test
    public void maukasKateisOstoToimiiJosMaksuOnRiittava() {
        assertEquals(100, paate.syoMaukkaasti(500));
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
        assertEquals(100400, paate.kassassaRahaa());
    }
    
    @Test
    public void edullinenKateisOstoToimiiJosMaksuEiRiita() {
        assertEquals(100, paate.syoEdullisesti(100));
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void maukasKateisOstoToimiiJosMaksuEiRiita() {
        assertEquals(250, paate.syoMaukkaasti(250));
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void edullinenKorttiOstoToimiiJosMaksuOnRiittava() {
        assertEquals(true, paate.syoEdullisesti(rikasKortti));
        assertEquals(1, paate.edullisiaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(760, rikasKortti.saldo());
    }
    
    @Test
    public void maukasKorttiOstoToimiiJosMaksuOnRiittava() {
        assertEquals(true, paate.syoMaukkaasti(rikasKortti));
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(600, rikasKortti.saldo());
    }
    
    @Test
    public void edullinenKorttiOstoToimiiJosMaksuEiRiita() {
        assertEquals(false, paate.syoEdullisesti(koyhaKortti));
        assertEquals(0, paate.edullisiaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(200, koyhaKortti.saldo());
    }
    
    @Test
    public void maukasKorttiOstoToimiiJosMaksuEiRiita() {
        assertEquals(false, paate.syoMaukkaasti(koyhaKortti));
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals(200, koyhaKortti.saldo());
    }
    
    @Test
    public void rahanLataaminenKortilleToimii() {
        paate.lataaRahaaKortille(koyhaKortti, 1000);
        assertEquals(1200, koyhaKortti.saldo());
        assertEquals(101000, paate.kassassaRahaa());
    }
    
    @Test
    public void negatiivisenRahanLataaminenKortilleEiToimi() {
        paate.lataaRahaaKortille(rikasKortti, -100);
        assertEquals(1000, rikasKortti.saldo());
        assertEquals(100000, paate.kassassaRahaa());
    }

}
