import '../../styles/index.css';
import { Button, ButtonId, ButtonAddPais, ButtonUpdatePais } from './buttons.jsx';

import { handleGetAllPaises, handleGetById, handleGetSedes, handleAddPais, handleUpdatePais } from '../../controller/jjoo/jjooController.js';
import { useNavigate } from 'react-router-dom';
import { Navigate } from 'react-router-dom';

function DivButtons({ setData, setTableType, logOut }) {
    const navigate = useNavigate();
    const handleSearch = async (id) => {
        const pais = await handleGetById(setData, id);
        setTableType('PAISES');
        
        const navigate = useNavigate();
        navigate(`/app/${id}`);
        
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
                navigate("/app/paises");
                break;
            case 'QUERY_SEDES':
                handleGetSedes(setData);
                setTableType('SEDES');
                navigate("/app/sedes");
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
            <Button onClick={() => navigate("/login")} text="Log Out"/>
        </div>
    );
}

export default DivButtons;