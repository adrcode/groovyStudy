/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groovystudy;

import java.io.Console;
import static java.lang.Math.max;
import static java.lang.System.console;

/**
 *
 * @author asun
 */
public class GroovyStudy {
//    private boolean color;
    enum color{
        RED, GREEN
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GroovyStudy d = new GroovyStudy();
        color c;
        c = color.GREEN;
        System.out.println(c);
    }
}
