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
                <tr key={pais.id}>
                    <td>{pais.id}</td>
                    <td>{pais.nombre}</td>
                    <td>{pais.capital}</td>
                </tr>
                ))}
            </tbody>
        </table>
    );
}

export default TablePais;