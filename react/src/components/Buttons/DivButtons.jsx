import { useState } from "react";
import { Button, ButtonId, ButtonAddPais } from "./Button.jsx";
import '../../index.css';

import { handleGetAllPaises, handleGetById, handleGetSedes, handleAddPais } from '../../controller/controller.js';

function DivButtons({ setData, setTableType }) {
    const handleSearch = (id) => {
        handleGetById(setData, id);
        setTableType('PAISES');
    };

    const handleAdd = (nombre, codigo, valor) => {
        handleAddPais(setData, nombre, codigo, valor );
        setTableType('PAISES');
    };

    const handleButtonClick = (action) => {
        switch (action) {
            case 'GET_ALL_PAISES':
                handleGetAllPaises(setData);
                setTableType('PAISES');
                break;
            case 'QUERY_SEDES':
                handleGetSedes(setData);
                setTableType('SEDES');
                break;
            case 'ADD_PAIS':
                break;
            case 'UPDATE_PAIS':
                break;
            default:
                console.log('Acción desconocida');
        }
    };

    return (
        <div className="div-left">
            <Button onClick={() => handleButtonClick('GET_ALL_PAISES')} text="Get All Paises" />
            <ButtonId handleSearch={handleSearch} />
            <Button onClick={() => handleButtonClick('QUERY_SEDES')} text="Query" />
            <ButtonAddPais handleAdd={handleAdd} />
            <Button onClick={() => handleButtonClick('UPDATE_PAIS')} text="Update Pais" />
        </div>
    );
}

export default DivButtons;
