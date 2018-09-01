package br.pro.ramon.dcs.web.temperatura;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.is;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import static org.junit.Assert.*;

public class TemperaturaFormTest {

    @Test
    public void testForm() throws IOException {
        Document html = Jsoup.connect("http://localhost:8084/dcs-web-temperatura/index.html").get();

        Elements forms = html.getElementsByTag("form");

        Element form = forms.get(0);
        assertThat(form.attr("action"), is("temperatura"));
        assertThat(form.attr("method"), is("GET"));

        Elements entradas = form.children();

        Element fInput = entradas.get(0);
        assertThat(fInput.tagName(), is("input"));
        assertThat(fInput.attr("type"), is("text"));
        assertThat(fInput.attr("id"), is("f"));
        assertThat(fInput.attr("name"), is("f"));

        Element fLabel = entradas.get(1);
        assertThat(fLabel.tagName(), is("label"));
        assertThat(fLabel.attr("for"), is("f"));
        assertThat(fLabel.text(), is("°F"));

        Element cButton = entradas.get(2);
        assertThat(cButton.tagName(), is("input"));
        assertThat(cButton.attr("type"), is("submit"));
        assertThat(cButton.attr("value"), is("em °C"));
    }

}
