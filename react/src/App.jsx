import './App.css'
import DivButtons from './components/buttons/DivButtons'
import DivTable from './components/table/DivTable'
import React, { useState } from 'react';

function App() {
    const [data, setData] = useState([]);
    const [tableType, setTableType] = useState('PAISES');
    return (
        <>
        
            <DivButtons setData={setData} setTableType={setTableType}/>
            <DivTable data={data} tableType={tableType}/>
        </>
    )
}

export default App
