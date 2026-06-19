resp = True;
while(resp):
    print("===================================");
    print("\tSistema de Salário")
    print("===================================");
    print("Digite para...")
    print("1 - Calcular salário");
    print("2 - Sair");
    cont = int(input("=> "));

    if (cont == 2):
        resp = False;
    elif (cont == 1):
        salBruto = 0.0;
        while(salBruto <= 0.0):
            salBruto = float(input("Digite o salário bruto: "));
            if (salBruto <= 0.0): print("Digite um valor válido");
        
        if (salBruto <= 1100): imposto = 0.05;
        elif (salBruto <= 2500): imposto = 0.1;
        else: imposto = 0.15;

        bonus = int(input("Digite o valor do bônus: "));

        salario = salBruto - (salBruto * imposto) + bonus;

        print(f"\nValor do salário {salario}\n");

    




