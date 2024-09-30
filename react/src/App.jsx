import './App.css'
import DivButtons from './components/buttons/DivButtons'
import DivTable from './components/table/DivTable'
import React, { useState } from 'react';

function App() {
    const [paises, setPaises] = useState([]);
    return (
        <>
            <DivButtons setPaises={setPaises}/>
            <DivTable paises={paises}/>
        </>
    )
}

export default App
