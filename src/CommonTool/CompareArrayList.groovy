/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CommonTool

/**
 *
 * @author asun
 */
class CompareArrayList {
    static void main(args) {
        def source = [26309,26310,26311,26312,26313,26314,26315,26316,26317,30362,30363,30364,30365,30366,30367,30368,30369,30370,30371,26276,30372,30373,29478,30374,29479,30375,30376,30377,30378,30379,30380,30381,30382,30383,30384,30385,30386]
        def dest = [26276,26309,26310,29478,26311,29479,26312,26313,26314,26315,26316,26317]
        println source -dest
        println source.size() - dest.size()
        def a = [30362, 30363, 30364, 30365, 30366, 30367, 30368, 30369, 30370, 30371, 30372, 30373, 30374, 30375, 30376, 30377, 30378, 30379, 30380, 30381, 30382, 30383, 30384, 30385, 30386]
        def test1 = ["ab","b","C"]
        def test2 = test1.collect{
            it.toUpperCase()
        }
        println test2
    }	

}

