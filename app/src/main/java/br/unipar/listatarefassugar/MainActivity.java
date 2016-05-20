package br.unipar.listatarefassugar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.melnykov.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.unipar.listatarefassugar.dados.Tarefa;


public class MainActivity extends ActionBarActivity {

    private ListView lista;
    private ArrayList<String> dados;
    private ArrayAdapter<String> adapter;
    private List<Tarefa> tarefas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.lista);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.attachToListView(lista);

        tarefas = Tarefa.listAll(Tarefa.class);


        dados = new ArrayList<String>();

        for (Tarefa t : tarefas) {
            dados.add(t.getTexto());
        }

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dados);
        lista.setAdapter(adapter);

    }


    public void addTarefa(View view){
        final AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("Lista de Tarefas");
        alerta.setMessage("Adicione um item");

        final EditText campo = new EditText(this);
        campo.setHint("ex: estudar android");
        alerta.setView(campo);

        alerta.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String valor = campo.getText().toString();

                Tarefa nova_tarefa = new Tarefa(valor);
                nova_tarefa.save();

                //adiciona na tarefas
                tarefas.add(nova_tarefa);

                dados.add(valor);
                adapter.notifyDataSetChanged();
            }
        });

        alerta.show();
    }
}
