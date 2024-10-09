import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';

import React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import Paper from '@mui/material/Paper';
import { useState } from 'react';

function TablePaises({ data, setPais }) {
    const [selectedRowId, setSelectedRowId] = useState(null);

    const columns = [
        { field: 'ID_PAIS', headerName: 'ID_PAIS', flex: 1 },
        { field: 'NOMBRE_PAIS', headerName: 'NOMBRE_PAIS', flex: 1 },
        { field: 'CODIGO_PAIS', headerName: 'CODIGO_PAIS', flex: 1 },
        { field: 'VALOR_PAIS', headerName: 'VALOR_PAIS', flex: 1, type: 'number' },
    ];

    const rows = data.map((element, index) => ({
        id: index,
        ID_PAIS: element.ID_PAIS,
        NOMBRE_PAIS: element.NOMBRE_PAIS,
        CODIGO_PAIS: element.CODIGO_PAIS,
        VALOR_PAIS: element.VALOR_PAIS,
    }));

    const handleRowSelection = (selectionModel) => {
        setSelectedRowId(selectionModel[0]);
    };

    setPais();

    return (
        <Paper style={{ height: '100%', width: '100%' }}>
            <DataGrid
                rows={rows}
                columns={columns}
                pageSize={5}
                rowsPerPageOptions={[5]}
                checkboxSelection
                disableMultipleRowSelection
                disableSelectionOnClick
                onSelectionModelChange={handleRowSelection}
            />
        </Paper>
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
                disableSelectionOnClick
            />
        </Paper>
    );
}

export { TablePaises, TableSedes };
