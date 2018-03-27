package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein(){
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanLataaminenKasvattaaSaldoaOikein(){
        kortti.lataaRahaa(115);
        assertEquals("saldo: 1.25", kortti.toString());
    }
    
    @Test
    //Alkuperäisessä ohjelmassa voi ladata negatiivista saldoa.
    public void eiNegatiivistaLataamista(){
        kortti.lataaRahaa(-5);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    //Alkuperäisessä ohjelmassa saldo vähenee väärin. Sentit ja kymmenet sentit menee sekaisin.
    public void saldoVaheneeOikeinJosTarpeeksiRahaa(){
        kortti.otaRahaa(5);
        assertEquals("saldo: 0.05", kortti.toString());
    }
    
    @Test
    public void saldoEiMuutuJosEiTarpeeksiRahaa(){
        kortti.otaRahaa(15);
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void palauttaaTrueJosRahatRiittaa(){
        assertTrue(kortti.otaRahaa(5));
    }
    
    @Test
    public void palauttaaFalseJosRahatEiRiita(){
        assertFalse(kortti.otaRahaa(15));
    }
    
    @Test
    public void saldoPalautuuOikein(){
        assertEquals(10, kortti.saldo());
    }
}
