import Button from "./Button.jsx";
import '../../index.css';

import { handleGetAllPaises, handleGetSedes } from '../../controller/controller.js';

function DivButtons({setData, setTableType}) {

    const handleButtonClick = (action) => {
        switch(action) {
            case 'GET_ALL_PAISES':
                handleGetAllPaises(setData);
                setTableType('PAISES');
                break;
            case 'GET_BY_ID':
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
            <Button onClick={() => handleButtonClick('GET_ALL_PAISES')} text="Get All Paises"/>
            <Button onClick={() => handleButtonClick('GET_BY_ID')} text="Get By Id"/>
            <Button onClick={() => handleButtonClick('QUERY_SEDES')} text="Query"/>
            <Button onClick={() => handleButtonClick('ADD_PAIS')} text="Add Pais"/>
            <Button onClick={() => handleButtonClick('UPDATE_PAIS')} text="Update Pais"/>
        </div>
    );
}

export default DivButtons;
