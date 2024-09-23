package org.example.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSObject;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.example.controller.entities.Pais;
import org.example.model.Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    public static void buttonGetPaisById() {
        
    }

    public static void buttonAddPais() {}
    public static void buttonFindByCodigPais() {}
    public static void buttonQuery() {}
}
