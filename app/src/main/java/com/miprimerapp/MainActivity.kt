package com.miprimerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import com.miprimerapp.Utils.cambioTexto
import com.miprimerapp.Utils.toggleVisibility
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val key = "USER_KEY"
    private var elTextoGuardado : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // var elTextoGuardado : String = ""
        //val elTexto = findViewById<TextView>(R.id.txtInicio)

        val prefs = PreferenceManager.getDefaultSharedPreferences(this)


        txtInicio.text = prefs.getString(key,"No hay nada")
        //btnInicio.text = "MI BOTÓN CAMBIÓ"

        elTextoGuardado = btnInicio.text.toString()

        txtInicio.setOnClickListener{
            //cambiarTextoBoton(btnInicio)
            btnInicio.cambioTexto(elTextoGuardado)
        }

        btnInicio.setOnClickListener{
           // cambiarTextoBoton(btnInicio)
            btnInicio.cambioTexto(elTextoGuardado)
            val editor = prefs.edit()
            editor.remove(key)
            editor.apply()
        }

        btnNuevo.setOnClickListener{
           // btnNuevo.cambioTexto(elTextoGuardado)
            btnInicio.toggleVisibility()
        }
        /*
        variablesYConstantes()
        tipoDeDatos()
        sentenciaIf()
        sentenciaWhen()
        arrays()
        maps()
        loops()*/
    }
    /*
    private fun cambiarTextoBoton(myBoton : Button){
        if(myBoton.text == elTextoGuardado){
            myBoton.text = "Botón presionado"
        }else{
            myBoton.text = elTextoGuardado
        }
    }
*/

    private fun variablesYConstantes(){

        //Variables
        var myFistVariable = "Bienvenidos a Android studio"
        var mySecondVariable = 1
        myFistVariable = "Algo diferente"

        println(myFistVariable)

        //Constante
        val myFistContant = myFistVariable
    }

    private fun tipoDeDatos(){

        val myString: String = "Hola "
        val myString2 = "Bienvenidos"

        val myString3 = myString + myString2

        println(myString3)
        Log.e("Concatenar",myString3)

        Log.e("Concatenar2","Esto es lo que se concatena ${myString2} seguir con esto")

        val myInt = 1
        val myInt2 = 2

        Log.e("Enteros", "${myInt}  ${myInt2}" )

        //Boolean

        val myBool:Boolean = true
        val myBool2 = false

        println(myBool == myBool2)
        println(myBool && myBool2)
    }

    private fun sentenciaIf(){
        val myNumber = 1

        //Operadores Condicionales
        // > mayor que
        //menor que
        // >= mayor igual
        // <>  !=  desigualdad
        // === igualdad
        // = == ===

        if(myNumber < 10){
            println("$myNumber es menor que 10")
        }else{
            println("$myNumber no es menor que 10")
        }
    }


    private fun sentenciaWhen(){

        val pais = "Colombia"

        when(pais){
            "Mexico","Perú","Colombia" -> {
                println("El idioma es español")
            }"EEUU" -> {
                println("El idioma es Ingles")
            }else -> {
                println("No conocemos el idioma")
            }
        }

        //When con -int

        val edad = 30

        when(edad){
                0,1,2 -> {
                    println("Eres un bebé")
                } in 3..10 -> {
                    println("Eres un niño")
                } in 11..17 -> {
                    println("Eres un adolescente")
                }
        }
    }

    private fun arrays(){
        val nombre = "Carlos"
        val apellido = "Sancho"
        val empresa = "GeekPark"
        val edad = "27"

        val myArray = arrayListOf<String>()

        //Añadir datos
        myArray.add(nombre)
        myArray.add(apellido)
        myArray.add(empresa)
        myArray.add(edad)

        println(myArray)

        myArray.addAll(listOf("Hola","Bienvenidos al curso de kotlin"))
        println(myArray)

        val myEmpresa = myArray[2]
        println(myEmpresa)

        //Eliminar
        myArray.removeAt(2)
        println(myArray)

        //Recorrer datos
        myArray.forEach{
            println(it)
        }

        println(myArray.count())
        myArray.clear()

        println(myArray)

    }

    private fun maps(){

        var algo : String

        var myMap: Map<String,Int> = mapOf()

        println(myMap)

        //Añadir
        myMap = mapOf("Carlos" to 29, "Hugo" to 26, "Sara" to 3)
        println(myMap)

        myMap = mutableMapOf("Carlos" to 29, "Hugo" to 26)
        myMap["Ana"] = 7
        myMap.put("Maria",8)
        println(myMap)

        //Acceso a datos
        println(myMap["Ana"])

        //Eliminar
        myMap.remove("Carlos")
        println(myMap)

    }

    private fun loops(){

        val nombre = "Carlos"
        val apellido = "Sancho"
        val empresa = "GeekPark"
        val edad = "27"

        val myArray = listOf(nombre,apellido,empresa,edad)
        val myMap = mapOf("Carlos" to 29, "Hugo" to 26, "Sara" to 3)

        //For
        for(myString in myArray){
            println(myString)
        }
        for(perrito in myMap){
            println(perrito)
        }

        for(myElement in myMap){
            println("${myElement.key}-${myElement.value}")
        }

        for(x in 0..10){
            println("${x}")
        }
        for(x in 0 until 10){
            println("${x}")
        }

        for(x in 0..10 step 2){
            println(x)
        }

        for(x in 10 downTo 0 step 3){
            println(x)
        }

        val myNumericArray = (0..20)
        for(perrito in myNumericArray){
            println(perrito)
        }

        ////////////////While
        var x = 0

        while( x < 10){
            println(x)
            //x++
            x += 1
        }



    }


}
