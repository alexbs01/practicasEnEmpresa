import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';

import React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import Paper from '@mui/material/Paper';

function TablePaises({ data }) {
    const columns = [
        { field: 'ID_PAIS', headerName: 'ID_PAIS', flex: 1 },
        { field: 'NOMBRE_PAIS', headerName: 'NOMBRE_PAIS', flex: 1 },
        { field: 'CODIGO_PAIS', headerName: 'CODIGO_PAIS', flex: 1 },
        { field: 'VALOR_PAIS', headerName: 'VALOR_PAIS', flex: 1, type: 'number' },
    ]

    const rows = data.map((element, index) => {
        return {
            id: index,
            ID_PAIS: element.ID_PAIS,
            NOMBRE_PAIS: element.NOMBRE_PAIS,
            CODIGO_PAIS: element.CODIGO_PAIS,
            VALOR_PAIS: element.VALOR_PAIS,
        }
    })

    return (
        <Paper style={{ height: '100%', width: '100%' }}>
            <DataGrid
                rows={rows}
                columns={columns}
                pageSize={5}
                rowsPerPageOptions={[5]}
                checkboxSelection
                disableSelectionOnClick
            />
        </Paper>
    );
}

function TablePaises2({ data }) {
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
    const columns = [
        { field: 'ID_PAIS', headerName: 'ID_PAIS', flex: 1 },
        { field: 'NOMBRE_PAIS', headerName: 'NOMBRE_PAIS', flex: 1 },
        { field: 'ID_CIUDAD', headerName: 'ID_CIUDAD', flex: 1 },
        { field: 'VALOR_CIUDAD', headerName: 'VALOR_CIUDAD', flex: 1, type: 'number' },
        { field: 'DESCRIPCION_TIPO', headerName: 'DESCRIPCION_TIPO', flex: 1 },
        { field: 'COUNT_SEDES', headerName: 'COUNT_SEDES', flex: 1, type: 'number' },
    ]

    const rows = data.map((element, index) => {
        return {
            id: index,
            ID_PAIS: element.ID_PAIS,
            NOMBRE_PAIS: element.NOMBRE_PAIS,
            ID_CIUDAD: element.ID_CIUDAD,
            VALOR_CIUDAD: element.VALOR_CIUDAD,
            DESCRIPCION_TIPO: element.DESCRIPCION_TIPO,
            COUNT_SEDES: element.COUNT_SEDES,
        }
    })

    return (
        <Paper style={{ height: '100%', width: '100%' }}>
            <DataGrid
                rows={rows}
                columns={columns}
                pageSize={5}
                rowsPerPageOptions={[5]}
                checkboxSelection
                disableSelectionOnClick
            />
        </Paper>
    );
}

function TableSedes1({ data }) {
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
