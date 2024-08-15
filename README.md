# ProgramacaoConcorrente
Repositório com todos os projetos feitos na disciplina "Programação Concorrente", no 3º semestre do curso de Ciência da Computação da 
Universidade Estadual do Sudoeste da Bahia.

# pc_trabalho01_202110839

O projeto se trata de um aplicativo para desktop feito em java onde é possível descobrir o signo do usuário utilizando  os dados fornecidos
pelo próprio usuário. É possível também obter mais informações sobre os signos e entrar em contato com o desenvolvedor.

![Yastrologia](https://github.com/user-attachments/assets/08f07c79-b141-4c36-b5e3-9eb1173655d3)

# pc_trabalho02_202110839

Esse projeto está dividido em duas partes, uma feita em c++ que está na subpasta "fork" e a outra na subpasta chamada "thread".
O projeto fork se trata da divisao de processos em um arquivo onde os processos foram dividos em 7. Esses processos são instanciados e "mortos"
em um tempo previamente determinado. eles são chamados de: pai, filho1, filho2, filho3, neto1, neto2 e bisneto.
O projeto thread se trata da divisão de processos em java feito atraves da classe Thread que é extendida para as classes usadas no projeto. Utilizando
o mesmo conceito aplicado no Fork, o projeto thread conta com uma GUI feita em javafx para representar o nascimento e a morte dos processos.

![pctrabalho02](https://github.com/user-attachments/assets/de57d367-d534-42ff-bed3-1efae90f1f59)

# pc_trabalho03_202110839
O desafio dos trens está essencialmente relacionado à regra de que dois trens não podem ocupar ao mesmo tempo a mesma região crítica, que, neste caso, é
uma ponte de via única. Se dois trens tentarem cruzar a ponte ao mesmo tempo, uma colisão é inevitável. Em programação concorrente, duas abordagens comuns
para resolver esse problema são o uso de variáveis de bloqueio e a alternância rigorosa.

# pc_trabalho04_202110839

# pc_trabalho05_202110839
O desafio do Trânsito Autônomo envolve oito carros, cada um com uma rota definida. Em cada rua, apenas um carro pode circular por vez. Por isso, eles compartilham
essas vias e precisam coordenar suas passagens para evitar problemas de concorrência, como corridas, deadlocks e inanição. Para resolver essas questões, foram
implementadas soluções utilizando semáforos, que empregam mecanismos de sincronização para assegurar que os carros acessem as ruas de maneira segura e organizada.
