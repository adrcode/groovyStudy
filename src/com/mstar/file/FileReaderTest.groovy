/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mstar.file

/**
 *
 * @author asun
 */
class FileReaderTest {
        /**常用的文件处理方法
         * void append(String text)     将字符串追加到文件末尾
         * Boolean createNewFile()      创建一个新空文档，当且仅当不存在使用这个文件名的文件时以抽象路径名命名
         * Boolean delete()     删除由抽象路径命名的文件或目录
         * void eachFile(Closure closure)       为指定目录中的每个文件应用闭包
         * void eachFileRecurse(Closure closure)    为指定目录中的每个文件应用闭包, 且对每个子目录使用递归方法
         * void eachLine(Closure closure)       逐行遍历指定的文件
         * String getText()      读取文件内容并将它作为一个字符串返回
         * Boolean exists()     判断是否存在以抽象路径命名的文件或路径
         * String getPath()     将抽象路径名转换成一个路径字符串
         * String getName()     获取文件名并返回一个字符串
         * String getAbsolutePath()     将文件路径转换成一个绝对路径字符串
         * Boolean isDirectory()        判断抽象路径所代表的对象是否为一个目录
         * Boolean mkdir()          创建一个以抽象路径命名的目录名
         * void withPrintWriter(Closure closure)      为文件创建一个新的PrintWrite辅助方法，并将它传递给闭包，
         *                                            并且确认文件是否被关闭
         * PrintWrite类       通常用来格式化输出文件的对象                                           
         * 
         *                                            
         * 
        */
	static void main(args) {
//            def fileNM = "result_20151201033534.txt"
//            File file = new File(fileNM)
//            
//            //#############获取文件路径##############
//            println file.getPath()
//            println file.getAbsolutePath()
//            
//            //#############逐行读取文件#############
//            file.eachWithIndex{index, line->
//                println index
//                println line
//            }
            
//            //#############eachFile() 输出文件目录结构##################
//            def dirPath = "D:\\workspace\\groovyStudy"
//            def file = new File(dirPath)
//            def test = new FileReaderTest()
//            test.listDir(file, 0)

              //#############eachFileRecurse() 递归输出所有文件名###############
//              def dirPath = "D:\\workspace\\groovyStudy"
//              def file = new File(dirPath)             
//              file.eachFileRecurse{f ->
//                  if(!f.isDirectory())
//                    println f.getName()
//              }
              
              //#########File类的newPrintWriter()方法为给定文件传递PrintWriter对象  文件拷贝##############
//              def fileOut = "output.txt"
//              def fileIn = "source.txt"
//              
//              File outFile = new File(fileOut)
//              def printWriter = outFile.newPrintWriter()
//              new File(fileIn).eachLine{line ->
//                  printWriter.println(line)
//              }
//              
//              printWriter.flush()
//              printWriter.close()

            //##########withPrintWriter方法首先为文件创建一个PrintWriter对象，传递给闭包，并确保随后关闭这个对象###
//              def fileOut = "output.txt"
//              def fileIn = "source.txt"            
//              
//              new File(fileOut).withPrintWriter{printWriter ->
//                  new File(fileIn).eachLine{line ->
//                      printWriter.println(line)
//                  }
//              }
              
            //###############文件排序#####################
              def fileIn = "source.txt"        
              def lines = new ArrayList()
              new File(fileIn).eachLine{line ->
                  lines << line
              }
              
              lines.sort()
              
              new File(fileIn).withPrintWriter{printWriter ->
                  lines.each{line ->
                      printWriter.println(line)
                  }
              }
              
        
        }
        
    
    
        def listDir(fileDir, indent) {
            fileDir.eachFile{file ->
                (0..<indent).each{print "  "}
                println file.getName()
                if(file.isDirectory()) {
                    listDir(file, 2 + indent)
                }
            }
        }
}

