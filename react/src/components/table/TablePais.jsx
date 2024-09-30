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

export default TablePais;
