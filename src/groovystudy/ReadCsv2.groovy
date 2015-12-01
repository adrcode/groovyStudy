/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package groovystudy

/**
 *
 * @author asun
 */
class ReadCsv2 {
    static void main(args){
        def file = new File("D:\\tool\\api2direct\\api2direct\\sourceCopy.csv")
        assert file.name == 'sourceCopy.csv'
        assert file.path == 'D:\\tool\\api2direct\\api2direct\\sourceCopy.csv'
        assert file.isAbsolute()
        assert file.parent == 'D:\\tool\\api2direct\\api2direct'
        
        file.filterLine{
            if(it.contains('RR01S'))
                it
        }.writeTo(new PrintWriter(System.out))
    }
}

