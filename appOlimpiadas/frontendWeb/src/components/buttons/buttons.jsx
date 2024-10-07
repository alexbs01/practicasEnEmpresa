import { useState } from "react";

// Botón básico
function Button({ onClick, text }) {
    return (
        <div className="div-buttons">
            <button className="buttons-left" onClick={onClick}>
                {text}
            </button>
        </div>
    );
}

// Botón con lógica para buscar por ID
function ButtonId({ handleSearch }) {
    const [isSearching, setIsSearching] = useState(false);
    const [searchId, setSearchId] = useState('');

    const toggleSearch = () => setIsSearching(!isSearching);

    const doSearchAndReset = async (id) => {
        const pais = await handleSearch(id);
        setSearchId('');
        toggleSearch();
    }

    return (
        <div className="div-buttons">
            {!isSearching ? (
                <Button onClick={toggleSearch} text="Get By Id" />
            ) : (
                <div className="div-id">
                    <div className="div-id-text">
                        <input
                        type="text"
                        value={searchId}
                        onChange={(e) => setSearchId(e.target.value)}
                        placeholder="Find by Id"
                        />
                    </div>
                    
                    <div className="div-id-buttons">
                        <Button onClick={() => doSearchAndReset(searchId)} text="Buscar" />
                        <Button onClick={toggleSearch} text="Cancelar" />
                    </div>
                </div>
            )}
        </div>
    );
}


function ButtonAddPais({ handleAdd }) {
    const [isFormVisible, setFormVisible] = useState(false);
    const [nombrePais, setNombrePais] = useState('');
    const [codigoPais, setCodigoPais] = useState('');
    const [valorPais, setValorPais] = useState('');

    const toggleFormVisible = () => setFormVisible(!isFormVisible);

    const doAddAndReset = async (nombre, codigo, valor) => {
        await handleAdd(nombre, codigo, valor);
        setNombrePais('');
        setCodigoPais('');
        setValorPais('');
        toggleFormVisible();
    }

    return (
        <div className="div-buttons">
            {!isFormVisible ? (
                <Button onClick={toggleFormVisible} text="Add pais" />
            ) : (
                <div className="div-id">
                    <div className="div-id-text">
                        <input
                        type="text"
                        value={nombrePais}
                        onChange={(e) => setNombrePais(e.target.value)}
                        placeholder="Nombre Pais"
                        />

                        <input
                        type="text"
                        value={codigoPais}
                        onChange={(e) => setCodigoPais(e.target.value)}
                        placeholder="Codigo Pais"
                        />

                        <input
                        type="text"
                        value={valorPais}
                        onChange={(e) => setValorPais(e.target.value)}
                        placeholder="Valor Pais"
                        />
                    </div>
                    
                    <div className="div-id-buttons">
                        <Button onClick={() => doAddAndReset(nombrePais, codigoPais, valorPais)} text="Añadir" />
                        <Button onClick={toggleFormVisible} text="Cancelar" />
                    </div>
                </div>
            )}
        </div>
    );
}

function ButtonUpdatePais({ handleUpdate, handleSearch }) {
    const [formVisible, setFormVisible] = useState(0);
    const [nombrePais, setNombrePais] = useState('');
    const [codigoPais, setCodigoPais] = useState('');
    const [valorPais, setValorPais] = useState('');
    const [idPais, setIdPais] = useState('');

    const toggleFormVisible = (newState) => setFormVisible(newState);

    const handleSearchAndUpdateForm = async () => {
        try {
            const pais = await handleSearch(idPais);
            console.log("Datos del país:", pais);
    
            if (pais && pais.ID_PAIS.toString() === idPais) {
                setNombrePais(pais.NOMBRE_PAIS);
                setCodigoPais(pais.CODIGO_PAIS);
                setValorPais(pais.VALOR_PAIS);
                toggleFormVisible(2);
            } else {
                alert("País no encontrado");
            }
        } catch (error) {
            console.error("Error al buscar el país:", error);
            alert("Ocurrió un error al buscar el país");
        }
    };

    const doUpdateAndReset = async (id, nombre, codigo, valor) => {
        await handleUpdate(id, nombre, codigo, valor);
        setIdPais('');
        setNombrePais('');
        setCodigoPais('');
        setValorPais('');
        toggleFormVisible(0);
    }

    return (
        <div className="div-buttons">
            {formVisible === 0 ? (
                <Button onClick={() => toggleFormVisible(1)} text="Update país" />
            ) : formVisible === 1 ? (
                <div className="div-id">
                    <div className="div-id-text">
                        <input
                            type="text"
                            value={idPais}
                            onChange={(e) => setIdPais(e.target.value)}
                            placeholder="ID País"
                        />
                    </div>
                    <div className="div-id-buttons">
                        <Button onClick={handleSearchAndUpdateForm} text="Buscar" />
                        <Button onClick={() => toggleFormVisible(0)} text="Cancelar" />
                    </div>
                </div>
            ) : formVisible === 2 && (
                <div className="div-id">
                    <div className="div-id-text">
                        <input
                            type="text"
                            value={nombrePais}
                            onChange={(e) => setNombrePais(e.target.value)}
                            placeholder="Nombre País"
                            defaultValue={nombrePais}
                        />

                        <input
                            type="text"
                            value={codigoPais}
                            onChange={(e) => setCodigoPais(e.target.value)}
                            placeholder="Código País"
                            defaultValue={codigoPais}
                        />

                        <input
                            type="text"
                            value={valorPais}
                            onChange={(e) => setValorPais(e.target.value)}
                            placeholder="Valor País"
                            defaultValue={valorPais}
                        />
                    </div>

                    <div className="div-id-buttons">
                        <Button onClick={() => doUpdateAndReset(idPais, nombrePais, codigoPais, valorPais)} text="Actualizar" />
                        <Button onClick={() => toggleFormVisible(0)} text="Cancelar" />
                    </div>
                </div>
            )}
        </div>
    );
}

export { Button, ButtonId, ButtonAddPais, ButtonUpdatePais };
