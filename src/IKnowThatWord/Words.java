package IKnowThatWord;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Words {
    private String user;
    private int nivel,aciertos;
    private FileManager fileManager;
    private List<String> palabrasCorrectas, palabrasIncorrectas, listaCombinada;

    /**
     * Gets the username written in the first JtextField
     */
    public Words (String user) {
        this.user = user;
        this.fileManager = new FileManager();
        inicializar();
    }

    /**
     * Sets up everything for the game to start, such as checking if it is already registered player and the level,
     * creates list of correct words, incorrect words and a mix of both
     */
    public void inicializar(){
        aciertos=0;
        String infoUser = this.fileManager.retornaUsuario(this.user);
        String nivelUsuario = infoUser.split(",")[1];
        this.nivel = Integer.parseInt(nivelUsuario);
        this.palabrasCorrectas = fileManager.lecturaFile("src/myProject/diccionario/wordsOk.txt",nivel);
        Collections.shuffle(palabrasCorrectas);
        this.palabrasIncorrectas = fileManager.lecturaFile("src/myProject/diccionario/wordsNok.txt",nivel);
        Collections.shuffle(palabrasIncorrectas);
        listaCombinada = new ArrayList<>();
        listaCombinada.addAll(palabrasCorrectas);
        listaCombinada.addAll(palabrasIncorrectas);
        Collections.shuffle(listaCombinada);
    }

    /**
     * Winning conditions based on level percentage
     */

    public void resultadoNivel(){
        int tamañoLista = listaCombinada.size();
        double multiplicador = 0;

        switch (nivel){
            case 1,2:
                multiplicador = 0.7;
                break;
            case 3:
                multiplicador = 0.75;
                break;
            case 4,5:
                multiplicador = 0.8;
                break;
            case 6:
                multiplicador = 0.85;
                break;
            case 7,8:
                multiplicador = 0.9;
                break;
            case 9:
                multiplicador = 0.95;
                break;
            default:
                multiplicador=1;
        }
        double promedio = tamañoLista*multiplicador;
        if(aciertos>=promedio) {
            if(nivel<10){
                fileManager.actualizarUsuario(user, nivel + 1);
            }else{
                int i = JOptionPane.showConfirmDialog(null, "Has vencido el juego, ¿quieres volver a jugar?","Felicitaciones!", JOptionPane.YES_NO_OPTION);
                if(i==JOptionPane.YES_OPTION){
                    fileManager.actualizarUsuario(user, nivel = 1);
                }else{
                    System.exit(0);
                }
            }
            aciertos=0;
        }else{
            int i = JOptionPane.showConfirmDialog(null, "Has perdido, ¿quieres volver a intentar?","Mala suerte", JOptionPane.YES_NO_OPTION);
            if(i==JOptionPane.YES_OPTION){
                fileManager.actualizarUsuario(user, nivel);
            }else{
                System.exit(0);
            }
        }
    }

    /**
     * setters and getters
     * @return
     */
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public List<String> getPalabrasCorrectas() {
        return palabrasCorrectas;
    }

    public void setPalabrasCorrectas(List<String> palabrasCorrectas) {
        this.palabrasCorrectas = palabrasCorrectas;
    }

    public List<String> getPalabrasIncorrectas() {
        return palabrasIncorrectas;
    }

    public void setPalabrasIncorrectas(List<String> palabrasIncorrectas) {
        this.palabrasIncorrectas = palabrasIncorrectas;
    }

    public List<String> getListaCombinada() {
        return listaCombinada;
    }

    public void setListaCombinada(List<String> listaCombinada) {
        this.listaCombinada = listaCombinada;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

}
