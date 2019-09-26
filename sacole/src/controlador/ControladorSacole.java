/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoSacole;
import javax.swing.JOptionPane;
import modelo.Sacole;
import tela.manutencao.ManutencaoSacole;
import tela.manutencao.ManutencaoSacole;

/**
 *
 * @author Administrador
 */
public class ControladorSacole {

    public static void inserir(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        objeto.setSerie(Integer.parseInt(man.jtfSerie.getText()));
        objeto.setPreco(Double.parseDouble(man.jtfPreco.getText()));
        objeto.setValidade(LocalDate.parse(man.jtfValidade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setSabor(man.jtfSabor.getText());
        
        boolean resultado = DaoSacole.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

    public static void alterar(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setSerie(Integer.parseInt(man.jtfSerie.getText()));
        objeto.setPreco(Double.parseDouble(man.jtfPreco.getText()));
        objeto.setValidade(LocalDate.parse(man.jtfValidade.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setSabor(man.jtfSabor.getText());
        
        boolean resultado = DaoSacole.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }

    public static void excluir(ManutencaoSacole man){
        Sacole objeto = new Sacole();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoSacole.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
}
