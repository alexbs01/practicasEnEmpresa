package org.example.controller.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pais {
    @JsonProperty("ID_PAIS")
    private String ID_PAIS;

    @JsonProperty("NOMBRE_PAIS")
    private String NOMBRE_PAIS;

    @JsonProperty("CODIGO_PAIS")
    private String CODIGO_PAIS;

    @JsonProperty("VALOR_PAIS")
    private int VALOR_PAIS;

    public String toJson() {
        return "{" +
                "\"NOMBRE_PAIS\":\"" + NOMBRE_PAIS + "\"," +
                "\"CODIGO_PAIS\":\"" + CODIGO_PAIS + "\"," +
                "\"VALOR_PAIS\":" + VALOR_PAIS +
                "}";
    }

    public String getID_PAIS() {
        return ID_PAIS;
    }

    public void setID_PAIS(String ID_PAIS) {
        this.ID_PAIS = ID_PAIS;
    }

    public String getNOMBRE_PAIS() {
        return NOMBRE_PAIS;
    }

    public void setNOMBRE_PAIS(String NOMBRE_PAIS) {
        this.NOMBRE_PAIS = NOMBRE_PAIS;
    }

    public String getCODIGO_PAIS() {
        return CODIGO_PAIS;
    }

    public void setCODIGO_PAIS(String CODIGO_PAIS) {
        this.CODIGO_PAIS = CODIGO_PAIS;
    }

    public int getVALOR_PAIS() {
        return VALOR_PAIS;
    }

    public void setVALOR_PAIS(int VALOR_PAIS) {
        this.VALOR_PAIS = VALOR_PAIS;
    }
}
