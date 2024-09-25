package org.example.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
    private static Controller instance;
    private static final Model model = Model.getInstance();

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }

        return instance;
    }

    public void buttonGetAllPaises(Table table) {
        String jsonString = model.getAllPaises().body();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserializa el json en una lista de paises
            List<Pais> paises = objectMapper.readValue(jsonString, new TypeReference<>() {
            });

            String[] titles = {"ID_PAIS", "NOMBRE_PAIS", "CODIGO_PAIS", "VALOR_PAIS"};

            for (String title : titles) {
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

            for (int i = 0; i < titles.length; i++) {
                table.getColumn(i).pack();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void buttonGetPaisById(Table table, String id) {
        if (someFieldIsEmpty(new String[]{id})) return;

        String jsonString = model.getPaisById(id).body();

        ObjectMapper objectMapper = new ObjectMapper();

        showPais(table, jsonString, objectMapper);
    }

    public String[] getPaisByID(String id) {
        if (someFieldIsEmpty(new String[]{id})) return new String[]{};

        String jsonString = model.getPaisById(id).body();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Pais pais = objectMapper.readValue(jsonString, new TypeReference<>() {
            });

            return new String[]{pais.getNOMBRE_PAIS(), pais.getCODIGO_PAIS(), String.valueOf(pais.getVALOR_PAIS())};

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void buttonQuery(Table table) {
        String jsonString = model.getSedes().body();

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Deserializa el json en una lista de paises
            List<Query02> result = objectMapper.readValue(jsonString, new TypeReference<>() {
            });

            String[] titles = {"ID_PAIS", "NOMBRE_PAIS", "ID_CIUDAD", "VALOR_CIUDAD", "DESCRIPCION_TIPO", "COUNT_SEDES"};

            for (String title : titles) {
                TableColumn column = new TableColumn(table, SWT.NONE);
                column.setText(title);
            }

            for (Query02 row : result) {
                TableItem item = new TableItem(table, SWT.NONE);
                item.setText(0, row.getID_PAIS());
                item.setText(1, row.getNOMBRE_PAIS());
                item.setText(2, String.valueOf(row.getID_CIUDAD()));
                item.setText(3, String.valueOf(row.getVALOR_CIUDAD()));
                item.setText(4, row.getDESCRIPCION_TIPO());
                item.setText(5, String.valueOf(row.getCOUNT_SEDES()));
            }


            for (int i = 0; i < titles.length; i++) {
                table.getColumn(i).pack();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buttonAddPais(Table table, String nombre, String codigo, String valor) {

        if (someFieldIsEmpty(new String[]{nombre, codigo, valor})) {
            return;
        }

        Pais pais = new Pais();

        pais.setNOMBRE_PAIS(nombre);
        pais.setCODIGO_PAIS(codigo);
        pais.setVALOR_PAIS(Integer.parseInt(valor));

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = model.addPais(pais.toJson()).body();

        showPais(table, jsonString, objectMapper);
    }

    public void buttonUpdatePais(Table table, String id, String[] paisData) {
        if (someFieldIsEmpty(new String[]{id, paisData[0], paisData[1], paisData[2]})) return;

        Pais pais = new Pais();
        pais.setNOMBRE_PAIS(paisData[0]);
        pais.setCODIGO_PAIS(paisData[1]);
        pais.setVALOR_PAIS(Integer.parseInt(paisData[2]));

        String json = pais.toJson();
        ObjectMapper objectMapper = new ObjectMapper();

        String jsonString = model.updatePais(id, json).body();

        showPais(table, jsonString, objectMapper);
    }

    private boolean someFieldIsEmpty(String[] fields) {
        for (String field : fields) {
            if (field == null || field.isEmpty()) return true;
        }

        return false;
    }

    private void showPais(Table table, String jsonString, ObjectMapper objectMapper) {
        try {
            // Deserializa el json en una lista de paises
            Pais pais = objectMapper.readValue(jsonString, new TypeReference<>() {
            });

            String[] titles = {"ID_PAIS", "NOMBRE_PAIS", "CODIGO_PAIS", "VALOR_PAIS"};

            for (String title : titles) {
                TableColumn column = new TableColumn(table, SWT.NONE);
                column.setText(title);
            }

            TableItem item = new TableItem(table, SWT.NONE);
            item.setText(0, pais.getID_PAIS());
            item.setText(1, pais.getNOMBRE_PAIS());
            item.setText(2, pais.getCODIGO_PAIS());
            item.setText(3, String.valueOf(pais.getVALOR_PAIS()));

            for (int i = 0; i < titles.length; i++) {
                table.getColumn(i).pack();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
