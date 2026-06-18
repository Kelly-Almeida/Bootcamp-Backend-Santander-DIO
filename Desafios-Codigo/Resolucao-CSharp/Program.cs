using System;
using System.Diagnostics.Contracts;
namespace ResolucaoCSharp
{
    public class Program
    {
        public static void Main()
        {
            int op;
            String? resp;

            do{
                Console.WriteLine("================================");
                Console.WriteLine("\tSistema de salário");
                Console.WriteLine("================================");
                Console.WriteLine("Digite para...");
                Console.WriteLine("1 - Calcular salário");
                Console.WriteLine("2 - Sair");
                Console.Write("=> ");
                resp = Console.ReadLine();
                
                Boolean respValida = int.TryParse(resp, out op);

                if (respValida )
                {   
                    if (op == 1)
                    {
                        calcularSalario();
                    }
                }
                else
                {
                    Console.WriteLine("Opção inválida!!");
                }
            }while(op != 2);
            Console.WriteLine("Tenha ium bom dia!");
        }

        public static void calcularSalario()
        {
            float salBruto, imposto = 0;
            Boolean respValida;

            do
            {
                String? resp;

                Console.WriteLine("Digite o salário bruto: ");
                resp = Console.ReadLine();
                respValida = float.TryParse(resp, out salBruto);

                if (salBruto <= 0 || !respValida)
                {
                    Console.WriteLine("Digite um salário válido");
                }
                else
                {
                    if (salBruto <= 1100)
                    {
                        imposto = 0.05F;
                    }else if (salBruto <= 2500)
                    {
                        imposto = 0.1F;
                    }
                    else
                    {
                        imposto = 0.15F;
                    }
                }
                

            } while(salBruto <= 0 || !respValida);

            float bonus;
            
            do
            {
                String? resp;

                Console.WriteLine("Digite o valor do bonús: ");
                resp = Console.ReadLine();
                respValida = float.TryParse(resp, out bonus);

                if (salBruto < 0 || !respValida)
                {
                    Console.WriteLine("Digite um bónus válido");
                }
                

            } while(salBruto < 0 || !respValida);

            float salario = (salBruto - (salBruto * imposto)) + bonus;

            Console.WriteLine($"O salário é de R$ {salario}");
        }
    }
}