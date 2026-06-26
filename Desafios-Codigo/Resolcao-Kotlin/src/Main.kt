fun main(){
    var escol = 0

    do{
        do{
            println("========================================")
            println("\t\tSistemas de Salários")
            println("========================================")
            println("1 - Calcular salário;")
            println("2 - Sair")

            print("=> ")

            escol = readln().toInt();

            if (escol != 1 && escol != 2){
                println("Digite uma opção válida!")
            }
        }while (escol != 1 && escol != 2)

        if(escol == 1){
            print("Digite o valor do salário bruto: ")
            var salBruto = readln().toFloat()

            var imposto = if (salBruto <= 1100) 0.05
            else if (salBruto <= 2500) 0.1
            else 0.15

            print("Digite o valor do bônus: ");
            var bonus = readln().toFloat();

            var salario = salBruto - (salBruto * imposto) + bonus
            println("\nO salário é de R$${salario}\n")
        }
    }while(escol != 2)
    println("Tenha uma boa noite")
}