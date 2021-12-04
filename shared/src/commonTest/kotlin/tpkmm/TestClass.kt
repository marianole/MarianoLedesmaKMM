package tpkmm


import com.example.tp_kmm.testeoQueResteBien
import com.example.tp_kmm.testeoQueSumeBien
import kotlin.test.Test
import kotlin.test.assertEquals

class TestClass {

    @Test
    private fun testQueSumeBien(){
        val i: Int = 4

        assertEquals(testeoQueSumeBien(),i)
        //assertEquals(2,i)
    }

    @Test
    private fun testQueResteBien(){
        val i = 9

        assertEquals(testeoQueResteBien(),i)
        //assertEquals(10,i)
    }
}