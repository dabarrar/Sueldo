package com.example.sueldo

abstract class Trabajadores  {
    abstract fun calcularLiquido(): Double
}

class Honorario (val bruto:Double) : Trabajadores(){
    override fun calcularLiquido(): Double = bruto - ( bruto * 0.13)
    }
class Contrato (val bruto: Double) : Trabajadores(){
    override fun calcularLiquido(): Double = bruto - ( bruto * 0.2)
}
