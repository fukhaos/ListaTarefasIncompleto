package br.unipar.listatarefassugar.dados;

import com.orm.SugarRecord;

/**
 * Created by user on 19/05/16.
 */
public class Tarefa extends SugarRecord<Tarefa> {
    private String texto;

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Tarefa() {
    }

    public Tarefa(String texto) {
        this.texto = texto;
    }
}
