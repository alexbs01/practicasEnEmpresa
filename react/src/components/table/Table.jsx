import React from 'react';

function TablePaises({ data }) {
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
                {data.map((element, index) => (
                    <tr key={index}>
                        <td>{element.ID_PAIS}</td>
                        <td>{element.NOMBRE_PAIS}</td>
                        <td>{element.CODIGO_PAIS}</td>
                        <td>{element.VALOR_PAIS}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}

function TableSedes({ data }) {
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
                {data.map((element, index) => (
                    <tr key={index}>
                        <td>{element.ID_PAIS}</td>
                        <td>{element.NOMBRE_PAIS}</td>
                        <td>{element.ID_CIUDAD}</td>
                        <td>{element.VALOR_CIUDAD}</td>
                        <td>{element.DESCRIPCION_TIPO}</td>
                        <td>{element.COUNT_SEDES}</td>
                    </tr>
                ))}
            </tbody>
        </table>
    );
}

export { TablePaises, TableSedes };
