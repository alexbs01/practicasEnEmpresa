import './styles/App.css';
import React, { useState, useEffect } from 'react';
import { Route, Routes } from "react-router-dom";
import Index from "./index";
import Login from "./login";
import App2 from "./App2";

function App() {
    const [isLogged, setIsLogged] = useState(false);
    const [user, setUser] = useState(null);

    // Función para obtener una cookie por su nombre
    const getCookie = (name) => {
        const nameEQ = name + "=";
        const ca = document.cookie.split(';');
        for (let i = 0; i < ca.length; i++) {
            let c = ca[i].trim();
            if (c.indexOf(nameEQ) === 0) return c.substring(nameEQ.length, c.length);
        }
        return null;
    };

    useEffect(() => {
        // Al cargar el componente, busca si hay una cookie de usuario
        const userCookie = getCookie('user');
        if (userCookie) {
            setIsLogged(true);
            setUser(userCookie); // Establece el usuario a partir de la cookie
        }
    }, []);

    const toggleIsLogged = (username = null) => {
        if (isLogged) {
            // Al cerrar sesión, eliminar la cookie
            setIsLogged(false);
            setUser(null);
            document.cookie = 'user=; path=/; Max-Age=0'; // Borra la cookie de forma más precisa
        } else {
            // Al iniciar sesión, establecer la cookie
            setIsLogged(true);
            setUser(username);
            document.cookie = `user=${username}; SameSite=None; Secure; path=/; max-age=${60 * 60 * 24 * 70}`;
        } 
    };
    

    return (
        <Routes>
            <Route path="/" element={<Index isLogged={isLogged} />} />
            <Route path="login" element={<Login toggleIsLogged={toggleIsLogged}/>} />
            <Route path="app" 
                element={
                    isLogged ? 
                        <App2 user={user} logOut={toggleIsLogged}/> 
                        : <Login toggleIsLogged={toggleIsLogged}/>
                } 
            />
        </Routes>
    );
}

export default App;
