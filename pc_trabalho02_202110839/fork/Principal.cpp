/* ***************************************************************
* Autor............: Yago Oliveira Silva
* Matricula........: 202110839
* Inicio...........: 18/03/2023
* Ultima alteracao.: 19/03/2023
* Nome.............: Principal.cpp
* Funcao...........: Arvore Genealogica em c++ utilizando o comando fork e derivados (sleep).
******************************************************************/
#include<unistd.h>
#include<iostream>
#include<time.h>
#include<stdlib.h>

using namespace std;

int main (void){
  pid_t processId; //identificacao do processo
  cout << "Inicio da vida \n" << endl;
  processId = fork(); // criando o processo filho
  
  if (processId < 0){ // o processo filho sempre sera igual a 0, se o retorno
    exit(1);         //for igual a -1 eh pq ele nao foi criado
  }
  
  if (processId == 0){
    sleep(22); // faz com que o filho nasca apos 22s 
    cout << "o primeiro filho nasceu!" << endl;
    cout << "Id do pai: " << getppid() << endl;
    cout << "Id do filho: " << getpid() << "\n"<< endl;
    processId = fork(); // criando o processo primeiro neto

    if (processId < 0){ // o processo filho sempre sera igual a 0, se o retorno
        exit(1);       //for igual a -1 eh pq ele nao foi criado
    }
    
    if (processId == 0){
      sleep(16); //faz com que o primeiro neto nasca apos 38s
      cout << "O primeiro Neto nasceu!"<< endl;
      cout << "Id do pai: " << getppid() << endl;
      cout << "Id do filho: " << getpid() << "\n"<< endl;
      processId = fork(); // criando o processo primeiro bisneto
       
      if (processId == 0){
        sleep(30); //faz com que o bisneto nasca apos 68s
        cout << "O bisneto nasceu!"<< endl;
        cout << "Id do pai: " << getppid() << endl;
        cout << "Id do filho: " << getpid() << "\n"<< endl;
       
        sleep(12); // faz com que o bisneto morra apos 12s de iniciado
        cout << "O bisneto faleceu! :( \n" << endl;
        _exit (0); //finaliza o processo primeiro bisneto
      }
      else{
        sleep(35); // faz com que o neto morra apos 35s de iniciado
        cout << "O primeiro neto faleceu! :( \n" << endl; 
        _exit(0); // Finaliza o processo primeiro neto
      }
    }
    else{
      sleep(61); // faz com que o filho morra apos 61s de iniciado
      cout <<"o primeiro filho faleceu! :( \n" << endl;
      _exit(0); // Finaliza o processo primeiro filho
    }
          
  }
  
  else{
    //cria o pai
    cout << "O pai nasceu!\n"<< endl;
    processId = fork(); // criando o processo segundo filho
    
    if (processId < 0) // o processo filho sempre sera igual a 0, se o retorno
      exit(1);        // for igual a -1 eh pq ele nao foi criado
    
    if (processId == 0){
      sleep(25); // faz com que o segundo filho nasca apos 25s
      cout << "o segundo filho nasceu!" << endl;
      cout << "Id do pai: " << getppid() << endl;
      cout << "Id do filho: " << getpid() << "\n"<< endl;
      processId = fork(); // criando o processo do segundo neto

      if (processId < 0) // o processo filho sempre sera igual a 0, se o retorno
      exit(1);          // for igual a -1 eh pq ele nao foi criado

      if(processId == 0){
        sleep(20); // faz com que o segundo neto nasca apos 45s
        cout << "o segundo neto nasceu!" << endl;
        cout << "Id do pai: " << getppid() << endl;
        cout << "Id do filho: " << getpid() << "\n"<< endl;
        sleep(33);  // faz com que o segundo neto morra apos 33s de iniciado
        cout << "O segundo neto faleceu! :( \n" << endl; 
        _exit(0); // Finaliza o processo segundo neto
      }
      else{
        sleep(55); // faz com que o segundo filho morra apos 55s de iniciado
        cout << "O segundo filho faleceu! :( \n" << endl;
        _exit(0); // Finaliza o processo segundo filho
      }

    } 

    else{
      processId = fork(); // criando o processo terceiro filho

      if (processId < 0)
      exit(1);

      if (processId == 0){
        sleep(32);  // faz com que o terceiro filho nasca apos 32s
        cout << "terceiro filho nasceu!" << endl;
        cout << "Id do pai: " << getppid() << endl;
        cout << "Id do filho: " << getpid() << "\n"<< endl;
        sleep(55); // faz com que o terceiro filho morra apos 55s
        cout << "O terceiro filho faleceu! :( \n" << endl;
        _exit(0); // Finaliza o processo terceiro filho
      }

      else{
        sleep(90); // faz com que o pai morra apos 90s
        cout << "O pai Faleceu! :(";
        _exit(0); // Finaliza o processo pai
      }
    }    
  }
  return 0; 
}    
