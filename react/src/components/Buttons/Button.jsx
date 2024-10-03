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
                        <Button onClick={() => handleSearch(searchId)} text="Buscar" />
                        <Button onClick={toggleSearch} text="Cancelar" />
                    </div>
                </div>
            )}
        </div>
    );
}

// Botón con lógica para buscar por ID
function ButtonAddPais({ handleAdd }) {
    const [isSearching, setIsSearching] = useState(false);
    const [nombrePais, setNombrePais] = useState('');
    const [codigoPais, setCodigoPais] = useState('');
    const [valorPais, setValorPais] = useState('');

    const toggleSearch = () => setIsSearching(!isSearching);

    return (
        <div className="div-buttons">
            {!isSearching ? (
                <Button onClick={toggleSearch} text="Add pais" />
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
                        <Button onClick={() => handleAdd(nombrePais, codigoPais, valorPais)} text="Añadir" />
                        <Button onClick={toggleSearch} text="Cancelar" />
                    </div>
                </div>
            )}
        </div>
    );
}



export { Button, ButtonId, ButtonAddPais };
