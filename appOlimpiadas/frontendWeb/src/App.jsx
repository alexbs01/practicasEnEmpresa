import './App.css'
import DivButtons from './components/buttons/DivButtons'
import DivTable from './components/table/DivTable'
import React, { useState } from 'react';

function App() {
    const [data, setData] = useState([]);
    const [tableType, setTableType] = useState('PAISES');
    const [pais, setPais] = useState({
        ID_PAIS: '',
        NOMBRE_PAIS: '',
        CODIGO_PAIS: '',
        VALOR_PAIS: '',
    });
    return (
        <>
        
            <DivButtons setData={setData} setTableType={setTableType} pais={pais}/>
            <DivTable data={data} tableType={tableType} setPais={setPais}/>
        </>
    )
}

export default App
