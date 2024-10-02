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
    const [isSearching, setIsSearching] = useState(false); // Controla si mostrar el input de búsqueda
    const [searchId, setSearchId] = useState(''); // Almacena el ID a buscar

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
                        placeholder="Id"
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

export { Button, ButtonId };
