package br.pro.ramon.dcs.web.temperatura;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import static org.junit.Assert.*;

public class TemperaturaServletTest {

    @Test
    public void testZeroCelsius() throws IOException {
        String f = "32";

        String saida = acessaServletPelolNavegador(f);

        assertThat(saida, is("0.00"));
    }

    @Test
    public void test40Celsius() throws IOException {
        String f = "104";

        String saida = acessaServletPelolNavegador(f);

        assertThat(saida, is("40.00"));
    }

    @Test
    public void test100Fahrenheit() throws IOException {
        String f = "100";

        String saida = acessaServletPelolNavegador(f);

        assertThat(saida, is("37.78"));
    }

    @Test
    public void testCemCelsius() throws IOException {
        String f = "212";

        String saida = acessaServletPelolNavegador(f);

        assertThat(saida, is("100.00"));
    }

    private String acessaServletPelolNavegador(String f) throws IOException {
        Document html = Jsoup.connect("http://localhost:8084/dcs-web-temperatura/temperatura")
                .data("f", f)
                .get();

        String saida = html.body().text();

        return saida;
    }

}
