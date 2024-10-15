import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import Index from './index.jsx'
import App from './App.jsx'
import { BrowserRouter, Route, Routes } from "react-router-dom";

createRoot(document.getElementById('root')).render(
    <StrictMode>
        <BrowserRouter>
            <App />
        </BrowserRouter>
    </StrictMode>
)
