package br.pro.ramon.dcs.web.temperatura;

import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;

public class TemperaturaTest {

    @Test
    public void testZeroCelsius() {
        double f = 32;

        TemperaturaF tf = new TemperaturaF(f);
        double c = tf.getC();

        assertThat(c, is(0.0));
    }

    @Test
    public void test40Celsius() {
        double f = 104;

        TemperaturaF tf = new TemperaturaF(f);
        double c = tf.getC();

        assertThat(c, is(40.0));
    }

    @Test
    public void test100Fahrenheit() {
        double f = 100;

        TemperaturaF tf = new TemperaturaF(f);
        double c = tf.getC();

        final double PRECISAO = 0.01;
        assertEquals(37.77, c, PRECISAO);
        assertEquals(37.78, c, PRECISAO);
    }

    @Test
    public void testCemCelsius() {
        double f = 212;

        TemperaturaF tf = new TemperaturaF(f);
        double c = tf.getC();

        assertThat(c, is(100.0));
    }

}
