import { TablePaises, TableSedes} from "./Table";

function DivTable({ data, tableType, setPais }) {
    const table = (tableType) => {
        switch(tableType) {
                case 'PAISES':
                    return <TablePaises data={data} setPais={setPais}/>;
                case 'SEDES':
                    return <TableSedes data={data} />;
                default:
                    return <p>No data</p>;
        };
    }
    

    return (
        <div className="div-right">
            {table(tableType)}
        </div>
    );
}

export default DivTable;