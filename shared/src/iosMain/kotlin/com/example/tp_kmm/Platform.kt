package com.example.tp_kmm

import com.example.tp_kmm.data.Calculadora
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import platform.UIKit.UIDevice

actual class Platform actual constructor() {
    actual val platform: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}


actual fun initLogger(){
    Napier.base(DebugAntilog())
}

actual fun testeoQueSumeBien():Int{
    val operacion = Calculadora()

    return operacion.sumando(10,2)
}

actual fun testeoQueResteBien():Int{
    val opera= Calculadora()
    opera.restando(10,8)
}