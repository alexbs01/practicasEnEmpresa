import React from 'react';

function TablePais({ paises }) {
    return (
        <table>
            <thead>
                <tr>
                    <th>ID_PAIS</th>
                    <th>NOMBRE_PAIS</th>
                    <th>CODIGO_PAIS</th>
                    <th>VALOR_PAIS</th>
                </tr>
            </thead>
            <tbody>
                {paises.map((pais) => (
                    <tr key={pais.ID_PAIS}>
                        <td>{pais.ID_PAIS}</td>
                        <td>{pais.NOMBRE_PAIS}</td>
                        <td>{pais.CODIGO_PAIS}</td>
                        <td>{pais.VALOR_PAIS}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}

function TableSedes({ sedes }) {
    return (
        <table>
            <thead>
                <tr>
                    <th>ID_PAIS</th>
                    <th>NOMBRE_PAIS</th>
                    <th>ID_CIUDAD</th>
                    <th>VALOR_CIUDAD</th>
                    <th>DESCRIPCION_TIPO</th>
                    <th>COUNT_SEDES</th>
                </tr>
            </thead>
            <tbody>
                {sedes.map((sede) => (
                    <tr key={sede.ID_PAIS}>
                        <td>{sede.ID_PAIS}</td>
                        <td>{sede.ID_CIUDAD}</td>
                        <td>{sede.VALOR_CIUDAD}</td>
                        <td>{sede.DESCRIPCION_TIPO}</td>
                        <td>{sede.COUNT_SEDES}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}

export default TablePais;
