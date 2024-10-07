package org.example.controller.queries;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Query02 {
    @JsonProperty("ID_PAIS")
    private String ID_PAIS;

    @JsonProperty("NOMBRE_PAIS")
    private String NOMBRE_PAIS;

    @JsonProperty("ID_CIUDAD")
    private String ID_CIUDAD;

    @JsonProperty("VALOR_CIUDAD")
    private int VALOR_CIUDAD;

    @JsonProperty("DESCRIPCION_TIPO")
    private String DESCRIPCION_TIPO;

    @JsonProperty("COUNT_SEDES")
    private int COUNT_SEDES;

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

    public String getID_CIUDAD() {
        return ID_CIUDAD;
    }

    public void setID_CIUDAD(String ID_CIUDAD) {
        this.ID_CIUDAD = ID_CIUDAD;
    }

    public int getVALOR_CIUDAD() {
        return VALOR_CIUDAD;
    }

    public void setVALOR_CIUDAD(int VALOR_CIUDAD) {
        this.VALOR_CIUDAD = VALOR_CIUDAD;
    }

    public String getDESCRIPCION_TIPO() {
        return DESCRIPCION_TIPO;
    }

    public void setDESCRIPCION_TIPO(String DESCRIPCION_TIPO) {
        this.DESCRIPCION_TIPO = DESCRIPCION_TIPO;
    }

    public int getCOUNT_SEDES() {
        return COUNT_SEDES;
    }

    public void setCOUNT_SEDES(int COUNT_SEDES) {
        this.COUNT_SEDES = COUNT_SEDES;
    }
}
