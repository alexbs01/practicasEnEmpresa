import React from 'react';
import Login from './Login';
import App from './App';
import { useState } from 'react';
import { Navigate } from 'react-router-dom';

function Index({ isLogged }) {


    return (
        isLogged ? <Navigate to="/app" /> : <Navigate push to="/login" />
    );

}

export default Index;