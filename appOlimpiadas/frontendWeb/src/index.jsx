import React from 'react';
import Login from './Login';
import App from './App';
import { useState } from 'react';

function Index() {
    const [isLogged, setIsLogged] = useState(false);

    const toggleIsLogged = () => {
        setIsLogged(!isLogged);
    }

    return (
        isLogged ? <App /> : <Login toggleIsLogged={toggleIsLogged}/>
    );

}

export default Index;