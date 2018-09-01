package br.pro.ramon.dcs.web.temperatura;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    br.pro.ramon.dcs.web.temperatura.TemperaturaTest.class,
    br.pro.ramon.dcs.web.temperatura.TemperaturaServletTest.class,
    br.pro.ramon.dcs.web.temperatura.TemperaturaFormTest.class
})
public class AllTests {
}
