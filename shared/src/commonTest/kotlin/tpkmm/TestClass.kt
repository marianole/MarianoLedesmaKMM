package tpkmm


import com.example.tp_kmm.testeoQueResteBien
import com.example.tp_kmm.testeoQueSumeBien
import kotlin.test.Test
import kotlin.test.assertEquals

class TestClass {

    @Test
    fun testQueSumeBien(){
        val i: Int = 2

        assertEquals(testeoQueSumeBien(),i)
        //assertEquals(2,i)
    }

    @Test
     fun testQueResteBien(){
        val i = 2

        assertEquals(testeoQueResteBien(),i)
        //assertEquals(10,i)
    }
}