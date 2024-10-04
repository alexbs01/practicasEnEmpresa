import { Button, ButtonId, ButtonAddPais, ButtonUpdatePais } from './buttons.jsx';
import '../../index.css';

import { handleGetAllPaises, handleGetById, handleGetSedes, handleAddPais, handleUpdatePais } from '../../controller/controller.js';

function DivButtons({ setData, setTableType }) {
    const handleSearch = async (id) => {
        const pais = await handleGetById(setData, id);
        setTableType('PAISES');
        return pais;
    };

    const handleAdd = (nombre, codigo, valor) => {
        handleAddPais(setData, nombre, codigo, valor );
        setTableType('PAISES');
    };

    const handleUpdate = (id, nombre, codigo, valor) => {
        handleUpdatePais(setData, id, nombre, codigo, valor);
        setTableType('PAISES');
    }

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
            <ButtonUpdatePais handleUpdate={handleUpdate} handleSearch={handleSearch} />
        </div>
    );
}

export default DivButtons;
