/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groovystudy

import org.apache.log4j.Logger
/**
 *
 * @author asun
 */
class Log4jExample {
    static Logger logger = Logger.getLogger(Log4jExample.class)
    static void main(args) {
        logger.debug("This is debug message.")
        logger.info("This is info message.")
        logger.error("This is error message.")
    }
}

