import java.util.Scanner;

public class Executa {
    
    public static void main (String args[]){


        String nome, url, e_mail, descricao;

        Scanner scanner = new Scanner(System.in);
        // scanner.useDelimiter("\n");

        InstaPet SociaMedia = new InstaPet();
        int opcao = 99;
        
        do {
            System.out.println("Selecione uma opcao:\n");

            System.out.println("1 - CADASTRAR USUARIO");
            System.out.println("2 - CADASTRAR FOTO");
            System.out.println("3 - LISTAR USUARIOS");
            System.out.println("4 - LISTAR PETS");
            System.out.println("5 - QUANTIDADE DE USUARIOS DO SISTEMA");
            System.out.println("6 - QUANTIDADE DE FOTOS DE UM USUARIO DO SISTEMA"); 
            System.out.println("7 - ALTERAR A DESCRICAO DE UMA FOTO DE UM USUARIO DO SISTEMA"); 
            System.out.println("\n0 - SAIR\n");

            System.out.print("> ");
            opcao = scanner.nextInt();
            System.out.println();

            switch (opcao) {

                case 0: // Encerrar o programa 
                {
                    break; 
                }
    
                case 1: // Cadastrar usuario
                {
                    System.out.print ("> CADASTRAR_USUARIO ");

                    nome = scanner.next();
                    e_mail = scanner.next();
                    SociaMedia.cadastrar_usuario(nome, e_mail);

                    System.out.println();
                    break;
                }
                    
                case 2: // Cadastrar foto
                {
                    System.out.print ("> CADASTRAR_FOTO ");
                
                    e_mail = scanner.next();
                    url = scanner.next();
                    descricao = scanner.next();

                    SociaMedia.cadastrar_foto(e_mail, url, descricao);

                    System.out.println();
                    break;
                }
    
                case 3: // Listar usuarios do sistema
                {
                    System.out.println ("> LISTAR_USUARIOS ");
                    
                    Usuario vetor_usuarios [] = SociaMedia.listar_Usuarios();

                    for (int i = 0; i < SociaMedia.qnt_usuarios(); i++) {

                        System.out.println ("  " + vetor_usuarios[i].getNome() + " - " + vetor_usuarios[i].getE_mail());
                    }

                    System.out.println();
                    break;
                }
    
                case 4: // Listar pets de um usuario
                {
                    System.out.print ("> LISTAR_PETS ");
                    e_mail = scanner.next();
                    
                    Foto vetor_pets [] = SociaMedia.listar_pets(e_mail);

                    if ( vetor_pets != null) {

                        for (int i = 0; i < SociaMedia.qnt_pets(e_mail); i++) {

                            System.out.println ("  "+vetor_pets[i].getUrl() + " - " + vetor_pets[i].getDescricao());
                        }

                    }
                    else { System.out.println("  Sem registros"); }
                    
                    System.out.println();
                    break;
                }
    
                case 5: // Imprimir quantidade de usuarios do sistema
                {
                    System.out.println("> USUARIOS_CADASTRADOS");

                    System.out.println ( "  " + SociaMedia.qnt_usuarios() + "\n" );
                    break;
                }
    
                case 6: // Imprimir quantidade de fotos de um usuario do sistema
                {

                    System.out.print ("> QUANTIDADE_FOTOS ");
                    e_mail = scanner.next();

                    System.out.println("  " + SociaMedia.qnt_pets(e_mail) + "\n" );
                    break;
                }

                case 7: // Alterar descricao de uma foto
                {
                    System.out.print ("> ALTERAR DESCRICAO ");
                
                    e_mail = scanner.next();
                    url = scanner.next();
                    descricao = scanner.next();

                    SociaMedia.alterar_descricao(e_mail, url, descricao);

                    System.out.println();
                    break;
                }    
            
            }
            

        } while (opcao != 0);

        scanner.close();
        
    }
}
