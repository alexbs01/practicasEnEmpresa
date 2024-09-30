import TablePais from "./TablePais";

function DivTable({ paises }) {
    return (
        <div className="div-right">
            {paises.length > 0 ? <TablePais paises={paises} /> : <p>No data</p>}
        </div>
    );
}

export default DivTable;