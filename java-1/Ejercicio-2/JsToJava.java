import java.util.Scanner;
import java.util.function.BiFunction;

/** JsToJava. */
public class JsToJava {

  private static int suma(int num1, int num2) {
    return num1 + num2;
  }

  private static int resta(int num1, int num2) {
    return num1 - num2;
  }

  private static int multiplicar(int num1, int num2) {
    return num1 * num2;
  }

  private static int dividir(int num1, int num2) {
    if (num2 == 0) {
      System.out.println("No se puede dividir por 0");
      return -1;
    }
    return num1 / num2;
  }

  private static int pedirNumero() {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("Ingrese un numero");
      String value = sc.nextLine();

      if (value.matches("^-?\\d+$")) {
        return Integer.parseInt(value);
      } else {
        System.out.println("Debe ingresar un numero valido");
      }
    }
  }

  private static int ejecutarCaso(BiFunction<Integer, Integer, Integer> operacion) {
    int num1 = pedirNumero();
    int num2 = pedirNumero();
    return operacion.apply(num1, num2);
  }

  private static void menu() {
    Scanner sc = new Scanner(System.in);
    String opcion = "0";
    while (!opcion.equals("5")) {
      System.out.println("### Calculadora ###");
      System.out.println("1. Sumar");
      System.out.println("2. Restar");
      System.out.println("3. Multiplicar");
      System.out.println("4. Dividir");
      System.out.println("5. Salir");

      opcion = sc.nextLine();

      switch (opcion) {
        case "1":
          System.out.println("Resultado: " + ejecutarCaso(JsToJava::suma));
          break;

        case "2":
          System.out.println("Resultado: " + ejecutarCaso(JsToJava::resta));
          break;

        case "3":
          System.out.println("Resultado: " + ejecutarCaso(JsToJava::multiplicar));
          break;

        case "4":
          System.out.println("Resultado: " + ejecutarCaso(JsToJava::dividir));
          break;

        case "5":
          System.out.println("Saliendo del programa");
          sc.close();
          break;
        default:
          System.out.println("Opcion Invalida");
          break;
      }
    }
  }

  public static void main(String[] args) {
    menu();
  }
}

// // Hacer un menu interactivo que pueda sumar, restar, multiplicar y dividir con funciones
// const prompt = require("prompt-sync")();
//
// function suma(num1, num2){
// 	return num1 + num2
// }
//
// function resta(num1, num2){
// 	return num1 - num2
// }
//
// function multiplicar(num1, num2){
// 	return num1*num2
// }
//
// function dividir(num1, num2){
// 	if(num2 === 0){
// 		return "No se puede dividir por 0";
// 	} else {
// 		return num1/num2;
// 	}
// }
//
// function pedirNumero(){
// 	let numero;
// 	while(true){
// 		numero = Number(prompt("Ingrese un número: "))
// 		if(!isNaN(numero)){
// 			return numero
// 		} else {
// 			console.log("Debe ingresar un número valido")
// 		}
// 	}
// }
//
// function ejecutarCaso(operacion){
// 	let num1 = pedirNumero();
// 	let num2 = pedirNumero();
// 	resultado = operacion(num1, num2)
// 	return resultado
// }
//
// function menu(){
// 	let opcion;
// 	while(opcion !== "5"){
// 		console.log("### Calculadora ###")
// 		console.log("1. Sumar")
// 		console.log("2. Restar")
// 		console.log("3. Multiplicar")
// 		console.log("4. dividir")
// 		console.log("5. Salir")
//
// 		opcion = prompt("Selecciona una opción: ")
//
// 		let numero1;
// 		let numero2;
// 		let resultado;
//
// 		switch(opcion){
// 			case "1":
// 				resultado = ejecutarCaso(suma)
// 				console.log(`Resultado: ${resultado}`)
// 				break;
// 			case "2":
// 				resultado = ejecutarCaso(resta)
// 				console.log(`Resultado: ${resultado}`)
// 				break;
// 			case "3":
// 				resultado = ejecutarCaso(multiplicar)
// 				console.log(`Resultado: ${resultado}`)
// 				break;
// 			case "4":
// 				console.log(`Resultado: ${ejecutarCaso(dividir)}`)
// 				break;
//
// 			case "5":
// 				console.log("Saliendo del programa...");
// 				break;
// 			default:
// 				console.log( "Opción invalida")
// 		}
// 	}
// }
//
// menu();
