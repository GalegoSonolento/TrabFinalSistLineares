# TrabFinalSistLineares
Trabalho final da cadeira de sistemas lineares do segundo semestre de ciência da computação


==-- Montagem da classe Pessoa --==
  É uma classe simples para a criação de um objeto que será colocado dentro das listas para manipulação. Ele precisa de um toString para retornar a esquematização certa para colocar dentro do CSV (ou json).
  
==-- Montagem da classe ListaPessoa --==
  Em um primeiro momento é só uma lista de pessoas, não faz nada mais que isso. Ela ainda se mostra importante por guardar os métodos básicos de acesso à lista, já que ela ficou em uma classe separada (tentando evitar acoplamento desnecessário e ainda usar apenas uma lista durante todo o codigo)
  
==-- Montagem da classe Cálculos --==
  A primeira classe que efetivamente precisa de testes. Essa classe vai guardar os cálculos simples do projeto. Apenas números e retornos, não vai existir manupilação de objetos ou lists, em um primeiro momento pelo menos.
  
==-- Montagem da classe LerPreencherCSV --==
  Contém métodos que auxiliam na leitura e preenchimento dos arquivos CSV.
  
==-- Montagem da classe Funcional --==
  Classe que contém toda a lógica de execução do programa. É nessa classe que os menus são exibidos ao usuário, que são criados scanners para receber as informações, e que a lógica dos cálculos é aplicada.

==-- Montagem da classe UI --==
  Contém o menu inicial do programa, com as opções para o usuário digitar o que deseja.
 
==-- Montagem da classe Main --==
  Apenas executa o programa, basicamente.
