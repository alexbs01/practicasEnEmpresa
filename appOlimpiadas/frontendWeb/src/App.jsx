import './styles/App.css';
import DivButtons from './components/buttons/DivButtons'
import DivTable from './components/table/DivTable'
import React, { useState } from 'react';

function App({ logOut }) {
    const [data, setData] = useState([]);
    const [tableType, setTableType] = useState('PAISES');
    return (
        <>
            <DivButtons setData={setData} setTableType={setTableType} logOut={logOut}/>
            <DivTable data={data} tableType={tableType}/>
        </>
    )
}

export default App