package com.example.tp_kmm

import com.example.tp_kmm.data.Calculadora
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

actual class Platform actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun initLogger(){
    Napier.base(DebugAntilog())
}

actual fun testeoQueSumeBien(): Int{
    val operacion = Calculadora()

    return operacion.sumando(1,1)
}

actual fun testeoQueResteBien():Int{
    val opera = Calculadora()
    return opera.restando(10,8)
}