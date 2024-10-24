import React from 'react';
import { Navigate } from 'react-router-dom';

function Index({ isLogged }) {
    return (
        isLogged ? <Navigate to="/app" /> : <Navigate push to="/login" />
    );

}

export default Index;