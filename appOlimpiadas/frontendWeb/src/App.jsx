import './styles/App.css';
import React, { useState } from 'react';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Index from "./index";
import Login from "./login";
import App2 from "./App2";

function App() {
    const [isLogged, setIsLogged] = useState(false);

    const toggleIsLogged = () => {
        setIsLogged(!isLogged);
    }

    return (
            <Routes>
                <Route path="/" element={<Index isLogged={isLogged}/>} />
                <Route path="login" element={<Login toggleIsLogged={toggleIsLogged}/>} />
                <Route path="app" 
                    element={
                        isLogged ? 
                            <App2 logOut={toggleIsLogged}/> 
                            : <Login toggleIsLogged={toggleIsLogged}/>
                    } 
                />

            </Routes>
    )
}

export default App