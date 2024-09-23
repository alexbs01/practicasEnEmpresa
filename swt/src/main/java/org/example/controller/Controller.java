package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.example.controller.entities.Pais;
import org.example.controller.queries.Query02;
import org.example.model.Model;

import java.io.IOException;
import java.util.List;

public class Controller {
    public static void buttonGetAllPaises(Table table) {
        String jsonString = Model.getAllPaises().body();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserializa el json en una lista de paises
            List<Pais> paises = objectMapper.readValue(jsonString, new TypeReference<>() {});

            String[] titles = {"ID_PAIS", "NOMBRE_PAIS", "CODIGO_PAIS", "VALOR_PAIS"};

            for(String title : titles) {
                TableColumn column = new TableColumn(table, SWT.NONE);
                column.setText(title);
            }

            for (Pais pais : paises) {
                TableItem item = new TableItem(table, SWT.NONE);
                item.setText(0, pais.getID_PAIS());
                item.setText(1, pais.getNOMBRE_PAIS());
                item.setText(2, pais.getCODIGO_PAIS());
                item.setText(3, String.valueOf(pais.getVALOR_PAIS()));
            }

            for(int i = 0; i < titles.length; i++) {
                table.getColumn(i).pack();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void buttonGetPaisById(Table table, String id) {
        String jsonString = Model.getPaisById(id).body();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserializa el json en una lista de paises
            Pais pais = objectMapper.readValue(jsonString, new TypeReference<>() {});

            String[] titles = {"ID_PAIS", "NOMBRE_PAIS", "CODIGO_PAIS", "VALOR_PAIS"};

            for(String title : titles) {
                TableColumn column = new TableColumn(table, SWT.NONE);
                column.setText(title);
            }


            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(0, pais.getID_PAIS());
            item.setText(1, pais.getNOMBRE_PAIS());
            item.setText(2, pais.getCODIGO_PAIS());
            item.setText(3, String.valueOf(pais.getVALOR_PAIS()));

            for(int i = 0; i < titles.length; i++) {
                table.getColumn(i).pack();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buttonQuery(Table table) {
        String jsonString = Model.getSedes().body();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserializa el json en una lista de paises
            List<Query02> result = objectMapper.readValue(jsonString, new TypeReference<>() {});

            String[] titles = {"ID_PAIS", "NOMBRE_PAIS", "ID_CIUDAD", "VALOR_CIUDAD", "DESCRIPCION_TIPO", "COUNT_SEDES"};

            for(String title : titles) {
                TableColumn column = new TableColumn(table, SWT.NONE);
                column.setText(title);
            }

            for(Query02 row : result) {
                TableItem item = new TableItem(table, SWT.NONE);
                item.setText(0, row.getID_PAIS());
                item.setText(1, row.getNOMBRE_PAIS());
                item.setText(2, String.valueOf(row.getID_CIUDAD()));
                item.setText(3, String.valueOf(row.getVALOR_CIUDAD()));
                item.setText(4, row.getDESCRIPCION_TIPO());
                item.setText(5, String.valueOf(row.getCOUNT_SEDES()));
            }


            for(int i = 0; i < titles.length; i++) {
                table.getColumn(i).pack();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void buttonAddPais(Table table, String nombre, String codigo, String valor) {
        Pais pais = new Pais();

        pais.setNOMBRE_PAIS(nombre);
        pais.setCODIGO_PAIS(codigo);
        pais.setVALOR_PAIS(Integer.parseInt(valor));

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonToSend = "";

        try {
            jsonToSend = objectMapper.writeValueAsString(pais);

        } catch (IOException e) {
            throw new RuntimeException("Error al convertir el objeto a JSON", e);
        }

        System.out.println(jsonToSend);

        String jsonString = Model.addPais(jsonToSend).body();

        try {
            Pais paisAdded = objectMapper.readValue(jsonString, new TypeReference<>() {});

            String[] titles = {"ID_PAIS", "NOMBRE_PAIS", "CODIGO_PAIS", "VALOR_PAIS"};

            for(String title : titles) {
                TableColumn column = new TableColumn(table, SWT.NONE);
                column.setText(title);
            }


            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(0, paisAdded.getID_PAIS());
            item.setText(1, paisAdded.getNOMBRE_PAIS());
            item.setText(2, paisAdded.getCODIGO_PAIS());
            item.setText(3, String.valueOf(paisAdded.getVALOR_PAIS()));

            for(int i = 0; i < titles.length; i++) {
                table.getColumn(i).pack();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void buttonFindByCodigPais() {}
}
